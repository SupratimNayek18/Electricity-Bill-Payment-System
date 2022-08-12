package electricitybillpaymentsystem.services;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import electricitybillpaymentsystem.entities.Bill;
import electricitybillpaymentsystem.entities.Connection;
import electricitybillpaymentsystem.entities.Payment;
import electricitybillpaymentsystem.entities.Reading;
import electricitybillpaymentsystem.exception.BillAlreadyPaidException;
import electricitybillpaymentsystem.exception.ConsumerNumberNotFoundException;
import electricitybillpaymentsystem.exception.ReadingNotFoundException;
import electricitybillpaymentsystem.repository.ConnectionRepository;
import electricitybillpaymentsystem.repository.PaymentRepository;

@Service
@Transactional
public class BillServiceImpl implements BillService {

	@Autowired
	ConnectionRepository connectionRepository;
	
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public Bill getBill(Long consumerNumber) throws ConsumerNumberNotFoundException, ReadingNotFoundException, BillAlreadyPaidException {

		Connection connection = connectionRepository.getByConsumerNumber(consumerNumber);
		
		if (connection == null)
			throw new ConsumerNumberNotFoundException("No connection found with given consumer number");
		
		Reading reading = connection.getReading();
		if(reading==null) throw new ReadingNotFoundException("No Reading uploaded for current connection");
		
		Bill bill = reading.getBill();
		if(bill.getPayment()!=null&&bill.getPayment().getStatus()) throw new BillAlreadyPaidException("Bill for current reading already paid");
		
		return bill;
	}

	@Override
	public Payment payBill(Long consumerNumber) throws ConsumerNumberNotFoundException, ReadingNotFoundException, BillAlreadyPaidException {
		
		Bill bill = getBill(consumerNumber);
		
		if(bill.getPayment()!=null) throw new BillAlreadyPaidException("Bill for current reading already paid");
		
		Payment payment = new Payment();
		payment.setLatePaymentCharges(0.0);
		payment.setPaymentDate(LocalDate.now());
		payment.setStatus(true);
		payment.setTotalPaid((double)bill.getBillAmount());
		
		bill.setPayment(payment);
		
		return paymentRepository.save(payment);
		
	}

}
