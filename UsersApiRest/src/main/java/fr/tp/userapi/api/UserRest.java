package fr.tp.userapi.api;

import java.util.List;

import fr.tp.userapi.bo.User;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
public class UserRest {

	private List<User> users;
	
	public UserRest() {
		users = List.of(
				new User(1, "Olivier", "Dupont", "Paris", 30),
				new User(2, "Olivier2", "Dupont2", "Paris", 30),
				new User(3, "Olivier3", "Dupont3", "Paris", 30),
				new User(4, "Olivier4", "Dupont4", "Paris", 30),
				new User(5, "Olivier5", "Dupont5", "Paris", 30)
				);
	}
	
	@GET
	@Path("/{id:[0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getOneUser(@PathParam("id") int id) {
		return users.get(id-1);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return users;
	}
	
	
}
