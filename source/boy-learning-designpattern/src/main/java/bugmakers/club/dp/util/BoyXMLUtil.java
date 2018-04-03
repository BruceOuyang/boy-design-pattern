package bugmakers.club.dp.util;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/4/3 10:41
 */
public class BoyXMLUtil {

    /**
     * 默认标签：className
     */
    public static final String DEFAULT_TAG = "className";

    /**
     * 获取bean
     * @param configFile xml配置文件路径
     * @param tagName 标签名
     * @return
     */
    public static Object getBean(String configFile, String tagName){

        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(new File(configFile));

            NodeList nl = doc.getElementsByTagName(tagName);
            String className = nl.item(0).getFirstChild().getNodeValue();

            return Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 获取bean
     * @param configFile xml配置文件路径
     * @return
     */
    public static Object getBean(String configFile){

        return getBean(configFile, DEFAULT_TAG);
    }
}
