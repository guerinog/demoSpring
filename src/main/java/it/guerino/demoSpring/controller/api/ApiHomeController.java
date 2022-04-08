package it.guerino.demoSpring.controller.api;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.guerino.demoSpring.model.Foto;
import it.guerino.demoSpring.service.IFotoService;

@RestController
public class ApiHomeController {
	private Logger logger = LogManager.getLogger(ApiHomeController.class);
	@Autowired
	@Qualifier("mainFotoService")
	private IFotoService serviceFoto;
	
	
	@RequestMapping("/api/photo")
	public Iterable<Foto> allPhoto(){
		logger.info("sono in allPhoto");
		return serviceFoto.allPhoto(); 
	}
	
	@RequestMapping("/api/photo/{id}")
	public Foto getFotoById(@PathVariable int id) {
		logger.debug("sono in getFotoById");
		Optional<Foto> f = serviceFoto.getFotoById(id);
		if(!f.isPresent()) {
			logger.error("Foto non trovata");
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foto non trovata");
		}
		logger.debug("Foto con id "+ id + " trovata");
		return f.get();
	}
	
	
}
