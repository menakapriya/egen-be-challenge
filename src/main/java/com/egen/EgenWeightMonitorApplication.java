package com.egen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
*<h1>EGEN WEIGHT MONITOR APPLICATION</h1>
* The EgenWeightMonitorApplication is the Spring Boot application
* main class to launch the Weight Monitor API.
*  
* @author  Menaka Priya Ranjani
* @version 1.0
* @since   2016-06-08
*/
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.egen" })
public class EgenWeightMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EgenWeightMonitorApplication.class, args);
	}
}
