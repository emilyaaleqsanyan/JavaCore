package homework.onlineShop.commands;

public interface AdminCommands {

    String LOGOUT = "0";
    String ADD_PRODUCT = "1";
    String REMOVE_PRODUCT_BY_ID = "2";
    String PRINT_PRODUCT = "3";
    String PRINT_USER = "4";
    String PRINT_ORDERS = "5";
    String CHANG_ORDER_STATUS = "6";


    static void printAdminCommands() {
        System.out.println("Please input " + LOGOUT + " for LOGOUT ");
        System.out.println("Please input " + ADD_PRODUCT + " for ADD PRODUCT ");
        System.out.println("Please input " + REMOVE_PRODUCT_BY_ID + " for REMOVE PRODUCT BY ID ");
        System.out.println("Please input " + PRINT_PRODUCT + " for PRINT PRODUCT ");
        System.out.println("Please input " + PRINT_USER + " for PRINT USER ");
        System.out.println("Please input " + PRINT_ORDERS + " for PRINT ORDER ");
        System.out.println("Please input " + CHANG_ORDER_STATUS + " for CHANG ORDER STATUS ");
    }
}
