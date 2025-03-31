package Portfolio.JavaDev.runnerz;

import Portfolio.JavaDev.runnerz.run.Location;
import Portfolio.JavaDev.runnerz.run.Run;
import Portfolio.JavaDev.runnerz.run.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class RunnerzApplication {

	//Alap Spring Boot logger, amúgy van beépített is
	private static final Logger log  = LoggerFactory.getLogger(RunnerzApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class);
		//log.info("Something changed!"); //Logger meghívása
	}

//	@Bean
//	CommandLineRunner runner(RunRepository runRepository) {
//		return args -> {
//			Run run = new Run(1, "First run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
//			//log.info("Run " + run);
//			runRepository.create(run);
//		};
//	}
}