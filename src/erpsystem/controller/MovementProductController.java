package erpsystem.controller;

import java.io.Serializable;

import erpsystem.model.MovProd;
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
public class MovementProductController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public MovementProductController() {
	}
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	public ObservableList<MovProd> findProds(int codMov) {
		MovProd movementProd = new MovProd();
		return movementProd.findProds(codMov);
	}

}
