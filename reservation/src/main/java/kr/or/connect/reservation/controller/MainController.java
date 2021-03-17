package kr.or.connect.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/main")
	public String main() {
		
		return "main";
	}
	
	@GetMapping("/failure")
	public String showFailure() {
		
		return "failure";
	}
	
}
