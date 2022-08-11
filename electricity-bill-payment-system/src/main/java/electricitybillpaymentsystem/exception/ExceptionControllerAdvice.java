package electricitybillpaymentsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(ConsumerNumberNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	  String consumerNumberNotFoundException(ConsumerNumberNotFoundException cnnfe) {
	    return cnnfe.getMessage();
	  }
	
	@ExceptionHandler(BillAlreadyPaidException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	  String billAlreadyPaidException(BillAlreadyPaidException bape) {
	    return bape.getMessage();
	  }
	
	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	  String customerNotFoundException(CustomerNotFoundException cnfe) {
	    return cnfe.getMessage();
	  }
	@ExceptionHandler(InvalidEmailException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	  String invalidEmailException(InvalidEmailException ieme) {
	    return ieme.getMessage();
	  }
	@ExceptionHandler(InvalidPassWordException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	  String invalidPassWordException(InvalidPassWordException ipe) {
	    return ipe.getMessage();
	  }
	@ExceptionHandler(ReadingNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	  String readingNotFoundException(ReadingNotFoundException rnfe) {
	    return rnfe.getMessage();
	  }
	@ExceptionHandler(UsernameAlreadyExistsException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	  String usernameAlreadyExistsException(UsernameAlreadyExistsException unae) {
	    return unae.getMessage();
	  }
}
