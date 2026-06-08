package repository;
import java.util.ArrayList;
import java.util.List;
import model.category;
public class categoryRepository {
	private List<category>categories=new ArrayList<>();
	public void add(category category) {
		categories.add(category);
	}
	public List<category>getAll(){
		return categories;
	}
	public void delete(category category) {
		categories.remove(category);
	}
}
