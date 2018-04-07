/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2018
 */
package test.documentTest.dom;


import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.*;
import test.documentTest.entity.DomXml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 吴中稳(WuZhongWen)
 * @version $Id: DocTest, v0.1 2018年04月06日 15:10 吴中稳(WuZhongWen) Exp $
 */
public class DocTest {
    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            ClassPathResource classPathResource = new ClassPathResource("dom.xml");
            InputStream inputStream = classPathResource.getInputStream();
            Document document = documentBuilder.parse(inputStream);
            //根元素
            Element element = document.getDocumentElement();
            //1.获取根元素的名字
            System.out.println(element.getTagName());
            //2.获取根元素的所有属性
            List<DomXml> domXmlList = new ArrayList<DomXml>();
            NamedNodeMap namedNodeMap = element.getAttributes();
            for (int i = 0; i < namedNodeMap.getLength(); i++) {
                DomXml domXml = new DomXml();
                domXml.setName(namedNodeMap.item(i).getNodeName());
                domXml.setDesc(namedNodeMap.item(i).getNodeValue());
                domXmlList.add(domXml);
            }
            //遍历子元素
            NodeList nodeList = element.getChildNodes();
            element.getFirstChild();
            element.getNextSibling();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element){

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

