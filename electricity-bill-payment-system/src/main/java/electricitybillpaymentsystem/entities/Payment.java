package electricitybillpaymentsystem.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(generator = "Payment_SequenceStyleGenerator")
	@GenericGenerator(name = "Payment_SequenceStyleGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "payment_SEQ"), @Parameter(name = "optimizer", value = "hilo"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
	private Long paymentId;
	private LocalDate paymentDate;
	private Double latePaymentCharges;
	private Double totalPaid;
	private Boolean status;
	
	public Payment() {}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getLatePaymentCharges() {
		return latePaymentCharges;
	}

	public void setLatePaymentCharges(Double latePaymentCharges) {
		this.latePaymentCharges = latePaymentCharges;
	}

	public Double getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(Double totalPaid) {
		this.totalPaid = totalPaid;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", latePaymentCharges="
				+ latePaymentCharges + ", totalPaid=" + totalPaid + ", status=" + status + "]";
	}
	
	
}
