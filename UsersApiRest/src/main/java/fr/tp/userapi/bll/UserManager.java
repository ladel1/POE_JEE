package fr.tp.userapi.bll;

import java.util.List;

import fr.tp.userapi.bo.User;
import fr.tp.userapi.dal.UserDao;
import fr.tp.userapi.dal.UserDaoImpl;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;


public class UserManager {
	
	private UserDao userDao = new UserDaoImpl();
	
	public List<User> getUsers(){
		return userDao.findAll();
	}
	public User getUser(int id){
		return userDao.findOne(id);
	}
	
	public void addUser(User user) {
		userDao.insert(user);
	}	
}
