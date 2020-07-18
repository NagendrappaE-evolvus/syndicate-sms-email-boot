/**
 * 
 */
package com.evolvus.smsEmailWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author EVOLVUS\manishp
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("com.evolvus")
@ComponentScan("com.evolvus")
@EntityScan("com.evolvus")
@RestController
public class SpringBootMain {
	
	public static void main(String[] args) {

		SpringApplication.run(SpringBootMain.class, args);

	}
	
	@RequestMapping("/status")
	public String status(){
		return "Application is up";
	}
	
}