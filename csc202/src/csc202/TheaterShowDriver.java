/**
 * NOVA :: Loudoun County Campus
 * Professor Hashem Anwari
 * Assigned 8/27/2015 – Due 9/3/2015
 * Homework 1, review of CSC 201, Stylistic assessment 
 *  
 */
package csc202;

import java.util.Scanner;
import java.util.Arrays;
/**
 * @author Casey Carnnia
 * This is a driver class that utilizes TheaterShow class
 */
public class TheaterShowDriver {
	
	// an array of our show objects. limit of our theater is 10 shows
	private static TheaterShow[] triStarTheaterShows = new TheaterShow[10];
	// inventory counter
	private static int count = 0; 
	
	private static Scanner keyboard = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		manageTheater();

	}
	
	/**
	 * private method, establishes dialog with the user 
	 * precondition: given a string
	 * postcondition: returns a boolean 
	 */
	private static void manageTheater(){
		System.out.println(":::::::::: Welcome to Tri Star Theater Management System ::::::::::");
		System.out.println(":::::::::: We have " + count + " shows in our current inventory ::::::::::");
		Scanner keyboard = new Scanner(System.in);
		int response = 0;
		do{
			System.out.println("Please make a selection:");
			System.out.println("[1 = ADD]  [2 = LIST]  [3 = EDIT]  [4 = DELETE]  [0 = QUIT] ");
			response = keyboard.nextInt();
			if (response == 1){
				addShow();
			}
			else if(response == 2){
				listShows();
			}
			else if (response == 3){
				editShow();
			}
			else if (response == 4){
				deleteShow();
			}
		} while(response > 0);
			
		}
	/*
	 * private method 
	 */
	private static void addShow(){
		System.out.println("~~~~~~~~~~ 1 Add a Show ~~~~~~~~~~");
		System.out.println("Current inventory ==> " + count);
		insertShow(count);
		String inputName, inputTime, inputStar, inputRating;
		System.out.println("Please enter the show's name:");
		inputName = keyboard.nextLine();
		System.out.println("Please enter the show's time:");
		inputTime = keyboard.nextLine();
		System.out.println("Please enter the star's name:");
		inputStar = keyboard.nextLine();
		System.out.println("Please enter the show's rating:");
		inputRating = keyboard.nextLine();
		
		triStarTheaterShows[count] = new TheaterShow(inputName, inputTime, inputStar, inputRating);
		count ++;
		System.out.println("We have successfuly added a show to the inventory.");
		System.out.println("Current inventory ==> " + count);
		
	}
	
	/*
	 * private method 
	 */
	private static void listShows(){
		System.out.println("~~~~~~~~~~ 2 List Shows ~~~~~~~~~~");
		
		for (int index = 0; index < triStarTheaterShows.length; index++){
			listShows(index);
		}
		System.out.println("That is all that we have in our inventory.");
		System.out.println("Current inventory ==> " + count);
	}
	
	/*
	 * private method 
	 */
	private static void editShow(){
		System.out.println("~~~~~~~~~~ 3 Edit a Show ~~~~~~~~~~");
		System.out.println("Please enter the ID# of the show you like to edit.");
		int editID = keyboard.nextInt();
		System.out.println("Here is the current setting for show ID# " + editID);
		listShows(editID);
		System.out.println("What information about the show do you like to edit?");
		System.out.println("[5 = NAME]  [6 = TIME]  [7 = STAR]  [8 = RATING]  [9 = REVIEW] ");
		int editOption = keyboard.nextInt();
		if (editOption == 5){
			System.out.println("Please enter the new name");
			triStarTheaterShows[editID].setShowName(keyboard.next());
		}
		else if(editOption == 6){
			System.out.println("Please enter the new time");
			triStarTheaterShows[editID].setShowTime(keyboard.next());
		}
		else if (editOption == 7){
			System.out.println("Please enter the new star");
			triStarTheaterShows[editID].setShowStar(keyboard.next());
		}
		else if (editOption == 8){
			System.out.println("Please enter the new rating");
			triStarTheaterShows[editID].setShowRating(keyboard.next());
		}
		else if (editOption == 9){
			System.out.println("Please enter a review review rating from 1 to 4");
			triStarTheaterShows[editID].setShowReview(keyboard.nextInt());
		}
	}
	
	/*
	 * private method 
	 */
	private static void deleteShow(){
		System.out.println("~~~~~~~~~~ 4 Delete a Show ~~~~~~~~~~");
		System.out.println("Please enter the ID# of the show you like to delete.");
		int deleteID = keyboard.nextInt();
		// TO DO delete a show and re order the array of shows
		triStarTheaterShows[deleteID] = null;
		//Arrays.sort(triStarTheaterShows);
		count --;
		System.out.println("We have deleted show ID# " + deleteID);
		System.out.println("Current inventory ==> " + count);
		
	}
	
	/*
	 * private method
	 */
	private static void listShows(int showID){

		// check for null pointer exception
		if (triStarTheaterShows[showID] != null){
			System.out.println(":::::::::: * * * ::::::::::");
			System.out.println("Show ID# " + showID);
			System.out.println("Name: " + triStarTheaterShows[showID].getShowName());
			System.out.println("Time: " + triStarTheaterShows[showID].getShowTime());
			System.out.println("Star: " + triStarTheaterShows[showID].getShowStar());
			System.out.println("Rating: " + triStarTheaterShows[showID].getShowRating());
			System.out.println("Review: " + triStarTheaterShows[showID].getShowReview());
			System.out.println("----------------------------------------");
		}
	}
	
	/*
	 * private method
	 */
	private static void insertShow(int showID){
		
	}

}
