package Talangthang.com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RequestMapping("/Combo")
	public Resource placeHolder(){
		return new ClassPathResource("static/placeholder.html");
	}
	@RequestMapping("/Contact")
	public Resource contact(){
		return new ClassPathResource("static/Contact.html");
	}
	@RequestMapping("/Info")
	public Resource Info(){
		return new ClassPathResource("static/info.html");
	}

	@RequestMapping("/Safety")
	public Resource Safety(){
		return new ClassPathResource("static/safety.html");
	}
	@RequestMapping("/About-us")
	public Resource About(){
		return new ClassPathResource("static/about.html");
	}
}
