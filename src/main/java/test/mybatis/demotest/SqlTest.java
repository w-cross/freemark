package test.mybatis.demotest;


public class SqlTest {
    public static void main(String[] args) {
        String data = "#{}abad";
        int start = data.indexOf("#{",0);

        int end = data.indexOf("a",0);

        System.out.println(start);
        System.out.println("end"+end);
    }
}
