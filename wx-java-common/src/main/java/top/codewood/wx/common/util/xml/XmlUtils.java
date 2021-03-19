package top.codewood.wx.common.util.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlUtils {

    public static Map<String, Object> xml2Map(String xml) {
        try {
            SAXReader saxReader = new SAXReader();
            saxReader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            saxReader.setFeature("http://javax.xml.XMLConstants/feature/secure-processing", true);
            saxReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            saxReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            saxReader.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            Document doc = saxReader.read(new StringReader(xml));
            Element root = doc.getRootElement();
            List<Element> elements = root.elements();

            Map<String, Object> map = new HashMap<>();
            for (Element element : elements) {
                map.put(element.getName(), element.getStringValue());
            }
            return map;
        } catch (DocumentException | SAXException e) {
            throw new RuntimeException(e);
        }


    }

}
