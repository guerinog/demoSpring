package it.guerino.demoSpring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringApplication {

	
	private static final  Logger loggerMain = LogManager.getLogger(DemoSpringApplication.class);
	
	public static void main(String[] args) {
		loggerMain.debug("Inizio main");
		SpringApplication.run(DemoSpringApplication.class, args);
	}

}
