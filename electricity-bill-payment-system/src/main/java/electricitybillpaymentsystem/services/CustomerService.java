package electricitybillpaymentsystem.services;

import electricitybillpaymentsystem.dto.CustomerDTO;
import electricitybillpaymentsystem.entities.Customer;
import electricitybillpaymentsystem.exception.CustomerNotFoundException;

public interface CustomerService {
	
	public Customer register(CustomerDTO customerDTO,String userName,String password);
	
	public Customer login(String userName, String password) throws CustomerNotFoundException;
}
