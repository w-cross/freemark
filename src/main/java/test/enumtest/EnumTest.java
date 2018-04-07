/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2018
 */
package test.enumtest;

/**
 * @author 吴中稳(WuZhongWen)
 * @version $Id: EnumTest, v0.1 2018年04月02日 14:29 吴中稳(WuZhongWen) Exp $
 */
public enum EnumTest {
    COLOR("颜色",1);
    private String color;
    private Integer idex;

    EnumTest(String color,Integer index){
        this.color = color;
        this.idex = idex;
    }

    /**
     * Getter method for property <tt>color</tt>.
     *
     * @return property value of color
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter method for property <tt>color</tt>.
     *
     * @param color value to be assigned to property color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter method for property <tt>idex</tt>.
     *
     * @return property value of idex
     */
    public Integer getIdex() {
        return idex;
    }

    /**
     * Setter method for property <tt>idex</tt>.
     *
     * @param idex value to be assigned to property idex
     */
    public void setIdex(Integer idex) {
        this.idex = idex;
    }

    public String getColorByIndex(){
        for (EnumTest enumTest : EnumTest.values()){
            if (enumTest.idex == 1){
                return enumTest.color;
            }
        }
        return null;
    }
}
