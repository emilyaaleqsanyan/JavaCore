package classwork.chapter10;

public class ThrowsDemo {
    static void throeOne() throws IllegalAccessException {
        System.out.println("В теле метода throwOne().");
        throw new IllegalAccessException("демонстрация");
    }

    public static void main(String[] args) {
        try {
            throeOne();
        } catch (IllegalAccessException e) {
            System.out.println("Перехвачено исключение:" + e);
        }
    }
}
