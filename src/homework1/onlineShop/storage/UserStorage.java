package homework1.onlineShop.storage;


import homework1.onlineShop.enums.UserType;
import homework1.onlineShop.model.User;
import homework1.onlineShop.util.StorageSerializeUtil;

import java.io.Serializable;

public class UserStorage implements Serializable {
    private User[] users = new User[10];
    private int size;

    public void add(User user) {
        if (size == users.length) {
            extend();
        }
        users[size++] = user;
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            if (users[i].getUserType() == UserType.USER) {
                System.out.println(users[i]);
            }
        }
    }

    public User searchByEmailPassword(String email, String password) {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmile().equals(email) && users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        return null;
    }

    private void extend() {
        User[] tmp = new User[users.length + 10];
        System.arraycopy(users, 0, tmp, 0, users.length);
        users = tmp;
    }

}

