package electricitybillpaymentsystem.services;

import electricitybillpaymentsystem.entities.Bill;
import electricitybillpaymentsystem.entities.Payment;
import electricitybillpaymentsystem.exception.BillAlreadyPaidException;
import electricitybillpaymentsystem.exception.ConsumerNumberNotFoundException;
import electricitybillpaymentsystem.exception.ReadingNotFoundException;

public interface BillService {
	
	public Bill getBill(Long consumerNumber) throws ConsumerNumberNotFoundException, ReadingNotFoundException, BillAlreadyPaidException;
	
	public Payment payBill(Long consumerNumber) throws ConsumerNumberNotFoundException, ReadingNotFoundException, BillAlreadyPaidException;

}
