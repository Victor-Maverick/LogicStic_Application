package africa.semicolon.dtos.response;

import lombok.Data;

@Data
public class RegisterResponse {
    private String message;
    private Long id;
    private String phoneNumber;
}
