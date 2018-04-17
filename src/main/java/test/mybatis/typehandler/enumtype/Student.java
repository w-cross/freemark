package test.mybatis.typehandler.enumtype;

public enum Student {
    ZHANGSAN("张三",25);
    private String name;
    private Integer age;

    Student(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public static Student getStudentByName(String name){
        for (Student student : Student.values()){
            if (name.equals(student.name)){
                return student;
            }
        }
        return null;
    }


}
