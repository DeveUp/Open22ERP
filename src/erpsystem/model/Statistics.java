package erpsystem.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import erpsystem.util.DB;

/**
 * @project Open22ERP.
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 * @version 2.0.0.
 */
public class Statistics implements Serializable {

	private static final long serialVersionUID = 1L;

	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public Statistics() {
	}

	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	public Double getValorCompraEm(long initialDate, long finalDate) {
		try {
			Connection conn = DB.getConnection();
			Statement st = conn.createStatement();
			String sql = " select sum(coalesce(coalesce(mov_prod.preco) * coalesce(mov_prod.qt))) as 'compravalue'"
					+ " from mov, mov_prod" + " where mov.codigo = mov_prod.cod_mov" + "   and mov.mov_type = 1"
					+ "   and ( mov.mov_time >= " + initialDate + " and mov.mov_time <= " + finalDate + ")";

			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				double value = rs.getDouble("compravalue");
				return value;
			} else
				return null;
		} catch (Exception e) {
			// Log.log(e);
			return null;
		}
	}

	public Double getValorVendaEm(long initialDate, long finalDate) {
		try {
			Connection conn = DB.getConnection();
			Statement st = conn.createStatement();
			String sql = " select sum(coalesce(coalesce(mov_prod.preco) * coalesce(mov_prod.qt))) as 'vendavalue'"
					+ " from mov, mov_prod" + " where mov.codigo = mov_prod.cod_mov" + "   and mov.mov_type = 2"
					+ "   and ( mov.mov_time >= " + initialDate + " and mov.mov_time <= " + finalDate + ")";

			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				double value = rs.getDouble("vendavalue");
				return value;
			} else
				return null;
		} catch (Exception e) {
			// Log.log(e);
			return null;
		}
	}

	public Double getValorLucroEm(long initialDate, long finalDate) {
		try {
			Connection conn = DB.getConnection();
			Statement st = conn.createStatement();
			String sql = " select sum(coalesce(coalesce(mov_prod.preco) * coalesce(mov_prod.qt)) - ( coalesce(produtos.preco_compra) * mov_prod.qt )) as 'lucro'"
					+ " from mov, mov_prod, produtos" + " where mov.codigo      = mov_prod.cod_mov"
					+ "   and mov.mov_type    = 2" + "   and produtos.codigo = mov_prod.cod_prod"
					+ "   and ( mov.mov_time >= " + initialDate + " and mov.mov_time <= " + finalDate + ")";

			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {
				double value = rs.getDouble("lucro");
				return value;
			} else
				return null;
		} catch (Exception e) {
			// Log.log(e);
			return null;
		}
	}
}
