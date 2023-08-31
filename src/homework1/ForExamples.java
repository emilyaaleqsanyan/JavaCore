package homework1;

//for example 1
public class ForExamples {
    public static void main(String[] args) {
        int i;
        for (i = 1; i < 1000; i++) {
            System.out.print(i + "-");
        }
        if (i > 999) {
            System.out.println(i++);
        }

        System.out.println();
        System.out.println();

        //for example 2
        for (i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
        System.out.println();

        //for example 3
        int[] array = {2, 5, 8, 4, 9, 3, 7};
        int max = array[0];
        for(i = 1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }
            System.out.println("Наибольшой элемент: " + max);

    }


}
