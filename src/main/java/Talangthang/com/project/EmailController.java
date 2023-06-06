package Talangthang.com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmailController {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailController(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @PostMapping("/send-email")
    public ResponseEntity<Map<String, String>> sendFeedbackEmail(@RequestBody Map<String, String> feedback) {
        String name = feedback.get("name");
        String email = feedback.get("email");
        String subject = feedback.get("subject");
        String message = feedback.get("message");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("Talangthang2023@gmail.com"); // Your personal email address
        mailMessage.setSubject(subject);
        mailMessage.setText("Name: " + name + "\nEmail: " + email + "\n\nMessage:\n" + message);

        emailSender.send(mailMessage);

        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Email sent successfully!");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
