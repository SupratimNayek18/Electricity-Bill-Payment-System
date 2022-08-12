package electricitybillpaymentsystem.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import electricitybillpaymentsystem.dto.CustomerDTO;
import electricitybillpaymentsystem.entities.Customer;
import electricitybillpaymentsystem.entities.User;
import electricitybillpaymentsystem.exception.CustomerNotFoundException;
import electricitybillpaymentsystem.exception.EmailAlreadyExistsException;
import electricitybillpaymentsystem.exception.InvalidEmailException;
import electricitybillpaymentsystem.exception.InvalidUsernameException;
import electricitybillpaymentsystem.exception.UsernameAlreadyExistsException;
import electricitybillpaymentsystem.repository.CustomerRepository;
import electricitybillpaymentsystem.repository.UserRepository;
import electricitybillpaymentsystem.utils.CustomPasswordEncoder;
import electricitybillpaymentsystem.utils.ValidationUtils;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomPasswordEncoder passwordEncoder;

	@Override
	public Customer register(CustomerDTO customerDTO, String userName, String password)
			throws InvalidUsernameException, InvalidEmailException, UsernameAlreadyExistsException,
			EmailAlreadyExistsException {

		
		//Creating the customer entity object
		Customer customer = new Customer();
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setMiddleName(customerDTO.getMiddleName());
		customer.setAadharNumber(customerDTO.getAadharNumber());

		
		//Validating the email pattern and checking if it already exists
		if (ValidationUtils.emailPatternMatches(customerDTO.getEmail())) {
			
			Customer checkingEmail = customerRepository.findByEmail(customerDTO.getEmail());
			if(checkingEmail!=null) throw new EmailAlreadyExistsException("Email Already Exists");
			
			customer.setEmail(customerDTO.getEmail());
		}
			
		else
			throw new InvalidEmailException("Invalid Email Address");

		customer.setGender(customerDTO.getEmail());
		customer.setMobileNumber(customerDTO.getMobileNumber());
		
		
		//Creating user entity object
		User user = new User();
		
		
		//Validating the username and checking if it already exists
		if (ValidationUtils.usernamePatternMatches(userName)) {

			User userCredentials = userRepository.findByUsername(userName);
			if (userCredentials != null)
				throw new UsernameAlreadyExistsException("Username Already Exists");

			user.setUserName(userName);
		} else
			throw new InvalidUsernameException("Invalid Username");

		user.setPassword(passwordEncoder.encode(password));

		
		//Establishing bidirectional relation
		customer.setUser(user);
		user.setCustomer(customer);

		
		//Saving the customer
		return customerRepository.save(customer);
	}

	@Override
	public Customer login(String userName, String password) throws CustomerNotFoundException {

		User userCredentials = userRepository.findByUsername(userName);
		if (userCredentials == null)
			throw new CustomerNotFoundException("Username doesn't exist");
		else {
			if (passwordEncoder.matches(password, userCredentials.getPassword())) {
				return userCredentials.getCustomer();
			} else
				throw new CustomerNotFoundException("Incorrect Password");
		}

	}

	@Override
	public Customer searchByCustomerId(Long customerId) throws CustomerNotFoundException {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if(customer.isPresent()) return customer.get();
		throw new CustomerNotFoundException("Customer with given id not found");
	}

	@Override
	public Customer searchByCustomerEmail(String email) throws CustomerNotFoundException {
		Customer customer = customerRepository.findByEmail(email);
		if(customer!=null) return customer;
		throw new CustomerNotFoundException("Customer with given email not found");
	}

}
