package it.guerino.demoSpring.service;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import it.guerino.demoSpring.model.Foto;

public interface IFotoService {
	
	public Iterable<Foto> allPhoto();
	
	public Optional<Foto>  getFotoById(int id);
	
	public Foto creaNuovaFoto(@RequestBody Foto foto);
	 
	public Optional<Foto> aggiornaNuovaFoto(int idFoto,Foto foto);
	
	public boolean rimuoviFoto(int idFoto);
}
