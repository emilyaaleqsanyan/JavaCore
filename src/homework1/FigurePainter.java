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


        System.out.println();
        System.out.println();
        for (i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        for (i = 0; i < 4; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" ");
            }
            for (int j = 4; j > i; j--) {
                System.out.print(" " + a);
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();
        for (i = 0; i < 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(a);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        for (i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 5; j > i; j--) {
                System.out.print(a);
            }
            System.out.println();
        }
    }

}