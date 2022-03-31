package annotations;

import java.lang.annotation.Annotation;
import java.util.Arrays;

@SingleTestAnnotation(
        item = "Ciao",
        value = TestAnnotationEnum.SUCCESS
)
public class TestAnnotationClass {

    @SingleTestAnnotation(
            item = "Ciao",
            value = TestAnnotationEnum.SUCCESS
    )
    private String annotation;

    public void isAnnotationPresent(){


        TestAnnotationClass test = new TestAnnotationClass();
        //if(test.isAnnotationPresent();)
    }

    public static void main(String[] args) {
        Class test = TestAnnotationClass.class;
        Class c = TestAnnotationClass.class;
        Annotation[] a = c.getAnnotations();
        Arrays.stream(a);
    }





}
