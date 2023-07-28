package fr.eni.miniallocine.bll;

import java.util.List;

import fr.eni.miniallocine.bo.Titre;
import fr.eni.miniallocine.dal.DaoFactory;
import fr.eni.miniallocine.dal.TitreDAO;

public class TitreManager {
	TitreDAO titreDao = DaoFactory.getTitreDao();
	
	public List<Titre> afficherTitres(){
		return titreDao.selectAll();
	}
	
	public void ajouterTitre(Titre titre) {		
		// Validation ????				
		titreDao.insert(titre);
	}
	
}
