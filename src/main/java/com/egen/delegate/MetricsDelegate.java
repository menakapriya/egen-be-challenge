package com.egen.delegate;

import java.util.Date;
import java.util.List;

import org.easyrules.api.RulesEngine;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.egen.common.ApplicationContextProvider;
import com.egen.rules.OverWeightRule;
import com.egen.rules.UnderWeightRule;
import com.egen.vo.Metrics;

/**
*<h1>METRICS DELEGATE</h1>
* The MetricsDelegate class is a business service entity 
* which implements pre-defined services to handle all 
* Metrics operations
* 
* @author  Menaka Priya Ranjani
* @version 1.0
* @since   2016-06-08
*/
@Repository
public class MetricsDelegate {
	
	/**
	 *  MetricsDelegate class member variables declaration.
	 */
	private MongoOperations mongoOperations = (MongoOperations)ApplicationContextProvider.getApplicationContext().getBean("mongoTemplateBean");
	private RulesEngine rulesEngine = (RulesEngine)ApplicationContextProvider.getApplicationContext().getBean("rulesEngine");
	private OverWeightRule overWeightRule = (OverWeightRule)ApplicationContextProvider.getApplicationContext().getBean("overWeightRuleBean");
	private UnderWeightRule underWeightRule = (UnderWeightRule)ApplicationContextProvider.getApplicationContext().getBean("underWeightRuleBean");
	
	
	
	/**
	 * This Method is used to save Metrics in MongoDB database collection
	 * and triggers all weight monitor rules.
	 * @param Metrics
	 * @return Metrics
	 */
	@ExceptionHandler(Exception.class)
	public Metrics createMetrics(Metrics metrics) {
		if(OverWeightRule.getOverWeightValue() == null){
			OverWeightRule.setOverWeightValue(metrics.getValue()+(metrics.getValue()/10));
		}
		if(UnderWeightRule.getUnderWeightValue() == null){
			UnderWeightRule.setUnderWeightValue(metrics.getValue()-(metrics.getValue()/10));
		}
		overWeightRule.setMetrics(metrics);
	 	underWeightRule.setMetrics(metrics);
		rulesEngine.fireRules();
		mongoOperations.save(metrics);
		return metrics;
	}

	/**
	 * This Method is used to read all the Metrics data from MongoDB database collection.
	 * @return Metrics List
	 */
	@ExceptionHandler(Exception.class)
	public List<Metrics> readAllMetrics() {
		return mongoOperations.findAll(Metrics.class);
	}

	/**
	 * This Method is used to get all the Metrics data for the given date range.
	 * @param fromDate
	 * @param toDate
	 * @return Metrics List
	 */
	@ExceptionHandler(Exception.class) 
	public List<Metrics> readMetricsByRange(String fromDate, String toDate) {
		Date fromDateValue = new Date(Long.parseLong(fromDate));
		Date toDateValue = new Date(Long.parseLong(toDate));
		Query query = new Query().addCriteria(Criteria.where("timeStamp").gt(fromDateValue).lte(toDateValue));
        return mongoOperations.find(query, Metrics.class);
			
 
	}

	
	
}
