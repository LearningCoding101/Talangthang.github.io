package Talangthang.com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}
	@GetMapping("/")
	public Resource index(){
		return new ClassPathResource("static/index.html");
	}
	@RequestMapping("/360demo")
	public Resource fullView(){
		return new ClassPathResource("static/test.html");
	}

	@RequestMapping(value = {"/Info", "/Combo", "/Safety", "/About-us"})
	@ResponseBody
	public Resource placeholder(){
		return new ClassPathResource("static/placeholder.html");
	}
	@RequestMapping("/Contact")
	public Resource contact(){
		return new ClassPathResource("static/Contact.html");
	}
}
