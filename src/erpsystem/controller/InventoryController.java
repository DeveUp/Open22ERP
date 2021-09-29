package erpsystem.controller;

import java.io.Serializable;

import erpsystem.model.Inventory;

/**
 * @project Open22ERP.
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 * @version 2.0.0.
 */
public class InventoryController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public InventoryController() {
	}
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	public Inventory find(int code) {
		Inventory et = new Inventory();
		et.find(code);
		return et;
	}
	
	public boolean add(Inventory estoque) {
		Inventory et = new Inventory();
		return et.add(estoque);
	}
}
