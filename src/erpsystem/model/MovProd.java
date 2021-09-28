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
public class MovProd implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int codMov;
    private int codProd;
    private String desc; 
    private double preco;
    private int qt;
    private double total;
    
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
    public MovProd() {
	}
    
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
    public boolean add(MovProd movProd, int movType)
    {
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = " INSERT "
                          + "   INTO mov_prod "
                          + "   VALUES(" + movProd.getCodMov()  + ","
                                       	 + movProd.getCodProd() + ","
                                       	 + movProd.getPreco()   + ","
                                       	 + movProd.getQt()      + ","
                                       	 + movProd.getTotal()
                          + ")";   
            st.executeUpdate(update);
            //Atualizando o estoque.
            Estoque estoque = new Estoque();
            estoque.setCodProd(movProd.getCodProd());
            if ( movType == 1 ) //compra
                estoque.setQt(movProd.getQt());
            else //venda
                estoque.setQt(-movProd.getQt());
             Estoque et = new Estoque();
            boolean result = et.add(estoque);    
            if ( result ){
                con.commit();
                return true;
            }
            else{
                con.rollback();
                return false;
            }   
        }
        catch ( SQLException e ){
            Log.log(e);
            return false;
        }
    }
    
    public List<MovProd> findProds(int codMov)
    {
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = " SELECT mov_prod.cod_prod            AS 'codprod',"
                          + "        produtos.descricao           AS 'desc',"
                          + "        mov_prod.preco               AS 'preco',"
                          + "        mov_prod.qt                  AS 'qt',"
                          + "        mov_prod.qt * mov_prod.preco AS 'total'"
                          + " FROM mov_prod, produtos "
                          + " WHERE mov_prod.cod_prod = produtos.codigo "
                          + "   AND mov_prod.cod_mov = " + codMov;
            
            ResultSet rs = st.executeQuery(update);
            List<MovProd> mpList = new ArrayList<>();
            while (rs.next()){
                MovProd mp = new MovProd();   
                mp.setCodProd(rs.getInt("codprod"));
                mp.setDesc(rs.getString("desc"));
                mp.setPreco(rs.getDouble("preco"));
                mp.setQt(rs.getInt("qt"));
                mp.setTotal(rs.getDouble("total"));
                mpList.add(mp);
            }
            return mpList;
        }
        catch ( SQLException e ){
            Log.log(e);
            return null;
        }        
    }
    
	///////////////////////////////////////////////////////
	// Getter and Setters
	///////////////////////////////////////////////////////
    public int getCodMov() {
        return codMov;
    }

    public int getCodProd() {
        return codProd;
    }

    public double getPreco() {
        return preco;
    }

    public int getQt() {
        return qt;
    }

    public double getTotal() {
        return total;
    }
    
    public void setCodMov(int codMov) {
        this.codMov = codMov;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQt(int qt) {
        this.qt = qt;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }   
}
