package electricitybillpaymentsystem.exception;

public class ConsumerNumberNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ConsumerNumberNotFoundException(String message){
		super(message);
	}
	
}