package fr.eni.miniallocine.dal.txt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import fr.eni.miniallocine.bo.Titre;
import fr.eni.miniallocine.dal.TitreDAO;

public class TitreDaoTxtImpl implements TitreDAO {

	@Override
	public Titre selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Titre> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Titre titre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Titre titre) {
		try(
			PrintWriter printWriter = FileConnection.getPrintFile("C:\\Users\\alatibi\\eclipse-workspace\\mini-allocine\\titre.txt")	
			){
			System.out.println("Début");
			printWriter.print(titre.getNom()+" "+titre.getSynopsis()+" "+
							  titre.getGenre()+" "+titre.getDuree()+" "+
					          titre.getRealisateur()+" "+titre.isType()+" "+
							  titre.getDateSortie());
			System.out.println("Fin");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
