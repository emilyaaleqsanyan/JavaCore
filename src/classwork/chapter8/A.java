package classwork.chapter8;

public class A {
    int i, j;

    void showij() {
        System.out.println("i и j: " + i + " " + j);
    }
    void callme(){
        System.out.println("В методе callme() из класса A");
    }
}

class B extends A {
    int k;

    void showk() {
        System.out.println("k: " + k);
    }
    void callme(){
        System.out.println("В методе callme() из класса B");
    }

    void sum() {
        System.out.println("i + j + k: " + (i + j + k));
    }
}
class C extends A{
    void callme(){
        System.out.println("В методе callme() из класса C");
    }
}
