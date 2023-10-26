package classwork.chapter12;

public class EnumDemo {
    public static void main(String[] args) {
        Apple ap;
        ap = Apple.RED_DEL;
        System.out.println("Значение ap: " + ap);
        System.out.println();
        ap = Apple.GOLDEN_DEL;
        if (ap == Apple.GOLDEN_DEL) {
            System.out.println("Переменная ap содержит GOLDEN.\n");
            switch (ap) {
                case JONATHAN:
                    System.out.println("Сорт JONATHAN красный.");
                    break;
                case GOLDEN_DEL:
                    System.out.println("Сорт GOLDEN_DEL желтый.");
                    break;
                case RED_DEL:
                    System.out.println("Сорт RED_DEL красный");
                    break;
                case WINESAP:
                    System.out.println("Сорт WINESAP красный");
                    break;
                case CORTLAND:
                    System.out.println("Сорт CORTLAND красный");
                    break;
            }
        }

    }
}
