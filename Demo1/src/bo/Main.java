package bo;

public class Main {

	public static void main(String[] args) {
		
		try {
			Personne p = new Personne("Maisel", "Sarah",
					"Niort", 20);
			p.setAge(-5);
			System.out.println(p);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Fin");

	}

}
