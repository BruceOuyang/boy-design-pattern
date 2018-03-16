package bugmakers.club.dp.behavioral.seq02.command.demo;

import org.w3c.dom.Document;
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
 * @Datetime: 2018/3/16 17:38
 */
public class CommandXMLUtil {

    private static final String COMMAND_CONFIG = "config-repo/behavioral/seq02/command/command-pattern.xml";

    public static Command getCommand(int i){
        Command command = null;
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(COMMAND_CONFIG));

            NodeList nodeList = document.getElementsByTagName("className");

            Node classNode = null;
            if(0 == i){
                classNode = nodeList.item(0).getFirstChild();
            }else{
                classNode = nodeList.item(1).getFirstChild();
            }

            String cName = classNode.getNodeValue();

            Class obj = Class.forName(cName);
            command = (Command) obj.newInstance();

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
        return command;
    }
}
