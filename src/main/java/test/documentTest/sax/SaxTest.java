/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2018
 */
package test.documentTest.sax;

import org.springframework.core.io.ClassPathResource;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

/**
 * @author 吴中稳(WuZhongWen)
 * @version $Id: SaxTest, v0.1 2018年04月06日 17:30 吴中稳(WuZhongWen) Exp $
 */
public class SaxTest {
    public static void main(final String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            ClassPathResource classPathResource = new ClassPathResource("dom.xml");
            InputStream inputStream = classPathResource.getInputStream();
            DefaultHandler defaultHandler = new DefaultHandler(){
                public void startElement (String uri, String localName,
                                          String qName, Attributes attributes)
                        throws SAXException
                {
//                    System.out.println(localName);
                    System.out.println(qName);
                    for (int i =0;i<attributes.getLength();i++){
                        System.out.println(attributes.getValue(i));
                    }
                }
            };
            saxParser.parse(inputStream,defaultHandler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
