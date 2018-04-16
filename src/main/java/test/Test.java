/**
 * @company
 * @copyright Copyright (c) 2015 - 2018
 */
package test;

/**
 * @author \
 * @version $Id: Test, v0.1 2018年04月02日 15:19 Exp $
 */
public class Test {
    public Test(String s){
        System.out.println("zifuchuan");
    }
    public Test(Integer i){
        System.out.println(1);
    }

    public static void main(String[] args) {
//        Test test = new Test(5);
//        Integer integer1 = 128;
//        Integer integer2 = 128;
//        System.out.println(integer1 == integer2);
//
//        Integer integer3 = 127;
//        Integer integer4 = 127;
//        Integer.valueOf(100);
//        System.out.println(integer3 == integer4);
        String s = "123";
        String s1 = "1" + "23";
        System.out.println(s == s1);

        String str = new String("123");
        String test = String.valueOf(123);

        StringBuilder stringBuilder  = new StringBuilder('a');

    }
}
