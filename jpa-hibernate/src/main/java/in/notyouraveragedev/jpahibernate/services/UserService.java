package in.notyouraveragedev.jpahibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.notyouraveragedev.jpahibernate.model.User;
import in.notyouraveragedev.jpahibernate.repository.UserRepository;

/**
 * User Service controls the operations to be performed on the user repository.
 * Any business logic to be implemented on the data from database must be done
 * here
 * 
 * @author A Anand
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Returns the details of a specific user from database
	 * 
	 * @param userId the id of the user to be fetched from database
	 * @return the user
	 */
	public User getUsedById(Integer userId) {
		return userRepository.findById(userId).get();
	}

	/**
	 * Returns the details of all the users available in the database.
	 * 
	 * @return the list of all available users
	 */
	public List<User> findAllUsers() {
		List<User> returnUsersList = new ArrayList<>();
		userRepository.findAll().forEach(user -> returnUsersList.add(user));
		return returnUsersList;
	}

	/**
	 * Deletes the specified user from database
	 * 
	 * @param userId the id of the user to be deleted
	 */
	public void deleteUser(Integer userId) {
		userRepository.deleteById(userId);
	}

	/**
	 * Creates a new user record in the database
	 * 
	 * @param user the user to be created
	 */
	public void createUser(User user) {
		userRepository.save(user);
	}

	/**
	 * Updates an existing user in the database
	 * 
	 * @param userId the id of the user to be updated
	 * @param user   the new details of the user
	 */
	public void updateUser(Integer userId, User user) {
		user.setUserId(userId);
		userRepository.save(user);
	}
}
