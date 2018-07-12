package hello;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hello.entity.Child;
import hello.entity.Gender;
import hello.entity.Team;
import hello.repository.ChildRepository;
import hello.repository.TeamRepository;


@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public CommandLineRunner demo(TeamRepository teamRepository, ChildRepository childRepository) {
		return (args) -> {
			List<Team> teams = new ArrayList<>();
			
			Team cowboys = new Team("Kovbojove", "Petr", "Panek", 27);
			cowboys.getChildren().add(new Child("Martin", "Bily", "1234", Gender.Male));
			
			Team bulls = new Team("Bulls", "Ondrej", "Danes", 337);
			bulls.getChildren().add(new Child("Martin", "Prokop", "321", Gender.Male));
			
			teams.add(cowboys);
			teams.add(bulls);
			
			Iterable<Team> savedTeams = teamRepository.saveAll(teams);
			for (Team t : savedTeams) {
				System.out.println(t);
			}
		};
	}
}