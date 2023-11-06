package homework.onlineShop;

import homework.onlineShop.commands.AdminCommands;
import homework.onlineShop.commands.Register;
import homework.onlineShop.commands.UserCommands;
import homework.onlineShop.enums.OrderStatus;
import homework.onlineShop.enums.PaymentMethod;
import homework.onlineShop.exception.OutOfStockException;
import homework.onlineShop.model.Order;
import homework.onlineShop.model.Product;
import homework.onlineShop.enums.ProductType;
import homework.onlineShop.enums.UserType;
import homework.onlineShop.model.User;
import homework.onlineShop.storage.AdminStorage;
import homework.onlineShop.storage.OrderStorage;
import homework.onlineShop.storage.ProductStorage;
import homework.onlineShop.storage.UserStorage;
import homework.onlineShop.util.StorageSerializeUtil;

import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import static homework.onlineShop.enums.UserType.ADMIN;
import static homework.onlineShop.enums.UserType.USER;


public class OnlineShopMain implements Register, UserCommands, AdminCommands {

    private static Scanner scanner = new Scanner(System.in);
    private static UserStorage userStorage = StorageSerializeUtil.deserialazeUserStorage();
    private static ProductStorage productStorage = StorageSerializeUtil.deserialazeProductStorage();
    private static OrderStorage orderStorage = StorageSerializeUtil.deserialazeOrderStorage();
    private static AdminStorage adminStorage = StorageSerializeUtil.deserialazeAdminStorage();
    public static User currentUser = null;


    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            Register.printCommands();
            String command = scanner.nextLine();

            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case LOGIN:
                    typeCommand();
                    break;
                case REGISTER:
                    addUser();
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }


    private static void typeCommand() {

        System.out.println("pleas chose type ADMIN ORE USER");
        String type = scanner.nextLine().toUpperCase();
        switch (type) {
            case "ADMIN":
                AdminLogin();
                break;
            case "USER":
                UserLogin();
                break;
        }
    }


    private static void AdminLogin() {
        System.out.println("Please input email");
        String email = scanner.nextLine();
        System.out.println("Please input password");
        String password = scanner.nextLine();
        User user = adminStorage.searchAdminByEmailPassword(email, password);
        if (user != null) {
            if (user.getType2() == ADMIN) {
                adminCommand();
            }
        } else System.out.println("Invalid email or password. Please try again.");
    }


    private static void UserLogin() {
        System.out.println("Please input email");
        String email = scanner.nextLine();
        System.out.println("please input password");
        String password = scanner.nextLine();
        User user = userStorage.searchByEmailPassword(email, password);
        if (user != null) {
            if (user.getType2() == USER) {
                currentUser = user;
                userCommand();
            }
        } else System.out.println("Invalid email or password. Please try again.");
    }


    private static void adminCommand() {
        boolean isRun = true;
        while (isRun) {
            AdminCommands.printAdminCommands();
            String ac = scanner.nextLine();
            switch (ac) {
                case AdminCommands.LOGOUT:
                    isRun = false;
                    break;
                case ADD_PRODUCT:
                    addProduct();
                    break;
                case REMOVE_PRODUCT_BY_ID:
                    removeById();
                    break;
                case PRINT_PRODUCT:
                    productStorage.print();
                    break;
                case PRINT_USER:
                    userStorage.print();
                    break;
                case PRINT_ORDERS:
                    orderStorage.print();
                    break;
                case CHANG_ORDER_STATUS:
                    try {
                        changeOrderStatus();
                    } catch (OutOfStockException e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }
    }


    private static void userCommand() {
        boolean isRun = true;
        while (isRun) {
            UserCommands.printUserCommands();
            String ac = scanner.nextLine();
            switch (ac) {
                case UserCommands.LOGOUT:
                    isRun = false;
                    break;
                case PRINT_ALL_PRODUCTS:
                    productStorage.print();
                    break;
                case BUY_PRODUCTS:
                    buyProduct();
                    break;
                case PRINT_MY_ORDERS:
                    printMyOrders();
                    break;
                case CANCEL_ORDER_BY_ID:
                    cancelOrderById();
                    break;

            }
        }
    }

    private static void printMyOrders() {
        Order[] myOrder = orderStorage.getMyOrders(currentUser);
        for (Order order : myOrder) {
            System.out.println(order);
        }

    }


    private static void cancelOrderById() {
        System.out.println("Please input order id");
        printMyOrders();
        String id = scanner.nextLine();
        Order order = orderStorage.getOrderById(id);
        if (order != null) {
            order.setOrderStatus(OrderStatus.CANCELED);
            System.out.println("Order cansel");

        }
    }


    private static void buyProduct() {
        System.out.println("Please input product id");
        String productId = scanner.nextLine();
        System.out.println("Please input qty");
        int qty = Integer.parseInt(scanner.nextLine());
        System.out.println("please choose payment method");
        PaymentMethod[] methods = PaymentMethod.values();
        for (PaymentMethod p : methods) {
            System.out.println(p);
        }
        PaymentMethod method = PaymentMethod.valueOf(scanner.nextLine().toUpperCase());
        Product product = null;
        try {
            product = productStorage.getProduct(productId);

            if (product != null) {
                double productPrice = product.getPrice();
                long price = (long) (productPrice * qty);
                System.out.println("Do you want to buy this product " + qty + " things " + "and " + price + " $ ");
                System.out.println("Choose YES if you agree");
                String answer = scanner.nextLine().toUpperCase();
                switch (answer) {
                    case "YES":
                        Date registerDate = new Date();
                        String uuid = orderId();
                        Order order = new Order(uuid, currentUser, product, registerDate, product.getPrice(), OrderStatus.NEW, qty, method);
                        orderStorage.add(order);
                        System.out.println("Order registered!");

                        break;
                }
            }
        } catch (OutOfStockException e) {
            System.out.println(e.getMessage());
        }
    }


    private static String orderId() {
        String uuid = UUID.randomUUID().toString();
        String[] uuids = uuid.split("-");
        String id = uuids[0];
        return id;
    }


    private static void addProduct() {
        System.out.println("please input product id");
        String productId = scanner.nextLine();
        System.out.println("please input product name");
        String productName = scanner.nextLine();
        System.out.println("please input product description ");
        String description = scanner.nextLine();
        System.out.println("please input product prise");
        double prise = Double.parseDouble(scanner.nextLine());
        System.out.println("please input stockQty");
        int stockQty = Integer.parseInt(scanner.nextLine());
        System.out.println("please choose type");
        ProductType[] types = ProductType.values();
        for (ProductType t : types) {
            System.out.println(t);
        }
        ProductType type = ProductType.valueOf(scanner.nextLine().toUpperCase());
        Product product = new Product(productId, productName, description, prise, stockQty, type);
        productStorage.add(product);
        System.out.println("product registered!");


    }


    private static void addUser() {
        System.out.println("please input  id");
        String id = scanner.nextLine();
        System.out.println("please input  name");
        String name = scanner.nextLine();
        System.out.println("please input email");
        String email = scanner.nextLine();
        System.out.println("please input password");
        String password = scanner.nextLine();
        System.out.println("please choose type");
        UserType[] types2 = UserType.values();
        for (UserType t : types2) {
            System.out.println(t);
        }
        UserType type2 = UserType.valueOf(scanner.nextLine().toUpperCase());
        User user = new User(id, name, email, password, type2);
        userStorage.add(user);
        System.out.println("User registered!");


    }


    private static void changeOrderStatus() throws OutOfStockException {
        orderStorage.orderStatusChange();
        Order[] order = orderStorage.newOrder();

        for (Order order1 : order) {
            String id = order1.getProduct().getId();
            int qty = order1.getQty();
            Product product = productStorage.getProduct(id);
            int stockQty = product.getStockQty();
            product.setStockQty(stockQty - qty);
            StorageSerializeUtil.serializeProductStorage(productStorage);
        }

    }

    private static void removeById() {
        System.out.println("please input id");
        String id = scanner.nextLine();
        productStorage.removeById(id);

    }
}







