package classwork.chapter5;

public class StringSwitch {
    public static void main(String[] args) {
        String str = "два";
        switch (str) {
            case "один":
                System.out.println("один");
                break;
            case "два":
                System.out.println("два");
            case "три":
                System.out.println("три");
            default:
                System.out.println("не совпало");
                break;
        }
    }
}
