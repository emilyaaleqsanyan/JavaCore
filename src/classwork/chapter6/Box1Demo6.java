package classwork.chapter6;

public class Box1Demo6 {
    public static void main(String[] args) {
        Box1 mybox1 = new Box1();
        Box1 mybox2 = new Box1();
        double vol1, vol2;
        vol1 = mybox1.volume();
        System.out.println("Объем равен " + vol1);
        vol2 = mybox2.volume();
        System.out.println("Объем равен " + vol2);
    }
}
