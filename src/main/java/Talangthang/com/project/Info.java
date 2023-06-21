package Talangthang.com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class Info {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public Info(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @GetMapping("/Information/{name}/Resources")
    public List<Map<String, Object>> testing(@PathVariable String name) {
        String sql = "SELECT Destination.*, Picture.* " +
                "FROM Destination " +
                "JOIN Picture ON Destination.DesID = Picture.DestinationID " +
                "WHERE Destination.DesID = ? " +
                "LIMIT 1;";

        return jdbcTemplate.queryForList(sql, name);
    }
}
