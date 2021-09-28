package erpsystem.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import erpsystem.controller.PersonController;
import erpsystem.model.Person;
import erpsystem.util.Util;
import erpsystem.util.Variable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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
public class AddPersonFXMLController implements Initializable {
	
	
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
	// Build
	///////////////////////////////////////////////////////
	public AddPersonFXMLController() {
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
