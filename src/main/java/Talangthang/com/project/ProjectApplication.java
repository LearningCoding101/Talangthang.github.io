package Talangthang.com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

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
	@RequestMapping(value = {"/Information/{name}","/Information"})
	public ResponseEntity<String> getDefault(@PathVariable(required = false) String name) {
		String htmlContent;

		try {
			ClassPathResource resource = new ClassPathResource("static/Default.html");
			byte[] fileBytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
			htmlContent = new String(fileBytes, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// Handle exception if the file cannot be read
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_HTML);

		return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
	}
	@GetMapping("/getCSS")
	public Resource getCSS(){
		return new ClassPathResource("static/style.css");
	}
	@GetMapping("/CountTime")
	public Resource getCount(){
		return new ClassPathResource("static/Count.html");
	}
}
