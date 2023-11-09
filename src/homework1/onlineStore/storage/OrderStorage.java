package homework1.onlineStore.storage;

import homework1.onlineStore.model.Order;
import homework1.onlineStore.model.User;
import homework1.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;

public class OrderStorage implements Serializable {

    private Order[] orders = new Order[10];

    private int size;

    public void add(Order order) {
        if (orders.length == size) {
            extend();
        }
        orders[size++] = order;
        StorageSerializeUtil.serializeOrderStorage(this);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(orders[i]);
        }
    }

    private void extend() {
        Order[] tmp = new Order[orders.length + 10];
        System.arraycopy(orders, 0, tmp, 0, orders.length);
        orders = tmp;
    }


    public Order getById(String id) {
        for (int i = 0; i < size; i++) {
            if (orders[i].getId().equals(id)) {
                return orders[i];
            }
        }
        return null;
    }

    public void printByUser(User currentUser) {
        for (int i = 0; i < size; i++) {
            if (orders[i].getUser().equals(currentUser)) {
                System.out.println(orders[i]);
            }

        }
    }
}
