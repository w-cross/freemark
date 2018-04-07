package test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface ProxyTest1 {
    String getNumber();
}

public class ProxyTest implements ProxyTest1{
    public String getNumber(){
        String data = "真实类开始了";
        return data;
    }
}

class ProxyTestProxy implements InvocationHandler{
    Object proxyTest;

    public  ProxyTestProxy(Object proxyTest){
        this.proxyTest = proxyTest;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类先开始");
        Object object = method.invoke(proxyTest,args);
        System.out.println("代理类结束");
        return object;
    }
}

class initTest {
    public static void main(String[] args) {
        ProxyTest1 proxyTest = new ProxyTest();
        ProxyTestProxy proxyTestProxy = new ProxyTestProxy(proxyTest);
        ProxyTest1 proxyTest1 =  (ProxyTest1)Proxy.newProxyInstance(proxyTest.getClass().getClassLoader(),
                proxyTest.getClass().getInterfaces(),
                proxyTestProxy);
        System.out.println(proxyTest1.getNumber());
    }
}