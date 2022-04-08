package it.guerino.demoSpring.model;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

//@Entity //dice che è un classa che rappresenta una tabella del db
public class Foto {
	
	//@Id //dice che è il campo chiave
	//@GeneratedValue // dice che autoincrement sul db
	private int id;
	@NotBlank(message="questo campo non può essere vuoto!")
	@Length(min=2, message="almeno due caratteri")
	private String url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Foto(int id, String url) {
		super();
		this.id = id;
		this.url = url;
	}
	
	
	public Foto() {
		
	}
}
