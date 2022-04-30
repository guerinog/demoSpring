package it.guerino.demoSpring;

import org.apache.logging.log4j.LogManager;
//import it.graziano.grazianofx.*;
import org.apache.logging.log4j.Logger;
//import org.joda.time.format.DateTimeFormat;
//import org.joda.time.format.DateTimeFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringApplication {

	
	private static final  Logger loggerMain = LogManager.getLogger(DemoSpringApplication.class);
	
	public static void main(String[] args) {
		loggerMain.debug("Inizio main");
		SpringApplication.run(DemoSpringApplication.class, args);
		//Validate validazione = new Validate();
		//boolean validateByFindPatternCharSpecial = validazione.validateByFindPatternCharSpecial("dsfsdfsd5$£343");
//DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
//System.out.println("DATA: " + dtf.print(new Date().getTime()));
}

	
}
