package com.vermeg.settlementModule.instructionManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.vermeg.settlementModule" })
@EntityScan("com.vermeg.settlementModule")
@EnableJpaRepositories()
public class InstructionMangerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstructionMangerApplication.class, args);
	}

}
