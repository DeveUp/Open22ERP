package erpsystem.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import erpsystem.util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class ERPFXMLController implements Initializable {
	
	@FXML
	private JFXButton buttonPerson;
	
	@FXML
	private AnchorPane containerChange;
	
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public ERPFXMLController() {
	}
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	///////////////////////////////////////////////////////
	// Method - Println - Register
	///////////////////////////////////////////////////////
	@FXML
	public void onButtonRegisterPerson(ActionEvent event) {
		try {
			containerChange = Util.loadViewFXML(containerChange, getClass().getResource("../fxml/addPersonFXML.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onButtonRegisterProduct(ActionEvent event) {
		try {
			containerChange = Util.loadViewFXML(containerChange, getClass().getResource("../fxml/addProductFXML.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onButtonRegisterMov(ActionEvent event) {
		try {
			containerChange = Util.loadViewFXML(containerChange, getClass().getResource("../fxml/addMovementFXML.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onButtonRegisterPage(ActionEvent event) {
		try {
			containerChange = Util.loadViewFXML(containerChange, getClass().getResource("../fxml/addWayToPayFXML.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onButtonRegisterStock(ActionEvent event) {
		try {
			containerChange = Util.loadViewFXML(containerChange, getClass().getResource("../fxml/addInventoryFXML.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	///////////////////////////////////////////////////////
	// Method - Println - Find
	///////////////////////////////////////////////////////
	@FXML
	public void onButtonFindPerson(ActionEvent event) {
		try {
			containerChange = Util.loadViewFXML(containerChange, getClass().getResource("../fxml/findPersonFXML.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onButtonFindProduct(ActionEvent event) {
		try {
			containerChange = Util.loadViewFXML(containerChange, getClass().getResource("../fxml/findProductFXML.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onButtonFindMov(ActionEvent event) {
		try {
			containerChange = Util.loadViewFXML(containerChange, getClass().getResource("../fxml/findCheckMovementsFXML.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	///////////////////////////////////////////////////////
	// Method - Println - Stadistic
	///////////////////////////////////////////////////////
	@FXML
	public void onButtonEstadisticInterval(ActionEvent event) {
		
	}
	
	@FXML
	public void onButtonEstadisticDay(ActionEvent event) {
		try {
			containerChange = Util.loadViewFXML(containerChange, getClass().getResource("../fxml/stadistChartDayFXML.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
