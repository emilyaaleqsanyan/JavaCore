package classwork.chapter2;

public class IfSample {
    public static void main(String[] args) {
        int x, y;
        x = 10;
        y = 20;
        if (x < y) {
            System.out.println("x менше y");
        }
        x = x * 2;
        if (x == y) {
            System.out.println("x теперь равно y");
        }
        x = x * 2;
        if (x > y) {
            System.out.println("x теперь больше y");
        }
        if (x == y) {
            System.out.println("вы не увидите этого");
        }
    }

}
