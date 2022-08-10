package electricitybillpaymentsystem.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import electricitybillpaymentsystem.entities.Customer;
import electricitybillpaymentsystem.exception.CustomerAlreadyExistException;
import electricitybillpaymentsystem.exception.CustomerDontExistException;
import electricitybillpaymentsystem.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
    private CustomerRepository customerRepository;
	@Override
	public Customer saveCustomer(Customer customer) throws CustomerAlreadyExistException {
		return customerRepository.save(customer);
	}

	@Override
	public Optional<Customer> fetchCustomer(Long customerId) {
		return customerRepository.findById(customerId);
	}

	@Override
	public Customer loginCustomer(String customerId, String password) throws CustomerDontExistException {
		return null;
	}

	@Override
	public Customer getCustomerByName(String firstName) throws CustomerDontExistException {
		return customerRepository.getByName(firstName);
	}

	@Override
	public Optional<Customer> getCustomerById(Long customerId) throws CustomerDontExistException {
		return customerRepository.findById(customerId);
	}


}