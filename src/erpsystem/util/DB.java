/*
 * The MIT License
 *
 * Copyright 2015 Diego Geronimo D' Onofre.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package erpsystem.util;

import java.io.Serializable;
import java.sql.*;

/**
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 */
public class DB implements Serializable{

	private static final long serialVersionUID = 1L;
    private static Connection con = null;

	
	static {
        try{
            Class.forName(Variable.ERP_SYSTEM_DB_DRIVER);
        }
        catch ( Exception e ){
            Log.log(e);
        }			
    }
    
	/**
	 * Method that allows the connection to the database.
	 * @return The connection.
	 */
    public static Connection getConnection(){
        try{
            if ( con == null ){
                con = DriverManager.getConnection(Variable.ERP_SYSTEM_DB_URL, Variable.ERP_SYSTEM_DB_USER, Variable.ERP_SYSTEM_DB_PASSWORD);
                con.setAutoCommit(false);
                return con;
            }
            else
                return con;
        }
        catch ( Exception e ){
            Log.log(e);
            return null;
        }
    }
}
