/**
 * NOVA :: Loudoun County Campus
 * Professor Hashem Anwari
 * Assigned 8/27/2015 – Due 9/3/2015
 * Homework 1, review of CSC 201, Stylistic assessment 
 *  
 */
package csc202;

import java.util.Scanner;

/**
 * @author Casey Carnnia
 * This is a class for creation and management of TheaterShow objects
 */
 
public class TheaterShow {
	
	private String theaterShowName;
	private String theaterShowTime;
	private String theaterShowStar;
	private String theaterShowRating;
	private int theaterShowReview = 0; 
	
	/**
	 * provides default constructor
	 * precondition:
	 * postcondition: instantiates a default object  
	 */
	public TheaterShow(){
		theaterShowName = "TBD: Name of the show goes here.";
		theaterShowTime = "00:00";
		theaterShowStar = "TBD: Name of the staring actor goes here.";
		theaterShowRating = "Not rated";
		theaterShowReview = 0;
	}
	/**
	 * provides full constructor 
	 * precondition: given string in this order: name, time, actor, rating
	 * postcondition: instantiates an object and populates the attributes as provided. 
	 * Sets the review to zero.  
	 */
	public TheaterShow(String showName, String showTime, String showStar, String showRating){
		setShowName(showName);
		setShowTime(showTime);
		setShowStar(showStar);
		setShowRating(showRating);
		theaterShowReview = 0;
	}
	/**
	 * getter
	 * precondition: none
	 * postcondition: returns the name of the show
	 */
	public String getShowName() {
		return theaterShowName;
	}
	/**
	 * getter
	 * precondition: none
	 * postcondition: returns the time of the show
	 */
	public String getShowTime() {
		return theaterShowTime;
	}
	/**
	 * getter
	 * precondition: none
	 * postcondition: returns the name of the acting star in the show
	 */
	public String getShowStar() {
		return theaterShowStar;
	}
	/**
	 * getter
	 * precondition: none
	 * postcondition: returns the rating for the show
	 */
	public String getShowRating() {
		return theaterShowRating;
	}
	/**
	 * getter
	 * precondition: given the review rating from 1 to 4
	 * postcondition: returns the star rating for the show
	 */
	public String getShowReview() {
		String starRating = "";
		switch (theaterShowReview){
		case 1:
			starRating = "One satr rating";
			break;
		
		case 2:
			starRating = "Two star rating";
			break;
		
		case 3:
			starRating = "Three star rating";
			break;
		
		case 4:
			starRating = "Four star rating";
			break;
			
		default:
			starRating = "The rating for this show is not within the star rating standard";
			break;
		}
		return starRating;
		
	}
	/**
	 * setter
	 * precondition: given string longer than one character 
	 * postcondition: sets the name of the show
	 */
	public void setShowName(String showName){
		if (notBlank(showName) == true){
			theaterShowName = showName;
		}
		else{
			theaterShowName = "TBD: Name of the show goes here.";
		}
	}
	/**
	 * setter
	 * precondition: given string longer than one character 
	 * postcondition: sets the time of the show
	 */
	public void setShowTime(String showTime){
		if (notBlank(showTime) == true){
			theaterShowTime = showTime;
		}
		else{
			theaterShowTime = "00:00";
		}
	}
	
	/**
	 * setter
	 * precondition: given string longer than one character 
	 * postcondition: sets the name of the show
	 */
	public void setShowStar(String showStar){
		if (notBlank(showStar) == true){
			theaterShowStar = showStar;
		}
		else{
			theaterShowStar = "TBD: Name of the staring actor goes here.";
		}
	}
	
	/**
	 * setter
	 * precondition: given string longer than one character 
	 * postcondition: sets the name of the show
	 */
	public void setShowRating(String showRating){
		if (notBlank(showRating) == true){
			theaterShowRating = showRating;
		}
		else{
			theaterShowRating = "Not rated yet.";
		}
	}
	
	/**
	 * setter
	 * precondition: given an integer as a review rating 
	 * postcondition: increments the shows review rating
	 */
	public void setShowReview(int showReview){
		theaterShowReview = theaterShowReview + showReview;
		 
	}
	
	/**
	 * private method, checks to see if a string is not blank
	 * precondition: given a string
	 * postcondition: returns a boolean 
	 */
	private boolean notBlank(String aString){
		if (aString.length() > 1){
			return true;
		}
		else{
			return false;
		}
	}
	 
	
}
