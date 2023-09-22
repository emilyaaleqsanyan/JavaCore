package homework.dynamicarray;

public class DynamicArray {
    //սա մեր հիմնական մասիվն է, որտեղ պահելու ենք ավելացվող էլեմենտները
    private int[] array = new int[10];
    //սա մեր մասիվի մեջ ավելացված էլեմենտների քանակն է
    private int size = 0;

    //ստուգել եթե մասիվի մեջ տեղ չկա-> կանչել extend()
    //և ավելացնենք
    public void add(int value) {
        if (size == array.length) {
            extend();
        }
        array[size++] = value;
    }

    //1․ ստեղծել հին մասիվից 10 էլեմենտ ավելի մեծ մասիվ
    //2․ քցել հին մասիվի էլեմենտները նորի մեջ
    //3․ հին մասիվի հղումը կապենք նոր մասիվի հղման հետ։
    private void extend() {
        int[] array1 = new int[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            array1[i] = array[i];
        }
        array = array1;
    }

    //եթե տրված ինդեքսը մեր ունեցած մասիվի ինդեքսի սահմաններում է, վերադարձնել
    // մասիվի index-երրորդ էլեմենտը։ Հակառակ դեպքում վերադարձնել -1։
    public int getByIndex(int index) {
        if (index >= 0 && index < array.length - 1) {
            return array[index];
        }
        return -1;
    }

    //տպել մասիվի ավելացված էլեմենտները
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Токой элемент не существует");
            return;
        }
        for (int i = index; i < size-1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }


    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            System.out.println("Токой элемент не существует");
        } else array[index] = value;
    }

    public void add(int index, int value) {
        if (index < 0 || index >= size) {
            System.out.println("Токой элемент не существует");
        }
        if(size == array.length) {
            extend();
        }
        size++;
        for (int i = size - 1; i >=index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
    }

    public boolean exists(int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public int getIndexByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}

