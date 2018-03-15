package bugmakers.club.dp.creational.seq6.builder.demo;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/8 17:15
 */
public class BuilderXMLUtil {

    private static final String BUILDER_CONFIG = "config-repo/creational/seq6/builder/builder-pattern.xml";

    /**
     * 该方法用于从XML配置文件中提取具体类类名，并返回一个实例对象
     * @return
     */
    public static Object getBean(){
        try
        {
            //创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc  = builder.parse(new File(BUILDER_CONFIG));

            //获取包含类名的文本节点
            NodeList nl = doc.getElementsByTagName("builder");
            Node classNode=nl.item(0).getFirstChild();
            String cName=classNode.getNodeValue();

            //通过类名生成实例对象并将其返回
            Class c=Class.forName(cName);
            Object obj=c.newInstance();
            return obj;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
