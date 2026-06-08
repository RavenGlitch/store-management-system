package com.storeSystem.repository;
import java.util.ArrayList;
import java.util.List;
import com.storeSystem.model.Category;
public class CategoryRepository {
    private List<Category>categories=new ArrayList<>();
    public void add(Category category) {
        categories.add(category);
    }
    public List<Category>getAll(){
        return categories;
    }
    public void delete(Category category) {
        categories.remove(category);
    }
}
