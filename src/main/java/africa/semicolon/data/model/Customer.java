package africa.semicolon.data.model;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String emailAddress;
    private String phoneNumber;
    private String password;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;
    @Setter(AccessLevel.NONE)
    @JsonSerialize(using = JsonSerializer.class)
    @JsonDeserialize(using = JsonDeserializer.class)
    private LocalDateTime createdAt;
    @Setter(AccessLevel.NONE)
    @JsonSerialize(using = JsonSerializer.class)
    @JsonDeserialize(using = JsonDeserializer.class)
    private LocalDateTime updatedAt;

    @PrePersist
    private void setCreatedAt() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void setUpdatedAt() {
        updatedAt = LocalDateTime.now();
    }

}



