package electricitybillpaymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import electricitybillpaymentsystem.entities.Connection;


public interface ConnectionRepository extends JpaRepository<Connection, Long> {
	
	@Query("select conn from Connection conn where conn.consumerNumber=:consumerNumber")
	public Connection getByConsumerNumber(@Param("consumerNumber") Long consumerNumber);

}
