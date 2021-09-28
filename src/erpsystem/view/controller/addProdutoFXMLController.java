package erpsystem.view.controller;



import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class addProdutoFXMLController{
	
	@FXML
	private TextField addFindProductoDescripcion;
	
	@FXML
	private Button addFindPersonNombrePersonaBuscar;
	
	@FXML
	private TableView addFindProductoTabla;

	public TextField getAddFindProductoDescripcion() {
		return addFindProductoDescripcion;
	}

	public void setAddFindProductoDescripcion(TextField addFindProductoDescripcion) {
		this.addFindProductoDescripcion = addFindProductoDescripcion;
	}

	public Button getAddFindPersonNombrePersonaBuscar() {
		return addFindPersonNombrePersonaBuscar;
	}

	public void setAddFindPersonNombrePersonaBuscar(Button addFindPersonNombrePersonaBuscar) {
		this.addFindPersonNombrePersonaBuscar = addFindPersonNombrePersonaBuscar;
	}

	public TableView getAddFindProductoTabla() {
		return addFindProductoTabla;
	}

	public void setAddFindProductoTabla(TableView addFindProductoTabla) {
		this.addFindProductoTabla = addFindProductoTabla;
	}
	
	
	
	
}