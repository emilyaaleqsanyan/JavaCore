package classwork.chapter12;

public class AutoBox3 {
    public static void main(String[] args) {
        Integer iOb, iOb2;
        int i;

        iOb = 100;
        System.out.println("Исходное значение iOb: " + iOb);

        ++iOb;
        System.out.println("После ++iOb: " + iOb);

        i = iOb + (iOb / 3);
        System.out.println("i после выражения: " + i);
    }
}
