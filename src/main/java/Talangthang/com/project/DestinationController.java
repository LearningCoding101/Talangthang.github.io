package Talangthang.com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DestinationController {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void DestinationController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @RequestMapping(value = "/Destination", method = RequestMethod.GET)
    public Resource Destination(){
        return new ClassPathResource("static/Destination.html");
    }

}
