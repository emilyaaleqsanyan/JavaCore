package classwork.chapter11;

public class DemoJoin {
    public static void main(String[] args) {
        NewThread2 ob1 = new NewThread2("Один");
        NewThread2 ob2 = new NewThread2("Два");
        NewThread2 ob3 = new NewThread2("Три");

        System.out.println("Поток Один запуен: " + ob1.t.isAlive());
        System.out.println("Поток два запущен: " + ob2.t.isAlive());
        System.out.println("Поток три запущен: " + ob3.t.isAlive());

        try {
            System.out.println("Ожидание завершения потоков.");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Поток Один запущен։ " + ob1.t.isAlive());
        System.out.println("Поток два запущен: " + ob2.t.isAlive());
        System.out.println("Поток три запущен: " + ob3.t.isAlive());
        System.out.println("Главный поток завершен.");

    }
}
