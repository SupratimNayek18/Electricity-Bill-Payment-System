package electricitybillpaymentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import electricitybillpaymentsystem.entities.Bill;
import electricitybillpaymentsystem.entities.Payment;
import electricitybillpaymentsystem.exception.BillAlreadyPaidException;
import electricitybillpaymentsystem.exception.ConsumerNumberNotFoundException;
import electricitybillpaymentsystem.exception.ReadingNotFoundException;
import electricitybillpaymentsystem.services.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	BillService billService;
	
	@GetMapping("/getBill")
	public ResponseEntity<Bill> getBill(@RequestParam Long consumerNumber) throws ConsumerNumberNotFoundException, ReadingNotFoundException{
		return new ResponseEntity<>(billService.getBill(consumerNumber),HttpStatus.OK);
	}
	
	@PostMapping("/payBill")
	public ResponseEntity<Payment> payBill(@RequestParam Long consumerNumer) throws ConsumerNumberNotFoundException, ReadingNotFoundException, BillAlreadyPaidException{
		return new ResponseEntity<>(billService.payBill(consumerNumer),HttpStatus.OK);
	}

}
