package classwork.chapter5;

import com.sun.security.jgss.GSSUtil;

public class Break {
    public static void main(String[] args) {
        boolean t = true;
        first:
        {
            second:
            {
                third:
                {
                    System.out.println("Предшествует оператор break.");
                    if (t) break second;
                    System.out.println("Этот оператор не будет выполняться");
                }
                System.out.println("Этот оператор не будет выполняться");
            }
            System.out.println("Этот оператор не будет выполняться");
        }
    }
}
