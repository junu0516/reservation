package kr.or.connect.reservation.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@GetMapping("/main")
	public String showMainPage(Principal principal, ModelMap modelMap) {
		
		System.out.println("메인페이지 호출");
		if(principal != null) {
			String userEmail = principal.getName();
			modelMap.addAttribute("userEmail",userEmail);
		}
		
		return "main";
	}
	
	@GetMapping("/loginForm")
	public String showLoginPage() {
		
		return "user/loginForm";
	}
	
	@GetMapping("/failure")
	public String showFailurePage() {
		
		System.out.println("로그인 실패 ");
		return "user/failure";
	}

}
