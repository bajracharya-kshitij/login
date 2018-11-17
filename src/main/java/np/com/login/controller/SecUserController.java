package np.com.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import np.com.login.model.SecUser;

@Controller
public class SecUserController {

	@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
	public String getRegistrationPage(Model model) {
		model.addAttribute("secUser", new SecUser());
		return "register";
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public String register() {
		System.out.println("Registration completed!!!");
		return "redirect:/register";
	}
}
