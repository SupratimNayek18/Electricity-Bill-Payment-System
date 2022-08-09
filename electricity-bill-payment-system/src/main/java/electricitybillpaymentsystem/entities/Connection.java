package electricitybillpaymentsystem.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "connection")
public class Connection {

	@Id
	@GeneratedValue(generator = "Connection_SequenceStyleGenerator")
	@GenericGenerator(name = "Connection_SequenceStyleGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "connection_SEQ"), @Parameter(name = "optimizer", value = "hilo"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
	private Long connectionId;
	private Long consumerNumber;
	private LocalDate applicationDate;
	private LocalDate connectionDate;
	private boolean connectionStatus;
	
	public Connection() {
		super();
	}

	public Long getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(Long connectionId) {
		this.connectionId = connectionId;
	}

	public Long getConsumerNumber() {
		return consumerNumber;
	}

	public void setConsumerNumber(Long consumerNumber) {
		this.consumerNumber = consumerNumber;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public LocalDate getConnectionDate() {
		return connectionDate;
	}

	public void setConnectionDate(LocalDate connectionDate) {
		this.connectionDate = connectionDate;
	}

	public boolean isConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	@Override
	public String toString() {
		return "Connection [connectionId=" + connectionId + ", consumerNumber=" + consumerNumber + ", applicationDate="
				+ applicationDate + ", connectionDate=" + connectionDate + ", connectionStatus=" + connectionStatus
				+ "]";
	}
	
	
}