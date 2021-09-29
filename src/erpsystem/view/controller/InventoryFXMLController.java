package erpsystem.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import erpsystem.controller.InventoryController;
import erpsystem.model.Inventory;
import erpsystem.util.Util;
import erpsystem.util.Variable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
public class InventoryFXMLController implements Initializable {

	///////////////////////////////////////////////////////
	// Add
	///////////////////////////////////////////////////////
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
	public InventoryFXMLController() {
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
		if (Util.isChain(addStockCodeProduct.getText())) {
			if (Util.isChain(addStockSize.getText())) {
				InventoryController inventoryController = new InventoryController();
				try {
					if (inventoryController.add(new Inventory(Integer.parseInt(addStockCodeProduct.getText()),
							Integer.parseInt(addStockSize.getText())))) {
						isError = false;
						message = "Se ha registrado la cantidad seleccionada.";
						addStockCodeProduct.setText("");
						addStockSize.setText("");
					} else {
						message = "No se ha registrado la cantidad seleccionada.";
					}
				} catch (Exception e) {
					message = "Los campos codigo de producto y cantidad deben ser numerico.";
				}
			} else {
				message = "El campo cantidad es obligatorio.";
			}
		} else {
			message = "El campo codigo producto es obligatorio.";
		}
		Alert a = new Alert((isError) ? AlertType.WARNING : AlertType.CONFIRMATION);
		a.setTitle(Variable.ERP_SYSTEM_NAME);
		a.setContentText(message);
		a.show();
	}

	@FXML
	public void onButtonRegisterFindProduct(ActionEvent event) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("../fxml/findProductFXML.fxml"));
			if (parent != null) {
				Stage stage = new Stage();
				Scene scene = new Scene(parent, 664, 804);
				stage.setTitle(Variable.ERP_SYSTEM_NAME + " - Consultar Producto");
				stage.setScene(scene);
				stage.show();
			}
		} catch (Exception e) {
			Alert a = new Alert(AlertType.ERROR);
			a.setTitle(Variable.ERP_SYSTEM_NAME);
			a.setContentText("Se ha presentado un error interno - la vista no ha sido encontrado, intentalo mas tarde.");
			a.show();
		}
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
