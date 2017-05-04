package com.sheshu.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 董帮辉 2017-3-5.
 */
public class DataShapeConvertUtils {

    public static Map<String, String>  xmlToMap(String xml) throws IOException,DocumentException{
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();

        Document doc = reader.read(xml);

        Element root = doc.getRootElement();

        List<Element> list = root.elements();

        for(Element e : list){
            map.put(e.getName(), e.getText());
        }
        return map;
    }

    /**
     * 解析微信发送过来的xml
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static Map<String, String> parseXml(HttpServletRequest request) throws IOException, DocumentException {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();
        InputStream inputStream = request.getInputStream();
        Document doc = reader.read(inputStream);
        Element root = doc.getRootElement();
        List<Element> list = root.elements();
        for(Element e : list){
            map.put(e.getName(),e.getText());
        }
        inputStream.close();
        return map;
    }

}
