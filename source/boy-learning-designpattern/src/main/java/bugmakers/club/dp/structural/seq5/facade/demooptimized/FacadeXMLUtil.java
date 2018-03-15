package bugmakers.club.dp.structural.seq5.facade.demooptimized;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/15 10:07
 */
public class FacadeXMLUtil {

    private static final String FACADE_CONFIG = "config-repo/structural/seq5/facade/facade-pattern.xml";

    public static AbstractEncryptFacade getBean(){
        try {

            // 通过文档构件工厂创建文档对象
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(FACADE_CONFIG));

            // 获取配置的类名
            NodeList nodeList = doc.getElementsByTagName("add");
            Node node = nodeList.item(0);
            NamedNodeMap namedNodeMap = node.getAttributes();
            String facadeClassName = namedNodeMap.getNamedItem("value").getNodeValue();

            // 使用反射获取facade实例
            Class facade = Class.forName(facadeClassName, false, ClassLoader.getSystemClassLoader());
            return (AbstractEncryptFacade) facade.newInstance();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
