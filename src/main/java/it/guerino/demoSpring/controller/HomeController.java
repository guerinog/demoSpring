package it.guerino.demoSpring.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	private Logger logger = LogManager.getLogger(HomeController.class);
	@RequestMapping("/")
	public String index() {
		logger.debug("Inizio index");
		return "index";
	}
}

