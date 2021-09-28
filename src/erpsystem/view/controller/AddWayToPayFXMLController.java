package erpsystem.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import erpsystem.controller.WayToPayController;
import erpsystem.model.WayToPay;
import erpsystem.util.Util;
import erpsystem.util.Variable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/**
 * @project Open22ERP.
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 * @version 2.0.0.
 */
public class AddWayToPayFXMLController implements Initializable {
	
	@FXML
	private TextField addNameWayToPay;
	
	@FXML
	private TextField addDaysPaidLimitWayToPay;
	
	@FXML
	private Button addButtonWayToPay;
	
	///////////////////////////////////////////////////////
	// Build
	///////////////////////////////////////////////////////
	public AddWayToPayFXMLController() {
	}
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	@FXML
	public void onButtonRegister(ActionEvent event) {
		String message = "";
		boolean isError = true;
		if(Util.isChain(addNameWayToPay.getText())) {
			if(Util.isChain(addDaysPaidLimitWayToPay.getText())) {
				WayToPayController wayToPayController = new WayToPayController();
				try {
					if(wayToPayController.add(
							new WayToPay(
									addNameWayToPay.getText(), 
									Integer.parseInt(addDaysPaidLimitWayToPay.getText())
							)
					)) {
						isError = false;
						message = "Se ha registrado la forma de pago.";
						addNameWayToPay.setText("");
						addDaysPaidLimitWayToPay.setText("");
					}else {
						message = "No se ha registrado la forma de pago.";
					}
				}catch (Exception e) {
					message = "El campo limite de dias debe ser numerico.";
				}
			}else {
				message = "El campo limite de dias es obligatorio.";
			}
		}else {
			message = "El campo nombre es obligatorio.";
		}
		Alert a = new Alert((isError) ? AlertType.WARNING : AlertType.CONFIRMATION);
		a.setTitle(Variable.ERP_SYSTEM_NAME);
		a.setContentText(message);
		a.show();
	}
	
	///////////////////////////////////////////////////////
	// Getter and Setters
	///////////////////////////////////////////////////////
	public TextField getAddNameWayToPay() {
		return addNameWayToPay;
	}

	public void setAddNameWayToPay(TextField addNameWayToPay) {
		this.addNameWayToPay = addNameWayToPay;
	}

	public TextField getAddDaysPaidLimitWayToPay() {
		return addDaysPaidLimitWayToPay;
	}

	public void setAddDaysPaidLimitWayToPay(TextField addDaysPaidLimitWayToPay) {
		this.addDaysPaidLimitWayToPay = addDaysPaidLimitWayToPay;
	}

	public Button getAddButtonWayToPay() {
		return addButtonWayToPay;
	}

	public void setAddButtonWayToPay(Button addButtonWayToPay) {
		this.addButtonWayToPay = addButtonWayToPay;
	}
}
