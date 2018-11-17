package np.com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import np.com.login.model.SecUser;
import np.com.login.service.SecUserService;

@Controller
public class SecUserController {
	
	@Autowired
    SecUserService secUserService;

	@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
	public String getRegistrationPage(Model model) {
		model.addAttribute("formUser", new SecUser());
		return "register";
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public String register(@ModelAttribute("formUser") SecUser formUser) {
		SecUser secUser = secUserService.findByUsername(formUser.getUsername());
		if (secUser != null) {
			System.out.println("User already exists!!!");
            return "redirect:/register";
        }
		formUser.setPassword(new BCryptPasswordEncoder().encode(formUser.getPassword()));
		if (secUserService.save(formUser) != null) {
			System.out.println("Registration completed!!!");
        } else {
        	System.out.println("Registration failed!!!");
        }

        return "redirect:/register";
	}
}
