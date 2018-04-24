package test.mybatis.demotest;

import com.alibaba.druid.support.logging.Resources;

import javax.annotation.Resource;

public class TypeAliasTest {
    public static void main(String[] args) {
        try {
            Class name = Resources.classForName("test.mybatis.demotest.TypeAliasTest");
            System.out.println(name.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
