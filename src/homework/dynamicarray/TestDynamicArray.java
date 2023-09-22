package homework.dynamicarray;

import com.sun.security.jgss.GSSUtil;

public class TestDynamicArray {
    public static void main(String[] args) {
        DynamicArray da = new DynamicArray();
        da.add(6);
        da.add(4);
        da.add(7);
        da.add(2);
        da.add(4);
        da.add(3);
        da.add(1);
        da.add(9);
        da.add(4);
        da.add(1);

        da.print();

        //System.out.println(da.getByIndex(555));
//        da.print();
        //System.out.println(da.getByIndex(5));
//        da.deleteByIndex(7);
       // System.out.println();
        //da.print();
        //da.set(1,7);
//        da.add(5,9);
//        System.out.println (da.exists(8));
        System.out.println(da.getIndexByValue(4));
        da.print();

    }

}
