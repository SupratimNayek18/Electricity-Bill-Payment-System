package electricitybillpaymentsystem.services;

import java.util.Optional;

import electricitybillpaymentsystem.entities.Customer;
import electricitybillpaymentsystem.exception.CustomerAlreadyExistException;
import electricitybillpaymentsystem.exception.CustomerDontExistException;

public interface CustomerService {
	
	Customer saveCustomer(Customer customer) throws CustomerAlreadyExistException; 
	Optional<Customer> fetchCustomer(Long customerId);	
	Customer loginCustomer(String customerId, String password) throws CustomerDontExistException;
	Customer getCustomerByName(String firstName) throws CustomerDontExistException;
	Optional<Customer> getCustomerById(Long customerId) throws CustomerDontExistException;
}
