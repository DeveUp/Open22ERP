package erpsystem.view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FindPersonFXMLController {
	
	@FXML
	private TextField addFindPersonNombrePersona;
	
	@FXML
	private Button addFindPersonNombrePersonaBuscar;
	
	@FXML
	private TableView addFindPersonTabla;

	public TextField getAddFindPersonNombrePersona() {
		return addFindPersonNombrePersona;
	}

	public void setAddFindPersonNombrePersona(TextField addFindPersonNombrePersona) {
		this.addFindPersonNombrePersona = addFindPersonNombrePersona;
	}

	public Button getAddFindPersonNombrePersonaBuscar() {
		return addFindPersonNombrePersonaBuscar;
	}

	public void setAddFindPersonNombrePersonaBuscar(Button addFindPersonNombrePersonaBuscar) {
		this.addFindPersonNombrePersonaBuscar = addFindPersonNombrePersonaBuscar;
	}

	public TableView getAddFindPersonTabla() {
		return addFindPersonTabla;
	}

	public void setAddFindPersonTabla(TableView addFindPersonTabla) {
		this.addFindPersonTabla = addFindPersonTabla;
	}
	
	
	

}
