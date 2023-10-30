package classwork.chapter12.annotation;

import java.lang.reflect.Method;

public class Meta {
    @MyAnno(str = "Пример аннотации", val = 100)
    public static void myMeth() {
        Meta ob = new Meta();
        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMeth");
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException exc) {
            System.out.println("Метод не найден.");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}
