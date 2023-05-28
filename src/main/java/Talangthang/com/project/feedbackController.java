package Talangthang.com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class feedbackController {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void feedbackController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/feedback")
    public ResponseEntity<String> handleFeedback(@RequestBody Feedback feedback) {
        String sql = "INSERT INTO feedbacks (email, feedback) VALUES ( ?, ?)";
        jdbcTemplate.update(sql,feedback.getEmail(), feedback.getFeedback());

        return ResponseEntity.ok("Thank you for your feedback!");
    }
}
