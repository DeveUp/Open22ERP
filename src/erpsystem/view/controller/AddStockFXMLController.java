package erpsystem.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddStockFXMLController  implements Initializable {

	@FXML
	private TextField addStockCodeProduct;
	
	@FXML
	private Button addStockButtonFindProduct;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}

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
