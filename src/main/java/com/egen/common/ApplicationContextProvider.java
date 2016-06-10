package com.egen.common;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
*<h1>APPLICATION CONTEXT PROVIDER</h1>
* The ApplicationContextProvider class to create the application context  
* for weight monitor application.
* 
* @author  Menaka Priya Ranjani
* @version 1.0
* @since   2016-06-08
*/
public class ApplicationContextProvider implements ApplicationContextAware{
  
	/**
	 *  ApplicationContextProvider class member variables declaration.
	 */
	private static ApplicationContext applicationContext = new GenericXmlApplicationContext("spring-configuration.xml");

	 @ExceptionHandler(Exception.class)
	 public static ApplicationContext getApplicationContext() {
		return applicationContext;
	 }
	 
	 @ExceptionHandler(Exception.class)
	 public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
			 ApplicationContextProvider.applicationContext = applicationContext;
	 }
}
