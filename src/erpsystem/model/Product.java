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
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int codigo;
    private String codBarras;
    private String descricao;
    private double precoCompra;
    private double precoVenda;
    
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
    public Product() {
	}

    
	public Product(String codBarras, String descricao, double precoCompra, double precoVenda) {
		this.codBarras = codBarras;
		this.descricao = descricao;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
	}

	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
    public boolean exists(int code){
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = " SELECT codigo AS 'cod' "
                          + " FROM produtos "
                          + " WHERE codigo = " + code;
            ResultSet rs = st.executeQuery(update);
            return rs.next();
        }
        catch ( Exception e ){
            Log.log(e);
            return false;
        }        
    }  
    
    public boolean existsBarcode(String code){
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = " SELECT codigo AS 'cod' "
                          + " FROM produtos "
                          + " WHERE cod_barras = " + code;
            ResultSet rs = st.executeQuery(update);
            return rs.next();
        }
        catch ( Exception e ){
            Log.log(e);
            return false;
        }        
    }  
    
    public Product find(int cod){
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String sql = " SELECT * "
                       + " FROM produtos "
                       + " WHERE codigo = " + cod;
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                setCodigo(rs.getInt("codigo"));
                setCodBarras(rs.getString("cod_barras"));
                setDescricao(rs.getString("descricao"));
                setPrecoCompra(rs.getDouble("preco_compra"));
                setPrecoVenda(rs.getDouble("preco_venda"));
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
    
    public int findCode() {
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = "SELECT MAX(codigo) AS 'cod' FROM produtos";
            ResultSet rs = st.executeQuery(update);
            rs.next();
            return rs.getInt("cod") + 1;
        }
        catch ( Exception e ){
            Log.log(e);
            return -1;
        }
    }
    
    public ObservableList<Product> findProd(String desc){
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = " SELECT produtos.codigo       AS 'cod',"
                          + "        produtos.cod_barras   AS 'cod_barras',"
                          + "        produtos.descricao    AS 'desc',"
                          + "        produtos.preco_compra AS 'preco_compra',"
                          + "        produtos.preco_venda  AS 'preco_venda'"
                          + " FROM produtos "
                          + " WHERE UPPER(trim(produtos.descricao)) LIKE '%" + desc.trim().toUpperCase() + "%'";
            
            ResultSet rs = st.executeQuery(update);
            ObservableList<Product> prodList = FXCollections.observableArrayList();
            while (rs.next()){
                Product prod = new Product();             
                prod.setCodigo(rs.getInt("cod"));
                prod.setCodBarras(rs.getString("cod_barras"));
                prod.setDescricao(rs.getString("desc"));
                prod.setPrecoCompra(rs.getDouble("preco_compra"));
                prod.setPrecoVenda(rs.getDouble("preco_venda"));
                prodList.add(prod);
            }
            return prodList;
        }
        catch ( SQLException e ){
            Log.log(e);
            return null;
        }        
    }
    
    /**
     * Este método injeta o código do produto
     * no objeto passado como parâmetro "Produto"
     * depois que tem certeza que o produto foi cadastrado.
     */
    public boolean add(Product prod){
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            int code = findCode();
            String update = " insert "
                          + " into produtos "
                          + " values(" + code + ","
                                    + "'" + prod.getCodBarras() + "',"
                                    + "'" + prod.getDescricao() + "',"
                                    + prod.getPrecoCompra() + ","
                                    + prod.getPrecoVenda()
                          + ")";
            st.executeUpdate(update);
            con.commit();
            prod.setCodigo(code);
            return true;
        }
        catch ( Exception e ){
            Log.log(e);
            return false;
        }
    }
    
	///////////////////////////////////////////////////////
	// Getter and Setters
	///////////////////////////////////////////////////////
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public String getDescricao() {
        return descricao;
    }
 
    public String getSummDesc()
    {        
        if ( descricao.length() >= 12 )
            return descricao.substring(0,10);
        else
            return descricao;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
    
    public String getSummary()
    {
        return  descricao 
                + " Compra:R$" 
                + precoCompra
                + " Venda:R$" 
                + precoVenda;
    }    
}
