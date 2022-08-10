package electricitybillpaymentsystem.services;

import electricitybillpaymentsystem.entities.Reading;
import electricitybillpaymentsystem.exception.ConsumerNumberNotFoundException;

public interface ReadingService {
	
	public Reading submitReading(Long consumerId,int consumedUnits) throws ConsumerNumberNotFoundException;

}
