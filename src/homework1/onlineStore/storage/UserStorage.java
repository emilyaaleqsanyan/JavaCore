package homework1.onlineStore.storage;

import homework1.onlineStore.model.User;
import homework1.onlineStore.model.enams.UserType;
import homework1.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;

public class UserStorage implements Serializable {

    private User[] users = new User[10];
    private int size;

    public void add(User user) {
        if (users.length == size) {
            extend();
        }
        users[size++] = user;
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(users[i]);
        }
    }


    private void extend() {
        User[] tmp = new User[users.length + 10];
        System.arraycopy(users, 0, tmp, 0, users.length);
        users = tmp;
    }

    public User getByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(email)) {
                return users[i];
            }
        }
        return null;
    }

    public void printByType(UserType userType) {
        for (int i = 0; i < size; i++) {
            if (users[i].getUserType() == userType) {
                System.out.println(users[i]);
            }

        }
    }
}
