import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


public class XMLUtil {
	
	public static String getChartType() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("config.xml"));
		NodeList nodeList = document.getElementsByTagName("chartType");
		String chartType = nodeList.item(0).getTextContent();
		return chartType;
	}

}
