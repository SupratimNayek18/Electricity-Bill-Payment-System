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

import electricitybillpaymentsystem.dto.AddressDTO;
import electricitybillpaymentsystem.entities.Connection;
import electricitybillpaymentsystem.entities.Customer;
import electricitybillpaymentsystem.exception.ConnectionAlreadyExistsException;
import electricitybillpaymentsystem.exception.ConsumerNumberNotFoundException;
import electricitybillpaymentsystem.exception.CustomerNotFoundException;
import electricitybillpaymentsystem.services.ConnectionService;

@RestController
@RequestMapping("/connection")
public class ConnectionController {
	
	@Autowired
	ConnectionService connectionService;
	
	@PostMapping("/getConnection")
	public ResponseEntity<Connection> getConnection(@RequestParam Long customerId,@RequestBody AddressDTO addressDTO) throws CustomerNotFoundException, ConnectionAlreadyExistsException{
		
		return new ResponseEntity<>(connectionService.newConnection(customerId, addressDTO),HttpStatus.OK);
		
	}
	
	@GetMapping("/getByConsumerNumber")
	public ResponseEntity<Customer> getByConsumerNumber(@RequestParam Long consumerNumber) throws ConsumerNumberNotFoundException{
		return new ResponseEntity<>(connectionService.searchByConsumerNumber(consumerNumber),HttpStatus.FOUND);
	}

}
