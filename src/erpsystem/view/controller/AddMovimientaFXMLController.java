package erpsystem.view.controller;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AddMovimientaFXMLController {
	
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

	public TextField getAddMovimientoCodigoPersona() {
		return addMovimientoCodigoPersona;
	}

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

	public TableView getAddMovimientoTablaProdcutos() {
		return addMovimientoTablaProdcutos;
	}

	public void setAddMovimientoTablaProdcutos(TableView addMovimientoTablaProdcutos) {
		this.addMovimientoTablaProdcutos = addMovimientoTablaProdcutos;
	}
	
	

}
