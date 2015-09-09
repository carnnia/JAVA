
/**
 * NOVA :: Loudoun County Campus
 * Professor Hashem Anwari
 * Assigned 9/3/2015 – Due 9/9/2015
 * Homework 2, GPS SYstem 
 *  
 */ 
package csc202;

import java.util.Date;
import java.util.Scanner;
import java.util.Arrays;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Casey Carnnia
 * This is a driver class that utilizes Satellite class
 */
public class SatelliteDriver {
	
	// an array of our Satellite objects. limit of our objects is 4
	private static Satellite[] mySats = new Satellite[4]; 
	// Satellite counter
	private static int count = 0; 
	// speed of light meters per second
	private static long c = 299792458; 
	// keyboard object allows us to communicate with the screen
	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) { 
		System.out.println(":::::::::: This is a GPS Learning System ::::::::::"); 
		Scanner keyboard = new Scanner(System.in);
		int response = 0;
		do{
			System.out.println("Please make a selection:");
			System.out.println("[1 = ADD]  [2 = LIST]  [3 = FIND CLOSEST]  [0 = QUIT] ");
			response = keyboard.nextInt();
			if (response == 1){
				addSatellite();
			}
			else if(response == 2){
				listSatellite();
			}
			else if (response == 3){
				findCloseest();
			}
			 
		} while(response > 0);
		
		// good idea, protect against resource leak, learn it, use it
		keyboard.close();

	}
	
	/*
	 * private method 
	 * precondition: attributes of an object is provided by the user
	 * postcondition: instantiates an object
	 * 				  increments satellite count 
	 */
	private static void addSatellite(){
		System.out.println("~~~~~~~~~~ 1 Add a Satellite ~~~~~~~~~~");
		System.out.println("We currently have " + count + " Satellites.");
		
		Date inputDate = null; 
		System.out.println("Please enter the Satellite's ID number (0,1,2,3):");
		int inputId = keyboard.nextInt();
		// capture date from user
		System.out.println("Please enter the Satellite's Date (01-01-2015):");
		String inputDateString = keyboard.next();
		// capture time from user
		System.out.println("Please enter the Satellite's Time (23:37:50):");
		// concatenate date and time with single space in between
		inputDateString = inputDateString + " " + keyboard.next();
		// remove any trailing line return
		inputDateString = inputDateString.trim();
		// set up a date format
		DateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		// using try catch block, take the user input string and format it as date with granularity of seconds 
		// because our formula P =(Tr-Tb)*C expects Tr (receiver time) to be in seconds 
		try{
			inputDate = myFormat.parse(inputDateString);
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		// add a Satellite object and increment the counter 
		mySats[count] = new Satellite(inputId, inputDate); 
		count ++;
		// inform the user
		System.out.println("We have successfuly added a satillite. ");
		System.out.println("We now have " + count + " Satellites.");
		
	}
	/*
	 * private method 
	 * precondition: none
	 * postcondition: lists the nods in the array holding the individual objects
	 */
	private static void listSatellite(){
		System.out.println("~~~~~~~~~~ 2 List Satellites ~~~~~~~~~~");
		
		for (int index = 0; index < mySats.length; index++){
			// check for null pointer exception
			if (mySats[index] != null){
				System.out.println(":::::::::: * * * ::::::::::");
				System.out.println("Satellite's ID # " + mySats[index].getSatelliteId());
				System.out.println("Satellite's Date " + mySats[index].getSatelliteDate());
				System.out.println("----------------------------------------");
			}
			
		}
		System.out.println("That is all that we have in our inventory.");
		System.out.println("Current inventory ==> " + count);
	}
	/*
	 * private method 
	 * precondition: none
	 * postcondition: using the formula P = ( Tr - Tb) * C show the closest satellite
	 * P is the pseudo range
	 * Tr is receive time: time according to the GPS receiver
	 * Tb is broadcast time: time according to the satellite 
	 * (Tr - Tb) times C (the speed of light) is the radius of a sphere that is centered at the satellite   
	 * 
	 */
	private static void findCloseest() {
		Date gpsReceiverDate = new Date();
		int aSatelliteId = mySats[0].getSatelliteId();
		Date aSatelliteDate = mySats[0].getSatelliteDate();
		long seconds = gpsReceiverDate.getTime() - aSatelliteDate.getTime();
		// seconds difference between sender and receiver times the speed of light 
		long aDistance = seconds * c;
		for (int index = 0; index < mySats.length; index++){
			// check for null pointer exception
			if (mySats[index] != null){
				Date gpsDate = new Date();
				Date aSatDate = mySats[index].getSatelliteDate();
				long loopSeconds = gpsDate.getTime() - aSatDate.getTime();
				long loopDistance = loopSeconds * c;
				if(loopDistance < aDistance){
					seconds = loopSeconds;
					aDistance = loopDistance; 
					aSatelliteId = mySats[index].getSatelliteId();
				}
				System.out.println("Satellite Id " + aSatelliteId + " is " + loopDistance / 1000 + " kilometers away. Time diffrence is " + loopSeconds + " seconds.");
				 
			}
			
		}
		System.out.println("The closest satellite ID# " + aSatelliteId + " is " + aDistance / 1000 + " kilometers away. Time diffrence is " + seconds + " seconds.");
		System.out.println("The time on the GPS reciver is " + gpsReceiverDate.toString() + " and the time satellite ID# " + aSatelliteId + " is " + mySats[aSatelliteId].getSatelliteDate().toString() );
		
		
		
	}
	

}
