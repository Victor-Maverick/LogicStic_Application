package africa.semicolon.data.repository;

import africa.semicolon.data.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Products extends JpaRepository<Item, Long> {
}
