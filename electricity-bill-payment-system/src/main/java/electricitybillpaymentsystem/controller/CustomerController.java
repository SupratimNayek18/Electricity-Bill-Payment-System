package electricitybillpaymentsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import electricitybillpaymentsystem.entities.Customer;
import electricitybillpaymentsystem.exception.CustomerAlreadyExistException;
import electricitybillpaymentsystem.exception.CustomerDontExistException;
import electricitybillpaymentsystem.services.CustomerService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	  private CustomerService customerService;

	 @PostMapping("/register")
	 public ResponseEntity<Customer> registerUser(@RequestBody Customer customer) throws CustomerAlreadyExistException {
		 Long checkId = customer.getCustomerId();
		 if(checkId != null && !"".equals(checkId)) {
			 Optional<Customer> customerObj = customerService.fetchCustomer(checkId);
			 if(customerObj != null) {
				 throw new CustomerAlreadyExistException();
			 }
		 }
		 return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.OK);
	 }
	 
		
		 @GetMapping("/getbyid/{customerId}") 
		 public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) throws CustomerDontExistException{ 
			 return new ResponseEntity<>(customerService.getCustomerById(customerId),HttpStatus.OK);
		 }
		 
}