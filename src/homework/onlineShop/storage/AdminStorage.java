package homework.onlineShop.storage;

import homework.onlineShop.commands.AdminCommands;
import homework.onlineShop.enums.UserType;
import homework.onlineShop.model.User;

public class AdminStorage {
    private static String id = "A001";
    private static String name = "Emilya";
    private static String mail = "emilyaaleqsanyan@gmail.com";
    private static String password = "1111";
    private static UserType type = UserType.ADMIN;
    User user = new User("A001", "Emilya", "emilyaaleqsanyan@gmail.com", "1111", UserType.ADMIN);


    public User searchAdminByEmailPassword(String email, String password) {

        if (user.getEmile().equals(email) && user.getPassword().equals(password)) {
            return user;
        }
        return null;


    }


}
