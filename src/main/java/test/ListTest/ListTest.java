package test.ListTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        Collections.sort(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (Integer data : list)
            System.out.println(data);

        //2  测试
        Student student1 = new Student();
        student1.setAge(12);
        student1.setName("张三");
        Student student2 = new Student();
        student2.setName("李四");
        student2.setAge(13);
        Student student3 = new Student();
        student3.setName("王五");
        student3.setAge(14);
        List<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        Collections.sort(students);
        for (Student student: students)
            System.out.println(student.getAge());
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return  o2.getAge() - o1.getAge();
            }
        });
        for (Student student : students)
            System.out.println(student.getAge());
    }
}
