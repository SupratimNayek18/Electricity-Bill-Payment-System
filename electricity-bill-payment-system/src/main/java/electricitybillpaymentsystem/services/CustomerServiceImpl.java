package electricitybillpaymentsystem.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import electricitybillpaymentsystem.dto.CustomerDTO;
import electricitybillpaymentsystem.entities.Customer;
import electricitybillpaymentsystem.entities.User;
import electricitybillpaymentsystem.exception.CustomerNotFoundException;
import electricitybillpaymentsystem.repository.CustomerRepository;
import electricitybillpaymentsystem.repository.UserRepository;
import electricitybillpaymentsystem.utils.CustomPasswordEncoder;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
    private CustomerRepository customerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomPasswordEncoder passwordEncoder;
	
	@Override
	public Customer register(CustomerDTO customerDTO,String userName,String password){
		
		Customer customer = new Customer();
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setMiddleName(customerDTO.getMiddleName());
		customer.setAadharNumber(customerDTO.getAadharNumber());
		customer.setEmail(customerDTO.getEmail());
		customer.setGender(customerDTO.getEmail());
		customer.setMobileNumber(customerDTO.getMobileNumber());
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(passwordEncoder.encode(password));
		
		customer.setUser(user);
		user.setCustomer(customer);
		
		return customerRepository.save(customer);
	}


	@Override
	public Customer login(String userName, String password) throws CustomerNotFoundException {
		
		User userCredentials = userRepository.login(userName);
		if(userCredentials==null) throw new CustomerNotFoundException("Username doesn't exist");
		else {
			if(passwordEncoder.matches(password, userCredentials.getPassword())) {
				return userCredentials.getCustomer();
			}else throw new CustomerNotFoundException("Incorrect Password");
		}
		
	}
	



}
