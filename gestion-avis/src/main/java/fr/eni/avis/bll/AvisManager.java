package fr.eni.avis.bll;

import java.util.List;

import fr.eni.avis.bll.exception.BLLException;
import fr.eni.avis.bo.Avis;
import fr.eni.avis.dal.DaoFactory;

public class AvisManager { 
	
	// Singleton
	
	public Avis getAvis(Integer id) {
		return DaoFactory.getAvisDao().findOne(id);
	}
	
	public List<Avis> getAllAvis(){
		return DaoFactory.getAvisDao().findAll();
	}
	
	public void addAvis(Avis avis) throws BLLException {
		// validation des données avant d'ajouter
		checkFields(avis);
		DaoFactory.getAvisDao().insert(avis);
	}
	
	public void updateAvis(Avis avis) throws BLLException {
		// validation des données avant d'ajouter
		checkFields(avis);
		DaoFactory.getAvisDao().update(avis);
	}

	private void checkFields(Avis avis) throws BLLException {
		
		if(avis == null) {
			throw new BLLException("L'objet avis est nul");
		}
		
		if(avis.getUsername()==null || avis.getUsername().isBlank()) {
			throw new BLLException("Le champs (Nom de l'utilisateur) est obligatoire!");
		}
		
		if(avis.getProductName()==null || avis.getProductName().isBlank()) {
			throw new BLLException("Le champs (Nom du produit) est obligatoire!");
		}	
		
		if(avis.getRating()<1 || avis.getRating()>5) {
			throw new BLLException("Le champs (note) doit etre entre 1 et 5");
		}		
		
	}
	
	
}
