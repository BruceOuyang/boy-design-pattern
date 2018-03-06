**需求**

1 图表库的设计  

Sunny软件公司欲基于Java语言开发一套图表库，该图表库可以为应用系统提供各种不同外观的图表，例如柱状图、饼状图、折线图等。Sunny软件公司图表库设计人员希望为应用系统开发人员提供一套灵活易用的图表库，而且可以较为方便地对图表库进行扩展，以便能够在将来增加一些新类型的图表。  

3 完整解决方案  

为了将Chart类的职责分离，同时将Chart对象的创建和使用分离，Sunny软件公司开发人员决定使用简单工厂模式对图表库进行重构，重构后的结构如图2所示：  
![图2 图表库结构图](http://upload-images.jianshu.io/upload_images/5792176-e88c17bde3dfae6c.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)  
图2 图表库结构图

在图2中，Chart接口充当抽象产品类，其子类HistogramChart、PieChart和LineChart充当具体产品类，ChartFactory充当工厂类。完整代码如下所示：
```java
//抽象图表接口：抽象产品类  
interface Chart {  
    public void display();  
}  

//柱状图类：具体产品类  
class HistogramChart implements Chart {  
    public HistogramChart() {  
        System.out.println("创建柱状图！");  
    }  

    public void display() {  
        System.out.println("显示柱状图！");  
    }  
}  

//饼状图类：具体产品类  
class PieChart implements Chart {  
    public PieChart() {  
        System.out.println("创建饼状图！");  
    }  

    public void display() {  
        System.out.println("显示饼状图！");  
    }  
}  

//折线图类：具体产品类  
class LineChart implements Chart {  
    public LineChart() {  
        System.out.println("创建折线图！");  
    }  

    public void display() {  
        System.out.println("显示折线图！");  
    }  
}  

//图表工厂类：工厂类  
class ChartFactory {  
    //静态工厂方法  
    public static Chart getChart(String type) {  
        Chart chart = null;  
        if (type.equalsIgnoreCase("histogram")) {  
            chart = new HistogramChart();  
            System.out.println("初始化设置柱状图！");  
        }  
        else if (type.equalsIgnoreCase("pie")) {  
            chart = new PieChart();  
            System.out.println("初始化设置饼状图！");  
        }  
        else if (type.equalsIgnoreCase("line")) {  
            chart = new LineChart();  
            System.out.println("初始化设置折线图！");              
        }  
        return chart;  
    }  
}
```

编写如下客户端测试代码：
```java
class Client {  
    public static void main(String args[]) {  
        Chart chart;  
        //通过静态工厂方法创建产品  
        chart = ChartFactory.getChart("histogram"); 
        chart.display();  
    }  
}
```

编译并运行程序，输出结果如下：
```
创建柱状图！
初始化设置柱状图！
显示柱状图！
```

在客户端测试类中，我们使用工厂类的静态工厂方法创建产品对象，如果需要更换产品，只需修改静态工厂方法中的参数即可，例如将柱状图改为饼状图，只需将代码：
```java
chart = ChartFactory.getChart("histogram");
```
改为
```java
chart = ChartFactory.getChart("pie");
```

编译并运行程序，输出结果如下：
```
创建饼状图！
初始化设置饼状图！
显示饼状图！
```

4 方案的改进  

Sunny软件公司开发人员发现在创建具体Chart对象时，每更换一个Chart对象都需要修改客户端代码中静态工厂方法的参数，客户端代码将要重新编译，这对于客户端而言，违反了“开闭原则”，有没有一种方法能够在不修改客户端代码的前提下更换具体产品对象呢？答案是肯定的，下面将介绍一种常用的实现方式。  

我们可以将静态工厂方法的参数存储在XML或properties格式的配置文件中，如下config.xml所示：
```xml
<?xml version="1.0"?>  
<config>  
    <chartType>histogram</chartType>  
</config>
```

再通过一个工具类XMLUtil来读取配置文件中的字符串参数，XMLUtil类的代码如下所示：  
```java
import javax.xml.parsers.*;  
import org.w3c.dom.*;  
import org.xml.sax.SAXException;  
import java.io.*;  

public class XMLUtil {  
    //该方法用于从XML配置文件中提取图表类型，并返回类型名  
    public static String getChartType() {  
        try {  
            //创建文档对象  
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder = dFactory.newDocumentBuilder();  
            Document doc;                             
            doc = builder.parse(new File("config.xml"));   

            //获取包含图表类型的文本节点  
            NodeList nl = doc.getElementsByTagName("chartType");  
            Node classNode = nl.item(0).getFirstChild();  
            String chartType = classNode.getNodeValue().trim();  
            return chartType;  
        }     
        catch(Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
}
```

在引入了配置文件和工具类XMLUtil之后，客户端代码修改如下：
```java
class Client {  
    public static void main(String args[]) {  
        Chart chart; 
        
        //读取配置文件中的参数  
        String type = XMLUtil.getChartType();
        
        //创建产品对象
        chart = ChartFactory.getChart(type);   
        chart.display();  
    }  
}
```

不难发现，在上述客户端代码中不包含任何与具体图表对象相关的信息，如果需要更换具体图表对象，只需修改配置文件config.xml，无须修改任何源代码，符合“开闭原则”。  
