package bo;

public class Personne {

	private String nom;
	private String prenom;
	private String adresse;
	private int age;
	
	public Personne(String nom, String prenom,
			String adresse, int age) throws Exception {

		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setAge(age);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws Exception {
		if(age<13) {
			throw new Exception("L'age doit etre >= 13");
		}		
		this.age = age;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", age=" + age + "]";
	}
	
	
	
}
