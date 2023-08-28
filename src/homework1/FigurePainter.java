package homework1;

public class FigurePainter {
    public static void main(String[] args) {
        int i;
        char a = '*';
        for (i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(a);
                System.out.print(" ");
            }
            System.out.println();

        }
        System.out.println();
        System.out.println();

        for (i = 0; i < 5; i++) {
            for (int j = 0; j < 1 + i; j++) {
                System.out.print(a);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        for (i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if (j > 5 - i) {
                    System.out.print(a);
                }
                System.out.print(" ");
            }
            System.out.println();
        }

        for (i = 0; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (j > i) {
                    System.out.print(" ");
                }
                System.out.print(a);
            }
            System.out.println();
        }
    }

}