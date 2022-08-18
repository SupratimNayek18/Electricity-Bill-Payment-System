package electricitybillpaymentsystem.services;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import electricitybillpaymentsystem.dto.AddressDTO;
import electricitybillpaymentsystem.entities.Address;
import electricitybillpaymentsystem.entities.Connection;
import electricitybillpaymentsystem.entities.Customer;
import electricitybillpaymentsystem.exception.ConnectionAlreadyExistsException;
import electricitybillpaymentsystem.exception.ConsumerNumberNotFoundException;
import electricitybillpaymentsystem.exception.CustomerNotFoundException;
import electricitybillpaymentsystem.repository.ConnectionRepository;
import electricitybillpaymentsystem.repository.CustomerRepository;

@Service
@Transactional
public class ConnectionServiceImpl implements ConnectionService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ConnectionRepository connectionRepository;

	@Override
	public Connection newConnection(Long customerId, AddressDTO addressDTO) throws CustomerNotFoundException, ConnectionAlreadyExistsException {

		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if (!optionalCustomer.isPresent())
			throw new CustomerNotFoundException("Customer Not Found");
		else {
			Customer customer = optionalCustomer.get();
			
			if(customer.getConnection()!=null) throw new ConnectionAlreadyExistsException("Connection for this customer id already exists");

			// Setting connection to customer
			Connection connection = new Connection();
			connection.setCustomer(customer);
			customer.setConnection(connection);

			// Setting address entity object from addressDTO
			Address address = new Address();
			address.setBuildingName(addressDTO.getBuildingName());
			address.setDistrict(addressDTO.getDistrict());
			address.setFlatOrHouseNumber(addressDTO.getFlatOrHouseNumber());
			address.setLandmark(addressDTO.getLandmark());
			address.setPincode(addressDTO.getPincode());
			address.setState(addressDTO.getState());
			address.setTaluka(addressDTO.getTaluka());
			address.setVillage(addressDTO.getVillage());

			// setting address to connection
			connection.setAddress(address);

			connection.setConnectionStatus(true);
			connection.setConsumerNumber(customer.getCustomerId()+1000);
			connection.setApplicationDate(LocalDate.now());
			connection.setConnectionDate(LocalDate.now());

			return connectionRepository.save(connection);
		}
	}

	@Override
	public Customer searchByConsumerNumber(Long consumerNumber) throws ConsumerNumberNotFoundException {

		Connection connection = connectionRepository.getByConsumerNumber(consumerNumber);
		if (connection != null) {
			return connection.getCustomer();
		} else {
			throw new ConsumerNumberNotFoundException("Customer with given consumer number not found");
		}
	}

	@Override
	public Address changeAddress(Long consumerNumber, AddressDTO addressDTO) {

		return null;
	}

}
