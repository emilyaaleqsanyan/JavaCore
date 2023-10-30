package classwork.chapter12.annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    String str() default "Тестирование";
    int val() default 9000;
}

