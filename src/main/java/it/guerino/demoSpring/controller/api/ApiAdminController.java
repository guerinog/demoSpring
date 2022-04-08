package it.guerino.demoSpring.controller.api;

import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.guerino.demoSpring.model.Foto;
import it.guerino.demoSpring.service.IFotoService;

@RestController
public class ApiAdminController {

	private Logger logger = LogManager.getLogger(ApiAdminController.class);
	@Autowired
	@Qualifier("mainFotoService")
	private IFotoService serviceFoto;

	
	@RequestMapping("/api/admin/photo")
	public Iterable<Foto> allPhoto(){
		logger.debug("sono in allPhoto");
		return serviceFoto.allPhoto();
	}
	
	@RequestMapping("/api/admin/photo/{id}")
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
	
	@RequestMapping(value="/api/admin/photo", method=RequestMethod.POST)
	public Foto creaNuovaFoto(@Valid @RequestBody Foto foto) {
		logger.debug("sono in creaNuovaFoto");
		return serviceFoto.creaNuovaFoto(foto);
	}
	
	@RequestMapping(value="/api/admin/photo/{idFoto}", method=RequestMethod.PUT)
	public Foto aggiornaNuovaFoto(@Valid @PathVariable int idFoto, @Valid @RequestBody Foto foto) {
		logger.debug("sono in aggiornaNuovaFoto");
		Optional<Foto> f = serviceFoto.aggiornaNuovaFoto(idFoto, foto);
		if(!f.isPresent()) {
			logger.error("Foto non trovata");
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foto non trovata");
		}
		logger.debug("Foto aggiornata correttamente, con id:" + idFoto);
		return f.get();
	}
	
	@RequestMapping(value="/api/admin/photo", method=RequestMethod.PUT)
	public Foto aggiornaFoto(@Valid @RequestBody Foto foto) {
		logger.debug("sono in aggiornaFoto");
		Optional<Foto> f = serviceFoto.aggiornaNuovaFoto(foto.getId(), foto);
		if(!f.isPresent()) {
			logger.error("Foto non trovata");
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foto non trovata");
		}
		logger.debug("Foto aggiornata correttamente, con id:" + f.get().getId());
		return f.get();
	}
	
	@RequestMapping(value="/api/admin/photo/{idFoto}", method=RequestMethod.DELETE)
	public void rimuoviFoto(@PathVariable int idFoto) {
		logger.debug("sono in rimuoviFoto");
		if(!serviceFoto.rimuoviFoto(idFoto)) {
			logger.error("Foto non trovata");
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foto non trovata");
		}
		logger.debug("Foto cancellata correttamente, con id:" + idFoto);
	}
}
