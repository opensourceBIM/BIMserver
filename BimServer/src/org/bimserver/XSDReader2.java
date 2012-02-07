package org.bimserver;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XSDReader2 {
	public static void main(String[] args) {
		new XSDReader2().start();
	}

	private void start() {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.parse(getClass().getResourceAsStream("IFC2X3.xsd"));
			NodeList childNodes = document.getChildNodes();
			for (int i=0; i<childNodes.getLength(); i++) {
				Node item = childNodes.item(i);
				if (item.getNodeName().equals("xs:schema")) {
					readSchema(item);
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readSchema(Node item) {
		NodeList childNodes = item.getChildNodes();
		for (int i=0; i<childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
			if (node.getNodeName().equals("xs:complexType")) {
				processComplexType(node);
			} else if (node.getNodeName().equals("xs:element")) {
				processElement(node);
			} else if (node.getNodeName().equals("xs:simpleType")) {
				processSimpleType(node);
			} else if (node.getNodeName().equals("xs:group")) {
				processGroup(node);
			} else if (node.getNodeName().equals("#text") || node.getNodeName().equals("#comment") || node.getNodeName().equals("xs:import")) {
			} else {
				System.out.println(node.getNodeName());
			}
		}
	}

	private void processGroup(Node node) {
	}

	private void processSimpleType(Node node) {
		System.out.println(getAttribute(node, "name"));
		NodeList childNodes = node.getChildNodes();
		for (int i=0; i<childNodes.getLength(); i++) {
			Node item = childNodes.item(i);
			if (item.getNodeName().equals("xs:restriction")) {
				
			}
		}
	}

	private void processElement(Node node) {
	}

	private void processComplexType(Node node) {
	}
	
	private String getAttribute(Node node, String key) {
		return node.getAttributes().getNamedItem(key).getTextContent();
	}
}