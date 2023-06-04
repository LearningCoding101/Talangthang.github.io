package Talangthang.com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
class PlaceTypeController {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void PlaceTypeController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @GetMapping("/PlaceType")
    public List<Map<String, Object>> getData() {
        String sql = "SELECT * FROM PlaceType";
        return jdbcTemplate.queryForList(sql);
    }
}
