package erpsystem.view.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import erpsystem.util.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ERPFXMLController implements Initializable {
	
	@FXML
	private JFXButton buttonPerson;
	
	@FXML
	private AnchorPane containerChange;
	
	///////////////////////////////////////////////////////
	// Icons
	///////////////////////////////////////////////////////
	@FXML
	private BorderPane iconMenuButtonRegisterPerson;
	@FXML
	private BorderPane iconMenuButtonRegisterProduct;
	@FXML
	private BorderPane iconMenuButtonRegisterMov;
	@FXML
	private BorderPane iconMenuButtonRegisterWayToPay;
	@FXML
	private BorderPane iconMenuButtonRegisterStock;
	
	@FXML
	private BorderPane iconMenuButtonFindPerson;
	@FXML
	private BorderPane iconMenuButtonFindProduct;
	@FXML
	private BorderPane iconMenuButtonFindMov;
	
	@FXML
	private BorderPane iconMenuButtonStadictInterval;
	@FXML
	private BorderPane iconMenuButtonStadictDay;
	
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
		iconMenuButtonRegisterPerson.getChildren().addAll(GlyphsDude.createIcon(FontAwesomeIcons.USER_PLUS));
		iconMenuButtonRegisterProduct.getChildren().addAll(GlyphsDude.createIcon(FontAwesomeIcons.INBOX));
		iconMenuButtonRegisterMov.getChildren().addAll(GlyphsDude.createIcon(FontAwesomeIcons.BUYSELLADS));
		iconMenuButtonRegisterWayToPay.getChildren().addAll(GlyphsDude.createIcon(FontAwesomeIcons.PAYPAL));
		iconMenuButtonRegisterStock.getChildren().addAll(GlyphsDude.createIcon(FontAwesomeIcons.PLUS_SQUARE_ALT));
		
		iconMenuButtonFindPerson.getChildren().addAll(GlyphsDude.createIcon(FontAwesomeIcons.SEARCH));
		iconMenuButtonFindProduct.getChildren().addAll(GlyphsDude.createIcon(FontAwesomeIcons.SEARCH_PLUS));
		iconMenuButtonFindMov.getChildren().addAll(GlyphsDude.createIcon(FontAwesomeIcons.SEARCH));
		
		iconMenuButtonStadictInterval.getChildren().addAll(GlyphsDude.createIcon(FontAwesomeIcons.BAR_CHART));
		iconMenuButtonStadictDay.getChildren().addAll(GlyphsDude.createIcon(FontAwesomeIcons.BARS));
		
		try {
			containerChange = Util.loadViewFXML(containerChange, getClass().getResource("../fxml/stadistChartDayFXML.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		try {
			containerChange = Util.loadViewFXML(containerChange, getClass().getResource("../fxml/stadistChartIntervalFXML.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void onButtonEstadisticDay(ActionEvent event) {
		try {
			containerChange = Util.loadViewFXML(containerChange, getClass().getResource("../fxml/stadistChartDayFXML.fxml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	///////////////////////////////////////////////////////
	// Getter and Setters
	///////////////////////////////////////////////////////
	public JFXButton getButtonPerson() {
		return buttonPerson;
	}

	public void setButtonPerson(JFXButton buttonPerson) {
		this.buttonPerson = buttonPerson;
	}

	public AnchorPane getContainerChange() {
		return containerChange;
	}

	public void setContainerChange(AnchorPane containerChange) {
		this.containerChange = containerChange;
	}

	public BorderPane getIconMenuButtonRegisterPerson() {
		return iconMenuButtonRegisterPerson;
	}

	public void setIconMenuButtonRegisterPerson(BorderPane iconMenuButtonRegisterPerson) {
		this.iconMenuButtonRegisterPerson = iconMenuButtonRegisterPerson;
	}

	public BorderPane getIconMenuButtonRegisterProduct() {
		return iconMenuButtonRegisterProduct;
	}

	public void setIconMenuButtonRegisterProduct(BorderPane iconMenuButtonRegisterProduct) {
		this.iconMenuButtonRegisterProduct = iconMenuButtonRegisterProduct;
	}

	public BorderPane getIconMenuButtonRegisterMov() {
		return iconMenuButtonRegisterMov;
	}

	public void setIconMenuButtonRegisterMov(BorderPane iconMenuButtonRegisterMov) {
		this.iconMenuButtonRegisterMov = iconMenuButtonRegisterMov;
	}

	public BorderPane getIconMenuButtonRegisterWayToPay() {
		return iconMenuButtonRegisterWayToPay;
	}

	public void setIconMenuButtonRegisterWayToPay(BorderPane iconMenuButtonRegisterWayToPay) {
		this.iconMenuButtonRegisterWayToPay = iconMenuButtonRegisterWayToPay;
	}

	public BorderPane getIconMenuButtonRegisterStock() {
		return iconMenuButtonRegisterStock;
	}

	public void setIconMenuButtonRegisterStock(BorderPane iconMenuButtonRegisterStock) {
		this.iconMenuButtonRegisterStock = iconMenuButtonRegisterStock;
	}

	public BorderPane getIconMenuButtonFindPerson() {
		return iconMenuButtonFindPerson;
	}

	public void setIconMenuButtonFindPerson(BorderPane iconMenuButtonFindPerson) {
		this.iconMenuButtonFindPerson = iconMenuButtonFindPerson;
	}

	public BorderPane getIconMenuButtonFindProduct() {
		return iconMenuButtonFindProduct;
	}

	public void setIconMenuButtonFindProduct(BorderPane iconMenuButtonFindProduct) {
		this.iconMenuButtonFindProduct = iconMenuButtonFindProduct;
	}

	public BorderPane getIconMenuButtonFindMov() {
		return iconMenuButtonFindMov;
	}

	public void setIconMenuButtonFindMov(BorderPane iconMenuButtonFindMov) {
		this.iconMenuButtonFindMov = iconMenuButtonFindMov;
	}

	public BorderPane getIconMenuButtonStadictInterval() {
		return iconMenuButtonStadictInterval;
	}

	public void setIconMenuButtonStadictInterval(BorderPane iconMenuButtonStadictInterval) {
		this.iconMenuButtonStadictInterval = iconMenuButtonStadictInterval;
	}

	public BorderPane getIconMenuButtonStadictDay() {
		return iconMenuButtonStadictDay;
	}

	public void setIconMenuButtonStadictDay(BorderPane iconMenuButtonStadictDay) {
		this.iconMenuButtonStadictDay = iconMenuButtonStadictDay;
	}
	
}
