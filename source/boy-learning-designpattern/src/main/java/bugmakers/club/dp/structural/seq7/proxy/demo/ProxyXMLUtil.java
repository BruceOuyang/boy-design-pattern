package bugmakers.club.dp.structural.seq7.proxy.demo;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/15 17:17
 */
public class ProxyXMLUtil {

    public static final String PROXY_CONFIG = "config-repo/structural/seq7/proxy/proxy-pattern.xml";

    public static Searcher getBean(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(PROXY_CONFIG));

            Node node = doc.getElementsByTagName("add").item(0);

            String proxyClassName = node.getAttributes().getNamedItem("value").getNodeValue();

            Class proxyClass = Class.forName(proxyClassName);
            return (Searcher) proxyClass.newInstance();

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
