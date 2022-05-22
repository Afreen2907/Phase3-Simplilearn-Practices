package com.simplilearn.workshop.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;



@Configuration
@Import(value= InfraStructureConfig.class)
@ComponentScan(basePackages="com.simplilearn.workshop.repository, com.simplilearn.workshop.service")
public class TodoServiceConfig {

	//no need bean methods
	
	//all configuration needs to be imported to one configuration
}
