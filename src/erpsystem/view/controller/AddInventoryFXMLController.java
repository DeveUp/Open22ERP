package erpsystem.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import erpsystem.controller.InventoryController;
import erpsystem.model.Inventory;
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
public class AddInventoryFXMLController implements Initializable {
	
	@FXML
	private TextField addStockCodeProduct;
	
	@FXML
	private TextField addStockSize;
	
	@FXML
	private Button addStockButtonFindProduct;
	
	@FXML
	private Button addStockButton;
	
	///////////////////////////////////////////////////////
	// Build
	///////////////////////////////////////////////////////
	public AddInventoryFXMLController() {
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
		if(Util.isChain(addStockCodeProduct.getText())) {
			if(Util.isChain(addStockSize.getText())) {
				InventoryController inventoryController = new InventoryController();
				try {
					if(inventoryController.add(
							new Inventory(
								Integer.parseInt(addStockCodeProduct.getText()),
								Integer.parseInt(addStockSize.getText())
							)
					)) {
						isError = false;
						message = "Se ha registrado la cantidad seleccionada.";
						addStockCodeProduct.setText("");
						addStockSize.setText("");
					}else {
						message = "No se ha registrado la cantidad seleccionada.";
					}
				}catch (Exception e) {
					message = "Los campos codigo de producto y cantidad deben ser numerico.";
				}	
			}else {
				message = "El campo cantidad es obligatorio.";
			}
		}else {
			message = "El campo codigo producto es obligatorio.";
		}
		Alert a = new Alert((isError) ? AlertType.WARNING : AlertType.CONFIRMATION);
		a.setTitle(Variable.ERP_SYSTEM_NAME);
		a.setContentText(message);
		a.show();
	}
	
	///////////////////////////////////////////////////////
	// Getter and Setters
	///////////////////////////////////////////////////////
	public TextField getAddStockCodeProduct() {
		return addStockCodeProduct;
	}

	public void setAddStockCodeProduct(TextField addStockCodeProduct) {
		this.addStockCodeProduct = addStockCodeProduct;
	}

	public TextField getAddStockSize() {
		return addStockSize;
	}

	public void setAddStockSize(TextField addStockSize) {
		this.addStockSize = addStockSize;
	}

	public Button getAddStockButtonFindProduct() {
		return addStockButtonFindProduct;
	}

	public void setAddStockButtonFindProduct(Button addStockButtonFindProduct) {
		this.addStockButtonFindProduct = addStockButtonFindProduct;
	}

	public Button getAddStockButton() {
		return addStockButton;
	}

	public void setAddStockButton(Button addStockButton) {
		this.addStockButton = addStockButton;
	}
}
