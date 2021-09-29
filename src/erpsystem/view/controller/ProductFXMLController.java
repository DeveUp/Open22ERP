package erpsystem.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import erpsystem.controller.ProductController;
import erpsystem.model.Product;
import erpsystem.util.Util;
import erpsystem.util.Variable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @project Open22ERP.
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 * @version 2.0.0.
 */
public class ProductFXMLController implements Initializable {
	
	@FXML
	private TextField addCodeBarraProduct;
	
	@FXML
	private TextArea addDescriptionProduct;
	
	@FXML
	private TextField addPriceBuyProduct;
	
	@FXML
	private TextField addPriceSaleProduct;
	
	///////////////////////////////////////////////////////
	// Find
	///////////////////////////////////////////////////////
	@FXML
	private Button addButtonProduct;
	
	@FXML
	private TextField findDescriptionProduct;
	
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView findProductTable;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findProductTableCode;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findProductTableBarCode;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findProductTableDescription;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findProductTablePriceBuy;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findProductTablePriceSale;
	
	@FXML
	private Button findButttonProduct;
	
	///////////////////////////////////////////////////////
	// Build
	///////////////////////////////////////////////////////
	public ProductFXMLController() {
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
	public void onButtonFind(ActionEvent event) {
		String message = "";
		boolean isError = true;
		if(Util.isChain(findDescriptionProduct.getText())) {
			ProductController productController = new ProductController();
			ObservableList<Product> observable = productController.findProd(findDescriptionProduct.getText()); 
			if(observable.size() > 0) {
				findProductTableCode.setCellValueFactory(new PropertyValueFactory("codigo"));
				findProductTableBarCode.setCellValueFactory(new PropertyValueFactory("codBarras"));
				findProductTableDescription.setCellValueFactory(new PropertyValueFactory("descricao"));
				findProductTablePriceBuy.setCellValueFactory(new PropertyValueFactory("precoCompra"));
				findProductTablePriceSale.setCellValueFactory(new PropertyValueFactory("precoVenda"));
				findProductTable.setItems(observable);
				isError = false;
				message = "Se han filtrado "+ observable.size() + " productos.";
			}else {
				message = "No se ha encontrado ningun producto.";
				findProductTable.setItems(FXCollections.observableArrayList());
			}
		}else {
			message = "No has digitado la descripcion del producto.";
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

	@SuppressWarnings("rawtypes")
	public TableView getFindProductTable() {
		return findProductTable;
	}
	@SuppressWarnings("rawtypes")
	public void setFindProductTable(TableView findProductTable) {
		this.findProductTable = findProductTable;
	}
	@SuppressWarnings("rawtypes")
	public TableColumn getFindProductTableCode() {
		return findProductTableCode;
	}

	public TextField getFindDescriptionProduct() {
		return findDescriptionProduct;
	}

	public void setFindDescriptionProduct(TextField findDescriptionProduct) {
		this.findDescriptionProduct = findDescriptionProduct;
	}
	@SuppressWarnings("rawtypes")
	public void setFindProductTableCode(TableColumn findProductTableCode) {
		this.findProductTableCode = findProductTableCode;
	}

	public Button getFindButttonPerson() {
		return findButttonProduct;
	}

	public void setFindButttonPerson(Button findButttonProduct) {
		this.findButttonProduct = findButttonProduct;
	}
	@SuppressWarnings("rawtypes")
	public TableColumn getFindProductTableBarCode() {
		return findProductTableBarCode;
	}
	@SuppressWarnings("rawtypes")
	public void setFindProductTableBarCode(TableColumn findProductTableBarCode) {
		this.findProductTableBarCode = findProductTableBarCode;
	}
	@SuppressWarnings("rawtypes")
	public TableColumn getFindProductTableDescription() {
		return findProductTableDescription;
	}
	@SuppressWarnings("rawtypes")
	public void setFindProductTableDescription(TableColumn findProductTableDescription) {
		this.findProductTableDescription = findProductTableDescription;
	}
	@SuppressWarnings("rawtypes")
	public TableColumn getFindProductTablePriceBuy() {
		return findProductTablePriceBuy;
	}
	@SuppressWarnings("rawtypes")
	public void setFindProductTablePriceBuy(TableColumn findProductTablePriceBuy) {
		this.findProductTablePriceBuy = findProductTablePriceBuy;
	}
	@SuppressWarnings("rawtypes")
	public TableColumn getFindProductTablePriceSale() {
		return findProductTablePriceSale;
	}
	@SuppressWarnings("rawtypes")
	public void setFindProductTablePriceSale(TableColumn findProductTablePriceSale) {
		this.findProductTablePriceSale = findProductTablePriceSale;
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