package electricitybillpaymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import electricitybillpaymentsystem.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
