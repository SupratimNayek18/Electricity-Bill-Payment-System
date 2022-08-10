package electricitybillpaymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import electricitybillpaymentsystem.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from User u where u.userId=:userId and u.password=:password")
	  User userLogin(
	    @Param("userId") String userId,
	    @Param("password") String password
	  );

}
