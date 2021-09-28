package erpsystem.view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class addPaymentFXMLController {
	
	@FXML
	private TextField addWayToPay;
	
	@FXML
	private TextField addDaysPaidLimit;
	
	@FXML
	private Button addPaymentButton;

	public TextField getAddWayToPay() {
		return addWayToPay;
	}

	public void setAddWayToPay(TextField addWayToPay) {
		this.addWayToPay = addWayToPay;
	}

	public TextField getAddDaysPaidLimit() {
		return addDaysPaidLimit;
	}

	public void setAddDaysPaidLimit(TextField addDaysPaidLimit) {
		this.addDaysPaidLimit = addDaysPaidLimit;
	}

	public Button getAddPaymentButton() {
		return addPaymentButton;
	}

	public void setAddPaymentButton(Button addPaymentButton) {
		this.addPaymentButton = addPaymentButton;
	}
	
	
	
	

}
