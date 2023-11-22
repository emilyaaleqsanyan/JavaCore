package homework1.onlineShop.storage;

import homework1.onlineShop.enums.OrderStatus;
import homework1.onlineShop.model.Order;
import homework1.onlineShop.model.User;
import homework1.onlineShop.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class OrderStorage implements Serializable {
    private final List<Order> orders = new LinkedList<>();


    public void add(Order order) {
        orders.add(order);
        StorageSerializeUtil.serializeOrderStorage(this);
    }


    public void print() {
        for (Order order : orders) {
            System.out.println(order);
        }
    }


    public Order[] getMyOrders(User currentUser) {
       int j = 0;
       Order[] newOrders = new Order[orders.size()];
        for (Order order : orders) {
            if (order.getUser().equals(currentUser)) {
                newOrders[j++] = order;
            }
        }
        return newOrders;
    }

    public void orderStatusChange(){
        for (Order order : orders) {
            if(order.getQty() < order.getProduct().getStockQty()){
                order.setOrderStatus(OrderStatus.DELIVERED);
            }
        }


    }

    public Order[] newOrder() {
        int j = 0;
        Order[] newOrders = new Order[orders.size()];
        for (Order order : orders) {
            if (order.getOrderStatus().equals(OrderStatus.DELIVERED)) {
                newOrders[j++] = order;
            }
        }
        return newOrders;

    }

    public Order getOrderById(String id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

}


