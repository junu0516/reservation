package kr.or.connect.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@GetMapping("/main")
	public String showMainPage() {
		
		return "main";
	}
	
	@GetMapping("/loginForm")
	public String showLoginPage() {
		
		return "user/loginForm";
	}
	
	@GetMapping("/failure")
	public String showFailurePage(@RequestParam("error_code")String errorCode) {
		
		System.out.println("로그인 실패 / 에러 코드 : "+errorCode);
		return "user/failure";
	}
	
	@GetMapping("/success")
	public String showSuccessPage() {
		
		System.out.println("로그인 성공");
		return "user/success";
	}
	
	
}
