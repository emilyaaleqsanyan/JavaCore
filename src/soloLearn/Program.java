package soloLearn;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;
        while (n > 0){
            sum += n;
            n--;
        }
        System.out.println(sum);
    }
}
