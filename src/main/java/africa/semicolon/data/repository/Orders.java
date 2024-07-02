package africa.semicolon.data.repository;

import africa.semicolon.data.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Orders extends JpaRepository<Order, Long> {
}
