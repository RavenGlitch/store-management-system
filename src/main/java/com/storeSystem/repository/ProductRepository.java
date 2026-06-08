package com.storeSystem.repository;
import java.util.ArrayList;
import java.util.List;

import com.storeSystem.model.Product;
public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }
    public List<Product> getAll(){
        return products;
    }
    public void delete(Product product) {
        products.remove(product);
    }
}
