**需求**

日志记录器的设计

> Sunny软件公司欲开发一个系统运行日志记录器(Logger)，该记录器可以通过多种途径保存系统的运行日志，如通过文件记录或数据库记录，用户可以通过修改配置文件灵活地更换日志记录方式。在设计各类日志记录器时，Sunny公司的开发人员发现需要对日志记录器进行一些初始化工作，初始化参数的设置过程较为复杂，而且某些参数的设置有严格的先后次序，否则可能会发生记录失败。如何封装记录器的初始化过程并保证多种记录器切换的灵活性是Sunny公司开发人员面临的一个难题。

3 完整解决方案  

Sunny公司开发人员决定使用工厂方法模式来设计日志记录器，其基本结构如图3所示：  
![图3 日志记录器结构图](http://upload-images.jianshu.io/upload_images/5792176-f08a6b616f9a6ddd.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图3 日志记录器结构图  

在图3中，Logger接口充当抽象产品，其子类FileLogger和DatabaseLogger充当具体产品，LoggerFactory接口充当抽象工厂，其子类FileLoggerFactory和DatabaseLoggerFactory充当具体工厂。完整代码如下所示：  
```java
//日志记录器接口：抽象产品  
interface Logger {  
    public void writeLog();  
}  

//数据库日志记录器：具体产品  
class DatabaseLogger implements Logger {  
    public void writeLog() {  
        System.out.println("数据库日志记录。");  
    }  
}  

//文件日志记录器：具体产品  
class FileLogger implements Logger {  
    public void writeLog() {  
        System.out.println("文件日志记录。");  
    }  
}  

//日志记录器工厂接口：抽象工厂  
interface LoggerFactory {  
    public Logger createLogger();  
}  

//数据库日志记录器工厂类：具体工厂  
class DatabaseLoggerFactory implements LoggerFactory {  
    public Logger createLogger() {  
            //连接数据库，代码省略  
            //创建数据库日志记录器对象  
            Logger logger = new DatabaseLogger();   
            //初始化数据库日志记录器，代码省略  
            return logger;  
    }     
}  

//文件日志记录器工厂类：具体工厂  
class FileLoggerFactory implements LoggerFactory {  
    public Logger createLogger() {  
            //创建文件日志记录器对象  
            Logger logger = new FileLogger();   
            //创建文件，代码省略  
            return logger;  
    }     
}
```

编写如下客户端测试代码：  
```java
class Client {  
    public static void main(String args[]) {  
        LoggerFactory factory;  
        Logger logger;  
        factory = new FileLoggerFactory(); //可引入配置文件实现  
        logger = factory.createLogger();  
        logger.writeLog();  
    }  
}
```  

编译并运行程序，输出结果如下：
```
文件日志记录。
```

4 反射与配置文件  

为了让系统具有更好的灵活性和可扩展性，Sunny公司开发人员决定对日志记录器客户端代码进行重构，使得可以在不修改任何客户端代码的基础上更换或增加新的日志记录方式。  

在客户端代码中将不再使用new关键字来创建工厂对象，而是将具体工厂类的类名存储在配置文件（如XML文件）中，通过读取配置文件获取类名字符串，再使用Java的反射机制，根据类名字符串生成对象。在整个实现过程中需要用到两个技术：Java反射机制与配置文件读取。软件系统的配置文件通常为XML文件，我们可以使用DOM (Document Object Model)、SAX (Simple API for XML)、StAX (Streaming API for XML)等技术来处理XML文件。关于DOM、SAX、StAX等技术的详细学习大家可以参考其他相关资料，在此不予扩展。  

**扩展**

关于Java与XML的相关资料，大家可以阅读Tom Myers和Alexander Nakhimovsky所著的《Java XML编程指南》一书或访问developer Works 中国中的“Java XML 技术专题”，参考链接： http://www.ibm.com/developerworks/cn/xml/theme/x-java.html  

Java反射(Java Reflection)是指在程序运行时获取已知名称的类或已有对象的相关信息的一种机制，包括类的方法、属性、父类等信息，还包括实例的创建和实例类型的判断等。在反射中使用最多的类是Class，Class类的实例表示正在运行的Java应用程序中的类和接口，其forName(String className)方法可以返回与带有给定字符串名的类或接口相关联的 Class对象，再通过Class对象的newInstance()方法创建此对象所表示的类的一个新实例，即通过一个类名字符串得到类的实例。如创建一个字符串类型的对象，其代码如下：  
```java
//通过类名生成实例对象并将其返回  
Class c=Class.forName("String");  
Object obj=c.newInstance();  
return obj;
```

此外，在JDK中还提供了java.lang.reflect包，封装了其他与反射相关的类，此处只用到上述简单的反射代码，在此不予扩展。  

Sunny公司开发人员创建了如下XML格式的配置文件config.xml用于存储具体日志记录器工厂类类名：  
```xml
<?xml version="1.0"?>  
<config>  
    <className>FileLoggerFactory</className>  
</config>
```

为了读取该配置文件并通过存储在其中的类名字符串反射生成对象，Sunny公司开发人员开发了一个名为XMLUtil的工具类，其详细代码如下所示：  
```java
//工具类XMLUtil.java  
import javax.xml.parsers.*;  
import org.w3c.dom.*;  
import org.xml.sax.SAXException;  
import java.io.*;  

public class XMLUtil {  
//该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象  
    public static Object getBean() {  
        try {  
            //创建DOM文档对象  
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder = dFactory.newDocumentBuilder();  
            Document doc;                             
            doc = builder.parse(new File("config.xml"));   

            //获取包含类名的文本节点  
            NodeList nl = doc.getElementsByTagName("className");  
            Node classNode=nl.item(0).getFirstChild();  
            String cName=classNode.getNodeValue();  

            //通过类名生成实例对象并将其返回  
            Class c=Class.forName(cName);  
            Object obj=c.newInstance();  
            return obj;  
        }     
        catch(Exception e) {  
            e.printStackTrace();  
            return null;  
         }  
    }  
}
```

有了XMLUtil类后，可以对日志记录器的客户端代码进行修改，不再直接使用new关键字来创建具体的工厂类，而是将具体工厂类的类名存储在XML文件中，再通过XMLUtil类的静态工厂方法getBean()方法进行对象的实例化，代码修改如下：  
```java
class Client {  
    public static void main(String args[]) {  
        LoggerFactory factory;  
        Logger logger;  
        factory = (LoggerFactory)XMLUtil.getBean(); //getBean()的返回类型为Object，需要进行强制类型转换  
        logger = factory.createLogger();  
        logger.writeLog();  
    }  
}
```  

引入XMLUtil类和XML配置文件后，如果要增加新的日志记录方式，只需要执行如下几个步骤：

(1) 新的日志记录器需要继承抽象日志记录器Logger；  

(2) 对应增加一个新的具体日志记录器工厂，继承抽象日志记录器工厂LoggerFactory，并实现其中的工厂方法createLogger()，设置好初始化参数和环境变量，返回具体日志记录器对象；  

(3) 修改配置文件config.xml，将新增的具体日志记录器工厂类的类名字符串替换原有工厂类类名字符串；  

(4) 编译新增的具体日志记录器类和具体日志记录器工厂类，运行客户端测试类即可使用新的日志记录方式，而原有类库代码无须做任何修改，完全符合“开闭原则”。  

通过上述重构可以使得系统更加灵活，由于很多设计模式都关注系统的可扩展性和灵活性，因此都定义了抽象层，在抽象层中声明业务方法，而将业务方法的实现放在实现层中。  

**疑问&思考**
有人说：可以在客户端代码中直接通过反射机制来生成产品对象，在定义产品对象时使用抽象类型，同样可以确保系统的灵活性和可扩展性，增加新的具体产品类无须修改源代码，只需要将其作为抽象产品类的子类再修改配置文件即可，根本不需要抽象工厂类和具体工厂类。  

试思考这种做法的可行性？如果可行，这种做法是否存在问题？为什么？


5 重载的工厂方法  

Sunny公司开发人员通过进一步分析，发现可以通过多种方式来初始化日志记录器，例如可以为各种日志记录器提供默认实现；还可以为数据库日志记录器提供数据库连接字符串，为文件日志记录器提供文件路径；也可以将参数封装在一个Object类型的对象中，通过Object对象将配置参数传入工厂类。此时，可以提供一组重载的工厂方法，以不同的方式对产品对象进行创建。当然，对于同一个具体工厂而言，无论使用哪个工厂方法，创建的产品类型均要相同。如图4所示：  
![图4 重载的工厂方法结构图](http://upload-images.jianshu.io/upload_images/5792176-b5c1d53c3a05d3b5.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图4 重载的工厂方法结构图  

引入重载方法后，抽象工厂LoggerFactory的代码修改如下：  
```java
interface LoggerFactory {  
    public Logger createLogger();  
    public Logger createLogger(String args);  
    public Logger createLogger(Object obj);  
}
```

具体工厂类DatabaseLoggerFactory代码修改如下：  
```java
class DatabaseLoggerFactory implements LoggerFactory {  
    public Logger createLogger() {  
            //使用默认方式连接数据库，代码省略  
            Logger logger = new DatabaseLogger();   
            //初始化数据库日志记录器，代码省略  
            return logger;  
    }  

    public Logger createLogger(String args) {  
            //使用参数args作为连接字符串来连接数据库，代码省略  
            Logger logger = new DatabaseLogger();   
            //初始化数据库日志记录器，代码省略  
            return logger;  
    }     

    public Logger createLogger(Object obj) {  
            //使用封装在参数obj中的连接字符串来连接数据库，代码省略  
            Logger logger = new DatabaseLogger();   
            //使用封装在参数obj中的数据来初始化数据库日志记录器，代码省略  
            return logger;  
    }     
}  

//其他具体工厂类代码省略
```

在抽象工厂中定义多个重载的工厂方法，在具体工厂中实现了这些工厂方法，这些方法可以包含不同的业务逻辑，以满足对不同产品对象的需求。

6 工厂方法的隐藏  

有时候，为了进一步简化客户端的使用，还可以对客户端隐藏工厂方法，此时，在工厂类中将直接调用产品类的业务方法，客户端无须调用工厂方法创建产品，直接通过工厂即可使用所创建的对象中的业务方法。

如果对客户端隐藏工厂方法，日志记录器的结构图将修改为图5所示：  
![图5 隐藏工厂方法后的日志记录器结构图](http://upload-images.jianshu.io/upload_images/5792176-e663028d19376b7b.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240) 
图5 隐藏工厂方法后的日志记录器结构图

在图5中，抽象工厂类LoggerFactory的代码修改如下：  
```java
//改为抽象类  
abstract class LoggerFactory {  
    //在工厂类中直接调用日志记录器类的业务方法writeLog()  
    public void writeLog() {  
        Logger logger = this.createLogger();  
        logger.writeLog();  
    }  

    public abstract Logger createLogger();    
}
```

客户端代码修改如下：  
```java
class Client {  
    public static void main(String args[]) {  
        LoggerFactory factory;  
        factory = (LoggerFactory)XMLUtil.getBean();  
        factory.writeLog(); //直接使用工厂对象来调用产品对象的业务方法  
    }  
}
```

通过将业务方法的调用移入工厂类，可以直接使用工厂对象来调用产品对象的业务方法，客户端无须直接使用工厂方法，在某些情况下我们也可以使用这种设计方案。  
