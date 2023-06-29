package Talangthang.com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class feedbackController {
    private JdbcTemplate jdbcTemplate;
    List<Feedback> feedbackCheck = new ArrayList<>();


    @Autowired
    public void feedbackController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/feedback")
    public ResponseEntity<String> handleFeedback(@RequestBody Feedback feedback) {
        String sql = "INSERT INTO feedbacks (email, feedback) VALUES ( ?, ?)";
        jdbcTemplate.update(sql,feedback.getEmail(), feedback.getFeedback());

        return ResponseEntity.ok("ok");
    }
    @GetMapping("/feedback")
    public List<Feedback> getFeedback(){
        String sql = "SELECT DISTINCT * FROM feedbacks";
        List<Feedback> feedback = jdbcTemplate.query(sql, new feedbackRowMapper());

        return feedback;
    }

}
