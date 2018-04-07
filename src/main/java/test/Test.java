/**
 * @company
 * @copyright Copyright (c) 2015 - 2018
 */
package test;

/**
 * @author 吴中稳(WuZhongWen)
 * @version $Id: Test, v0.1 2018年04月02日 15:19 吴中稳(WuZhongWen) Exp $
 */
public class Test {
    public Test(String s){
        System.out.println("zifuchuan");
    }
    public Test(Integer i){
        System.out.println(1);
    }

    public static void main(String[] args) {
        Test test = new Test(5);
    }
}
