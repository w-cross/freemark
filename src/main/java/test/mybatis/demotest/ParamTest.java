package test.mybatis.demotest;


public class ParamTest {
    public static void main(String[] args) {
        ParamTest paramTest = new ParamTest();
        paramTest.test("2");
    }

    public void test(String s){
        System.out.println(s.getClass().getTypeParameters());
        System.out.println(s.getClass().getDeclaredFields()[0].getName());
        System.out.println(s.getClass().getSimpleName());
    }

}
