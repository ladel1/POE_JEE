package fr.eni.miniallocine.bll;

import fr.eni.miniallocine.bo.Titre;
import fr.eni.miniallocine.dal.DaoFactory;
import fr.eni.miniallocine.dal.TitreDAO;

public class TitreManager {

	
	public void ajouterTitre(Titre titre) {
		
		// Validation ????
		
		TitreDAO titreDao = DaoFactory.getTitreDao();
		titreDao.insert(titre);
		
	}
	
}
