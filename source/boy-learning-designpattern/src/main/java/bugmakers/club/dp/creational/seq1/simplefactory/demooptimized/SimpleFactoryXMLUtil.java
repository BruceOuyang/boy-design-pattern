package bugmakers.club.dp.creational.seq1.simplefactory.demooptimized;

import javax.xml.parsers.*;
import org.w3c.dom.*;

import java.io.*;

/**
 * @Description: XML工具类
 * @Author: Bruce
 * @Datetime: 2018/3/1 16:25
 */
public class SimpleFactoryXMLUtil {

    /**
     * demo优化的配置文件
     */
    private static final String SIMPLE_FACTORY_CONFIG = "config-repo/creational/seq1/simplefactory/simple-abstractfactory-config.xml";
    /**
     * 练习题的配置文件
     */
    private static final String SIMPLE_FACTORY_PRACTICE_CONFIG = "config-repo/creational/seq1/simplefactory/simple-abstractfactory-practice-config.xml";

    /**
     * 从XML配置文件中提取图表类型，并返回类型名
     * @return
     */
    public static String getChartType() {
        return getType(SIMPLE_FACTORY_CONFIG, "chartType");
    }

    /**
     * 从XML配置文件中提取形状类型，并返回类型名
     * @return
     */
    public static String getShapeType() {
        return getType(SIMPLE_FACTORY_PRACTICE_CONFIG, "shapeType");
    }

    private static String getType(String xmlPath, String tagName) {
        try {
            //创建文档对象
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File(xmlPath));

            //获取包含图表类型的文本节点
            NodeList nl = doc.getElementsByTagName(tagName);
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
