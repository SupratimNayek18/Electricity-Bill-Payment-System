package electricitybillpaymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import electricitybillpaymentsystem.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select user from User user where user.userName=:userName")
	public User login(@Param("userName") String userName);

}
