package test.documentTest.stax;

import org.springframework.core.io.ClassPathResource;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

public class StaxTest {
    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("dom.xml");
        try {
            InputStream inputStream = classPathResource.getInputStream();
            XMLInputFactory xmlFactory = XMLInputFactory.newInstance();
            XMLStreamReader parser = xmlFactory.createXMLStreamReader(inputStream);
            while (parser.hasNext()) {
                int event = parser.next();
                if (event == XMLStreamConstants.START_ELEMENT) {
                    int sum = parser.getAttributeCount();
                    for (int i = 0; i < sum; i++) {
                        System.out.println(parser.getAttributeName(i));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
