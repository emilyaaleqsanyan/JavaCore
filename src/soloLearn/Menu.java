package soloLearn;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        String[] menu = {"Tea", "Espresso", "Americano", "Water", "Hot Chocolate"};
        Scanner sc = new Scanner(System.in);
        boolean isRun = true;
        while (isRun) {
            int index = Integer.parseInt(sc.nextLine());
            if (index < 0 || index >= menu.length) {
                System.out.println("Invalid");
            }
            switch (index) {
                case 0:
                    System.out.println(menu[index]);
                    break;
                case 1:
                    System.out.println(menu[index]);
                    break;
                case 2:
                    System.out.println(menu[index]);
                    break;
                case 3:
                    System.out.println(menu[index]);
                    break;
                case 4:
                    System.out.println(menu[index]);
                    break;
            }
        }
    }
}


