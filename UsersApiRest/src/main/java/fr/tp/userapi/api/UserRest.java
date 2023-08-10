package fr.tp.userapi.api;

import java.util.List;

import fr.tp.userapi.bll.UserManager;
import fr.tp.userapi.bo.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserRest {


	private UserManager userManager = new  UserManager();
	
	@GET
	@Path("/{id:[0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getOneUser(@PathParam("id") int id) {
		return userManager.getUser(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userManager.getUsers();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		userManager.addUser(user);
		return Response.created(null).build();
	}
	
	
}
