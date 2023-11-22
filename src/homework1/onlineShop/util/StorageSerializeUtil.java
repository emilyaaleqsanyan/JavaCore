package homework1.onlineShop.util;

import homework1.onlineShop.storage.OrderStorage;
import homework1.onlineShop.storage.ProductStorage;
import homework1.onlineShop.storage.UserStorage;

import java.io.*;

public abstract class StorageSerializeUtil {
    private static final String USER_FILE_PATH = "C:\\Users\\Lenovo\\IdeaProjects\\JavaCore\\src\\homework1\\onlineShop\\data\\userStorage.dat";
    private static final String PRODUCT_FILE_PATH = "C:\\Users\\Lenovo\\IdeaProjects\\JavaCore\\src\\homework1\\onlineShop\\data\\productStorage.dat";
    private static final String ORDER_FILE_PATH = "C:\\Users\\Lenovo\\IdeaProjects\\JavaCore\\src\\homework1\\onlineShop\\data\\orderStrage.dat";
    private static final String ADMIN_FILE_PATH = "C:\\Users\\Lenovo\\IdeaProjects\\JavaCore\\src\\homework1\\onlineShop\\data\\adminStorage.dat";

    public static void serializeUserStorage(UserStorage userStorage) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(USER_FILE_PATH))) {
            outputStream.writeObject(userStorage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void serializeProductStorage(ProductStorage productStorage) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(PRODUCT_FILE_PATH))) {
            outputStream.writeObject(productStorage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void serializeOrderStorage(OrderStorage orderStorage) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ORDER_FILE_PATH))) {
            outputStream.writeObject(orderStorage);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static UserStorage deserialazeUserStorage() {
        File file = new File(USER_FILE_PATH);
        if (!file.exists()) {
            return new UserStorage();
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(USER_FILE_PATH))) {
            Object o = inputStream.readObject();
            if (o instanceof UserStorage userStorage) {
                return userStorage;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new UserStorage();
    }

    public static ProductStorage deserialazeProductStorage() {
        File file = new File(PRODUCT_FILE_PATH);
        if(!file.exists()){
            return new ProductStorage();
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(PRODUCT_FILE_PATH))) {
            Object o = inputStream.readObject();
            if (o instanceof ProductStorage productStorage) {
                return productStorage;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ProductStorage();
    }


    public static OrderStorage deserialazeOrderStorage() {
        File file =new File(ORDER_FILE_PATH);
        if(!file.exists()){
            return new OrderStorage();
        }
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ORDER_FILE_PATH))) {
            Object o = inputStream.readObject();
            if (o instanceof OrderStorage orderStorage) {
                return orderStorage;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new OrderStorage();
    }


}
