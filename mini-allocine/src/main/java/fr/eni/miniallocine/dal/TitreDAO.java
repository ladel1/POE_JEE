package fr.eni.miniallocine.dal;

import java.util.List;

import fr.eni.miniallocine.bo.Titre;

public interface TitreDAO {
	// CRUD
	// DIL
	Titre selectOne(int id);
	List<Titre> selectAll();
	// DML
	void update( Titre titre);
	void insert(Titre titre);
	void delete(int id);
}
