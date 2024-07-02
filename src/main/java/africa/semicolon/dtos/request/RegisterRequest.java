package africa.semicolon.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequest {
    private String email;
    private String phoneNumber;
    private int number;
    private String street;
    private String city;
    private String state;
}
