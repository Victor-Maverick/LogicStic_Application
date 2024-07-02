package africa.semicolon.data.repository;

import africa.semicolon.data.model.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Carriers extends JpaRepository<Carrier, Long> {
}
