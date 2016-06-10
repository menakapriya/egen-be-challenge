package com.egen.vo;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
*<h1>ALERTS</h1>
* The Alerts class implements a model object that
* represents Alerts entity in Egens Weight Monitor API
*
* @author  Menaka Priya Ranjani
* @version 1.0
* @since   2016-06-08
*/
@Document(collection="alerts")
public class Alerts {
	
	/**
	 *  Alerts class member variables declaration.
	 */  
	@Id 
    private String id; //To add an instance variable for the object ID
    private String alert; //To receive and manipulate Alert value received from Emulator.
    @DateTimeFormat(iso = ISO.DATE_TIME)
    private Date timeStamp;// To receive and manipulate Alert Time stamp received from Emulator.  
    
    /**
     * Declaration provided for Default constructor
     */
    public Alerts(){
    	this.alert = null;
    	this.timeStamp = new Date();
    }
    
    /**
     * Declaration provided for Parameterized Constructor
     * @param alert This is to receive and manipulate Alert value received from Emulator
     * @param timeStamp This is to receive and manipulate Alert Time stamp received from Emulator. 
     */
    public Alerts(String alert, Date timeStamp){
        this.alert = alert;
        this.timeStamp = timeStamp;
    }
  
    /**
     * This Method has been overridden to show the Alerts object with its values assigned.
     */
    @Override
    public String toString() {
        return String.format("[id = %s, alert = %s, timestamp = %s]", id, alert, timeStamp);
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

} 
