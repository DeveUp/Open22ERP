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
package erpsystem.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import erpsystem.util.DB;
import erpsystem.util.Log;

/**
 * @project Open22ERP.
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 * @version 2.0.0.
 */
public class Inventory implements Serializable{

	private static final long serialVersionUID = 1L;

	private int codProd;
    private int qt;
    
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
    public Inventory() {
    	this(-1, -1);
	}
    
	public Inventory(int codProd, int qt) {
		this.codProd = codProd;
		this.qt = qt;
	}

	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
    public boolean add(Inventory estoque)
    {
        this.codProd = estoque.getCodProd();
        int qt = estoque.getQt();       
        Connection con = DB.getConnection();
        try{
            Statement st = con.createStatement();          
            String update = " insert "
                          + " into estoque "
                          + " values(" + codProd + ","
                                       + qt
                          + ")";
            
            st.executeUpdate(update);
            con.commit();
            return true;
        }
        catch ( SQLException e ){
            try{
                Inventory et = find(codProd);
                if (et != null ){
                    Boolean exists = exists(codProd);
                    if ( exists != null){
                        if ( exists ){                           
                            final int nowQt = et.getQt();
                            Statement st = con.createStatement();          
                            String update = " update "
                                          + " estoque "
                                          + " set qt = " + (nowQt + qt)
                                          + " where cod_prod = " + codProd;

                            st.executeUpdate(update);
                            con.commit(); 
                            return true;
                        }
                        else
                            System.out.println("Possibilidade: 456754");
                    }
                    else
                        System.out.println("Possibilidade: 456472");
                }
                else{
                    System.out.println("Possibilidade: 521845");
                }
            }
            catch ( Exception ee ){
                Log.log(e);
            }
        }
        return false;
    }  
    
    public Inventory find(int code)
    {
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = "SELECT estoque.cod_prod AS 'cod', estoque.qt AS 'qt'"
                          + " FROM   estoque "
                          + " WHERE  estoque.cod_prod = " + code;
            
            ResultSet rs = st.executeQuery(update);
            if (rs.next()){
            	this.setCodProd(rs.getInt("cod"));
            	this.setQt(rs.getInt("qt"));
                return this;
            }
            else
                return null;
        }
        catch ( Exception e ){
            Log.log(e);
            return null;
        }        
    } 
    
    public static Boolean exists(int cod)
    {
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String query = "SELECT estoque.cod_prod"
                          + " FROM estoque "
                          + " WHERE estoque.cod_prod = " + cod;
            
            ResultSet rs = st.executeQuery(query);
            return rs.next();
        }
        catch ( Exception e ){
            Log.log(e);
            return null;
        } 
    }
    
	///////////////////////////////////////////////////////
	// Getter and Setters
	///////////////////////////////////////////////////////
    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public int getQt() {
        return qt;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }
}
