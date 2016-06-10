package com.egen;

import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.egen.EgenWeightMonitorApplication;
import com.egen.vo.Alerts;
import com.egen.vo.Metrics;
import com.egen.delegate.AlertsDelegate;
import com.egen.delegate.MetricsDelegate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EgenWeightMonitorApplication.class)
@WebAppConfiguration
public class EgenWeightMonitorApplicationTests {
	
	@Autowired 
	MetricsDelegate metricsDelegate  ;
	@Autowired
	AlertsDelegate alertsDelegate  ;

	/**
	 * Test for create metrics method
	 */
	@Test
	public void createMetrics() {
		Metrics metrics = new Metrics(175, new Date());
		metrics = metricsDelegate.createMetrics(metrics);
		Assert.assertNotNull("Create Metrics Failed", metrics);
	}
	
	/**
	 * Test to find all metrics method
	 */
	@Test
	public void readAllMetrics(){
		List<Metrics> metricsList = metricsDelegate.readAllMetrics();
		Assert.assertNotNull("Read All Metrics Failed", metricsList);
		//Assert.assertEquals(0, metricsList.size());
	}
	
	/**
	 * Test to find metrics by range
	 */
	@Test
	public void readMetricsByRange(){
		List<Metrics> metricsList = metricsDelegate.readMetricsByRange("1465460333929", "1465403359406");
		Assert.assertNotNull("Read All Metrics by Range Failed", metricsList);
		Assert.assertEquals(0, metricsList.size());
	}
	
	/**
	 * Test to create alerts 
	 */
	@Test
	public void createAlerts(){
		Alerts alerts = new Alerts("Executing Alerts Test scenarios...", new Date());
		alerts = alertsDelegate.createAlerts(alerts);
		Assert.assertNotNull("Create Alerts Failed", alerts);
	}
	
	/**
	 * Test to find all alerts method
	 */
	@Test
	public void readAllAlerts(){
		List<Alerts> alertsList = alertsDelegate.readAllAlerts();
		Assert.assertNotNull("Read All Alerts Failed", alertsList);
		//Assert.assertEquals(0, alertsList.size());
	}
	
	/**
	 * Test to find alerts by range
	 */
	@Test
	public void readAlertsByRange(){
		List<Alerts> alertsList = alertsDelegate.readAlertsByRange("1465459391909", "1465459457295");
		Assert.assertNotNull("Read Alerts by Range Failed", alertsList);
		Assert.assertEquals(0, alertsList.size());
	}

}
