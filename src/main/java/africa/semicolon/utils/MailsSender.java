package africa.semicolon.utils;

import africa.semicolon.dtos.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSender {
    @Autowired
    private  JavaMailSender mailSender;

    public  void sendMail(RegisterRequest request){
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(request.getEmail());
            message.setFrom("victormsonter@gmail.com");
            message.setSubject("Registration Confirmation");
            message.setText("You have successfully registered with LogicSteeze");
            mailSender.send(message);
        }catch (MailSendException e){
            e.getMessage();
        }
    }
}
