package soloLearn;

import java.util.Scanner;

public class ColorExample {
   public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please input color");
        String color = scanner.nextLine();
        switch (color){
            case "red":
                System.out.println("1");
                break;
            case"green":
                System.out.println("2");
                break;
            case "black":
                System.out.println("3");
                break;
            default:
                System.out.println("invalid command. Try again!");
        }
    }
}
