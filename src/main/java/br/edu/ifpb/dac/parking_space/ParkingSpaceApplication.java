package br.edu.ifpb.dac.parking_space;

import br.edu.ifpb.dac.parking_space.business.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EnableWebMvc
public class ParkingSpaceApplication implements WebMvcConfigurer, CommandLineRunner {

	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(ParkingSpaceApplication.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry
				.addMapping("/**")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH");
	}

	@Override
	public void run(String... args) throws Exception {
		roleService.createDefaultValues();
	}
}
