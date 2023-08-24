package homework.chapter2;

import com.sun.security.jgss.GSSUtil;

import java.sql.SQLOutput;

public class IfExample {
    public static void main(String[] args) {
        int x, y;
        x = 20;
        y = 15;
        if (x > y) {
            System.out.println("x больше y");
        }
        y = y + 5;
        if (x == y) {
            System.out.println("x теперь равно y");
        }
        x = y - 15;
        if (x < y) {
            System.out.println("x теперь меньше y");
        }
    }
}