package fr.usermanager.helper;

import fr.usermanager.bll.exception.BLLException;
import fr.usermanager.bo.User;

public class Validate {

	public static void isValide(User user) throws BLLException {
		BLLException bllE = new BLLException();
		if(user == null) {
			bllE.addError("L'instance Utilisateur est nulle!");
			throw bllE;
		}
		
		if(user.getEmail()==null || user.getEmail().isBlank()) {
			bllE.addError("Le champs email est obligatoire!");
		}
		/// verifier le format de l'email!!!!!		
		if(user.getUsername()==null || user.getUsername().isBlank()) {
			bllE.addError("Le champs username est obligatoire!");
		}
		
		if(user.getPassword()==null || user.getPassword().isBlank()) {
			bllE.addError("Le champs mot de passe est obligatoire!");
		}else if(user.getPassword().length()<8) {
			bllE.addError("Le mot de passe doit etre entre 8 et 30");
		}		
		
		if(bllE.getErrors().size()>0) throw bllE;
		
	}

	public static void isValide(String email, String password) throws BLLException {
		BLLException bllE = new BLLException();
		if(email == null || email.isBlank()) {
			bllE.addError("Le champs email est obligatoire");
		}
		if(password == null || password.isBlank()) {
			bllE.addError("Le Mot de passe est obligatoire");
		}		
		if(bllE.getErrors().size()>0) throw bllE;
	}

}
