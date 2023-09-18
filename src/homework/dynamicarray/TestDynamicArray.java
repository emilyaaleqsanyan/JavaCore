package homework.dynamicarray;

public class TestDynamicArray {
    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();
        da.add(6);
        da.add(6);
        da.add(6);
        da.add(6);
        da.add(6);
        da.add(6);
        da.add(4);
        da.add(9);
        da.add(7);
        da.add(7);
        da.add(7);
        da.add(7);
        System.out.println(da.getByIndex(7));
        System.out.println(da.getByIndex(555));
        da.print();
        System.out.println(da.getByIndex(5));

    }

}
