package service;
import java.util.List;
import model.category;
import repository.categoryRepository;
public class categoryService {
	private categoryRepository repository = new categoryRepository();
	public void addcategory(category category) {
		repository.add(category);
	}
	public List<category>getAllcategories(){
		return repository.getAll();
	}
	public void deletecategory(category category) {
		repository.delete(category);
	}

}
