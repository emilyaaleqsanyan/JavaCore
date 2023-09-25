package classwork.chapter7;

public class AccessTest1 {
    public static void main(String[] args) {
        Test1 ob = new Test1();
        ob.a = 10;
        ob.b = 20;
        ob.setc(100);
        System.out.println("a,b и c: " + ob.a + " " + ob.b + " " + ob.getc());
    }
}
