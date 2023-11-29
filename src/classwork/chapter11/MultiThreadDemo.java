package classwork.chapter11;

public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewThread2("Один");
        new NewThread2("Два");
        new NewThread2("Три");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершен");
    }
}
