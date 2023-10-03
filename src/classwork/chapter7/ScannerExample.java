package classwork.chapter7;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input b");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input + or -");
        String op = scanner.nextLine();
        if(op.equals("+")){
            System.out.println(a + b);
        } else if (op.equals("-")) {
            System.out.println(a - b);
        }else {
            System.out.println("unsupported");
        }
    }

//        System.out.println("Please input full name");
//        String  fullName= scanner.nextLine();
//        String[] fullNameArray = fullName.split(" ");
//        System.out.println(fullNameArray[0]);
//        System.out.println(fullNameArray[1]);
//    }
}
