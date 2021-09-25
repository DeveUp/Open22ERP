package erpsystem.util;

import java.io.Serializable;

/**
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 */
public class Variable implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static final String ERP_SYSTEM_DB_DRIVER = "com.mysql.jdbc.Driver";
	public static final String ERP_SYSTEM_DB_NAME = "db";
	public static final String ERP_SYSTEM_DB_URL = "jdbc:mysql://localhost/"+ERP_SYSTEM_DB_NAME;
	public static final String ERP_SYSTEM_DB_USER = "root";
	public static final String ERP_SYSTEM_DB_PASSWORD = "";
}
