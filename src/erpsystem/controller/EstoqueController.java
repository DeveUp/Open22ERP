package erpsystem.controller;

import java.io.Serializable;

import erpsystem.model.Estoque;

public class EstoqueController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public EstoqueController() {
	}
	
	public Estoque find(int code) {
		Estoque et = new Estoque();
		et.find(code);
		return et;
	}
	
	public boolean add(Estoque estoque) {
		Estoque et = new Estoque();
		return et.add(estoque);
	}

}
