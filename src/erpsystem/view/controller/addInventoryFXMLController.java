package erpsystem.view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class addInventoryFXMLController {
	
	@FXML
	private TextField addStockCodeProduct;
	
	@FXML
	private TextField addStockSize;
	
	@FXML
	private Button addStockButtonFindProduct;
	
	@FXML
	private Button addStockButton;

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
