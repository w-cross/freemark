/**
 * @company
 * @copyright Copyright (c) 2015 - 2018
 */
package test.documentTest.dom;

import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import java.io.InputStream;

/**
 * @author
 * @version $Id: XpathTest, v0.1 2018年04月10日 15:13  Exp $
 */
public class XpathTest {
    private static XPath xpath;
    private static DocumentBuilderFactory documentBuilderFactory;
    private static DocumentBuilder documentBuilder;

    public static void main(String[] args) {
        try {
            //1.建造builder工厂
            //2.建造builder
            //3.建造结果对象
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            ClassPathResource classPathResource = new ClassPathResource("dom.xml");
            InputStream inputStream = classPathResource.getInputStream();
            Document document = documentBuilder.parse(inputStream);
            //xpath解析工具，用来解析document
            XPathFactory xPathFactory = XPathFactory.newInstance();
            xpath = xPathFactory.newXPath();
            XpathTest xpathTest = new XpathTest();
            //获取跟元素
            Node node = xpathTest.getNode(document, "/root");
            System.out.println(node.getNodeName());
            //获取根元素下的某个子元素
            Node node1 = xpathTest.getNode(node, "firstchild");
            System.out.println(node1.getNodeName());
            //获取根元素下的某个子元素的所有元素
            NodeList nodeList = node1.getChildNodes();
            System.out.println(nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println(nodeList.item(i).getNodeType()); //1代表子元素，3代表默认填充的元素 #text
                System.out.println(nodeList.item(i).getNodeName());
            }

            //获取某个子元素
            Node node2 = xpathTest.getNode(node,"/root/firstchild");
            System.out.println(node2.getNodeName());
            System.out.println(node2.getChildNodes().getLength());



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过xpath取得节点列表
     *
     * @param node       节点   相当于document
     * @param expression XPath表达式
     * @return NodeList
     * @throws XPathExpressionException XPath表达式异常
     * @see [类、类#方法、类#成员]
     */
    public NodeList selectNodes(Node node, String expression)
            throws XPathExpressionException {
        // XPath对象编译XPath表达式
        XPathExpression xpexpreesion = this.xpath.compile(expression);
        Object object = xpexpreesion.evaluate(node, XPathConstants.NODESET);
        return (NodeList) object;
    }

    /**
     * 获取结点值
     *
     * @param node
     * @return
     */
    public String getNodeValue(Node node) {
        String dataValue = node.getTextContent();
        return dataValue;
    }

    /**
     * 获取结点List
     *
     * @param node
     * @param expression
     * @return
     * @throws XPathExpressionException
     */
    public NodeList getNodeList(org.w3c.dom.Node node, String expression) throws XPathExpressionException {
        NodeList nodeList = (NodeList) xpath.evaluate(expression, node, XPathConstants.NODESET);
        return nodeList;
    }

    /**
     * 获取单个结点
     *
     * @param node
     * @param expression
     * @return
     * @throws XPathExpressionException
     */
    public Node getNode(org.w3c.dom.Node node, String expression) throws XPathExpressionException {
        Node nodeRet = (Node) xpath.evaluate(expression, node, XPathConstants.NODE);
        return nodeRet;
    }
}
