package classwork.chapter11;

public class ExtendThread {
    public static void main(String[] args) {
        new NewThread1();

        try{
            for (int i = 5; i > 0 ; i--) {
                System.err.println("Главный поток: " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.err.println("Главный поток прерван.");
        }
        System.err.println("Главный поток завершен.");
    }
}
