package com.freemark.query;




public class TestVO {

private static final long serialVersionUID = 1L;

/**
* @serialField id：主键id
*/
    private Integer id=0;

/**
* @serialField name：姓名
*/
    private String name="";


/**
* Getter method for property <tt>id</tt>.
*
* @return property value of id
*/
public Integer getId() {
    return id;
}

/**
* Setter method for property <tt>id</tt>.
*
* @param id value to be assigned to property id
*/
public void setId(Integer id) {
    this.id = id;
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

}