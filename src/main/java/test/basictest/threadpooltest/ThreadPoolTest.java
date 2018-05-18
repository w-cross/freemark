/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2018
 */
package test.basictest.threadpooltest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author 吴中稳(WuZhongWen)
 * @version $Id: ThreadPoolTest, v0.1 2018年04月30日 13:03 吴中稳(WuZhongWen) Exp $
 */
public class ThreadPoolTest {

    private static int times = 1000000;

    public static void main(String[] args) {
        ThreadPoolTest threadPoolTest = new ThreadPoolTest();
        List<Integer> list = threadPoolTest.test1();
        for (Integer data : list){
            System.out.println(data);
        }
    }


    /**
     * threadPoolExcutor测试类
     * @return
     */
    public List test1() {
        ArrayBlockingQueue a = new ArrayBlockingQueue(10);
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(5, 10, 100, TimeUnit.NANOSECONDS, a);
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < times; i++) {
            ThreadTest threadTest = new ThreadTest();
            Future<Integer> result = threadPoolExecutor.submit(threadTest);
            try {
                list.add(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static class ThreadTest implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return 5;
        }
    }

    public void poolTest(){
        ExecutorService executorService = Executors.newFixedThreadPool(times);
    }

}
