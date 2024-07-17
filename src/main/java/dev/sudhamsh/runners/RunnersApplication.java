package dev.sudhamsh.runners;

import dev.sudhamsh.runners.run.Location;
import dev.sudhamsh.runners.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RunnersApplication {
	private static final Logger log = LoggerFactory.getLogger(RunnersApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(RunnersApplication.class, args);
//		ConfigurableApplicationContext context = SpringApplication.run(RunnersApplication.class, args);
		log.info("Application started!");
	}


}
