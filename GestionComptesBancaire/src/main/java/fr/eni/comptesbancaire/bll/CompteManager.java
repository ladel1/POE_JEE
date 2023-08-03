package fr.eni.comptesbancaire.bll;

import fr.eni.comptesbancaire.bo.Compte;
import fr.eni.comptesbancaire.dal.CompteDao;
import jakarta.ejb.Singleton;

@Singleton
public class CompteManager {

	private CompteDao compteDao  = new CompteDao();
	
	public void ajouterCompte(Compte compte) {
		// la validation !!!!!!!!!!
		compteDao.saveCompte(compte);
	}
	
	public void afficher() {
		System.out.println("coucou");
	}
	
}
