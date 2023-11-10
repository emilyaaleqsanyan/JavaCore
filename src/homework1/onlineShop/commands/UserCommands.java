package homework1.onlineShop.commands;

public interface UserCommands {
    String LOGOUT = "0";
    String PRINT_ALL_PRODUCTS = "1";
    String BUY_PRODUCTS = "2";
    String PRINT_MY_ORDERS = "3";
    String CANCEL_ORDER_BY_ID = "4";


    static void printUserCommands() {
        System.out.println("Please input " + LOGOUT + " for LOGOUT ");
        System.out.println("Please input " + PRINT_ALL_PRODUCTS + " for  PRINT ALL PRODUCTS ");
        System.out.println("Please input " + BUY_PRODUCTS + " for BUY PRODUCTS ");
        System.out.println("Please input " + PRINT_MY_ORDERS + " for PRINT MY ORDERS");
        System.out.println("Please input " + CANCEL_ORDER_BY_ID + " for CANCEL ORDER BY ID ");
    }
}
