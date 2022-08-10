package electricitybillpaymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import electricitybillpaymentsystem.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
