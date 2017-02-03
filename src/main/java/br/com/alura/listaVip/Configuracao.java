package br.com.alura.listaVip;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@SpringBootApplication
public class Configuracao {
	
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
		
	}
	
	@Bean
	public DataSource datasource(){
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Drive");
		datasource.setUrl("jdbc:mysql://localhost:3306/listavip");
		datasource.setUsername("root");
		datasource.setPassword("root");
		return datasource;
		
	}
}
