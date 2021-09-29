package erpsystem.controller;

import java.io.Serializable;

import erpsystem.model.Statistics;

/**
 * @project Open22ERP.
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 * @version 2.0.0.
 */
public class StatisticsController implements Serializable{
	private static final long serialVersionUID = 1L;

	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public StatisticsController() {
	}
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	public Double getValorCompraEm(long initialDate, long finalDate) {
		Statistics statistics = new Statistics();
		return statistics.getValorCompraEm(initialDate, finalDate);
	}
	
	public Double getValorVendaEm(long initialDate, long finalDate) {
		Statistics statistics = new Statistics();
		return statistics.getValorVendaEm(initialDate, finalDate);
	}
	
	public Double getValorLucroEm(long initialDate, long finalDate) {
		Statistics statistics = new Statistics();
		return statistics.getValorLucroEm(initialDate, finalDate);
	}
}
