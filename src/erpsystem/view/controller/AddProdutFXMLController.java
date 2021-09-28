package erpsystem.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import erpsystem.controller.ProductController;
import erpsystem.model.Product;
import erpsystem.util.Util;
import erpsystem.util.Variable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
public class AddProdutFXMLController implements Initializable {
	
	@FXML
	private TextField addCodeBarraProduct;
	
	@FXML
	private TextArea addDescriptionProduct;
	
	@FXML
	private TextField addPriceBuyProduct;
	
	@FXML
	private TextField addPriceSaleProduct;
	
	@FXML
	private Button addButtonProduct;
	
	///////////////////////////////////////////////////////
	// Build
	///////////////////////////////////////////////////////
	public AddProdutFXMLController() {
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
		if(Util.isChain(addCodeBarraProduct.getText())) {
			if(Util.isChain(addDescriptionProduct.getText())) {
				if(Util.isChain(addPriceBuyProduct.getText())) {
					if(Util.isChain(addPriceSaleProduct.getText())) {
						ProductController productController = new ProductController();
						if(!productController.existsBarcode(addCodeBarraProduct.getText())) {
							if(productController.add(
									new Product(
											addCodeBarraProduct.getText(),
											addDescriptionProduct.getText(),
											Util.parseDouble(addPriceBuyProduct.getText()),
											Util.parseDouble(addPriceSaleProduct.getText())
											
									)
							)) {
								isError = false;
								message = "Se ha registrado el producto.";
								addCodeBarraProduct.setText("");
								addDescriptionProduct.setText("");
								addPriceBuyProduct.setText("");
								addPriceSaleProduct.setText("");
							}else {
								message = "No se ha registrado el producto.";
							}
						}else {
							message = "Ya existe un producto con ese codigo de barra.";
						}
					}else {
						message = "El campo precio venta es obligatorio.";
					}
				}else {
					message = "El campo precio compra es obligatorio.";
				}
			}else {
				message = "El campo descripcion es obligatorio.";
			}
		}else {
			message = "El campo codigo barra es obligatorio.";
		}
		Alert a = new Alert((isError) ? AlertType.WARNING : AlertType.CONFIRMATION);
		a.setTitle(Variable.ERP_SYSTEM_NAME);
		a.setContentText(message);
		a.show();
	}
	
	///////////////////////////////////////////////////////
	// Getter and Setters
	///////////////////////////////////////////////////////
	public TextField getAddCodeBarraProduct() {
		return addCodeBarraProduct;
	}

	public void setAddCodeBarraProduct(TextField addCodeBarraProduct) {
		this.addCodeBarraProduct = addCodeBarraProduct;
	}

	public TextArea getAddDescriptionProduct() {
		return addDescriptionProduct;
	}

	public void setAddDescriptionProduct(TextArea addDescriptionProduct) {
		this.addDescriptionProduct = addDescriptionProduct;
	}

	public TextField getAddPriceBuyProduct() {
		return addPriceBuyProduct;
	}

	public void setAddPriceBuyProduct(TextField addPriceBuyProduct) {
		this.addPriceBuyProduct = addPriceBuyProduct;
	}

	public TextField getAddPriceSaleProduct() {
		return addPriceSaleProduct;
	}

	public void setAddPriceSaleProduct(TextField addPriceSaleProduct) {
		this.addPriceSaleProduct = addPriceSaleProduct;
	}

	public Button getAddButtonProduct() {
		return addButtonProduct;
	}

	public void setAddButtonProduct(Button addButtonProduct) {
		this.addButtonProduct = addButtonProduct;
	}
}