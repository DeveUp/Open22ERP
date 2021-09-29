package erpsystem.controller;

import java.io.Serializable;
import java.util.List;

import erpsystem.model.Product;
import javafx.collections.ObservableList;

/**
 * @project Open22ERP.
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 * @version 2.0.0.
 */
public class ProductController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public ProductController() {
	}
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	public boolean exists(int code){
		Product productModel = new Product();
		return productModel.exists(code);
	}
	
	public boolean existsBarcode(String code){
		Product productModel = new Product();
		return productModel.existsBarcode(code);
	}
	
	public Product find(int code){
		Product productModel = new Product();
		return productModel.find(code);
	}
	
	public ObservableList<Product> findProd(String desc){
		Product productModel = new Product();
		return productModel.findProd(desc);
	}
	
	public boolean add(Product produto){
		Product productModel = new Product();
		return productModel.add(produto);
	}
}
