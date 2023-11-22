package homework1.onlineShop.storage;

import homework1.onlineShop.exception.OutOfStockException;
import homework1.onlineShop.model.Product;
import homework1.onlineShop.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProductStorage implements Serializable {
    private Set<Product> products = new HashSet<>();
    ;


    public void add(Product product) {
        products.add(product);
        StorageSerializeUtil.serializeProductStorage(this);
    }

    public void print() {
        for (Product product : products) {
            System.out.println(product);

        }
    }


    public void removeById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                products.remove(product);

            }
        }
        StorageSerializeUtil.serializeProductStorage(this);
    }


    public Product getProduct(String id) throws OutOfStockException {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        throw new OutOfStockException("not available");
    }


}
