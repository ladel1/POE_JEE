package fr.usermanager.helper;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {
	
	public static String hashPassword(String password) {
		try {
			// Bcrypt
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashedBytes = md.digest(password.getBytes());
			
			// Convertir les bytes en format hexadécimal
			StringBuilder sb = new StringBuilder();
			for (byte b : hashedBytes) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
	    }
	}

	public static boolean verifyPassword(String inputPassword, String hashedPassword) {
		String hashedInputPassword = hashPassword(inputPassword);
		return hashedInputPassword.equals(hashedPassword);
	}

//	public static void main(String[] args) {
//		String password = "mon_mot_de_passe";
//		String hashedPassword = hashPassword(password);
//		
//		// Vérifier si un mot de passe correspond à son hachage
//		String inputPassword = "mon_mot_de_passe";
//		boolean isMatch = verifyPassword(inputPassword, hashedPassword);
//		System.out.println("Le mot de passe correspond: " + isMatch);
//	}
}