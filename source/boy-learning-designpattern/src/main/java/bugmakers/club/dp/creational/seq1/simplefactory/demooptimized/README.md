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

**思考**  

> 在简单工厂模式中增加新的具体产品时是否符合“开闭原则”？如果不符合，原有系统需作出哪些修改？  
