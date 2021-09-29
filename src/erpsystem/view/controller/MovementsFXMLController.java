package erpsystem.view.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import erpsystem.controller.MovController;
import erpsystem.controller.MovementProductController;
import erpsystem.model.MovProd;
import erpsystem.model.Person;
import erpsystem.model.PessoaMov;
import erpsystem.util.Util;
import erpsystem.util.Variable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * @project Open22ERP.
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 * @version 2.0.0.
 */
public class MovementsFXMLController implements Initializable {
	
	///////////////////////////////////////////////////////
	// Add
	///////////////////////////////////////////////////////
	@FXML
	private TextField addMovimientoCodigoPersona;
	
	@FXML
	private Button addMovimientoCodigoPersonaAgregar;
	
	@FXML
	private TextField addMovimientoCodigoProducto;
	
	@FXML
	private Button addMovimientoCodigoProductoAgregar;
	
	@FXML
	private TextField addMovimientoCantidad;
	
	@FXML
	private TextField addMovimientoValorUnitario; 
	
	@FXML
	private ComboBox addMovimientoMetodoPago;
	
	@FXML
	private ComboBox addMovimientoTipo;
	
	@FXML
	private Button addMovimientoAgregarProdcuto; 
	
	@FXML
	private TableView addMovimientoTablaProdcutos;
	
	@FXML
	public TextField getAddMovimientoCodigoPersona() {
		return addMovimientoCodigoPersona;
	}
	
	///////////////////////////////////////////////////////
	// Find
	///////////////////////////////////////////////////////
	@FXML 
	private TextField findNamePersonMov;
	
	@FXML
	private Button addButtonFindPerson;
	
	@FXML 
	private Label findPriceMov;
	
	///////////////////////////////////////////////////////
	// Find - Table Mov Product
	///////////////////////////////////////////////////////
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView findTableMovProduct;
	
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTableMovProductCode;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTableMovProductDescription;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTableMovProductPrice;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTableMovProductSize;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTableMovProductTotal;
	
