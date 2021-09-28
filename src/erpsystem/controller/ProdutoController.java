package erpsystem.controller;

import java.io.Serializable;
import java.util.List;

import erpsystem.model.Produto;

/**
 * @project Open22ERP.
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 * @version 2.0.0.
 */
public class ProdutoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public ProdutoController() {
	}
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	public boolean exists(int code){
		Produto productModel = new Produto();
		return productModel.exists(code);
	}
	
	public Produto find(int code){
		Produto productModel = new Produto();
		return productModel.find(code);
	}
	
	public List<Produto> findProd(String desc){
		Produto productModel = new Produto();
		return productModel.findProd(desc);
	}
	
	public boolean add(Produto produto){
		Produto productModel = new Produto();
		return productModel.add(produto);
	}
}
