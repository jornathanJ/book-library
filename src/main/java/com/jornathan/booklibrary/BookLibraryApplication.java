package com.jornathan.booklibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class BookLibraryApplication {

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		System.setProperty("spring.profiles.default", "local");
		applicationContext = SpringApplication.run(BookLibraryApplication.class, args);
	}

}
