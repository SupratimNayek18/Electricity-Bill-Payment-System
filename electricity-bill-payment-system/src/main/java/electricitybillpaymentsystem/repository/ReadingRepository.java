package electricitybillpaymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import electricitybillpaymentsystem.entities.Reading;

public interface ReadingRepository extends JpaRepository<Reading, Long> {

}
