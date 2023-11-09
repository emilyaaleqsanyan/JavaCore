package soloLearn;

import java.util.Scanner;

public class Massive {
    public static void main(String[] args) {
        int[][] seats = {
                {0, 0, 0, 1, 1, 1, 0, 0, 1, 1},
                {1, 1, 0, 1, 0, 1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 1, 1}
        };
        Scanner sc = new Scanner(System.in);
        System.out.println("please input i");
        int i = Integer.parseInt(sc.nextLine());
        System.out.println("please input j");
        int j = Integer.parseInt(sc.nextLine());
        if (seats[i][j] == 0) {
            System.out.println("Free");
        } else if (seats[i][j] == 1) {
            System.out.println("Sold");

        }

    }

}


