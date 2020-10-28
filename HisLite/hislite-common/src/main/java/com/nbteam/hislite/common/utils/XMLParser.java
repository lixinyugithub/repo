package com.nbteam.hislite.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * Description: xml解析<br/>
 *
 */
public class XMLParser {
    /**
     * 从RefunQueryResponseString里面解析出退款订单数据
     * 
     * @return 因为订单数据有可能是多个，所以返回一个列表
     */

    public static Map<String, Object> getMapFromXML(String xmlString)
            throws ParserConfigurationException, IOException, SAXException {
        // 这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream is = CommonUtil.getStringStream(xmlString);
        Document document = builder.parse(is);

        // 获取到document里面的全部结点
        NodeList allNodes = document.getFirstChild().getChildNodes();
        Node node;
        Map<String, Object> map = new HashMap<String, Object>();
        int i = 0;
        while (i < allNodes.getLength()) {
            node = allNodes.item(i);
            if (node instanceof Element) {
                map.put(node.getNodeName(), node.getTextContent());
            }
            i++;
        }
        return map;
    }

    public static String objToXml(Map<String, Object> xmlMap) {
        StringBuilder sb = new StringBuilder(1000);
        sb.append("<xml>\n");
        for (String key : xmlMap.keySet()) {
            Object var = xmlMap.get(key);
            if (var == null) {
                continue;
            }
            sb.append("<").append(key).append(">");
            if (var instanceof String) {
                sb.append("<![CDATA[");
                sb.append(var);
                sb.append("]]>");
            } else {
                sb.append(var);
            }
            sb.append("</").append(key).append(">\n");
        }
        sb.append("</xml>\n");
        return sb.toString();
    }
}
