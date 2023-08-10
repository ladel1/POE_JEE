package fr.tp.userapi.dal;

import java.util.List;

import fr.tp.userapi.bo.User;

public interface UserDao {

	public void insert(User user);
	public List<User> findAll();
	public User findOne(int id);
	
}
