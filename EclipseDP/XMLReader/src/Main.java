import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Main {

	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("languages.xml"));
			Element root = document.getDocumentElement();
			System.out.println("cat = " + root.getAttribute("cat"));
			NodeList list = root.getElementsByTagName("lan");
			for (int i = 0; i<list.getLength(); i++){
				Element lan = (Element) list.item(i);
				System.out.println("-------------");
				System.out.println("id = " + lan.getAttribute("id"));
				
//				Element name = (Element) lan.getElementsByTagName("name").item(0);
//				System.out.println("name = " + name.getTextContent());
				
				NodeList childNodes = lan.getChildNodes();
				for (int j = 0; j<childNodes.getLength(); j++){
					Node n = childNodes.item(j);
					if (n instanceof Element){
						System.out.println(n.getNodeName() + " = " + n.getTextContent());
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
