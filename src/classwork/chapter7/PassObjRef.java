package classwork.chapter7;

public class PassObjRef {
    public static void main(String[] args) {
        Test ob = new Test(15, 20);
        System.out.println("ob.a и ob.b перед вызовом: " + ob.a + " " + ob.b);
        ob.meth(ob);
        System.out.println("ob.a и ob.b после вызова: " + ob.a + " " + ob.b);
    }
}
