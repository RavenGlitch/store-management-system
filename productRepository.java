package repository;
import java.util.ArrayList;
import java.util.List;

import model.category;
import model.product;
public class productRepository {
	private List<product>products=new ArrayList<>();
	public void add(product product) {
		products.add(product);
	}
	public List<product>getAll(){
		return products;
	}
	public void delete(product product) {
		products.remove(product);
	}
}
