package com.egen.delegate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.egen.common.ApplicationContextProvider;
import com.egen.vo.Alerts;

/**
*<h1>ALERTS DELEGATE</h1>
* The AlertsDelegate class is a business service entity 
* which implements pre-defined services to handle all 
* Alerts operations
* 
* @author  Menaka Priya Ranjani
* @version 1.0
* @since   2016-06-08
*/
@Repository
public class AlertsDelegate {
	
	/**
	 *  AlertsDelegate class member variables declaration.
	 */  
	@Autowired 
	private MongoOperations mongoOperations = (MongoOperations)ApplicationContextProvider.getApplicationContext().getBean("mongoTemplateBean");

	/**
	 * This Method is used to save Alerts in MongoDB database collection.
	 * @param Alerts
	 * @return Alerts
	 */
	@ExceptionHandler(Exception.class) 
	public Alerts createAlerts(Alerts alert){
		mongoOperations.save(alert);
		return alert;
	}
	/**
	 * This Method is used to read all the Alerts data from MongoDB database collection.
	 * @return Alerts List
	 */
	@ExceptionHandler(Exception.class) 
	public List<Alerts> readAllAlerts() {
		return mongoOperations.findAll(Alerts.class);
	}

	/**
	 * This Method is used to get all Alerts data for the given date range.
	 * @param fromDate
	 * @param toDate
	 * @return Alerts List
	 */
	@ExceptionHandler(Exception.class)
	public List<Alerts> readAlertsByRange(String fromDate, String toDate) {
		Date fromDateValue = new Date(Long.parseLong(fromDate));
		Date toDateValue = new Date(Long.parseLong(toDate));
		Query query = new Query().addCriteria(Criteria.where("timeStamp").gt(fromDateValue).lte(toDateValue));
        return mongoOperations.find(query, Alerts.class);
	}
}
