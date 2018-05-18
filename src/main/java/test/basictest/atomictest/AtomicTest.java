package test.basictest.atomictest;


import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicTest {
    private  static int g = 5;
    public static void main(String[] args) {
        int i = 5;
        AtomicInteger atomicInteger = new AtomicInteger(i);
        System.out.println(atomicInteger.compareAndSet(4,6));
        System.out.println(atomicInteger.get());
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        System.out.println(atomicBoolean.get());
        AtomicTest atomicTest = new AtomicTest();
        atomicTest.test1();
        atomicTest.test2();
        atomicTest.test3();
        atomicTest.test5();
        AtomicTest atomicTest1 = new AtomicTest();
        atomicTest1.test2();
    }

    public  void test1(){
        System.out.println(g++);

    }
    public  void test2(){
        System.out.println(g);
    }
    public void test3(){
        System.out.println(g);
    }

    public void test4(){
        int[] value = new int[]{0,1};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(value);
        System.out.println();
        Object o = new Object();

    }

    public void test5(){
        Integer i = 234;
        Integer g = 234;
        System.out.println(i == g);
    }
}
