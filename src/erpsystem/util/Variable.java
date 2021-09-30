package erpsystem.util;

import java.io.Serializable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @project Open22ERP.
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 * @version 2.0.0.
 */
public class Variable implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static final String ERP_SYSTEM_NAME = "Open22ERP";
	public static final String ERP_SYSTEM_PROJECT_PATH =  System.getProperty("user.dir");
	
	public static final String ERP_SYSTEM_DB_DRIVER = "com.mysql.jdbc.Driver";
	public static final String ERP_SYSTEM_DB_NAME = "db";
	public static final String ERP_SYSTEM_DB_URL = "jdbc:mysql://localhost/"+ERP_SYSTEM_DB_NAME;
	public static final String ERP_SYSTEM_DB_USER = "root";
	public static final String ERP_SYSTEM_DB_PASSWORD = "";
	
	
	public static final String ERP_ERROR_MOV = "Ocorreu um problema ao gravar as \n"
            									+ "informações da movimentação no banco de dados.\n"
            									+ "Isso pode ter ocorrido por diversos fatores como \n"
            									+ "problema de hardware ou o servidor de banco de dados \n"
            									+ " não estava em execução ou seu sistema está corrompido. \n"
            									+ " é recomendável realizar a movimentação novamente, assim se \n"
            									+ "o problema persistir entre em contato com o Desenvolvedor.";
	
	public static final ObservableList<String> month(){
		ObservableList<String> observableList = FXCollections.observableArrayList();
		observableList.addAll(
				"Enero", 
				"Febrero", 
				"Marzo", 
				"Abril", 
				"Mayo",
				"Junio",
				"Julio",
				"Agosto",
				"Septiembre",
				"Octubre",
				"Noviembre",
				"Diciembre"
		);
		return observableList;
	}
	
	public static final int month(String name){
		ObservableList<String> observableList = month();
		int i = 0;
		for(String aux : observableList) {
			if(aux.equalsIgnoreCase(name)) {
				return i + 1;
			}
			i++;
		}
		return 0;
	}
	
	public static final ObservableList<String> days(){
		ObservableList<String> observableList = FXCollections.observableArrayList();
		for(int i=1; i <=31; i++) {
			observableList.add(""+i);
		}
		return observableList;
	}
	
	public static final ObservableList<String> years(){
		ObservableList<String> observableList = FXCollections.observableArrayList();
		for(int i=1900; i <= 3000; i++) {
			observableList.add(""+i);
		}
		return observableList;
	}
	
}
