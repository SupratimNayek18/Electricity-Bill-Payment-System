package electricitybillpaymentsystem.services;

import electricitybillpaymentsystem.entities.Connection;
import electricitybillpaymentsystem.entities.Customer;
import electricitybillpaymentsystem.exception.ConnectionAlreadyExistsException;
import electricitybillpaymentsystem.exception.ConsumerNumberNotFoundException;
import electricitybillpaymentsystem.exception.CustomerNotFoundException;
import electricitybillpaymentsystem.entities.Address;

import electricitybillpaymentsystem.dto.AddressDTO;

public interface ConnectionService {

	public Connection newConnection(Long customerId, AddressDTO addressDTO) throws CustomerNotFoundException, ConnectionAlreadyExistsException;

	public Customer searchByConsumerNumber(Long consumerNumber) throws ConsumerNumberNotFoundException;

	public Address changeAddress(Long consumerNumber, AddressDTO addressDTO);
}
