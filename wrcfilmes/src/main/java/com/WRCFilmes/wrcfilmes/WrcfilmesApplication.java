package com.WRCFilmes.wrcfilmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WrcfilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WrcfilmesApplication.class, args);
		System.out.print(new BCryptPasswordEncoder().encode("123"));
	}

}
