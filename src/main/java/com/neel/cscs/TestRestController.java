package com.neel.cscs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
	
	//test with this url - https://localhost:5555/test 
	
	@GetMapping("/test")
	public String testService() {
		return "Test Success";
	}

}
