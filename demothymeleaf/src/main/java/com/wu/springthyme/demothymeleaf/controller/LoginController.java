/**
 * 
 */
package com.wu.springthyme.demothymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.wu.springthyme.demothymeleaf.form.LoginForm;

/**
 * @author Supraja Chamarty
 *
 */
@Controller
public class LoginController {
	
	//to get login page
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginForm() {
		return "login";
	}
	
	//checking for login credentials
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute(name="loginForm") LoginForm loginForm, Model model) {
		
		String userName = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		if(("admin").equals(userName) && ("admin").contentEquals(loginForm.getPassword())){
			return "home";
		}
		model.addAttribute("invalidCredentials",true);
		
		return "login";
		
		
	}
}
