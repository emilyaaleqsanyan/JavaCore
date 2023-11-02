package homework.onlineShop.storage;

import homework.onlineShop.exception.OutOfStockException;
import homework.onlineShop.model.Product;

public class ProductStorage {
    private Product[] products = new Product[10];
    private int size;

    public void add(Product product) {
        if (size == products.length) {
            extend();
        }
        products[size++] = product;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(products[i]);
        }
    }


    public void deleteOrderByQty(int orderQty, Product product) {
        for (int i = 0; i < orderQty; i++) {
            for (int j = 0; j < size; j++) {
                if (products[i].equals(product)) {
                    products[i - 1] = products[i];
                }
            }

        }
    }


    public void removeById(String id) {
        int indexById = getIndexByID(id);
        for (int i = 0; i < size; i++) {
            if (products[i].getId().equals(id)) {
                products[i - 1] = products[i];
            }
        }
        size--;
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
