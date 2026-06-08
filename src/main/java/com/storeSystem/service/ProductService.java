package com.storeSystem.service;

import com.storeSystem.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import com.storeSystem.model.Product;
import com.storeSystem.repository.ProductRepository;
public class ProductService {
    private ProductRepository repository=new ProductRepository();
    public void addProduct(Product product) {
        repository.add(product);
    }
    public List<Product>getAllProducts(){
        return repository.getAll();
    }
    public void deleteProduct(Product product) {
        repository.delete(product);
    }

}
