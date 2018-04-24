/**
 * @company 杭州信牛网络科技有限公司
 * @copyright Copyright (c) 2015 - 2018
 */
package test.mybatis.demotest;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Param;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author 吴中稳(WuZhongWen)
 * @version $Id: MethodTest, v0.1 2018年04月18日 18:56 吴中稳(WuZhongWen) Exp $
 */
public class MethodTest {
    public static void main(String[] args) {
        Method[] methods = MethodTest.class.getDeclaredMethods();
        for (Method data : methods){
            Annotation[][] annotations = data.getParameterAnnotations();
            System.out.println(JSON.toJSONString(annotations));
        }
    }

    public void test(String s, @Param("wode")String data){

    }
}
