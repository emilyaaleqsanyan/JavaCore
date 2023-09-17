package homework1;

public class Array_Util {
    int[] numbers;

    public Array_Util(int[] numbers) {
        this.numbers = numbers;
    }

    void Example1() {
        System.out.print("Все элементы массива:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    void Example2() {
        System.out.print("Первый элемент массива:" + numbers[0]);
    }

    void Example3() {
        System.out.println("Последний элемент массива: " + numbers[numbers.length - 1]);
    }

    void Example4() {
        System.out.println("Длинна массива:" + numbers.length);
    }

    void Example5() {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("min = " + min);
    }

    void example6() {
        if (numbers.length > 2) {
            if (numbers.length % 2 != 0) {
                System.out.println(numbers[numbers.length / 2]);
            } else System.out.println(numbers[numbers.length / 2] + " " + numbers[numbers.length / 2 - 1]);
        } else System.out.println("can't print middle values");

    }

    void Example7() {
        int qaunt = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                qaunt++;
            }
        }
        System.out.println("Количества четных элементов массива" + qaunt);
    }

    void Example8() {
        int qaunt1 = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                qaunt1++;
            }
        }
        System.out.println("Количества нечетных элементов:" + qaunt1);
    }

    void Example9() {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        System.out.print("Сумма элементов:" + sum);
    }

    void Example10() {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result = result + numbers[i];
        }
        System.out.println("Среднее арифметическое значение равно " + result / numbers.length);

    }
}
