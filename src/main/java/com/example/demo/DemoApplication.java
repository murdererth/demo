package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

	private UserRepository userRepository;

	public DemoApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostConstruct
	public void initialData() {
		userRepository.save(new User("B1"));
		userRepository.save(new User("B2"));
		userRepository.save(new User("B3"));
		userRepository.save(new User("B4"));
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(HelloService helloService) {
//		return args -> {
//			helloService.saveUser(new User("B1"));
//			helloService.saveUser(new User("B2"));
//			helloService.saveUser(new User("B3"));
//			helloService.saveUser(new User("B4"));
//		};
//	}
}
