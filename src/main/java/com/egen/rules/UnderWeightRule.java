package com.egen.rules;

import java.util.Date;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import com.egen.vo.Alerts;
import com.egen.vo.Metrics;
import com.egen.common.ApplicationContextProvider;
import com.egen.delegate.AlertsDelegate;

/**
*<h1>UNDER WEIGHT RULE</h1>
* The UnderWeightRule class is a business rule entity 
* which implements pre-defined rule or service to 
* monitor under weight. 
* 
* @author  Menaka Priya Ranjani
* @version 1.0
* @since   2016-06-08
*/
@Rule(name= "ALERT: UNDER WEIGHT RULE")
public class UnderWeightRule {
	
	/**
	 *  UnderWeightRule class member variables declaration.
	 */ 
 
	private static Integer underWeightValue;  
	private Metrics metrics;
	private AlertsDelegate alertsDelegate = (AlertsDelegate)ApplicationContextProvider.getApplicationContext().getBean("alertsDelegateBean");	
	
	/**
	 * This method is to check whether the Metrics value or weight
	 * deceeds 10 percent of the base weight.
	 * @return boolean 
	 */
	@Condition
	
	public boolean when(){
		
		if(metrics.getValue() < UnderWeightRule.underWeightValue)
			return true;
		else
			return false;
		}
	
	/**
	 * This method is to trigger Alert when the Metrics value or weight
	 * deceeds 10 percent of the base weight.   
	 */
	@Action
	public void then(){
		Alerts alert = new Alerts();
		alert.setAlert("UNDER WEIGHT ALERT: Weight("+metrics.getValue()+") is lesser than 10 percent of base weight");		 
		alert.setTimeStamp(new Date());
		alertsDelegate.createAlerts(alert);
		
	}

	public static Integer getUnderWeightValue() {
		return underWeightValue;
	}

	public static void setUnderWeightValue(Integer underWeightValue) {
		UnderWeightRule.underWeightValue = underWeightValue;
	}

	public Metrics getMetrics() {
		return metrics;
	}

	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
	}

}
