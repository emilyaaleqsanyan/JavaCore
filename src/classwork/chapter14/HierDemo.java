package classwork.chapter14;

public class HierDemo {
    public static void main(String[] args) {
        Gen2<String, Integer> x = new Gen2<>("Значение равно: ", 99);
        System.out.print(x.getOb());
        System.out.println(x.getOb2());
    }
}
