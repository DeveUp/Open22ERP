package erpsystem.view.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import erpsystem.controller.MovController;
import erpsystem.controller.MovementProductController;
import erpsystem.controller.WayToPayController;
import erpsystem.model.MovProd;
import erpsystem.model.PessoaMov;
import erpsystem.util.Util;
import erpsystem.util.Variable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
	private  AnchorPane addMovimentPanel;
	
	@FXML
	private Button addMovimentPanelAddPerson;
	@FXML
	private Button addMovimentPanelAddProduct;
	@FXML
	private Button addMovimientoAgregarProdcutoCar; 
	
	
	@FXML
	private TextField addMovimentPanelFindPerson;
	@FXML
	private TextField addMovimentPanelFindProduct;
	@FXML
	private TextField addMovimentPanelFindProductSize;
	@FXML
	private TextField addMovimentPanelFindProductPrice; 
	
	@FXML
	private ComboBox<String> addMovimentPanelFindWayToPay;
	@FXML
	private ComboBox<String> addMovimentPanelFindType;
	
	///////////////////////////////////////////////////////
	// Add - Table
	///////////////////////////////////////////////////////
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView addMovimentPanelTable;
	
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn addMovimentPanelTableCode;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn addMovimentPanelTableDescription;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn addMovimentPanelTableSize;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn addMovimentPanelTablePrice;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn addMovimentPanelTableTotal;
	
	
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
		if(addMovimentPanel != null) {
			if(addMovimentPanelFindWayToPay != null) {
				WayToPayController wayToPayController = new WayToPayController();
				addMovimentPanelFindWayToPay.setItems(wayToPayController.findAllName());
				addMovimentPanelFindWayToPay.getSelectionModel().selectFirst();
			}
			if(addMovimentPanelFindType != null) {
				ObservableList<String> observableList = FXCollections.observableArrayList();
				observableList.addAll("Venta", "Compra");
				addMovimentPanelFindType.setItems(observableList);
				addMovimentPanelFindType.getSelectionModel().selectFirst();
			}
		}
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
	
	@FXML
	public void onAddMovimientPersonFind(ActionEvent event) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("../fxml/findPersonFXML.fxml"));
			if (parent != null) {
				Stage stage = new Stage();
				Scene scene = new Scene(parent, 664, 804);
				stage.setTitle(Variable.ERP_SYSTEM_NAME + " - Consultar Persona");
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
	
	@FXML
	public void onAddMovimientProductFind(ActionEvent event) {
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
	@SuppressWarnings("rawtypes")
	public TableView getFindTableMovProduct() {
		return findTableMovProduct;
	}
	
	public AnchorPane getAddMovimentPanel() {
		return addMovimentPanel;
	}

	public void setAddMovimentPanel(AnchorPane addMovimentPanel) {
		this.addMovimentPanel = addMovimentPanel;
	}

	public Button getAddMovimentPanelAddPerson() {
		return addMovimentPanelAddPerson;
	}

	public void setAddMovimentPanelAddPerson(Button addMovimentPanelAddPerson) {
		this.addMovimentPanelAddPerson = addMovimentPanelAddPerson;
	}

	public Button getAddMovimentPanelAddProduct() {
		return addMovimentPanelAddProduct;
	}

	public void setAddMovimentPanelAddProduct(Button addMovimentPanelAddProduct) {
		this.addMovimentPanelAddProduct = addMovimentPanelAddProduct;
	}

	public Button getAddMovimientoAgregarProdcutoCar() {
		return addMovimientoAgregarProdcutoCar;
	}

	public void setAddMovimientoAgregarProdcutoCar(Button addMovimientoAgregarProdcutoCar) {
		this.addMovimientoAgregarProdcutoCar = addMovimientoAgregarProdcutoCar;
	}

	public TextField getAddMovimentPanelFindPerson() {
		return addMovimentPanelFindPerson;
	}

	public void setAddMovimentPanelFindPerson(TextField addMovimentPanelFindPerson) {
		this.addMovimentPanelFindPerson = addMovimentPanelFindPerson;
	}

	public TextField getAddMovimentPanelFindProduct() {
		return addMovimentPanelFindProduct;
	}

	public void setAddMovimentPanelFindProduct(TextField addMovimentPanelFindProduct) {
		this.addMovimentPanelFindProduct = addMovimentPanelFindProduct;
	}

	public TextField getAddMovimentPanelFindProductSize() {
		return addMovimentPanelFindProductSize;
	}

	public void setAddMovimentPanelFindProductSize(TextField addMovimentPanelFindProductSize) {
		this.addMovimentPanelFindProductSize = addMovimentPanelFindProductSize;
	}

	public TextField getAddMovimentPanelFindProductPrice() {
		return addMovimentPanelFindProductPrice;
	}

	public void setAddMovimentPanelFindProductPrice(TextField addMovimentPanelFindProductPrice) {
		this.addMovimentPanelFindProductPrice = addMovimentPanelFindProductPrice;
	}

	public ComboBox<String> getAddMovimentPanelFindWayToPay() {
		return addMovimentPanelFindWayToPay;
	}

	public void setAddMovimentPanelFindWayToPay(ComboBox<String> addMovimentPanelFindWayToPay) {
		this.addMovimentPanelFindWayToPay = addMovimentPanelFindWayToPay;
	}

	public ComboBox<String> getAddMovimentPanelFindType() {
		return addMovimentPanelFindType;
	}

	public void setAddMovimentPanelFindType(ComboBox<String> addMovimentPanelFindType) {
		this.addMovimentPanelFindType = addMovimentPanelFindType;
	}
	
	@SuppressWarnings("rawtypes")
	public TableView getAddMovimentPanelTable() {
		return addMovimentPanelTable;
	}

	@SuppressWarnings("rawtypes")
	public void setAddMovimentPanelTable(TableView addMovimentPanelTable) {
		this.addMovimentPanelTable = addMovimentPanelTable;
	}
	@SuppressWarnings("rawtypes")
	public TableColumn getAddMovimentPanelTableCode() {
		return addMovimentPanelTableCode;
	}
	@SuppressWarnings("rawtypes")
	public void setAddMovimentPanelTableCode(TableColumn addMovimentPanelTableCode) {
		this.addMovimentPanelTableCode = addMovimentPanelTableCode;
	}
	@SuppressWarnings("rawtypes")
	public TableColumn getAddMovimentPanelTableDescription() {
		return addMovimentPanelTableDescription;
	}
	@SuppressWarnings("rawtypes")
	public void setAddMovimentPanelTableDescription(TableColumn addMovimentPanelTableDescription) {
		this.addMovimentPanelTableDescription = addMovimentPanelTableDescription;
	}
	@SuppressWarnings("rawtypes")
	public TableColumn getAddMovimentPanelTableSize() {
		return addMovimentPanelTableSize;
	}
	@SuppressWarnings("rawtypes")
	public void setAddMovimentPanelTableSize(TableColumn addMovimentPanelTableSize) {
		this.addMovimentPanelTableSize = addMovimentPanelTableSize;
	}
	@SuppressWarnings("rawtypes")
	public TableColumn getAddMovimentPanelTablePrice() {
		return addMovimentPanelTablePrice;
	}
	@SuppressWarnings("rawtypes")
	public void setAddMovimentPanelTablePrice(TableColumn addMovimentPanelTablePrice) {
		this.addMovimentPanelTablePrice = addMovimentPanelTablePrice;
	}
	@SuppressWarnings("rawtypes")
	public TableColumn getAddMovimentPanelTableTotal() {
		return addMovimentPanelTableTotal;
	}
	@SuppressWarnings("rawtypes")
	public void setAddMovimentPanelTableTotal(TableColumn addMovimentPanelTableTotal) {
		this.addMovimentPanelTableTotal = addMovimentPanelTableTotal;
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
	@SuppressWarnings("rawtypes")
	public TableColumn getFindTableMovPersonCode() {
		return findTableMovPersonCode;
	}
	@SuppressWarnings("rawtypes")
	public void setFindTableMovPersonCode(TableColumn findTableMovPersonCode) {
		this.findTableMovPersonCode = findTableMovPersonCode;
	}
	@SuppressWarnings("rawtypes")
	public void setFindTableMovProduct(TableView findTableMovProduct) {
		this.findTableMovProduct = findTableMovProduct;
	}

	@SuppressWarnings("rawtypes")
	public TableColumn getFindTableMovProductCode() {
		return findTableMovProductCode;
	}

	@SuppressWarnings("rawtypes")
	public void setFindTableMovProductCode(TableColumn findTableMovProductCode) {
		this.findTableMovProductCode = findTableMovProductCode;
	}

	@SuppressWarnings("rawtypes")
	public TableColumn getFindTableMovProductDescription() {
		return findTableMovProductDescription;
	}
	@SuppressWarnings("rawtypes")

	public void setFindTableMovProductDescription(TableColumn findTableMovProductDescription) {
		this.findTableMovProductDescription = findTableMovProductDescription;
	}

	@SuppressWarnings("rawtypes")
	public TableColumn getFindTableMovProductPrice() {
		return findTableMovProductPrice;
	}

	@SuppressWarnings("rawtypes")
	public void setFindTableMovProductPrice(TableColumn findTableMovProductPrice) {
		this.findTableMovProductPrice = findTableMovProductPrice;
	}

	@SuppressWarnings("rawtypes")
	public TableColumn getFindTableMovProductSize() {
		return findTableMovProductSize;
	}

	@SuppressWarnings("rawtypes")
	public void setFindTableMovProductSize(TableColumn findTableMovProductSize) {
		this.findTableMovProductSize = findTableMovProductSize;
	}
	
	@SuppressWarnings("rawtypes")
	public TableColumn getFindTableMovProductTotal() {
		return findTableMovProductTotal;
	}

	@SuppressWarnings("rawtypes")
	public void setFindTableMovProductTotal(TableColumn findTableMovProductTotal) {
		this.findTableMovProductTotal = findTableMovProductTotal;
	}

	@SuppressWarnings("rawtypes")
	public TableView getFindTableMovPerson() {
		return findTableMovPerson;
	}

	@SuppressWarnings("rawtypes")
	public void setFindTableMovPerson(TableView findTableMovPerson) {
		this.findTableMovPerson = findTableMovPerson;
	}

	@SuppressWarnings("rawtypes")
	public TableColumn getFindTableMovPersonName() {
		return findTableMovPersonName;
	}

	@SuppressWarnings("rawtypes")
	public void setFindTableMovPersonName(TableColumn findTableMovPersonName) {
		this.findTableMovPersonName = findTableMovPersonName;
	}

	@SuppressWarnings("rawtypes")
	public TableColumn getFindTableMovPersonType() {
		return findTableMovPersonType;
	}

	@SuppressWarnings("rawtypes")
	public void setFindTableMovPersonType(TableColumn findTableMovPersonType) {
		this.findTableMovPersonType = findTableMovPersonType;
	}

	@SuppressWarnings("rawtypes")
	public TableColumn getFindTableMovPersonWayToPay() {
		return findTableMovPersonWayToPay;
	}

	@SuppressWarnings("rawtypes")
	public void setFindTableMovPersonWayToPay(TableColumn findTableMovPersonWayToPay) {
		this.findTableMovPersonWayToPay = findTableMovPersonWayToPay;
	}

	@SuppressWarnings("rawtypes")
	public TableColumn getFindTableMovPersonDate() {
		return findTableMovPersonDate;
	}

	@SuppressWarnings("rawtypes")
	public void setFindTableMovPersonDate(TableColumn findTableMovPersonDate) {
		this.findTableMovPersonDate = findTableMovPersonDate;
	}
}
