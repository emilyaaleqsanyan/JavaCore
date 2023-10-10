package classwork.chapter8;

public abstract class M {
    abstract void callme();

    void callmetoo(){
        System.out.println("Это конкретный метод. ");
    }
}

class N extends M {
    void callme() {
        System.out.println("Реализация метода callme() в классе N. ");
    }

}

