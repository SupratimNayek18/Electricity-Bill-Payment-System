package electricitybillpaymentsystem.services;

import java.util.Optional;

import javax.transaction.Transactional;

//import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import electricitybillpaymentsystem.entities.User;
import electricitybillpaymentsystem.exception.UserAlreadyExistException;
import electricitybillpaymentsystem.exception.UserDontExistException;
import electricitybillpaymentsystem.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepository;
	
	//@Autowired
    //PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) throws UserAlreadyExistException {
		return userRepository.save(user);
	}

	@Override
	public User loginUser(String userId, String password) throws UserDontExistException {
		return null;
	}

	@Override
	public Optional<User> fetchUser(Long userId) {
		return userRepository.findById(userId);
	}
	
}
