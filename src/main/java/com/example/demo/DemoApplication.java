package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

	private HelloService helloService;

	public DemoApplication(HelloService helloService) {
		this.helloService = helloService;
	}

	@PostConstruct
	public void initialData() {
		helloService.saveUser(new User("B1"));
		helloService.saveUser(new User("B2"));
		helloService.saveUser(new User("B3"));
		helloService.saveUser(new User("B4"));
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
