package erpsystem.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ERPFXMLController implements Initializable {
	
	@FXML
	private JFXButton buttonPerson;
	
	public ERPFXMLController() {
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	@FXML
	public void onButtonPerson(ActionEvent event) {
		System.out.println("SSSS");
	}
}
