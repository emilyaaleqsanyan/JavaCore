package classwork.chapter12;

public class EnumDemo3 {
    public static void main(String[] args) {
        Apple ap;
        System.out.println("Яблоко сорта WINESAP стоит" + Apple.WINESAP.getPrice() + "центов.\n");
        System.out.println("цены на вес сорта яблок:");
        for(Apple a : Apple.values()){
            System.out.println(a + "стоит " + a.getPrice() + " центов.");
        }
    }
}
