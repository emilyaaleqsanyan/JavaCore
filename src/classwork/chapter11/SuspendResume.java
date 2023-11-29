package classwork.chapter11;

public class SuspendResume {
    public static void main(String[] args) {
        NewThread3 ob1 = new NewThread3("Один");
        NewThread3 ob2 = new NewThread3("Два");

        try {
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Приостоновка потока Один");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Возобновление потока Один");
            ob2.mysuspend();
            System.out.println("Приостоновка потока Два");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Возобновление потока Два");
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }


        try {
            System.out.println("Главный поток прерван");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток завершен");
        }
    }
}
