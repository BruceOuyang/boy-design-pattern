package bugmakers.club.dp.creational.seq2.factorymethod.demooptimized.one;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @Description: 工厂方法模式的XMLUtil类，xml + 反射 配置获取具体工厂实例
 * @Author: Bruce
 * @Datetime: 2018/3/5 16:45
 */
public class FactoryMethodXMLUtil {

    /**
     * 配置文件路径
     */
    private static final String FACTORY_METHOD_CONFIG = "config-repo/creational/seq2/simplefactory/abstractfactory-method-pattern.xml";

    public static Object getBean(){
        try {
            // 创建DOM文档对象
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File(FACTORY_METHOD_CONFIG));

            // 获取包含日志记录器类名的节点
            NodeList nodeList = document.getElementsByTagName("className");
            Node node = nodeList.item(0).getFirstChild();
            String loggerClassName = node.getNodeValue();

            // 通过类名获取实例对象
            Class loggerClass = Class.forName(loggerClassName);
            Object logger = loggerClass.newInstance();
            return logger;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
