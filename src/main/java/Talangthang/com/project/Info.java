package Talangthang.com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class Info {
    private JdbcTemplate jdbcTemplate;
@Autowired
    public Info(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping(value = {"/Information/{name}"})
    public Resource getDefault(@PathVariable(required = false) String name) {
        return new ClassPathResource("static/Default.html");
    }
    @GetMapping("/Information/{name}/test")
    public List<Map<String, Object>> testing(@PathVariable String name) {
        String sql = "SELECT * FROM Destination WHERE Destination.DesID = ?";
        return jdbcTemplate.queryForList(sql, name);
    }

}
