/**
 * @company
 * @copyright Copyright (c) 2015 - 2018
 */
package test.basictest.ListTest;

/**
 * @author
 * @version $Id: Worker, v0.1 2018年04月16日 12:05  Exp $
 */
public class Student implements Comparable<Student>{
    private Integer age;
    private String name;

    /**
     * Getter method for property <tt>age</tt>.
     *
     * @return property value of age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     *
     * @param age value to be assigned to property age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

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



    @Override
    public int compareTo(Student o) {
        return o.getAge() - this.getAge();
    }
}
