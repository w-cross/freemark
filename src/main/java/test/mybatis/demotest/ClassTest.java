package test.mybatis.demotest;

import java.lang.reflect.Method;

/**
 * 类类型判断
 */
public class ClassTest {
    public static void main(String[] args) {
        ClassTest classTest = new ClassTest();
//        1，getDeclaredMethods能拿到所有（不包括继承的方法）；
//        2，getMethods只能拿到public方法（包括继承的类或接口的方法）
        Method[] methods = classTest.getClass().getMethods();
        for (Method data : methods){
            //getDeclaringClass() 表示获得该方法声明的类对象
            if (Object.class.equals(data.getDeclaringClass())){
                System.out.println(data.getName());
            }
        }
    }

    public void test1() {
    }
    public void test2(){}

    public void test3(){}
}
