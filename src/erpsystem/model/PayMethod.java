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
import java.util.ArrayList;
import java.util.List;

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
public class PayMethod implements Serializable{

	private static final long serialVersionUID = 1L;

	private int cod;
    private String descricao;
    private int limite;
    
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
    public PayMethod() {
	}
    
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
    public boolean exists(String desc)
    {
        return !findPayMethod(desc).isEmpty();
    }
    
    public boolean exists(int code)
    {
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = " SELECT codigo AS 'cod' "
                          + " FROM formaspagamento "
                          + " WHERE codigo = " + code;
            ResultSet rs = st.executeQuery(update);
            return rs.next();
        }
        catch ( Exception e ){
            Log.log(e);
            return false;
        }        
    } 
    
    public PayMethod find(int code)
    {      
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = " SELECT formaspagamento.codigo       AS 'cod',"
                          + "        formaspagamento.descricao    AS 'desc',"
                          + "        formaspagamento.limite_value AS 'lim'"
                          + " FROM formaspagamento "
                          + " WHERE codigo = " + code;
            ResultSet rs = st.executeQuery(update);
            if (rs.next()){
                setCod(rs.getInt("cod"));
                setDescricao(rs.getString("desc"));
                setLimite(rs.getInt("lim"));
                return this;
            }
            else
                return null;
        }
        catch ( SQLException e){
            Log.log(e);
            return null;
        }        
    }
    
    public int findCode()
    {
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = "SELECT MAX(codigo) AS 'cod' FROM formaspagamento";
            ResultSet rs = st.executeQuery(update);
            rs.next();
            return rs.getInt("cod") + 1;
        }
        catch ( Exception e ){
            Log.log(e);
            return -1;
        }
    }
    
    public void add(PayMethod pm)
    {
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = " INSERT "
                          + "   INTO formaspagamento "
                          + "   VALUES(" + findCode() + ","
                                    + "'" + pm.getDescricao() + "',"
                                    + ""  +  pm.getLimite() + ""
                          + ")";
            st.executeUpdate(update);
            con.commit();
        }
        catch ( Exception e ){
            Log.log(e);
        }
    }
    
    public List<PayMethod> findAll()
    {
        return findPayMethod("%");
    }
    
    public List<PayMethod> findPayMethod(String descricao)
    {
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = " SELECT formaspagamento.codigo        AS 'cod',"
                          + "        formaspagamento.descricao     AS 'desc',"
                          + "        formaspagamento.limite_value  AS 'lim'"
                          + " FROM formaspagamento "
                          + " WHERE UPPER(trim(formaspagamento.descricao)) LIKE '%" + descricao.trim().toUpperCase() + "%'";
            
            ResultSet rs = st.executeQuery(update);
            List<PayMethod> pmList = new ArrayList<>();
            while (rs.next()){
                PayMethod pm = new PayMethod();
                pm.setCod(rs.getInt("cod"));
                pm.setDescricao(rs.getString("desc"));
                pm.setLimite(rs.getInt("lim"));
                pmList.add(pm);
            }
            
            return pmList;
        }
        catch ( SQLException e ){
            Log.log(e);
            return null;
        }
    }
    
    
	///////////////////////////////////////////////////////
	// Getter and Setters
	///////////////////////////////////////////////////////
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }
    
    @Override
    public String toString()
    {
        return descricao.trim();
    }
}
