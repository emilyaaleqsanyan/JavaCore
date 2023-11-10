package homework1.onlineShop.storage;

import homework1.onlineShop.enums.OrderStatus;
import homework1.onlineShop.model.Order;
import homework1.onlineShop.model.User;
import homework1.onlineShop.util.StorageSerializeUtil;

import java.io.Serializable;

public class OrderStorage implements Serializable {
    private Order[] orders = new Order[10];
    private int size;


    public void add(Order order) {
        if (size == orders.length) {
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


    public Order[] getMyOrders(User currentUser) {
       int j = 0;
       Order[] newOrders = new Order[size];
        for (int i = 0; i < size; i++) {
            if (orders[i].getUser().equals(currentUser)) {
                newOrders[j++] = orders[i];
            }
        }
        return newOrders;
    }

    public void orderStatusChange(){
        for (int i = 0; i < size; i++) {
            if(orders[i].getQty() < orders[i].getProduct().getStockQty()){
                orders[i].setOrderStatus(OrderStatus.DELIVERED);
            }
        }


    }

    public Order[] newOrder() {
        int j = 0;
        Order[] newOrders = new Order[size];
        for (int i = 0; i < size; i++) {
            if (orders[i].getOrderStatus().equals(OrderStatus.DELIVERED)) {
                newOrders[j++] = orders[i];
            }
        }
        return newOrders;

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


