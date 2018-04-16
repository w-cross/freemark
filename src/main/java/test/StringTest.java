/**
 * @company
 * @copyright Copyright (c) 2015 - 2018
 */
package test;

import hello.HelloWord;

import java.util.logging.Handler;

/**
 * @author
 * @version $Id: StringTest, v0.1 2018年04月09日 19:11 Exp $
 */
public class StringTest {
    public static void main(String[] args) {
        String s = new String("aaa");
        test(s);
        System.out.println(s);

        HelloWord helloWord = new HelloWord();
        helloWord.setName("张三");
        System.out.println(helloWord);
        helloWord = new HelloWord();
        System.out.println(helloWord);
        test1(helloWord);
        System.out.println(helloWord);
        System.out.println(helloWord.getName());
    }

    public static void  test(String str){
        System.out.println(str);
        str = "bbb";
        System.out.println(str);
    }
    public static void test1(HelloWord helloWord){
        helloWord = new HelloWord();
        helloWord.setName("里斯");

    }
}
