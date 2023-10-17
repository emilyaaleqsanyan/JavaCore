package classwork.chapter9;

public class Client implements Callback {
    public void callback(int p) {
        System.out.println("Метод callback(), " + "вызываемый со значением " + p);
    }

    void nonIFaceMeth() {
        System.out.println("В классах, реализуюих интерфейсы, " + "могут определяться и другие члены.");
    }
}
