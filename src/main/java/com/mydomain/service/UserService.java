package com.mydomain.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mydomain.model.Users;

@Path("/user")
public class UserService {

	@GET
	@Path("/param")
	public Users getUser(@PathParam("param") Integer Id) {
		Users u = new Users();
		return u;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Users> getUsers() {
		Users u = new Users();
		List<Users> users = new ArrayList<Users>();
		users.add(u);
		return users;
	}

}
