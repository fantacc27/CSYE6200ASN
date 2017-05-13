package edu.neu.csye6200.registry;

import java.io.Serializable;

/**
 * CSYE6200 Example Vehicle class
 * @author MMUNSON
 */
public class Vehicle implements Serializable{
	static private int idCounter = 0;
	static double taxRate = 2.10; // An annual tax reate
	
	private int id; // A unique ID for each vehicle instance

	int year;
	String make;    // The vehicle manufacturer (i.e. Ford, Chevy, Mercedes, Fiat, etc.)
	String model;   // The vehicle model (i.e. A4, S60, Focus, etc.)
	String idOwner; // A unique ID that designates the owner

	int passengers; // The number of legal passengers
	int fuelCap;    // Liters
	double kpl;     // Kilometers per liter

	private double value = 1.0; // The vehicle value in dollars

    /**
     * Default constructor
     */
	public Vehicle() { 
		System.out.println("Vehicle default constructor");
		make="Unk.";
		model="-?-";
		id = idCounter++;
	}
	
	/**
	 * Vehicle constructor with input field specifications
	 * @param year model year
	 * @param make vehicle manufacturer
	 * @param model vehicle model type
	 * @param passengers number of seated passengers
	 * @param fuelCap fuel capacity in liters
	 * @param kpl fuel economy in kilometers per liter
	 */
	public Vehicle(String idOwner, int year, String make, String model, int passengers,
			int fuelCap, double kpl, double value) {
		//System.out.println("Vehicle Make-model:" + make + ":" + model);
		this.idOwner = idOwner;
		this.year = year;
		this.make = make;
		this.model = model;
		this.passengers = passengers;
		this.fuelCap = fuelCap;
		this.kpl = kpl;
		this.value = value;
		id = idCounter++;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Get the unique owner ID string
	 * @return a unique string that defines an owner
	 */
	public String getOwnerId() {
		return idOwner;
	}
       
	
	/**
	 * Calculate the vehicle range (i.e. fuelCap * kpl)
	 * @return the fuel efficiency in Kilometers per liter
	 */
	public double getRange() {
		return (fuelCap * kpl);
	}
	
	/**
	 * An example of a getter routine - this is used when we want to make a variable private
	 * @return
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Calculate the vehicle tax
	 * @return the annual tax (in dollars) based on value
	 */
	public double getAnnualTax() {
		return value * taxRate;
	}
	
	/**
	 * Return the Make/Model as a string
	 * @return
	 */
	public String getMakeModel() {
		return ("Vehicle[" + make + ":" + model + "]");
	}
	
	/**
	 * Print the year, make, model and range as a formatted string
	 * @return a formatted description of the vehicle
	 */
	public String toFormattedString() {
		return String.format(" %1$04d %2$10s %3$12s %4$,9.2f %5$11s", year, make, model, getRange(), getOwnerId());
	}
	
	/**
	 * The default toString() method, which is used to print an instance of the class
	 */
	public String toString() {
		return "Vehicle[make=" + make +
				",model="+ model +
				",pass=" + passengers + 
				",fuelCap=" + fuelCap +
				",kpl=" + kpl +
				",id=" + id +
		        ",tax=" + getAnnualTax() +"]";
	}
}
