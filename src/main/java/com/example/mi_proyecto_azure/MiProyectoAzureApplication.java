package com.example.mi_proyecto_azure;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan; 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories; 

import com.example.login.entity.Usuario;
import com.example.login.repository.UsuarioRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.mi_proyecto_azure", "com.example.login"}) 
@EnableJpaRepositories(basePackages = "com.example.login.repository") 
@EntityScan(basePackages = "com.example.login.entity") 
public class MiProyectoAzureApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiProyectoAzureApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UsuarioRepository repository) {
		return args -> {
			if (!repository.findByUsername("admin").isPresent()) {
				repository.save(new Usuario("admin", "12345"));
				System.out.println("--> Usuario de prueba creado de forma automática (User: admin | Pass: 12345)");
			}
		}; 
	} 
}