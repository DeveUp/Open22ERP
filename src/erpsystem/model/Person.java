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
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int codigo;
    private String nome;
    private String cpf;
    private String email;
    private String localizacao;
    private String telefone;
    
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
    public Person() {
	}
    
    public Person(String nome, String cpf, String email, String localizacao, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.localizacao = localizacao;
		this.telefone = telefone;
	}
    
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	public boolean exists(int code){
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = " SELECT codigo AS 'cod' "
                          + " FROM pessoas "
                          + " WHERE codigo = " + code;
            ResultSet rs = st.executeQuery(update);
            return rs.next();
        }
        catch ( Exception e ){
            Log.log(e);
            return false;
        }        
    }
    
    public Person find(int code){
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = " SELECT pessoas.codigo      AS 'cod',"
                          + "        pessoas.nome        AS 'nome',"
                          + "        pessoas.cpf         AS 'cpf',"
                          + "        pessoas.email       AS 'email',"
                          + "        pessoas.localizacao AS 'loc',"
                          + "        pessoas.telefone    AS 'tel'"
                          + " FROM pessoas "
                          + " WHERE codigo = " + code;
            ResultSet rs = st.executeQuery(update);    
            if (rs.next()){
                setCodigo(rs.getInt("cod"));
                setNome(rs.getString("nome"));
                setCpf(rs.getString("cpf"));
                setEmail(rs.getString("email"));
                setLocalizacao(rs.getString("loc"));
                setTelefone(rs.getString("tel"));
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
    
    public int findCode(){
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = "SELECT MAX(codigo) AS 'cod' FROM pessoas";
            ResultSet rs = st.executeQuery(update);
            rs.next();
            return rs.getInt("cod") + 1;
        }
        catch ( Exception e ){
            Log.log(e);
            return -1;
        }
    }
    
    public  List<Person> findClient(String clientName)
    {
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = " SELECT pessoas.codigo      AS 'cod',"
                          + "        pessoas.nome        AS 'nome',"
                          + "        pessoas.cpf         AS 'cpf',"
                          + "        pessoas.email       AS 'email',"
                          + "        pessoas.localizacao AS 'loc',"
                          + "        pessoas.telefone    AS 'tel'"
                          + " FROM pessoas "
                          + " WHERE UPPER(trim(pessoas.nome)) LIKE '%" + clientName.trim().toUpperCase() + "%'";
            
            ResultSet rs = st.executeQuery(update);
            List<Person> cliList = new ArrayList<>();
            while (rs.next()){    
                Person cli = new Person();
                cli.setCodigo(rs.getInt("cod"));
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));
                cli.setEmail(rs.getString("email"));
                cli.setLocalizacao(rs.getString("loc"));
                cli.setTelefone(rs.getString("tel"));
                cliList.add(cli);
            }
            return cliList;
        }
        catch ( SQLException e ){
            Log.log(e);
            return null;
        }
    }
    
    public boolean add(Person cli){
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = " INSERT "
                          + " INTO pessoas "
                          + " VALUES(" + findCode() + ","
                                    + "'" + cli.getNome() + "',"
                                    + "'" + cli.getCpf() + "',"
                                    + "'" + cli.getEmail() + "',"
                                    + "'" + cli.getLocalizacao() + "',"
                                    + "'" + cli.getTelefone() + "'"
                          + ")";
            st.executeUpdate(update);
            con.commit();
            return true;

        }
        catch ( Exception e ){
            Log.log(e);
            return false;
        }
    }
    
    public String getSummary(){
        return "Pessoa:'" + nome + "' CPF:'" + cpf + "'";
    }

	///////////////////////////////////////////////////////
	// Getter and Setters
	///////////////////////////////////////////////////////
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
