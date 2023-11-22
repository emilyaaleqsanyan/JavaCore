package homework1.onlineShop.storage;


import homework1.onlineShop.enums.UserType;
import homework1.onlineShop.model.User;
import homework1.onlineShop.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserStorage implements Serializable {
    private Map<String, User> users = new HashMap<>();


    public void add(String email, User user) {
        users.put(email, user);
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public void print() {
        for (Map.Entry<String, User> stringUserEntry : users.entrySet()) {
            System.out.println(stringUserEntry);
        }
    }

    public User searchByEmailPassword(String email, String password) {
        for (Map.Entry<String, User> stringUserEntry : users.entrySet()) {
            if (stringUserEntry.getKey().equals(email) && stringUserEntry.getValue().getPassword().equals(password)) {
                return  stringUserEntry.getValue();
            }

        } return null;
    }
}

