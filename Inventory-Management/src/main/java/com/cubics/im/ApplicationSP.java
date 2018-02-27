package com.cubics.im;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "classpath*:SpringJPA.xml" })
public class ApplicationSP {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationSP.class, args);
	}

}
