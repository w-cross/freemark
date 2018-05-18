
package test.basictest.dequetest;



import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class DequeTest {
    public static void main(String[] args) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(12);
        arrayBlockingQueue.add("s");
        String result = (String)arrayBlockingQueue.peek();
        System.out.println(result);
        AbstractQueuedSynchronizer abstractQueuedSynchronizer = null;
        ConcurrentHashMap concrrentHashMap = new ConcurrentHashMap();
        Map<String,String> map = new HashMap<String, String>();
        String s = "akey";
        map.put("1",s);


        //队列
        DelayQueue delayQueue = new DelayQueue();



    }
}
