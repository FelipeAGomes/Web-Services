package uk.co.webservices.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import uk.co.webservices.entities.User1;
import uk.co.webservices.repositories.User1Repository;
//configuration to test profile and seeding database

@Configuration
@Profile("test")// need to be same name from aplication-test.properties, to use this configuration only for test profile
public class TestConfig implements CommandLineRunner{

	@Autowired
	private User1Repository user1Repository;

	@Override
	public void run(String... args) throws Exception {
		User1 u1 = new User1(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User1 u2 = new User1(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		user1Repository.saveAll(Arrays.asList(u1,u2));
	}
	
}
