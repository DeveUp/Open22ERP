package erpsystem.controller;

import java.io.Serializable;
import java.util.List;

import erpsystem.model.Mov;
import erpsystem.model.MovProd;
import erpsystem.util.Variable;

/**
 * @author Diego Geronimo Onofre.
 * @channel https://www.youtube.com/user/cursostd.
 * @facebook https://www.facebook.com/diegogeronimoonofre.
 * @Github https://github.com/DiegoGeronimoOnofre.
 * @contributors SerBuitrago, yadirGarcia, soleimygomez, leynerjoseoa.
 */
public class MovController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Object lock = new Object();
	
	///////////////////////////////////////////////////////
	// Builders
	///////////////////////////////////////////////////////
	public MovController() {
	}

	///////////////////////////////////////////////////////
	// Method
	///////////////////////////////////////////////////////
	public String persistMov(Mov mov, List<MovProd> mpList) {
		synchronized (lock) {
			final int movCod = mov.add(mov);
			if (movCod != -1) {
				for (int i = 0; i < mpList.size(); i++) {
					MovProd mp = mpList.get(i);
					mp.setCodMov(movCod);
					boolean result = mp.add(mp, mov.getMovType());
					if (!result) {
						return Variable.ERP_ERROR_MOV;
					}
				}
				return null;
			} else
				return Variable.ERP_ERROR_MOV;
		}
	}

}
