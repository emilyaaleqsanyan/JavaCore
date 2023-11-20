package homework.onlineStore.storage;

import homework.onlineStore.model.User;
import homework.onlineStore.model.enams.UserType;
import homework.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserStorage implements Serializable {

    private Map<String,User> users = new HashMap<>();
    private int size;

    public void put(String email, User user) {
        users.put(email,user);
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public void print() {
        for (Map.Entry<String, User> stringUserEntry : users.entrySet()) {
            System.out.println(stringUserEntry);
        }
    }




    public User getByEmail(String email) {
        for (User user : users.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void printByType(UserType userType) {
        for (User user : users.values()) {
            if (user.getUserType() == userType) {
                System.out.println(user);
            }

        }
    }
}
