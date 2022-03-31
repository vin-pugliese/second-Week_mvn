package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
public @interface SingleTestAnnotation {

    String item();
    TestAnnotationEnum value();
}
