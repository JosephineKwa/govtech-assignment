
package com.govtech.assignment;

import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

import com.opencsv.bean.CsvToBeanBuilder;


@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private UserRepository repository;
	
	@Value(value = "classpath:users.csv")
	private Resource usersCsv;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		List<User> userBeans = new CsvToBeanBuilder<User>(
				new InputStreamReader(usersCsv.getInputStream()))
				.withType(User.class).build().parse();
		repository.saveAll(userBeans);
	}
}
