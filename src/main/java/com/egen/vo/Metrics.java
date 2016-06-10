package com.egen.vo;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
*<h1>METRICS</h1>
* The Metrics class implements a model object that
* represents Metrics entity in Egens Weight Monitor API
*
* @author  Menaka Priya Ranjani
* @version 1.0
* @since   2016-06-08
*/
@Document(collection="metrics")
public class Metrics {
	
	/**
	 *  Metrics class member variables declaration.
	 */  
	@Id
    private String id;
    private Integer value;
     @DateTimeFormat(iso = ISO.DATE_TIME)
    private Date timeStamp;
   
     /**
      * Declaration provided for Default constructor
      */
        public Metrics(){
    	this.value = 0;
    	this.timeStamp = new Date();
    }
        
        /**
         * Declaration provided for Parameterized Constructor
         * @param value This is to receive and manipulate Metric value received from Emulator
         * @param timeStamp This is to receive and manipulate Metric Time stamp received from Emulator. 
         */
    public Metrics(Integer value, Date timeStamp){
        this.value = value;
        this.timeStamp = timeStamp;
    }
  
    /**
     * This Method has been overridden to show the Metrics object with its values assigned.
     */
    @Override
    public String toString() {
        return String.format("[id = %s, value = %s, timestamp = %s]", id, value, timeStamp);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
} 
