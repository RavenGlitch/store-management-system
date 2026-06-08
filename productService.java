package service;
import java.util.List;
import model.product;
import repository.productRepository;
public class productService {
	private productRepository repository=new productRepository();
	public void addProduct(product product) {
		repository.add(product);
	}
	public List<product>getAllProducts(){
		return repository.getAll();
	}
	public void deleteProduct(product product) {
		repository.delete(product);
	}

}
