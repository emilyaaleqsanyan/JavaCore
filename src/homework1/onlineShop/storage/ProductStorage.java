package homework1.onlineShop.storage;

import homework1.onlineShop.exception.OutOfStockException;
import homework1.onlineShop.model.Product;
import homework1.onlineShop.util.StorageSerializeUtil;

import java.io.Serializable;

public class ProductStorage implements Serializable {
    private Product[] products = new Product[10];
    private int size;

    public void add(Product product) {
        if (size == products.length) {
            extend();
        }
        products[size++] = product;
        StorageSerializeUtil.serializeProductStorage(this);
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }
    }


//    public void deleteOrderByQty(int orderQty, Product product) {
//        for (int i = 0; i < orderQty; i++) {
//            for (int j = 0; j < size; j++) {
//                if (products[i].equals(product)) {
//                    products[i - 1] = products[i];
//                }
//            }
//
//        }
//        size--;
//    }


    public void removeById(String id) {
        int indexById = getIndexByID(id);
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(id)) {
                products[i - 1] = products[i];
            }
        }
        size--;
        StorageSerializeUtil.serializeProductStorage(this);
    }

    private int getIndexByID(String id) {
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public Product getProduct(String id) throws OutOfStockException {
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(id)) {
                return products[i];
            }
        }
        throw new OutOfStockException("not available");
    }


    private void extend() {
        Product[] tmp = new Product[products.length + 10];
        System.arraycopy(products, 0, tmp, 0, products.length);
        products = tmp;
    }


}
