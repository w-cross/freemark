package freemark.model;


public class MetaDataModel {
    private String columnName;
    private String dataType;
    private String columnComment;
    private String setAndGetName;


    public String getSetAndGetName() {
        return setAndGetName;
    }

    public void setSetAndGetName(String setAndGetName) {
        this.setAndGetName = setAndGetName;
    }

    /**
     * Getter method for property <tt>columnName</tt>.
     *
     * @return property value of columnName
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * Setter method for property <tt>columnName</tt>.
     *
     * @param columnName value to be assigned to property columnName
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Getter method for property <tt>dataType</tt>.
     *
     * @return property value of dataType
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * Setter method for property <tt>dataType</tt>.
     *
     * @param dataType value to be assigned to property dataType
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * Getter method for property <tt>columnComment</tt>.
     *
     * @return property value of columnComment
     */
    public String getColumnComment() {
        return columnComment;
    }

    /**
     * Setter method for property <tt>columnComment</tt>.
     *
     * @param columnComment value to be assigned to property columnComment
     */
    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }


}
