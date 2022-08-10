package electricitybillpaymentsystem.services;

import java.util.Optional;

import electricitybillpaymentsystem.entities.User;
import electricitybillpaymentsystem.exception.UserAlreadyExistException;
import electricitybillpaymentsystem.exception.UserDontExistException;

public interface UserService {

	public User saveUser(User user) throws UserAlreadyExistException; 
	public Optional<User> fetchUser(Long userId);	
	public User loginUser(String userId, String password) throws UserDontExistException;
}
