package com.egen.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.egen.delegate.AlertsDelegate;
import com.egen.vo.Alerts;

/**
*<h1>ALERTS MONITOR HANDLER</h1>
* The AlertsMonitorHandler class is a controller to handle 
* all Alerts related request.
* 
* @author  Menaka Priya Ranjani
* @version 1.0
* @since   2016-06-08
*/
@RestController
@RequestMapping(value = "/alertsHandler")
public final class AlertsMonitorHandler {
	
	/**
	 *  AlertsMonitorHandler class member variables declaration.
	 */
	@Autowired
	private AlertsDelegate alertsDelegate ; 
	
	/**
	 * This is a handler service method is to read all Alerts.
	 * @param builder
	 * @return Alerts List
	 */
	@RequestMapping(value = "/readAllAlerts", method = RequestMethod.GET)
	@ExceptionHandler(Exception.class)
	public List<Alerts> readAllAlerts(UriComponentsBuilder builder){
		
		List<Alerts> response = alertsDelegate.readAllAlerts();
		return response;
	}
	
	/**
	 * This is a handler service method is to read all Alerts 
	 * for the given date range.
	 * @param metric
	 * @param builder
	 * @return Alerts List
	 */
	@RequestMapping(value = "/readAlertsByRange/{fromDate}/{toDate}", method = RequestMethod.GET)
	@ExceptionHandler(Exception.class)
	public List<Alerts> readAlertsByRange(@PathVariable(value = "fromDate") String fromDate, 
			@PathVariable(value = "toDate") String toDate){
		
		List<Alerts> response = alertsDelegate.readAlertsByRange(fromDate, toDate);
		return response;
	}
	
	 
}
