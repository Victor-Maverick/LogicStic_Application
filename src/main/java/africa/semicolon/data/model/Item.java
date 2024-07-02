package africa.semicolon.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Item {
    @Id
    private String id;
    private String name;
    private Category category;
    private STATUS status;
}
