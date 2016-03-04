package com.nalegroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nalegroup.dao.UserDAO;

@Controller
public class LoginController {
	
	@RequestMapping(value="/welcome", method=RequestMethod.POST)
	public ModelAndView helloWorld(@RequestParam("flogin") String flogin,
			@RequestParam("fpassword") String fpassword) {
		
		
		UserDAO dao =  new UserDAO();
		
		String message = "Failed ";
		
		
		if(dao.validateUser(flogin, fpassword))  message = "Success";
		
		
		return new ModelAndView("welcome", "message", message);
	}

}
