package soloLearn;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Please input number");
        int x = Integer.parseInt(sc.nextLine());

        long fact = 1;

        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        System.out.println("Factorial: " + fact);

    }
}

