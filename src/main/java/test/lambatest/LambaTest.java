package test.lambatest;


public class LambaTest {
    private static Worker worker;
    private static Worker worker1;
    private static Worker worker2;
    private static Worker worker3;
    static {
        worker = new Worker("张三",20);
        worker1 = new Worker("王五",21);
        worker2 = new Worker("李四",22);
        worker3 = new Worker("孙六",23);

    }
    public static void main(String[] args) {

    }
}
