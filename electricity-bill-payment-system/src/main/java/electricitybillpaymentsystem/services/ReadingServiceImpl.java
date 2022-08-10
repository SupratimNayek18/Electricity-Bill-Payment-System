package electricitybillpaymentsystem.services;

import java.util.Optional;

import javax.transaction.Transactional;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import electricitybillpaymentsystem.entities.Connection;
import electricitybillpaymentsystem.entities.Reading;
import electricitybillpaymentsystem.exception.ConsumerNumberNotFoundException;
import electricitybillpaymentsystem.repository.ConnectionRepository;
import electricitybillpaymentsystem.repository.ReadingRepository;

@Service
@Transactional
public class ReadingServiceImpl implements ReadingService {

	@Autowired
	ConnectionRepository connectionRepository;
	
	@Autowired
	ReadingRepository readingRepository;

	@Override
	public Reading submitReading(Long consumerNumber, int consumedUnits) throws ConsumerNumberNotFoundException {

		Connection connection = connectionRepository.getByConsumerNumber(consumerNumber);
		
		if (connection==null)
			throw new ConsumerNumberNotFoundException("Connection with guven consumer number not found");
		
		Reading reading = new Reading();
		reading.setPricePerUnits(5);
		reading.setReadingDate(LocalDate.now());
		reading.setReadingPhoto("Uploaded");
		reading.setUnitsConsumed(consumedUnits);
		
		connection.setReading(reading);
		
		return readingRepository.save(reading);

	}

}
