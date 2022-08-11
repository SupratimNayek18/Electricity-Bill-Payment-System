package electricitybillpaymentsystem.services;

import electricitybillpaymentsystem.dto.CustomerDTO;
import electricitybillpaymentsystem.entities.Customer;
import electricitybillpaymentsystem.exception.CustomerNotFoundException;
import electricitybillpaymentsystem.exception.EmailAlreadyExistsException;
import electricitybillpaymentsystem.exception.InvalidEmailException;
import electricitybillpaymentsystem.exception.InvalidUsernameException;
import electricitybillpaymentsystem.exception.UsernameAlreadyExistsException;

public interface CustomerService {
	
	public Customer register(CustomerDTO customerDTO,String userName,String password) throws InvalidUsernameException, InvalidEmailException, UsernameAlreadyExistsException, EmailAlreadyExistsException;
	
	public Customer login(String userName, String password) throws CustomerNotFoundException;
	
	public Customer searchByCustomerId(Long customerId) throws CustomerNotFoundException;
	
	public Customer searchByCustomerEmail(String email) throws CustomerNotFoundException;
}
