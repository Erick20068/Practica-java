package com.example.mi_proyecto_azure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {
    DataSourceAutoConfiguration.class, 
    HibernateJpaAutoConfiguration.class
})
@ComponentScan(basePackages = {"com.example.mi_proyecto_azure", "com.example.login"}) 
public class MiProyectoAzureApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiProyectoAzureApplication.class, args);
    }
}