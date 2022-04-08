 package it.guerino.demoSpring.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import it.guerino.demoSpring.model.Foto;

@Service
public class DbFotoService implements IFotoService {
	private Logger logger = LogManager.getLogger(DbFotoService.class);

	@Override
	public Iterable<Foto> allPhoto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Foto> getFotoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Foto creaNuovaFoto(Foto foto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Foto> aggiornaNuovaFoto(int idFoto, Foto foto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean rimuoviFoto(int idFoto) {
		// TODO Auto-generated method stub
		return false;
	}
	
//	@Autowired
//	private IFotoRepository fotoRepository;
//	
//	@Override
//	public Iterable<Foto> allPhoto(){
//		logger.debug("sono in allPhoto di db fot service");
//		return fotoRepository.findAll();
//	}
//	
//	@Override
//	public Optional<Foto> getFotoById(int id) {
//		logger.debug("sono in getFotoById");
//	
//		logger.debug("Foto con id "+ id + " trovata");
//		return fotoRepository.findById(id);
//	}
//	
//	@Override
//	public Foto creaNuovaFoto(Foto foto) {
//		logger.debug("sono in creaNuovaFoto");
//	
//		logger.debug("REstituisco la nuova foto inserita con id:" + foto.getId());
//		return fotoRepository.save(foto);
//	}
//	
//	@Override
//	public Optional<Foto> aggiornaNuovaFoto(int idFoto,Foto foto) {
//		logger.debug("sono in aggiornaNuovaFoto");
//		Optional<Foto> f = fotoRepository.findById(idFoto);
//		if (!f.isPresent()) {
//			return f;
//		}
//		f.get().setUrl(foto.getUrl());
//		fotoRepository.save(f.get());
//		return f;
//	}
//	
//	@Override 
//	public boolean rimuoviFoto(int idFoto) {   
//		logger.debug("sono in rimuoviFoto");
//		Optional<Foto> f = fotoRepository.findById(idFoto);
//		if (!f.isPresent()) {
//			return false;
//		}
//		fotoRepository.delete(f.get());
//		return true;
//	}
}
