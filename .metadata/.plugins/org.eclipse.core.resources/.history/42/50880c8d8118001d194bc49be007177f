package electricitybillpaymentsystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import electricitybillpaymentsystem.entities.User;
import electricitybillpaymentsystem.exception.UserAlreadyExistException;
import electricitybillpaymentsystem.exception.UserDontExistException;
import electricitybillpaymentsystem.services.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	  private UserService userService;
	
	 @GetMapping("/healthcheck")
	  public String healthCheck() {
	    return "OK";
	  }
	 
	 @PostMapping("/register")
	 public ResponseEntity<User> registerUser(@RequestBody User user) throws UserAlreadyExistException {
		 Long checkId = user.getUserId();
		 if(checkId != null && !"".equals(checkId)) {
			 Optional<User> userObj = userService.fetchUser(checkId);
			 if(userObj != null) {
				 throw new UserAlreadyExistException();
			 }
		 }
		 return new ResponseEntity<>(userService.saveUser(user), HttpStatus.OK);
	 }
	
}
