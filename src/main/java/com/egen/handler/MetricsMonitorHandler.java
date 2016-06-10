package com.egen.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.egen.delegate.MetricsDelegate;
import com.egen.vo.Metrics;

/**
*<h1>METRICS MONITOR HANDLER</h1>
* The MetricsMonitorHandler class is a controller to handle 
* all Metrics related request.
* 
* @author  Menaka Priya Ranjani
* @version 1.0
* @since   2016-06-08
*/
@RestController
@RequestMapping(value = "/metricsHandler")
public final class MetricsMonitorHandler {
	
	/**
	 *  MetricsMonitorHandler class member variables declaration.
	 */
	@Autowired
	private MetricsDelegate metricsDelegate;
	
	/**
	 * This is a handler service method is to manipulate incoming JSON
	 * metric value from Emulator to Metric entity object and to save in 
	 * MongoDB database. 
	 * @param metric
	 * @param builder
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/createMetrics", method = RequestMethod.POST)
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> createMetrics(@RequestBody Metrics metrics, UriComponentsBuilder builder){
		HttpHeaders headers = new HttpHeaders();
		metricsDelegate.createMetrics(metrics);
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	/**
	 * This is a handler service method is to read all Metrics.
	 * @param builder
	 * @return Metrics List
	 */
	@RequestMapping(value = "/readAllMetrics", method = RequestMethod.GET)
	@ExceptionHandler(Exception.class)
	public List<Metrics> readAllMetrics(@RequestBody Metrics metric, UriComponentsBuilder builder){
		
		List<Metrics> response = metricsDelegate.readAllMetrics();
		return response;
	}
	
	/**
	 * This is a handler service method is to read all Metrics 
	 * for the given date range.
	 * @param metric
	 * @param builder
	 * @return Metrics List
	 */
	@RequestMapping(value = "/readMetricsByRange/{fromDate}/{toDate}", method = RequestMethod.GET)
	@ExceptionHandler(Exception.class)
	public List<Metrics> readMetricsByRange(@PathVariable(value = "fromDate") String fromDate, 
			@PathVariable(value = "toDate") String toDate){
		
		List<Metrics> response = metricsDelegate.readMetricsByRange(fromDate, toDate);
		return response;
	}
	
	
	 
}
