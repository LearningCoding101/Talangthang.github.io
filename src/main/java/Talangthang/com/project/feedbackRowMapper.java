package Talangthang.com.project;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class feedbackRowMapper implements RowMapper<Feedback> {
    public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException{
        Feedback feedback = new Feedback();
        feedback.setFeedback(rs.getString("feedback"));
        feedback.setEmail(rs.getString("email"));
        return feedback;
    }
}
