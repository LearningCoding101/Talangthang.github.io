package Talangthang.com.project;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DestinationController {
    @RequestMapping("/Destination")
    public Resource Destination(){
        return new ClassPathResource("static/Destination.html");
    }

}
