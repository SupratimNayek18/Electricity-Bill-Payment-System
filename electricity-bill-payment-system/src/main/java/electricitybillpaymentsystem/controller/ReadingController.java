package electricitybillpaymentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import electricitybillpaymentsystem.entities.Reading;
import electricitybillpaymentsystem.exception.ConsumerNumberNotFoundException;
import electricitybillpaymentsystem.services.ReadingService;

@RestController
@RequestMapping("/reading")
public class ReadingController {
	
	@Autowired
	ReadingService readingService;
	
	@PostMapping("/submitReading")
	public ResponseEntity<Reading> submitReading(@RequestParam Long consumerNumber,@RequestParam int consumedUnits) throws ConsumerNumberNotFoundException{
		return new ResponseEntity<>(readingService.submitReading(consumerNumber, consumedUnits),HttpStatus.OK);
	}

}
