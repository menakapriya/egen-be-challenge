package com.egen.rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import com.egen.common.ApplicationContextProvider;
import com.egen.delegate.AlertsDelegate;
import com.egen.vo.Alerts;
import com.egen.vo.Metrics;

/**
*<h1>OVER WEIGHT RULE</h1>
* The OverWeightRule class is a business rule entity 
* which implements pre-defined rule or service to 
* monitor overweight. 
* 
* @author  Menaka Priya Ranjani
* @version 1.0
* @since   2016-06-08
*/
@Rule(name = "ALERT: OVER WEIGHT RULE")
public class OverWeightRule {
	
	/**
	 *  OverWeightRule class member variables declaration.
	 */ 
	private static Integer overWeightValue;
	private Metrics metrics;
	private AlertsDelegate alertsDelegate = (AlertsDelegate)ApplicationContextProvider.getApplicationContext().getBean("alertsDelegateBean");
		
	/**
	 * This method is to check whether the Metrics value or weight
	 * exceeds 10 percent of the base weight.
	 * @return boolean 
	 */
	@Condition
	
	public boolean when(){
		 
		if(metrics.getValue() > overWeightValue)
			return true;
		else
			return false;
		
	}
	
	/**
	 * This method is to trigger Alert when the Metrics value or weight
	 * exceeds 10 percent of the base weight.   
	 */
	@Action
	public void then(){
		Alerts alert = new Alerts();
		alert.setAlert("OVER WEIGHT ALERT: Weight("+metrics.getValue()+") is greater than 10 percent of base weight");		 
		alert.setTimeStamp(metrics.getTimeStamp());
		alertsDelegate.createAlerts(alert);
		
	}

	public static Integer getOverWeightValue() {
		return overWeightValue;
	}

	public static void setOverWeightValue(Integer overWeightValue) {
		OverWeightRule.overWeightValue = overWeightValue;
	}

	public Metrics getMetrics() {
		return metrics;
	}

	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
	}




}
