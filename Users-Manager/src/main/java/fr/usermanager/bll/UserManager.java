package fr.usermanager.bll;

import fr.usermanager.bll.exception.BLLException;
import fr.usermanager.bo.User;
import fr.usermanager.dal.UserDao;
import fr.usermanager.helper.PasswordHasher;
import fr.usermanager.helper.Validate;

public class UserManager {

	/**
	 *  *************  Start LAZY Singleton  *********************
	 */
	private static UserManager instance = new UserManager();
	
	private UserManager() {
		userDao = new UserDao();		
	}
	
	public static UserManager getInstance() {
		return instance;
	}	
	/**
	 *  ***************  End *****************************
	 */
	
	
	
	/**
	 *  *****************  LOGIC METHODS 
	 *
	 */

	UserDao userDao;
	
	public void registerUser(User user) throws BLLException {
		// valider les données
		Validate.isValide(user);
		// Hasher le mot de passe
		user.setPassword(
				PasswordHasher
				.hashPassword(user.getPassword())
				);
		// ajouter 
		userDao.createUser(user);		
	}
	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws BLLException
	 */
	public User login(String email,String password) throws BLLException {
		 
		Validate.isValide(email,password);
		try {
			User user = userDao.selectUserByEmail(email);
			if(!PasswordHasher.verifyPassword(password, user.getPassword())) {
				throw new BLLException("L'email ou le mot de passe est incorrect!");
			}
			return user;
		} catch (Exception e) {
			throw new BLLException(e.getMessage());			
		}
	}
	
}
