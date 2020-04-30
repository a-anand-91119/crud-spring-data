package in.notyouraveragedev.jpahibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.notyouraveragedev.jpahibernate.model.User;
import in.notyouraveragedev.jpahibernate.services.UserService;

/**
 * Web Controller class provides and specifies the endpoints of the api that a
 * user can access. Generally no operations are performed in a controller class.
 * 
 * @author A Anand
 *
 */
@RestController
@RequestMapping("/jpa")
public class WebController {

	@Autowired
	private UserService userService;

	/**
	 * Endpoint to get the details of all the users created so far
	 * 
	 * @return
	 */
	@GetMapping("users")
	public List<User> getAllUsers() {
		return userService.findAllUsers();
	}

	/**
	 * Endpoint to fetch the details of a specific user
	 * 
	 * @param userId the id of the user to be fetched
	 * @return
	 */
	@GetMapping("users/{userId}")
	public User getUserById(@PathVariable(name = "userId") Integer userId) {
		return userService.getUsedById(userId);
	}

	/**
	 * End point to delete a specific user
	 * 
	 * @param userId the id of the user to be deleted
	 */
	@DeleteMapping("users/{userId}")
	public void deleteUser(@PathVariable(name = "userId") Integer userId) {
		userService.deleteUser(userId);
	}

	/**
	 * Create a new user. The user details send via request body
	 * 
	 * @param user the user to be created
	 */
	@PostMapping("users")
	public void saveUser(@RequestBody User user) {
		userService.createUser(user);
	}

	/**
	 * End point to update the details of a specified user.
	 * 
	 * @param userId the id of the user to be updated
	 * @param user   the new details of the user
	 */
	@PutMapping("users/{userId}")
	public void updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
		userService.updateUser(userId, user);
	}
}
