package homework.onlineStore.storage;

import homework.onlineStore.model.Product;
import homework.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProductStorage implements Serializable {
    private Set<Product> products = new HashSet<>();


    public void add(Product product) {
        products.add(product);
        StorageSerializeUtil.serializeProductStorage(this);
    }

    public Product getById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id) && !product.isRemoved()) {
                return product;
            }
        }
        return null;
    }


    public void print() {
        for (Product product : products) {
            if (!product.isRemoved()) {
                System.out.println(product);
            }
        }
    }



}
