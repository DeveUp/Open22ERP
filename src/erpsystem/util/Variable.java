package erpsystem.util;

import java.io.Serializable;

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
}
