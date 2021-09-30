package erpsystem.controller;

import java.io.Serializable;
import java.util.List;

import erpsystem.model.WayToPay;
import javafx.collections.FXCollections;
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
public class WayToPayController implements Serializable{

	private static final long serialVersionUID = 1L;

	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public WayToPayController() {
	}
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	public boolean add(WayToPay pay){
		WayToPay wayToPayModel = new WayToPay();
		return wayToPayModel.add(pay);
	}
	
	public ObservableList<String> findAllName(){
		ObservableList<String> observable = FXCollections.observableArrayList();
		WayToPay wayToPay = new WayToPay();
		List<WayToPay> list = wayToPay.findAll();
		for(WayToPay aux: list) {
			observable.add(aux.getDescricao());
		}
		return observable;
	}
}
