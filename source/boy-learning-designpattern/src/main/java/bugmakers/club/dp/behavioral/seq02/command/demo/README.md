1 自定义功能键

Sunny软件公司开发人员为公司内部OA系统开发了一个桌面版应用程序，该应用程序为用户提供了一系列自定义功能键，用户可以通过这些功能键来实现一些快捷操作。Sunny软件公司开发人员通过分析，发现不同的用户可能会有不同的使用习惯，在设置功能键的时候每个人都有自己的喜好，例如有的人喜欢将第一个功能键设置为“打开帮助文档”，有的人则喜欢将该功能键设置为“最小化至托盘”，为了让用户能够灵活地进行功能键的设置，开发人员提供了一个“功能键设置”窗口，该窗口界面如图2所示：  
![图2 “功能键设置”界面效果图](https://upload-images.jianshu.io/upload_images/5792176-72d3b7e492b866cf.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图2 “功能键设置”界面效果图  

通过如图2所示界面，用户可以将功能键和相应功能绑定在一起，还可以根据需要来修改功能键的设置，而且系统在未来可能还会增加一些新的功能或功能键。  

Sunny软件公司某开发人员欲使用如下代码来实现功能键与功能处理类之间的调用关系：  
```java
//FunctionButton：功能键类，请求发送者  
class FunctionButton {  
    private HelpHandler help; //HelpHandler：帮助文档处理类，请求接收者  

    //在FunctionButton的onClick()方法中调用HelpHandler的display()方法  
    public void onClick() {  
        help = new HelpHandler();  
        help.display(); //显示帮助文档  
    }  
}
```

在上述代码中，功能键类FunctionButton充当请求的发送者，帮助文档处理类HelpHandler充当请求的接收者，在发送者FunctionButton的onClick()方法中将调用接收者HelpHandler的display()方法。显然，如果使用上述代码，将给系统带来如下几个问题：
  
(1) 由于请求发送者和请求接收者之间存在方法的直接调用，耦合度很高，更换请求接收者必须修改发送者的源代码，如果需要将请求接收者HelpHandler改为WindowHanlder（窗口处理类），则需要修改FunctionButton的源代码，违背了“开闭原则”。  

(2) FunctionButton类在设计和实现时功能已被固定，如果增加一个新的请求接收者，如果不修改原有的FunctionButton类，则必须增加一个新的与FunctionButton功能类似的类，这将导致系统中类的个数急剧增加。由于请求接收者HelpHandler、WindowHanlder等类之间可能不存在任何关系，它们没有共同的抽象层，因此也很难依据“依赖倒转原则”来设计FunctionButton。  

(3) 用户无法按照自己的需要来设置某个功能键的功能，一个功能键类的功能一旦固定，在不修改源代码的情况下无法更换其功能，系统缺乏灵活性。  

不难得知，所有这些问题的产生都是因为请求发送者FunctionButton类和请求接收者HelpHandler、WindowHanlder等类之间存在直接耦合关系，如何降低请求发送者和接收者之间的耦合度，让相同的发送者可以对应不同的接收者？这是Sunny软件公司开发人员在设计“功能键设置”模块时不得不考虑的问题。命令模式正为解决这类问题而诞生，此时，如果我们使用命令模式，可以在一定程度上解决上述问题（注：命令模式无法解决类的个数增加的问题），下面就让我们正式进入命令模式的学习，看看命令模式到底如何实现请求发送者和接收者解耦。


3 完整解决方案

为了降低功能键与功能处理类之间的耦合度，让用户可以自定义每一个功能键的功能，Sunny软件公司开发人员使用命令模式来设计“自定义功能键”模块，其核心结构如图4所示：  
![图4 自定义功能键核心结构图](https://upload-images.jianshu.io/upload_images/5792176-7f328bec808c5362.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图4 自定义功能键核心结构图  

在图4中，FBSettingWindow是“功能键设置”界面类，FunctionButton充当请求调用者，Command充当抽象命令类，MinimizeCommand和HelpCommand充当具体命令类，WindowHanlder和HelpHandler充当请求接收者。完整代码如下所示：  
```java
import java.util.*;  

//功能键设置窗口类  
class FBSettingWindow {  
    private String title; //窗口标题  
    //定义一个ArrayList来存储所有功能键  
    private ArrayList<FunctionButton> functionButtons = new ArrayList<FunctionButton>();  

    public FBSettingWindow(String title) {  
        this.title = title;  
    }  

    public void setTitle(String title) {  
        this.title = title;  
    }  

    public String getTitle() {  
        return this.title;  
    }  

    public void addFunctionButton(FunctionButton fb) {  
        functionButtons.add(fb);  
    }  

    public void removeFunctionButton(FunctionButton fb) {  
        functionButtons.remove(fb);  
    }  

    //显示窗口及功能键  
    public void display() {  
        System.out.println("显示窗口：" + this.title);  
        System.out.println("显示功能键：");  
        for (Object obj : functionButtons) {  
            System.out.println(((FunctionButton)obj).getName());  
        }  
        System.out.println("------------------------------");  
    }     
}  

//功能键类：请求发送者  
class FunctionButton {  
    private String name; //功能键名称  
    private Command command; //维持一个抽象命令对象的引用  

    public FunctionButton(String name) {  
        this.name = name;  
    }  

    public String getName() {  
        return this.name;  
    }  

    //为功能键注入命令  
    public void setCommand(Command command) {  
        this.command = command;  
    }  

    //发送请求的方法  
    public void onClick() {  
        System.out.print("点击功能键：");  
        command.execute();  
    }  
}  

//抽象命令类  
abstract class Command {  
    public abstract void execute();  
}  

//帮助命令类：具体命令类  
class HelpCommand extends Command {  
    private HelpHandler hhObj; //维持对请求接收者的引用  

    public HelpCommand() {  
        hhObj = new HelpHandler();  
    }  

    //命令执行方法，将调用请求接收者的业务方法  
    public void execute() {  
        hhObj.display();  
    }  
}  

//最小化命令类：具体命令类  
class MinimizeCommand extends Command {  
    private WindowHanlder whObj; //维持对请求接收者的引用  

    public MinimizeCommand() {  
        whObj = new WindowHanlder();  
    }  

//命令执行方法，将调用请求接收者的业务方法  
    public void execute() {  
        whObj.minimize();  
    }  
}  

//窗口处理类：请求接收者  
class WindowHanlder {  
    public void minimize() {  
        System.out.println("将窗口最小化至托盘！");  
    }  
}  

//帮助文档处理类：请求接收者  
class HelpHandler {  
    public void display() {  
        System.out.println("显示帮助文档！");  
    }  
}
```

为了提高系统的灵活性和可扩展性，我们将具体命令类的类名存储在配置文件中，并通过工具类XMLUtil来读取配置文件并反射生成对象，XMLUtil类的代码如下所示：  
```java
import javax.xml.parsers.*;  
import org.w3c.dom.*;  
import org.xml.sax.SAXException;  
import java.io.*;  

public class XMLUtil {  
//该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象，可以通过参数的不同返回不同类名节点所对应的实例  
    public static Object getBean(int i) {  
        try {  
            //创建文档对象  
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder = dFactory.newDocumentBuilder();  
            Document doc;                             
            doc = builder.parse(new File("config.xml"));   

            //获取包含类名的文本节点  
            NodeList nl = doc.getElementsByTagName("className");  
            Node classNode = null;  
            if (0 == i) {  
                classNode = nl.item(0).getFirstChild();  
            }  
            else {  
                classNode = nl.item(1).getFirstChild();  
            }   

            String cName = classNode.getNodeValue();  

            //通过类名生成实例对象并将其返回  
            Class c = Class.forName(cName);  
            Object obj = c.newInstance();  
            return obj;  
        }     
        catch(Exception e){  
            e.printStackTrace();  
            return null;  
        }  
    }  
}
```

配置文件config.xml中存储了具体建造者类的类名，代码如下所示：  
```xml
<?xml version="1.0"?>  
<config>  
    <className>HelpCommand</className>  
    <className>MinimizeCommand</className>  
</config>  
```

编写如下客户端测试代码：  
```java
class Client {  
    public static void main(String args[]) {  
        FBSettingWindow fbsw = new FBSettingWindow("功能键设置");  

        FunctionButton fb1,fb2;  
        fb1 = new FunctionButton("功能键1");  
        fb2 = new FunctionButton("功能键1");  

        Command command1,command2;  
        //通过读取配置文件和反射生成具体命令对象  
        command1 = (Command)XMLUtil.getBean(0);  
        command2 = (Command)XMLUtil.getBean(1);  

        //将命令对象注入功能键  
        fb1.setCommand(command1);  
        fb2.setCommand(command2);  

        fbsw.addFunctionButton(fb1);  
        fbsw.addFunctionButton(fb2);  
        fbsw.display();  

        //调用功能键的业务方法  
        fb1.onClick();  
        fb2.onClick();  
    }  
}
```

编译并运行程序，输出结果如下：  
```
显示窗口：功能键设置
显示功能键：
功能键1
功能键1
------------------------------
点击功能键：显示帮助文档！
点击功能键：将窗口最小化至托盘！
```

如果需要修改功能键的功能，例如某个功能键可以实现“自动截屏”，只需要对应增加一个新的具体命令类，在该命令类与屏幕处理者(ScreenHandler)之间创建一个关联关系，然后将该具体命令类的对象通过配置文件注入到某个功能键即可，原有代码无须修改，符合“开闭原则”。在此过程中，每一个具体命令类对应一个请求的处理者（接收者），通过向请求发送者注入不同的具体命令对象可以使得相同的发送者对应不同的接收者，从而实现“将一个请求封装为一个对象，用不同的请求对客户进行参数化”，客户端只需要将具体命令对象作为参数注入请求发送者，无须直接操作请求的接收者。