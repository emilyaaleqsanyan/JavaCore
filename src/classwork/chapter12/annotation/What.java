package classwork.chapter12.annotation;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface What {
    String description();
}
