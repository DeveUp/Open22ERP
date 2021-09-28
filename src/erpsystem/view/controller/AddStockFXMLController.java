package erpsystem.view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddStockFXMLController {

	@FXML
	private TextField addStockCodeProduct;
	
	@FXML
	private Button addStockButtonFindProduct;
	
	

	public TextField getAddStockCodeProduct() {
		return addStockCodeProduct;
	}

	public void setAddStockCodeProduct(TextField addStockCodeProduct) {
		this.addStockCodeProduct = addStockCodeProduct;
	}

	public Button getAddStockButtonFindProduct() {
		return addStockButtonFindProduct;
	}

	public void setAddStockButtonFindProduct(Button addStockButtonFindProduct) {
		this.addStockButtonFindProduct = addStockButtonFindProduct;
	}
}
