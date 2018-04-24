/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2018
 */
package test.mybatis.demotest;

/**
 * @author 吴中稳(WuZhongWen)
 * @version $Id: CommonClass, v0.1 2018年04月20日 10:15 吴中稳(WuZhongWen) Exp $
 */
public class CommonClass {
    private String name;
    private String age;

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

    /**
     * Getter method for property <tt>age</tt>.
     *
     * @return property value of age
     */
    public String getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     *
     * @param age value to be assigned to property age
     */
    public void setAge(String age) {
        this.age = age;
    }

    public static String getNameByAge(String age){
        return "5";
    }

}
