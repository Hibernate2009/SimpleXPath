package com.bssys.service;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


import com.bssys.bo.XPathBO;



public class XPathServiceImpl implements XPathService {
	
	
	
	public List<String> process(XPathBO mainBO, PersonalNamespaceContext context) {

		ArrayList<String> res = new ArrayList<String>();
		try {

			DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
			domFactory.setNamespaceAware(true); // never forget this!
			DocumentBuilder builder = domFactory.newDocumentBuilder();
			InputSource s = new InputSource(new StringReader(mainBO.getXml()));

			Document doc = builder.parse(s);
			doc.setXmlStandalone(true);

			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			xpath.setNamespaceContext(context);
			XPathExpression expr = xpath.compile(mainBO.getXpath());

			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;

			for (int i = 0; i < nodes.getLength(); i++) {
				StringWriter sw = new StringWriter();
				Transformer serializer = TransformerFactory.newInstance().newTransformer();
				serializer.setOutputProperty("omit-xml-declaration", "yes");
				serializer.transform(new DOMSource(nodes.item(i)), new StreamResult(sw));
				//res.add(StringEscapeUtils.escapeXml(sw.toString()));
				res.add(sw.toString());

			}
		} catch (Exception e) {
			res.add(e.getMessage());
		}
		return res;
	}
}
