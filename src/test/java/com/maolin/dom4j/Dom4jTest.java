package com.maolin.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;
import org.dom4j.io.STAXEventReader;
import org.dom4j.tree.QNameCache;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * <PRE>
 * 这里填写类注释
 * </PRE>
 *
 * @author zhangmaolin
 * @version 1.0.0
 * @since 2021-04-29 09:59
 */
public class Dom4jTest {

    /**
     * 见test2
     *
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    @Test
    public void test() throws SAXException, ParserConfigurationException {
        // SAXParserFactory 非线程安全
        SAXParserFactory instance = SAXParserFactory.newInstance();
        // https://foojay.io/today/how-to-configure-your-java-xml-parsers-to-prevent-xxe-attacks/
        instance.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        SAXParser saxParser = instance.newSAXParser();
    }

    /**
     * 该方法在初始化parser对象的时候，调用了
     * SAXParserFactory factory = SAXParserFactory.newInstance();
     * 而该方法非常的消耗性能，原因自行看底层源码。
     * 解决方式： -Djavax.xml.parsers.SAXParserFactory="com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl"
     *
     * org.dom4j.io.JAXPHelper#createXMLReader(boolean, boolean)
     *
     * @throws DocumentException
     */
    @Test
    public void test2() throws DocumentException {
        String s = "<xml><zhang>你好</zhang></xml>";
        Document document = DocumentHelper.parseText(s);
        System.out.println(document);
    }

    /**
     * 同test2
     *
     * @throws SAXException
     * @throws DocumentException
     */
    @Test
    public void test3() throws SAXException, DocumentException {
        SAXReader reader = new SAXReader();
//        reader.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        String s = "<xml><zhang>你好</zhang></xml>";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        Document document = reader.read(inputStream);
        System.out.println(document);
    }

    /**
     * stax也有同样的问题
     *
     * @throws XMLStreamException
     */
    @Test
    public void test4() throws XMLStreamException {
        STAXEventReader reader = new STAXEventReader();
        String s = "<xml><zhang>你好</zhang></xml>";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        Document document = reader.readDocument(inputStream);
        System.out.println(document);
    }

    /**
     * https://github.com/dom4j/dom4j/issues/114
     * org.dom4j.tree.QNameCache
     * 多线程下，存在线程锁问题
     *
     */
    @Test
    public void test5(){
        //DocumentFactory.init();
        QNameCache cache;
    }
}
