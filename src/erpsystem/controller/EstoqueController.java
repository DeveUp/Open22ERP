package erpsystem.controller;

import java.io.Serializable;

import erpsystem.model.Estoque;

/**
 * @project Open22ERP.
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 * @version 2.0.0.
 */
public class EstoqueController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public EstoqueController() {
	}
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	public Estoque find(int code) {
		Estoque et = new Estoque();
		et.find(code);
		return et;
	}
	
	public boolean add(Estoque estoque) {
		Estoque et = new Estoque();
		return et.add(estoque);
	}
}
