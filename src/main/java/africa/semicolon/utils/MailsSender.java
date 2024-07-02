package africa.semicolon.utils;

import africa.semicolon.dtos.request.RegisterRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailsSender {
    @Autowired
    private JavaMailSender javaMailSender;
    static String senderMailAddress = "victormsonter@gmail.com";

    public void sendMail(RegisterRequest request){
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(senderMailAddress);
            mimeMessageHelper.setTo(request.getEmail());
            mimeMessageHelper.setText("<!DOCTYPE html>" +
                    "<html lang=\"en\">" +
                    "<head>" +
                    "<meta charset=\"UTF-8\">" +
                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                    "<title>Welcome to Our Spring Boot Application</title>" +
                    "<style>" +
                    "body { font-family: Arial, sans-serif; line-height: 1.6; color: #333; }" +
                    ".container { max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }" +
                    ".header { background-color: #4CAF50; color: white; padding: 10px 0; text-align: center; border-radius: 10px 10px 0 0; }" +
                    ".content { padding: 20px; }" +
                    ".footer { text-align: center; padding: 10px 0; background-color: #f1f1f1; border-radius: 0 0 10px 10px; }" +
                    "</style>" +
                    "</head>" +
                    "<body>" +
                    "<div class=\"container\">" +
                    "<div class=\"header\">" +
                    "<h1>Welcome to LogicSteeze!</h1>" +
                    "</div>" +
                    "<div class=\"content\">" +
                    "<p>Dear Customer </p>" +
                    "<p>Thank you for joining our application. We're excited to have you on board!</p>" +
                    "<p>Here are some resources to get you started:</p>" +
                    "<p>If you have any questions, feel free to <a href=\"mailto:victormsonter@gmail.com\">contact our support team</a>.</p>" +
                    "<p>Best regards,<br>The LogicSteeze Team</p>" +
                    "</div>" +
                    "<div class=\"footer\">" +
                    "<p>&copy; 2024 Your Company. All rights reserved.</p>" +
                    "</div>" +
                    "</div>" +
                    "</body>" +
                    "</html>", true);

            mimeMessageHelper.setSubject("Registration Confirmation");
            javaMailSender.send(mimeMessage);
        }catch (MailSendException e){
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
