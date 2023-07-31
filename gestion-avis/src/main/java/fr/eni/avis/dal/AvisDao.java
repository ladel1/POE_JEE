package fr.eni.avis.dal;

import java.util.List;

import fr.eni.avis.bo.Avis;

public interface AvisDao {

	// CRUD
	List<Avis> findAll();
	Avis findOne(Integer id);
	void insert(Avis avis);
	void update(Avis avis);
	
}
