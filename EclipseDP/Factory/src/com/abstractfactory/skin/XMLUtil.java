package com.abstractfactory.skin;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLUtil {
	
	public static Object getBean(){
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document root = builder.parse(new File("src/com/abstractfactory/skin/config.xml"));
			NodeList nodeList = root.getElementsByTagName("skinType");
			String skinType = nodeList.item(0).getTextContent();
//			System.out.println(">>>" + skinType);
			Object object = Class.forName(skinType).newInstance();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
