package com.october.praytest.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner init(IdeaRepository repository) {
		return args -> {
			Stream.of("Aristocratic", "Influence", "Offensive", "Defencive", "Plutocratic",
					"Religious", "Humanistic", "Economic", "Naval").forEach(name -> {
				Idea idea = new Idea();
				idea.setName(name);
				repository.save(idea);
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
