//**************************************************
//Course: CISS 481
//Author: Rebecca Whisnant
//Date: April 17, 2020
//Synopsis: This Java program will represent a car.
//**************************************************
import java.util.Scanner;

public class Car {
	
	//variables
	private String carManufacturer;
	private int carYear;
	private String carModel;
	private String carVIN;
	private String carBodyStyle;
	private double carValue;

	//get methods for all instance data
	public String getManufacturer() 
	{
		return carManufacturer;
	}
	public int getYear() 
	{
		return carYear;
	}
	public String getModel()
	{
		return carModel;
	}
	public String getVIN()
	{
		return carVIN;
	}
	public String getBodyStyle()
	{
		return carBodyStyle;
	}
	public double getValue()
	{
		return carValue;
	}
	
	//set methods for all instance data
	public void setManufacturer(String manufacturer)
	{
		carManufacturer = manufacturer;
	}
	public void setYear(int year)
	{
		carYear = year;
	}
	public void setModel(String model)
	{
		carModel = model;
	}
	public void setVIN(String vin)
	{
		carVIN = vin;
	}
	public void setBodyStyle(String bodystyle)
	{
		carBodyStyle = bodystyle;
	}
	public void setValue(double value)
	{
		carValue = value;
	}
	
	//constructor to initialize these values
	public Car(String manufacturer, int year, String model, String vin, String bodystyle, double value)
	{
		carManufacturer = manufacturer;
		carYear = year;
		carModel = model;
		carVIN = vin;
		carBodyStyle = bodystyle;
		carValue = value;
	}
	
	/*toString creates a one-line description of the car*/
	public String toString()
	{
		return carManufacturer + " " + Integer.toString(carYear) + " " + carModel + " " + carVIN + " " + carBodyStyle + " " + Double.toString(carValue) + " ";
	}
};