package bugmakers.club.dp.creational.seq3.abstractfactory.demooptimized;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

/**
 * @Description: 为了让系统具备良好的灵活性和可扩展性，我们引入了工具类XMLUtil和配置文件
 * @Author: Bruce
 * @Datetime: 2018/3/6 11:10
 */
public class AbstractFactoryXMLUtil {

    /**
     * 该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
      * @return
     */
    public static Object getBean() {
        try {
            //创建文档对象
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