package homework.figurepainter;

public class FigurePainter {
    void figure1(int n, char c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1 + i; j++) {
                System.out.print(c);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    void figure2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print('*');
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    void figure3(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    void figure4(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = n; j > i; j--) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    void figure5(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print('*' + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" ");
            }
            for (int j = n - 1; j > i; j--) {
                System.out.print(" " + '*');
            }
            System.out.println();
        }
    }
}
