 package it.guerino.demoSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import it.guerino.demoSpring.model.Foto;

@Service("mainFotoService") 
public class FotoService implements IFotoService{
	private Logger logger = LogManager.getLogger(FotoService.class);
	private List<Foto> lista;
	private int ultimoIdInserito;
	
	public FotoService() {
		this.lista= new ArrayList<Foto>();
		lista.add(new Foto(1,"./img/01.png"));
		lista.add(new Foto(2,"./img/02.png"));
		lista.add(new Foto(3,"./img/03.png"));
		ultimoIdInserito=3;
	}
	
	@Override
	public Iterable<Foto> allPhoto(){
		logger.debug("sono in allPhoto");
		return lista;
	}
	@Override
	public Optional<Foto>  getFotoById(int id) {
		logger.debug("sono in getFotoById");
		Optional<Foto> foto = lista.stream().filter(item->item.getId() ==  id).findFirst();
		logger.debug("Foto con id "+ id + " trovata");
		return foto;
	}
	@Override
	public Foto creaNuovaFoto(@RequestBody Foto foto) {
		logger.debug("sono in creaNuovaFoto");
		ultimoIdInserito++;
		foto.setId(ultimoIdInserito); 
		lista.add(foto);
		logger.debug("REstituisco la nuova foto inserita con id:" + foto.getId());
		return foto;
	}
	@Override
	public Optional<Foto> aggiornaNuovaFoto(int idFoto,Foto foto) {
		logger.debug("sono in aggiornaNuovaFoto");
		Optional<Foto> fotoTrovata = lista.stream().filter(item->item.getId() == idFoto).findFirst();
		fotoTrovata.get().setUrl(foto.getUrl());
		logger.debug("Foto aggiornata correttamente, con id:" + fotoTrovata.get().getId());
		return fotoTrovata;
	}
	@Override
	public boolean rimuoviFoto(int idFoto) { 
		logger.debug("sono in rimuoviFoto");
		Optional<Foto> fotoTrovata = lista.stream().filter(item->item.getId() == idFoto).findFirst();
		if(!fotoTrovata.isPresent()) {
			logger.error("Foto non trovata");
			return false;
		}
		lista.remove(fotoTrovata.get());
		logger.debug("Foto cancellata correttamente, con id:" + fotoTrovata.get().getId());
		return true;
	}
}
