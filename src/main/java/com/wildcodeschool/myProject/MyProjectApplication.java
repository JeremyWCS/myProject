package com.wildcodeschool.myProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class MyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "<ul>" +
				"<li><a href='http://localhost:8080/doctor/1'>William Hartnell</a></li>"+
				"<li><a href='http://localhost:8080/doctor/10'>David Tennant</a></li>"+
				"<li><a href='http://localhost:8080/doctor/13'>Jodie Whittaker</a></li>"+
				"<li><a href='http://localhost:8080/doctor/2'>Patrick Troughton</a></li>"+
				"</ul>";
	}


	@RequestMapping(path="/doctor/{number}")
	@ResponseBody
	public String getMessage(@PathVariable("number") String number) {

		switch (number) {
			case "1":
				return "William Hartnell";
			case "10":
				return "David Tennant";
			case "13":
				return "Jodie Whittaker";
			case "2":
				return "Patrick Troughton";
			default:
				return "Hello";
		}
	}
}
