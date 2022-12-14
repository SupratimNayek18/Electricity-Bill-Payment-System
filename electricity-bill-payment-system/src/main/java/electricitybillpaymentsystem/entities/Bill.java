package electricitybillpaymentsystem.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bill")
public class Bill {
	
	@Id
	@GeneratedValue(generator = "Bill_SequenceStyleGenerator")
	@GenericGenerator(name = "Bill_SequenceStyleGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "bill_SEQ"), @Parameter(name = "optimizer", value = "hilo"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
	private Long billId;
	private int unitsConsumed;
	private int billAmount;	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate billDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dueDate;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_fk",referencedColumnName = "paymentId")
	private Payment payment;
	
	public Bill() {
		super();
	}
	
	public Bill(Long billId, int unitsConsumed, int billAmount, LocalDate billDate, LocalDate dueDate) {
		super();
		this.billId = billId;
		this.unitsConsumed = unitsConsumed;
		this.billAmount = billAmount;
		this.billDate = billDate;
		this.dueDate = dueDate;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public int getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(int unitConsumed) {
		this.unitsConsumed = unitConsumed;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", unitsConsumed=" + unitsConsumed + ", billAmount=" + billAmount
				+ ", billDate=" + billDate + ", dueDate=" + dueDate + "]";
	}
	
}

