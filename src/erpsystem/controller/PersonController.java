package erpsystem.controller;

import java.io.Serializable;

import erpsystem.model.Person;
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
public class PersonController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public PersonController() {
	}
	
	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	public boolean exists(int codeClient) {
		Person pessoaModel = new Person();
		return pessoaModel.exists(codeClient);
	}
	
	public Person find(int code) {
		Person pessoaModel = new Person();
		return pessoaModel.find(code);
	}
	
	public boolean add(Person cli){
        return cli.add(cli);
    }
	
	public ObservableList<Person> findClient(String name) {
		Person pessoaModel = new Person();
		return pessoaModel.findClient(name);
	}

}
