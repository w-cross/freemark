package test.basictest.ListTest;

import com.alibaba.fastjson.JSON;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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


        Map<String,String>  map = new HashMap<String, String>();
        map.put("w","1");
        map.put("w","2");
        map.put("w","3");
        System.out.println(JSON.toJSONString(map));
        String begDate = "2017-10-1";
        String end = "2018-3-1";
        List<String> stringList = getDateBetweenTwoDate(begDate,end);
        System.out.println(stringList.size());
    }


    public static ArrayList<String> getDateBetweenTwoDate(String begDate, String end) {
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Date startDate = null;
        Date endDate = null;
        try {
            startDate = df.parse(begDate);
            endDate = df.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        startCalendar.setTime(startDate);
        endCalendar.setTime(endDate);
        ArrayList<String> list = new ArrayList();
        list.add(begDate);
        while (true) {
            startCalendar.add(Calendar.MONTH, 1);
            if (startCalendar.getTimeInMillis() <= endCalendar.getTimeInMillis()) {
                list.add(df.format(startCalendar.getTime()));
            } else {
                break;
            }
        }
        return list;
    }

}
