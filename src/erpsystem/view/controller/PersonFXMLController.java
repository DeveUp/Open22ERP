package erpsystem.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import erpsystem.controller.PersonController;
import erpsystem.model.Person;
import erpsystem.util.Util;
import erpsystem.util.Variable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @project Open22ERP.
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 * @version 2.0.0.
 */
public class PersonFXMLController implements Initializable {
	
	
	///////////////////////////////////////////////////////
	// Add
	///////////////////////////////////////////////////////
	@FXML
	private TextField addNamePerson;
	@FXML
	private TextField addDocumentPerson;
	@FXML 
	private TextField addMailPerson;
	@FXML
	private TextField addPhonePerson;
	@FXML
	private TextField addDirectionPerson;
	
	@FXML
	private Button addButtonPerson;
	
	///////////////////////////////////////////////////////
	// Fied
	///////////////////////////////////////////////////////
	@FXML
	private TextField findNamePerson;
	
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView findTablePerson;
	
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTablePersonCode;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTablePersonName;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTablePersonCC;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTablePersonMail;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTablePersonLocation;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableColumn findTablePersonPhone;
	
	@FXML
	private Button findButttonPerson;
	
	
	///////////////////////////////////////////////////////
	// Build
	///////////////////////////////////////////////////////
	public PersonFXMLController() {
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
		if(Util.isChain(addNamePerson.getText())) {
			if(Util.isChain(addDocumentPerson.getText())) {
				if(Util.isChain(addMailPerson.getText())) {
					if(Util.isChain(addPhonePerson.getText())) {
						if(Util.isChain(addDirectionPerson.getText())) {
							PersonController personController = new PersonController();
							if(personController.add(
								new Person(
									addNamePerson.getText(), 
									addDocumentPerson.getText(), 
									addMailPerson.getText(), 
									addDirectionPerson.getText(),
									addPhonePerson.getText()
								)
							)) {
								isError = false;
								message = "Se ha registrado la persona.";
								addNamePerson.setText("");
								addDocumentPerson.setText("");
								addMailPerson.setText("");
								addDirectionPerson.setText("");
								addPhonePerson.setText("");
							}else {
								message = "No se ha registrado la persona.";
							}
						}else {
							message = "El campo documento es obligatorio.";
						}
					}else {
						message = "El campo telefono es obligatorio.";
					}
				}else {
					message = "El campo email es obligatorio.";
				}
			}else {
				message = "El campo documento es obligatorio.";
			}
		}else {
			message = "El campo nombre es obligatorio.";
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
		if(Util.isChain(findNamePerson.getText())) {
			PersonController personController = new PersonController();
			ObservableList<Person> observable = personController.findClient(findNamePerson.getText()); 
			if(observable.size() > 0) {
				findTablePersonCode.setCellValueFactory(new PropertyValueFactory("codigo"));
				findTablePersonName.setCellValueFactory(new PropertyValueFactory("nome"));
				findTablePersonCC.setCellValueFactory(new PropertyValueFactory("cpf"));
				findTablePersonMail.setCellValueFactory(new PropertyValueFactory("email"));
				findTablePersonLocation.setCellValueFactory(new PropertyValueFactory("localizacao"));
				findTablePersonPhone.setCellValueFactory(new PropertyValueFactory("telefone"));
				findTablePerson.setItems(observable);
				isError = false;
				message = "Se han filtrado "+ observable.size() + " personas.";
			}else {
				message = "No se ha encontrado ninguna persona.";
				findTablePerson.setItems(FXCollections.observableArrayList());
			}
		}else {
			message = "No has digitado el nombre de la persona.";
		}
		Alert a = new Alert((isError) ? AlertType.WARNING : AlertType.CONFIRMATION);
		a.setTitle(Variable.ERP_SYSTEM_NAME);
		a.setContentText(message);
		a.show();
	}
	
	///////////////////////////////////////////////////////
	// Getter and Setters
	///////////////////////////////////////////////////////
	public TextField getAddNamePerson() {
		return addNamePerson;
	}


	public void setAddNamePerson(TextField addNamePerson) {
		this.addNamePerson = addNamePerson;
	}


	public TextField getAddDocumentPerson() {
		return addDocumentPerson;
	}


	public void setAddDocumentPerson(TextField addDocumentPerson) {
		this.addDocumentPerson = addDocumentPerson;
	}


	public TextField getAddMailPerson() {
		return addMailPerson;
	}


	public void setAddMailPerson(TextField addMailPerson) {
		this.addMailPerson = addMailPerson;
	}


	public TextField getAddPhonePerson() {
		return addPhonePerson;
	}

	public TextField getFindNamePerson() {
		return findNamePerson;
	}

	public void setFindNamePerson(TextField findNamePerson) {
		this.findNamePerson = findNamePerson;
	}

	@SuppressWarnings("rawtypes")
	public TableView getFindTablePerson() {
		return findTablePerson;
	}
	
	@SuppressWarnings("rawtypes")
	public void setFindTablePerson(TableView findTablePerson) {
		this.findTablePerson = findTablePerson;
	}
	
	@SuppressWarnings("rawtypes")
	public TableColumn getFindTablePersonCode() {
		return findTablePersonCode;
	}
	
	@SuppressWarnings("rawtypes")
	public void setFindTablePersonCode(TableColumn findTablePersonCode) {
		this.findTablePersonCode = findTablePersonCode;
	}
	
	@SuppressWarnings("rawtypes")
	public TableColumn getFindTablePersonName() {
		return findTablePersonName;
	}

	@SuppressWarnings("rawtypes")
	public void setFindTablePersonName(TableColumn findTablePersonName) {
		this.findTablePersonName = findTablePersonName;
	}
	
	@SuppressWarnings("rawtypes")
	public TableColumn getFindTablePersonCC() {
		return findTablePersonCC;
	}
	
	@SuppressWarnings("rawtypes")
	public void setFindTablePersonCC(TableColumn findTablePersonCC) {
		this.findTablePersonCC = findTablePersonCC;
	}
	
	@SuppressWarnings("rawtypes")
	public TableColumn getFindTablePersonMail() {
		return findTablePersonMail;
	}
	
	@SuppressWarnings("rawtypes")
	public void setFindTablePersonMail(TableColumn findTablePersonMail) {
		this.findTablePersonMail = findTablePersonMail;
	}
	
	@SuppressWarnings("rawtypes")
	public TableColumn getFindTablePersonLocation() {
		return findTablePersonLocation;
	}
	
	@SuppressWarnings("rawtypes")
	public void setFindTablePersonLocation(TableColumn findTablePersonLocation) {
		this.findTablePersonLocation = findTablePersonLocation;
	}
	
	@SuppressWarnings("rawtypes")
	public TableColumn getFindTablePersonPhone() {
		return findTablePersonPhone;
	}
	
	@SuppressWarnings("rawtypes")
	public void setFindTablePersonPhone(TableColumn findTablePersonPhone) {
		this.findTablePersonPhone = findTablePersonPhone;
	}

	public Button getFindButttonPerson() {
		return findButttonPerson;
	}

	public void setFindButttonPerson(Button findButttonPerson) {
		this.findButttonPerson = findButttonPerson;
	}

	public void setAddPhonePerson(TextField addPhonePerson) {
		this.addPhonePerson = addPhonePerson;
	}


	public TextField getAddDirectionPerson() {
		return addDirectionPerson;
	}


	public void setAddDirectionPerson(TextField addDirectionPerson) {
		this.addDirectionPerson = addDirectionPerson;
	}


	public Button getAddButtonPerson() {
		return addButtonPerson;
	}


	public void setAddButtonPerson(Button addButtonPerson) {
		this.addButtonPerson = addButtonPerson;
	}
}
