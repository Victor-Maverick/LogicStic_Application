package africa.semicolon.data.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "order_list")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trackingId;
    @ManyToOne
    private Customer customer;

}