	///////////////////////////////////////////////////////
	// Find - Table Mov Person
	///////////////////////////////////////////////////////
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView findTableMovPerson;
	
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTableMovPersonCode;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTableMovPersonName;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTableMovPersonType;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTableMovPersonWayToPay;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTableMovPersonDate;
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
	public void onButtonFindPerson(ActionEvent event) {
		String message = "";
		boolean isError = true;
		if(Util.isChain(findNamePersonMov.getText())) {
			MovController movController = new MovController();
			ObservableList<PessoaMov> observable = movController.findClientMov(findNamePersonMov.getText()); 
			if(observable.size() > 0) {
				findTableMovPersonCode.setCellValueFactory(new PropertyValueFactory("movCod"));
				findTableMovPersonName.setCellValueFactory(new PropertyValueFactory("clientName"));
				findTableMovPersonType.setCellValueFactory(new PropertyValueFactory("type"));
				findTableMovPersonWayToPay.setCellValueFactory(new PropertyValueFactory("payMethod"));
				findTableMovPersonDate.setCellValueFactory(new PropertyValueFactory("data"));
				findTableMovPerson.setItems(observable);
				isError = false;
				message = "Se han filtrado "+ observable.size() + "  movimientos a esa persona.";
			}else {
				message = "No se ha encontrado ninguna persona.";
				findTableMovPerson.setItems(FXCollections.observableArrayList());
			}
		}else {
			message = "No has digitado el nombre de la persona.";
		}
		Alert a = new Alert((isError) ? AlertType.WARNING : AlertType.CONFIRMATION);
		a.setTitle(Variable.ERP_SYSTEM_NAME);
		a.setContentText(message);
		a.show();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@FXML
	public void onClickMouseRowTableMovProduct(MouseEvent  event) {
		String message = "";
		boolean isError = true;
		if(findTableMovPerson != null) {
			List<PessoaMov> list = findTableMovPerson.getSelectionModel().getSelectedItems();
			if(list != null && list.size() > 0) {
				PessoaMov personMov = list.get(0);
				MovementProductController movementProductController = new MovementProductController();
				ObservableList<MovProd> observable = movementProductController.findProds(personMov.getMovCod()); 
				if(observable.size() > 0) {
					findTableMovProductCode.setCellValueFactory(new PropertyValueFactory("codProd"));
					findTableMovProductDescription.setCellValueFactory(new PropertyValueFactory("desc"));
					findTableMovProductPrice.setCellValueFactory(new PropertyValueFactory("preco"));
					findTableMovProductSize.setCellValueFactory(new PropertyValueFactory("qt"));
					findTableMovProductTotal.setCellValueFactory(new PropertyValueFactory("total"));
					findTableMovProduct.setItems(observable);
					double total = 0;
					for(MovProd aux : observable) {
						total += aux.getPreco();
					}
					findPriceMov.setText(""+total);
					isError = false;
					message = "Se han filtrado "+ observable.size() + "  movimientos de productos con el codigo seleccionado.";
				}else {
					message = "No se ha encontrado ningun movimiento con el codigo seleccionado.";
					findTableMovProduct.setItems(FXCollections.observableArrayList());
					findPriceMov.setText("");
				}
			}else {
				message = "No se ha seleccionado ninguna columna de la tabla.";
				findTableMovProduct.setItems(FXCollections.observableArrayList());
				findPriceMov.setText("");
			}
		}else {
			message = "Se ha presentado un error interno.";
		}
		Alert a = new Alert((isError) ? AlertType.WARNING : AlertType.CONFIRMATION);
		a.setTitle(Variable.ERP_SYSTEM_NAME);
		a.setContentText(message);
		a.show();
	}

	
	///////////////////////////////////////////////////////
	// Getter and Setters
	///////////////////////////////////////////////////////
	public void setAddMovimientoCodigoPersona(TextField addMovimientoCodigoPersona) {
		this.addMovimientoCodigoPersona = addMovimientoCodigoPersona;
	}

	public Button getAddMovimientoCodigoPersonaAgregar() {
		return addMovimientoCodigoPersonaAgregar;
	}

	public void setAddMovimientoCodigoPersonaAgregar(Button addMovimientoCodigoPersonaAgregar) {
		this.addMovimientoCodigoPersonaAgregar = addMovimientoCodigoPersonaAgregar;
	}

	public TextField getAddMovimientoCodigoProducto() {
		return addMovimientoCodigoProducto;
	}

	public void setAddMovimientoCodigoProducto(TextField addMovimientoCodigoProducto) {
		this.addMovimientoCodigoProducto = addMovimientoCodigoProducto;
	}

	public Button getAddMovimientoCodigoProductoAgregar() {
		return addMovimientoCodigoProductoAgregar;
	}

	public void setAddMovimientoCodigoProductoAgregar(Button addMovimientoCodigoProductoAgregar) {
		this.addMovimientoCodigoProductoAgregar = addMovimientoCodigoProductoAgregar;
	}

	public TextField getAddMovimientoCantidad() {
		return addMovimientoCantidad;
	}

	public void setAddMovimientoCantidad(TextField addMovimientoCantidad) {
		this.addMovimientoCantidad = addMovimientoCantidad;
	}

	public TextField getAddMovimientoValorUnitario() {
		return addMovimientoValorUnitario;
	}

	public TextField getFindNamePersonMov() {
		return findNamePersonMov;
	}
	public void setFindNamePersonMov(TextField findNamePersonMov) {
		this.findNamePersonMov = findNamePersonMov;
	}

	public Button getAddButtonFindPerson() {
		return addButtonFindPerson;
	}

	public void setAddButtonFindPerson(Button addButtonFindPerson) {
		this.addButtonFindPerson = addButtonFindPerson;
	}

	public Label getFindPriceMov() {
		return findPriceMov;
	}

	public void setFindPriceMov(Label findPriceMov) {
		this.findPriceMov = findPriceMov;
	}

	public void setAddMovimientoValorUnitario(TextField addMovimientoValorUnitario) {
		this.addMovimientoValorUnitario = addMovimientoValorUnitario;
	}

	public ComboBox getAddMovimientoMetodoPago() {
		return addMovimientoMetodoPago;
	}

	public void setAddMovimientoMetodoPago(ComboBox addMovimientoMetodoPago) {
		this.addMovimientoMetodoPago = addMovimientoMetodoPago;
	}

	public ComboBox getAddMovimientoTipo() {
		return addMovimientoTipo;
	}

	public void setAddMovimientoTipo(ComboBox addMovimientoTipo) {
		this.addMovimientoTipo = addMovimientoTipo;
	}

	public Button getAddMovimientoAgregarProdcuto() {
		return addMovimientoAgregarProdcuto;
	}

	public void setAddMovimientoAgregarProdcuto(Button addMovimientoAgregarProdcuto) {
		this.addMovimientoAgregarProdcuto = addMovimientoAgregarProdcuto;
	}

	public TableView getFindTableMovProduct() {
		return findTableMovProduct;
	}


	public void setFindTableMovProduct(TableView findTableMovProduct) {
		this.findTableMovProduct = findTableMovProduct;
	}


	public TableColumn getFindTableMovProductCode() {
		return findTableMovProductCode;
	}


	public void setFindTableMovProductCode(TableColumn findTableMovProductCode) {
		this.findTableMovProductCode = findTableMovProductCode;
	}


	public TableColumn getFindTableMovProductDescription() {
		return findTableMovProductDescription;
	}


	public void setFindTableMovProductDescription(TableColumn findTableMovProductDescription) {
		this.findTableMovProductDescription = findTableMovProductDescription;
	}


	public TableColumn getFindTableMovProductPrice() {
		return findTableMovProductPrice;
	}


	public void setFindTableMovProductPrice(TableColumn findTableMovProductPrice) {
		this.findTableMovProductPrice = findTableMovProductPrice;
	}


	public TableColumn getFindTableMovProductSize() {
		return findTableMovProductSize;
	}


	public void setFindTableMovProductSize(TableColumn findTableMovProductSize) {
		this.findTableMovProductSize = findTableMovProductSize;
	}


	public TableColumn getFindTableMovProductTotal() {
		return findTableMovProductTotal;
	}


	public void setFindTableMovProductTotal(TableColumn findTableMovProductTotal) {
		this.findTableMovProductTotal = findTableMovProductTotal;
	}


	public TableView getFindTableMovPerson() {
		return findTableMovPerson;
	}


	public void setFindTableMovPerson(TableView findTableMovPerson) {
		this.findTableMovPerson = findTableMovPerson;
	}


	public TableColumn getFindTableMovPersonName() {
		return findTableMovPersonName;
	}


	public void setFindTableMovPersonName(TableColumn findTableMovPersonName) {
		this.findTableMovPersonName = findTableMovPersonName;
	}


	public TableColumn getFindTableMovPersonType() {
		return findTableMovPersonType;
	}


	public void setFindTableMovPersonType(TableColumn findTableMovPersonType) {
		this.findTableMovPersonType = findTableMovPersonType;
	}


	public TableColumn getFindTableMovPersonWayToPay() {
		return findTableMovPersonWayToPay;
	}


	public void setFindTableMovPersonWayToPay(TableColumn findTableMovPersonWayToPay) {
		this.findTableMovPersonWayToPay = findTableMovPersonWayToPay;
	}


	public TableColumn getFindTableMovPersonDate() {
		return findTableMovPersonDate;
	}


	public void setFindTableMovPersonDate(TableColumn findTableMovPersonDate) {
		this.findTableMovPersonDate = findTableMovPersonDate;
	}

	public TableView getAddMovimientoTablaProdcutos() {
		return addMovimientoTablaProdcutos;
	}

	public void setAddMovimientoTablaProdcutos(TableView addMovimientoTablaProdcutos) {
		this.addMovimientoTablaProdcutos = addMovimientoTablaProdcutos;
	}
}
