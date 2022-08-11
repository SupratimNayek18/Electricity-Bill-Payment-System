package electricitybillpaymentsystem.exception;

public class BillAlreadyPaidException extends Exception {

	private static final long serialVersionUID = 1L;

	public BillAlreadyPaidException(String message) {
		super(message);
	}
}
