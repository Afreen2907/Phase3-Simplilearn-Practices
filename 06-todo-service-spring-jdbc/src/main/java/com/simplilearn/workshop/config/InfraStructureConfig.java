package com.simplilearn.workshop.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class InfraStructureConfig {

	//for database configuration
	@Bean
	public DataSource dataSource() {
		
		
		String url ="jdbc:mysql://localhost:3306/studentdb?useSSL=false";
		String user = "root";
		String password = "root";
		String driverClassName= "com.mysql.cj.jdbc.Driver";
		
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
	
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		
		return dataSource;
	}
}
