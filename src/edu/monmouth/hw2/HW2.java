package edu.monmouth.hw2;
//Joe Wheiler s1409757 Nov 11 FA26

import java.io.FileNotFoundException;

import java.io.PrintStream;

import java.util.List;
import java.util.ArrayList;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

import java.util.ListIterator;

import edu.monmouth.vehicle.*;

public class HW2 {
	
	public static void main(String[] args) {
		final int REQUIREDARGS=3, BADARGS=1, BADREDIRECT=2;
		
		// check for 3 command line arguments
		if(args.length != REQUIREDARGS) {
			System.err.println("Invalid number of args (must be 3: output filename, string data filename, vehicle data filename) ");
			System.exit(BADARGS);
		}
		// redirect STDOUT & STDERR to file name given in args[0]
		try {
			PrintStream redirectStream = new PrintStream(args[0]);
			System.setOut(redirectStream);
			System.setErr(redirectStream);
		} catch(FileNotFoundException ioe) {
			System.err.println("Cannot redirect stderr and stdout " + ioe.getMessage());
			ioe.printStackTrace();
			System.exit(BADREDIRECT);
		}
		
		//create list of strings
		List<String> strings = new ArrayList<String>();
		
		//read each line from file and add to string list
		try (BufferedReader br = new BufferedReader(new FileReader(args[1]))) {
            String line;
            while ((line = br.readLine()) != null) {
                strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		//create list of vehicles
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		//read each line from file
		try (BufferedReader br = new BufferedReader(new FileReader(args[2]))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); //split lines into 3 parts about commas
                PowerTypes p = null;
                if (parts.length != 3) System.err.println ("Line not formatted correctly"); //error if comma format incorrect
                else {
                	//System.out.println(parts[0]); //was useful for testing
                	//check if boat or car from first part
	                if (parts[0].equals("b")) { 
	                	//get power type from second part
	                	if (parts[1].equals("ELECTRICITY") || parts[1].equals("GASOLINE") || parts[1].equals("FUELOIL") || parts[1].equals("DEISEL")) {
	                		p = PowerTypes.valueOf(parts[1]);
		                	//parse int for length in third part
		                	try {
		            	        int i = Integer.parseInt(parts[2]);
		            	        try {
									vehicles.add(new Boat(p, i));
								} catch (BoatException be) {
									System.out.println(be.getMessage());
									be.printStackTrace();
								}
		            	    } catch (NumberFormatException e) {
		            	        System.err.println("Non-numeric value as length on this line");
		            	    }
	                	}
	                	else {
		                	System.err.println("Power type not properly specified on this line");
		                } 
	                }
	                else if (parts[0].equals("c")) {
	                	//get power type from second part
	                	if (parts[1].equals("ELECTRICITY") || parts[1].equals("GASOLINE") || parts[1].equals("FUELOIL") || parts[1].equals("DEISEL")) {
		                	if (parts[1].equals("ELECTRICITY")) p = PowerTypes.ELECTRICITY;
		                	if (parts[1].equals("GASOLINE")) p = PowerTypes.GASOLINE;
		                	if (parts[1].equals("FUELOIL")) p = PowerTypes.FUELOIL;
		                	if (parts[1].equals("DEISEL")) p = PowerTypes.DEISEL;
		                	try {
		                		//parse int for size in third part
		            	        int i = Integer.parseInt(parts[2]);
		            	        try {
									vehicles.add(new Car(p, i));
								} catch (CarException ce) {
									System.out.println(ce.getMessage());
									ce.printStackTrace();
								}
		            	    } catch (NumberFormatException e) {
		            	        System.err.println("Non-numeric value as engine size on this line");
		            	    }
	                	}
	                	else {
		                	System.err.println("Power type not properly specified on this line");
		                } 
	                }
	                
	                else {
	                	System.err.println("Vehicle type not properly specified on this line");
	                }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		//test isEmpty
		System.out.println("Is string list empty: " +strings.isEmpty());
		System.out.println("Is vehicle list empty: " +vehicles.isEmpty());
		
		//test remove and iterator
		strings.remove(0);
		System.out.println("String list elements after removal: ");
		ListIterator<String> strIt = strings.listIterator();
		while (strIt.hasNext()) {
		 System.out.println(strIt.next());
		}
		
		vehicles.remove(0);
		System.out.println("Vehicle list elements after removal: ");
		ListIterator<Vehicle> vehIt = vehicles.listIterator();
		while (vehIt.hasNext()) {
		 System.out.println(vehIt.next().toString());
		}
		
		//test contains
		Vehicle presentBoat = null;
		Vehicle absentBoat = null;
		
		try {
			presentBoat = new Boat(PowerTypes.ELECTRICITY, 42);
			absentBoat = new Boat(PowerTypes.GASOLINE, 22);
			
		} catch (BoatException be) {
			System.out.println(be.getMessage());
			be.printStackTrace();
		}
	
		System.out.println("Vehicle list contains presentBoat: " +vehicles.contains(presentBoat));
		System.out.println("Vehicle list contains absentBoat: " +vehicles.contains(absentBoat));
		
		////////// 11/11 in-class ////////// 
		
		/// a ///
		System.out.println("\nNumber of elements in string list: " +strings.size());
		System.out.println("Number of elements in vehicle list: " +vehicles.size());
		
		/// b & c ///
		strIt = strings.listIterator(); // reset string list's iterator
		
		System.out.println("\nString list w/ forward navigation: ");
		while (strIt.hasNext()) {
			 System.out.println(strIt.next());
			}
		
		System.out.println("\nString list w/ backward navigation: ");
		while (strIt.hasPrevious()) {
			 System.out.println(strIt.previous());
			}
		
		vehIt = vehicles.listIterator(); // reset vehicle list's iterator
		
		System.out.println("\nVehicle list w/ forward navigation: ");
		while (vehIt.hasNext()) {
			 System.out.println(vehIt.next());
			}
		
		System.out.println("\nVehicle list w/ backward navigation: ");
		while (vehIt.hasPrevious()) {
			 System.out.println(vehIt.previous());
			}
		
		/// d ///
		Vehicle presentCar = null;
		
		try {
			presentCar = new Car(PowerTypes.GASOLINE, 4);
			
		} catch (CarException be) {
			System.out.println(be.getMessage());
			be.printStackTrace();
		}
		
		vehicles.remove(presentCar);
		
		System.out.println("\nVehicle list elements after removal of presentCar: ");
		vehIt = vehicles.listIterator();
		while (vehIt.hasNext()) {
		 System.out.println(vehIt.next().toString());
		}
		
	}

}