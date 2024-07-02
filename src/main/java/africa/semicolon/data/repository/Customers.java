package africa.semicolon.data.repository;

import africa.semicolon.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customers extends JpaRepository<Customer, Long> {

    Customer findByEmailAddress(String username);
}
