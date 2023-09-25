package classwork.chapter7;

import com.sun.security.jgss.GSSUtil;

public class StaticDemo {
    static int a = 42;
    static int b = 99;

    static void callme() {
        System.out.println("a = " + a);
    }
}
