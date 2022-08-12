package electricitybillpaymentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import electricitybillpaymentsystem.dto.CustomerDTO;
import electricitybillpaymentsystem.entities.Customer;
import electricitybillpaymentsystem.exception.CustomerNotFoundException;
import electricitybillpaymentsystem.exception.EmailAlreadyExistsException;
import electricitybillpaymentsystem.exception.InvalidEmailException;
import electricitybillpaymentsystem.exception.InvalidUsernameException;
import electricitybillpaymentsystem.exception.UsernameAlreadyExistsException;
import electricitybillpaymentsystem.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// Mapping for registering customer
	@PostMapping("/register")
	public ResponseEntity<Customer> registerUser(@RequestParam String userName, @RequestParam String password,
			@RequestBody CustomerDTO customerDTO) throws InvalidUsernameException, InvalidEmailException,
			UsernameAlreadyExistsException, EmailAlreadyExistsException {

		return new ResponseEntity<>(customerService.register(customerDTO, userName, password), HttpStatus.OK);

	}

	// Mapping for customer login
	@GetMapping("/login")
	public ResponseEntity<Customer> login(@RequestParam String userName, @RequestParam String password)
			throws CustomerNotFoundException {

		return new ResponseEntity<>(customerService.login(userName, password), HttpStatus.FOUND);

	}

	// Mapping to find customer by id
	@GetMapping("/searchByCustomerId")
	public ResponseEntity<Customer> searchByCustomerId(@RequestParam Long customerId) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerService.searchByCustomerId(customerId), HttpStatus.OK);
	}
	
	//Mapping to find customer by email
	@GetMapping("/searchByCustomerEmail")
	public ResponseEntity<Customer> searchByCustomerEmail(@RequestParam String email) throws CustomerNotFoundException {
		return new ResponseEntity<>(customerService.searchByCustomerEmail(email), HttpStatus.OK);
	}

}
