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
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	String billAlreadyPaidException(BillAlreadyPaidException bape) {
		return bape.getMessage();
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	String customerNotFoundException(CustomerNotFoundException cnfe) {
		return cnfe.getMessage();
	}

	@ExceptionHandler(InvalidEmailException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	String invalidEmailException(InvalidEmailException ieme) {
		return ieme.getMessage();
	}

	@ExceptionHandler(ReadingNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	String readingNotFoundException(ReadingNotFoundException rnfe) {
		return rnfe.getMessage();
	}

	@ExceptionHandler(UsernameAlreadyExistsException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	String usernameAlreadyExistsException(UsernameAlreadyExistsException unae) {
		return unae.getMessage();
	}
	
	@ExceptionHandler(InvalidUsernameException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	String invalidUsernameException(InvalidUsernameException iue) {
		return iue.getMessage();
	}
	
	@ExceptionHandler(EmailAlreadyExistsException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	String emailAlreadyExistsException(EmailAlreadyExistsException eaee) {
		return eaee.getMessage();
	}
	
	@ExceptionHandler(ConnectionAlreadyExistsException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	String connectionAlreadyExistsException(ConnectionAlreadyExistsException caee) {
		return caee.getMessage();
	}
}
