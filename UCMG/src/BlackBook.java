//*******************************************************************
//Course: CISS 481
//Author: Rebecca Whisnant
//Date: April 17, 2020
//Synopsis: This Java program will represent a used car manual guide.
//********************************************************************
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class BlackBook {
	
	private ArrayList<Car> carList;
	
	//this is the arraylist that you can search in
	private ArrayList<Car> carResultList;
	
	public BlackBook()
	{
		//get methods		
		carList = new ArrayList<Car>();
		carResultList = new ArrayList<Car>();
		
	}
	
	//this method will be called when the search comboBoxs are used
	public ArrayList<Car> search(String manufacturer, int year, String model)
	{
		carResultList.clear();
		for(Car c:carList)
		{
			if(c.getManufacturer().equals(manufacturer) && c.getYear() == year && c.getModel().equals(model))
			{
				carResultList.add(c);
			}
		}
		return carResultList;
	}
	
	//update method
	public void update(String manufacturer, int year, String model, String vin, String bodystyle, double value)
	{
		
		for(int i = carList.size() - 1; i >= 0; i--)
		{
			if(carList.get(i).getManufacturer().equals(manufacturer) && carList.get(i).getYear() == year && carList.get(i).getModel().equals(model) && carList.get(i).getVIN().equals(vin) && carList.get(i).getBodyStyle().equals(bodystyle) && carList.get(i).getValue() == value)
			{
				carList.remove(i);
			}
			
		}
		
	}
	
	//remove method
	public boolean remove(int year, String vin)
	{
		boolean flag = true;
		for(int i = carList.size() - 1; i >= 0; i--)
		{
			
			if(carList.get(i).getYear() == year && carList.get(i).getVIN().equals(vin))
			{
				flag = false;
				carList.remove(i);
			}			
		}
		return flag;
	}
		
	//save a file
	public void saveFile()
	{
	try
	{
		FileWriter fw = new FileWriter("carList.txt");
		Writer output = new BufferedWriter(fw);
		int size = carList.size();
		for(int i = 0; i < size; i++)
		{
			output.write(carList.get(i).toString() + "\n");
		}
		output.close();
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(null, "I cannot create that file.");
	}
	}
	
	//read a file
	public void readFile()
	{
			try{
				Scanner x = new Scanner(new File("carList.txt"));
				
				while(x.hasNext())
				{
					String Manufacturer = x.next();
					int Year = Integer.parseInt(x.next());
					String Model = x.next();
					String VIN = x.next();
					String BodyStyle = x.next();
					double Value = Double.parseDouble(x.next());
					Car a = new Car(Manufacturer, Year, Model, VIN, BodyStyle, Value);
					carList.add(a);	
				}
				x.close();
			}
			
			//user receives a error message
			catch(Exception e) 
			{
				System.out.println("Could not find file" + e);
			}
	}
	
	//getCarList
	public ArrayList<Car> getCarList()
	{
		return carList;
	}
	
	//getCarResultList
	public ArrayList<Car> getCarResultList()
	{
		return carResultList;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	
		BlackBook b = new BlackBook();
		b.readFile();
		
		for(Car c : b.getCarList())
		{
			System.out.println(c);
		}
		for(Car c : b.getCarResultList())
		{
			System.out.println(c);
		}
				
		b.saveFile();
}
}
