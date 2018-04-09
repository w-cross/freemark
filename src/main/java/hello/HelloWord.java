/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2018
 */
package hello;

/**
 * @author 吴中稳(WuZhongWen)
 * @version $Id: HelloWord, v0.1 2018年03月28日 15:05 吴中稳(WuZhongWen) Exp $
 */
public class HelloWord {
    private String name;

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}