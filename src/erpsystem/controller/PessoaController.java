package erpsystem.controller;

import java.io.Serializable;
import java.util.List;

import erpsystem.model.Pessoa;

/**
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 */
public class PessoaController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public PessoaController() {
	}
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	public boolean exists(int codeClient) {
		Pessoa pessoaModel = new Pessoa();
		return pessoaModel.exists(codeClient);
	}
	
	public Pessoa find(int code) {
		Pessoa pessoaModel = new Pessoa();
		return pessoaModel.find(code);
	}
	
	public boolean add(Pessoa cli){
        return cli.add(cli);
    }
	
	public List<Pessoa> findClient(String name) {
		Pessoa pessoaModel = new Pessoa();
		return pessoaModel.findClient(name);
	}

}
