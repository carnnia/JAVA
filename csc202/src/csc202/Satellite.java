/**
 * NOVA :: Loudoun County Campus
 * Professor Hashem Anwari
 * Assigned 9/3/2015 – Due 9/9/2015
 * Homework 2, GPS SYstem 
 *  
 */

package csc202;

import java.util.Date;

/**
 * @author Casey Carnnia
 * This is a class for creation and management of Satellite objects
 * - provides methods to set following attributes for each object:
 * 		satelliteId, satelliteDate
 * - checks for blank attributes and uses  the default constructor for blank attributes. 
 * - provides methods to get the object attributes 
 * - provides a default constructor 
 * - provides a overloaded constructor 
 * - provides string, star rating based on integer, review attribute between 1 and 4 
 */
public class Satellite {
	private int satelliteId = 0;
	private Date satelliteDate; 
	
	/**
	 * provides default constructor
	 * precondition:
	 * postcondition: instantiates a default object  
	 */
	public Satellite(){
		satelliteId = 000123;
		satelliteDate = new Date(); 
	}
	/**
	 * provides full constructor 
	 * precondition: given id and a date
	 * postcondition: instantiates an object and populates the attributes as provided.  
	 */
	public Satellite(int satId, Date satDate){
		satelliteId = satId;
		satelliteDate = satDate; 
	}
	/**
	 * getter
	 * precondition: none
	 * postcondition: returns the satellite id
	 */
	public int getSatelliteId() {
		return satelliteId;
	}
	/**
	 * getter
	 * precondition: none
	 * postcondition: returns the satellite time
	 */
	public Date getSatelliteDate() {
		return satelliteDate;
	}
	/**
	 * setter
	 * precondition: given integer greater than 0 
	 * postcondition: sets the satellite id
	 */
	public void setSatelliteId(int satId){
		if (satId > 0){
			satelliteId = satId;
		}
		else{
			satelliteId = 000123;
		}
	}
	/**
	 * setter
	 * precondition: given time that is not null 
	 * postcondition: sets the satellite time
	 */
	public void setSatelliteDate(Date satDate){
		if (satDate != null){
			satelliteDate = satDate;
		}
		else{
			satelliteDate = new Date();
		}
	}

}
