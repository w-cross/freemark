/**
* @company 杭州信牛网络科技有限公司
* @copyright Copyright (c) 2012-2017
*/
package com.freemark.${packageName};


<#list tableData as cl>
    <#if cl.dataType=='varchar'||cl.dataType=='longtext' ||cl.dataType=='text' || cl.dataType=='char'>
    <#elseif cl.dataType=='bigint' || cl.dataType=='int' || cl.dataType=='tinyint'>
    <#elseif cl.dataType=='datetime' || cl.dataType=='timestamp'>
    import java.util.Date;
    <#elseif cl.dataType=='bit'>
    <#elseif cl.dataType=='decimal'>
    import java.math.BigDecimal;
    </#if>
</#list>

/**
* ${tableComment}  - VO实体
*
* @author ${author}(ZhangWenQing)
* @version $Id: ${voName}VO, v0.1 2017年02月23日 17:23 ${author}(ZhangWenQing) Exp $
*/
public class ${voName}VO {

private static final long serialVersionUID = 1L;
<#list tableData as cl>

/**
* @serialField ${cl.columnName}：<#if cl.columnComment??&&cl.columnComment!="">${cl.columnComment}</#if>
*/
    <#if cl.dataType=='varchar'||cl.dataType=='longtext' ||cl.dataType=='text' || cl.dataType=='char'>
    private String ${cl.columnName}="";
    <#elseif cl.dataType=='bigint' || cl.dataType=='int' || cl.dataType=='tinyint'>
    private Integer ${cl.columnName}=0;
    <#elseif cl.dataType=='datetime' ||cl.dataType=='timestamp'>
    private Date ${cl.columnName};
    <#elseif cl.dataType=='bit'>
    private Boolean ${cl.columnName};
    <#elseif cl.dataType=='decimal'>
    private BigDecimal ${cl.columnName};
    <#elseif cl.dataType=='double'>
    private Double ${cl.columnName}=0.0;
    </#if>
</#list>

<#list tableData as cl>

    <#if cl.dataType=='varchar' ||cl.dataType=='longtext'  ||cl.dataType=='text' || cl.dataType=='char'>
        <#assign dataType="String">
    <#elseif cl.dataType=='bigint' || cl.dataType=='int' || cl.dataType=='tinyint'>
        <#assign dataType="Integer">
    <#elseif cl.dataType=='datetime' || cl.dataType=='timestamp'>
        <#assign dataType="Date">
    <#elseif cl.dataType=='bit'>
        <#assign dataType="Boolean">
    <#elseif cl.dataType=='decimal'>
        <#assign dataType="BigDecimal">
    <#elseif cl.dataType=='double'>
        <#assign dataType="Double">
    </#if>
/**
* Getter method for property <tt>${cl.columnName}</tt>.
*
* @return property value of ${cl.columnName}
*/
public ${dataType} get${cl.setAndGetName}() {
    return ${cl.columnName};
}

/**
* Setter method for property <tt>${cl.columnName}</tt>.
*
* @param ${cl.columnName} value to be assigned to property ${cl.columnName}
*/
public void set${cl.setAndGetName}(${dataType} ${cl.columnName}) {
    this.${cl.columnName} = ${cl.columnName};
}
</#list>

}