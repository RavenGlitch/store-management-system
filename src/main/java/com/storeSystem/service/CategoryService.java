package com.storeSystem.service;
import java.util.List;
import com.storeSystem.model.Category;
import com.storeSystem.repository.CategoryRepository;
public class CategoryService {
    private CategoryRepository repository = new CategoryRepository();
    public void addcategory(Category category) {
        repository.add(category);
    }
    public List<Category>getAllcategories(){
        return repository.getAll();
    }
    public void deletecategory(Category category) {
        repository.delete(category);
    }

}
