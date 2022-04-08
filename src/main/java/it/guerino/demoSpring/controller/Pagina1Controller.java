package it.guerino.demoSpring.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Pagina1Controller {

	private Logger logger = LogManager.getLogger(Pagina1Controller.class);
	
	@RequestMapping("/pagina1")
	@ResponseBody
	public String indexPagina1() {
		logger.debug("Inizio indexPagina1");
		return "Pagina 1 - ciao graziano!!";
	}
}
