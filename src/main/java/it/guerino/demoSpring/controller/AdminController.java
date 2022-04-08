package it.guerino.demoSpring.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	private Logger logger = LogManager.getLogger(AdminController.class);
	
	@RequestMapping("/admin")
	public String admin() {
		logger.debug("Inizio admin");
		return "admin";
	}
	
	@RequestMapping("/login")
	public String login() {
		logger.debug("vado in login");
		return "login";
	}
}

