package soloLearn;

import java.util.Scanner;

public class SoloLearn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input price");
        Double price = Double.parseDouble(scanner.nextLine());
        double summ = price * 15 / 100;
        System.out.println(summ);
    }
}
