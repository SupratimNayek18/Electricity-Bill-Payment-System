package electricitybillpaymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import electricitybillpaymentsystem.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer getByName(String name);
	/*
	 * @Query("select c from Customer c where c.customerId=:customerId and c.password=:password"
	 * ) Customer customerLogin(
	 * 
	 * @Param("customerId") String customerId,
	 * 
	 * @Param("password") String password );
	 */
}
