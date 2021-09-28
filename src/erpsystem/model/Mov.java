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
import java.sql.Date;
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
public class Mov implements Serializable{

	private static final long serialVersionUID = 1L;

	private int codigo;
    private int cod_cli;
    private int payMethodCode;
    private int movType;
    
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
    public Mov() {
    	this(-1, -1, -1, -1);
	}
    
    public Mov(int cod_cli, int payMethodCode, int movType) {
		this(-1, cod_cli, payMethodCode, movType);
	}
    
	public Mov(int codigo, int cod_cli, int payMethodCode, int movType) {
		super();
		this.codigo = codigo;
		this.cod_cli = cod_cli;
		this.payMethodCode = payMethodCode;
		this.movType = movType;
	}


	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
    public int findCode()
    {
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = "SELECT MAX(codigo) AS 'cod' FROM mov";
            ResultSet rs = st.executeQuery(update);
            rs.next();
            return rs.getInt("cod") + 1;
        }
        catch ( SQLException e ){
            Log.log(e);
            return -1;
        }
    }
    
    public int add(Mov mov)
    {
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            final int cod          = findCode();
            final int codCli       = mov.getCod_cli();
            final int codPayMethod = mov.getPayMethodCode();
            final int movTypeCode  = mov.getMovType();
            long time              = System.currentTimeMillis();
            String update = " INSER "
                          + "   INTO mov "
                          + "   VALUES(" + cod + ","
                                         + codCli + ","
                                         + codPayMethod + ","
                                         + movTypeCode + ","
                                         + time
                          + ")";
            
            st.executeUpdate(update);
            con.commit();
            return cod;

        }
        catch ( SQLException e ){
            Log.log(e);
            return -1;
        }
    }
    
    public List<PessoaMov> findClientMov(String pessoa)
    {
        try{
            Connection con = DB.getConnection();
            Statement st = con.createStatement();
            String update = " SELECT mov.codigo         AS 'codmov',"
                          + "        mov.mov_time       AS 'mov_time',"
                          + "        pessoas.nome       AS 'nome',"
                          + "        mov.mov_type       AS 'mov_type',"
                          + "        mov.cod_pay_method AS 'paym'"
                          + " FROM mov, pessoas "
                          + " WHERE mov.cod_cli = pessoas.codigo "
                          + "   AND upper(trim(pessoas.nome)) LIKE '%" + pessoa.trim().toUpperCase() + "%'"
                          + " ORDER BY mov.mov_time";
            ResultSet rs = st.executeQuery(update);
            List<PessoaMov> cmList = new ArrayList<>();
            while (rs.next()){
                PessoaMov cm = new PessoaMov();
                cm.setMovCod(rs.getInt("codmov"));
                cm.setData(new Date(rs.getLong("mov_time")));
                cm.setClientName(rs.getString("nome"));
                cm.setType(rs.getInt("mov_type"));
                cm.setPayMethod(rs.getInt("paym"));
                cmList.add(cm);
            }
            return cmList;
        }
        catch ( SQLException e ){
            Log.log(e);
            return null;
        }
    }

	///////////////////////////////////////////////////////
	// Getter and Setters
	///////////////////////////////////////////////////////
    public int getCodigo() {
        return codigo;
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }

    public int getPayMethodCode() {
        return payMethodCode;
    }

    public void setPayMethodCode(int payMethodCode) {
        this.payMethodCode = payMethodCode;
    }

    public int getMovType() {
        return movType;
    }

    public void setMovType(int movType) {
        this.movType = movType;
    }
    
}
