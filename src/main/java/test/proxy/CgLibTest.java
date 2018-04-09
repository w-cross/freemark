package test.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgLibTest {
    int getNumber(){
        return 4;
    }
}

class MyCglibTest implements MethodInterceptor{

    CgLibTest cgLibTest = new CgLibTest();

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理类先执行");
        Object object = methodProxy.invokeSuper(o,objects);
//        System.out.println(method.invoke(cgLibTest,objects));
        System.out.println(object);
        return object;
    }
}

class initCglibTes{
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CgLibTest.class);
        enhancer.setCallback(new MyCglibTest());
        CgLibTest cgLibTest = (CgLibTest)enhancer.create();
        cgLibTest.getNumber();
    }

}
