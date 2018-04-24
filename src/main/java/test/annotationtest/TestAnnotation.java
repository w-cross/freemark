
package test.annotationtest;

import java.lang.annotation.Annotation;


public class TestAnnotation {
    public static void main(String[] args) {
        AnotationsTest anotationsTest = new AnotationsTest();

        //测试
        AnnotationTest annotationTest = anotationsTest.getClass().getAnnotation(AnnotationTest.class);
        System.out.println(annotationTest.hello());


        //测试
        Annotation[] annotations = anotationsTest.getClass().getAnnotations();
        if (annotations != null){
            AnnotationTest annotationTest1 = (AnnotationTest)annotations[0];
            System.out.println(annotationTest1.hello());
        }
    }
}
