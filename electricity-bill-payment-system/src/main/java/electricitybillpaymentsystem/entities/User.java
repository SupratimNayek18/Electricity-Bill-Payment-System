package electricitybillpaymentsystem.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(generator = "User_SequenceStyleGenerator")
	@GenericGenerator(name = "User_SequenceStyleGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "user_SEQ"), @Parameter(name = "optimizer", value = "hilo"),
			@Parameter(name = "initial_value", value = "1"), @Parameter(name = "increment_size", value = "1") })
	
	private Long userId;
	private String userName;
	private String password;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_fk",referencedColumnName = "customerId")
	private Customer customer;
	
	public User() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
