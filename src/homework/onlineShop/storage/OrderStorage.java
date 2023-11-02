package homework.onlineShop.storage;

import homework.onlineShop.enums.OrderStatus;
import homework.onlineShop.model.Order;
import homework.onlineShop.model.Product;
import homework.onlineShop.model.User;

public class OrderStorage {
    private Order[] orders = new Order[10];
    private int size;


    public void add(Order order) {
        if (size == orders.length) {
            extend();
        }
        orders[size++] = order;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(orders[i]);
        }
    }


    public Order getMyOrders(User currentUser) {
        for (int i = 0; i < size; i++) {
            if (orders[i].getUser().equals(currentUser)) {
                return orders[i];
            }
        }
        return null;
    }

    public int orderQty() {
        for (int i = 0; i < size; i++) {
            if (orders[i].getOrderStatus().equals(OrderStatus.DELIVERED)) {
                return orders[i].getQty();
            }

        }
        return -1;
    }


    public Product getProductId() {
        for (int i = 0; i < size; i++) {
            if (orders[i].getOrderStatus().equals(OrderStatus.DELIVERED)) {
                return orders[i].getProduct();
            }
        }
        return null;
    }


    public void canselOrderById(String id) throws ArrayIndexOutOfBoundsException {
        for (int i = 0; i < size; i++) {
            if (orders[i].getId().equals(id)) {
                for (int j = i; j < size; j++) {
                    orders[j] = orders[j + 1];
                }
            }
        }
        size--;
        throw new ArrayIndexOutOfBoundsException();
    }

    public Order getOrderById(String id) {
        for (int i = 0; i < size; i++) {
            if (orders[i].getId().equals(id)) {
                return orders[i];
            }
        }
        return null;
    }


    private void extend() {
        Order[] tmp = new Order[orders.length + 10];
        System.arraycopy(orders, 0, tmp, 0, orders.length);
        orders = tmp;
    }
}


