package test.mybatis.demotest;


import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

import java.util.HashMap;
import java.util.Map;

/**
 * ognl 测试  注意对象的get和set方法要写
 * <p>
 * 1.所有元素都必须以key value形式放入，除非是root元素
 * <p>
 * 2.map形式放入的为基本变量，可通过key直接取value
 */
public class OgnlTest {
    public static void main(String[] args) {
        OgnlContext ognlContext = new OgnlContext();
        CommonClass commonClass = new CommonClass();
        commonClass.setAge("23");
        commonClass.setName("wu");
        Object data = null;
        try {
            //root测试
            //非root
            ognlContext.put("commonClass", commonClass);
            Object expression = Ognl.parseExpression("#commonClass.name");
            data = Ognl.getValue(expression, ognlContext, ognlContext.getRoot());
            System.out.println(data);
            //去获取key对应的value中的某个属性的值
            Object object = Ognl.getValue("commonClass", ognlContext);
            System.out.println("获取key对应的value中的值" + Ognl.getValue("name", object));
            //root
            ognlContext.setRoot(commonClass);
            System.out.println(Ognl.getValue("name", ognlContext, ognlContext.getRoot()));
            //各种元素值测试
            //1.map直接取值
            Map<String, String> map = new HashMap<String, String>();
            map.put("first", "w");
            map.put("second", "z");
            ognlContext.putAll(map);
            System.out.println(ognlContext.get("first"));
            System.out.println(Ognl.getValue("second", ognlContext));
            //2.若value是一个map，从该map中取值
            ognlContext.put("mapTest", map);
            Object mapTest = Ognl.getValue("mapTest",ognlContext);
            System.out.println("mapTest结果为"+Ognl.getValue("first",mapTest));
            //调用静态方法测试(属于jdk内部的方法)
            Object type = Ognl.parseExpression("@Math@floor(10.9)");
            System.out.println(Ognl.getValue(type, ognlContext, ognlContext.getRoot()));
        } catch (OgnlException e) {
            e.printStackTrace();
        }

    }
}
