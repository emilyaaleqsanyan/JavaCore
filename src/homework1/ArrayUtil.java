package homework1;

import com.sun.security.jgss.GSSUtil;

public class ArrayUtil {
    public static void main(String[] args) {
        System.out.println("Example 1");
        int[] numbers = {1, 6, 3, 9, 15, 52, -3, 5, 8};
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();
        System.out.println();
        System.out.println("Example 2");
        System.out.print(numbers[0]);

        System.out.println();
        System.out.println("Example 3");
        System.out.println(numbers[numbers.length - 1]);


        System.out.println();
        System.out.println("Example 4");
        System.out.println(numbers.length);


        System.out.println();
        System.out.println("Example 5");
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("min = " + min);


        System.out.println();
        System.out.println("Example 6");

        if (numbers.length > 2) {
            if (numbers.length % 2 != 0) {
                System.out.println(numbers[numbers.length / 2]);
            } else System.out.println(numbers[numbers.length / 2] + numbers[numbers.length / 2 + 1]);
        } else System.out.println("can't print middle values");


        System.out.println();
        System.out.println("Example 7");
        int qaunt = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                qaunt++;
            }
        }
        System.out.println(qaunt);


        System.out.println();
        System.out.println("Example 8");
        int qaunt1 = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                qaunt1++;
            }
        }
        System.out.println(qaunt1);

        System.out.println();
        System.out.println("Example 9");
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        System.out.print("sum = " + sum);


        System.out.println();
        System.out.println("Example 10");
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result = result + numbers[i];
        }
        System.out.println("Среднее значение равно " + result / numbers.length);

    }
}
