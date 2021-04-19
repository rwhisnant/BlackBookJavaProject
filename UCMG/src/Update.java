//*********************************************************************
//Course: CISS 481
//Author: Rebecca Whisnant
//Date: April 17, 2020
//Synopsis: This Java program will update a car to the text file.
//*********************************************************************
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Update extends JFrame {

	private BlackBook book;
	private JPanel contentPane;
	private JLabel lblUpdateSystem;
	private JLabel lblUpdateCar;
	private JLabel lblCarManufacturer;
	private JLabel lblCarYear;
	private JLabel lblCarModel;
	private JLabel lblCarVin;
	private JLabel lblCarBodyStyle;
	private JLabel lblCarValue1;
	private JLabel show_validation_here;
	private JLabel lblInvalidEntry;
	private JTextField txtManufacturer;
	private JTextField txtYear;
	private JTextField txtModel;
	private JTextField txtVIN;
	private JTextField txtBodyStyle;
	private JTextField txtValue;
	private JButton btnUpdate;
	private JButton btnReturn;
	private JLabel lblBackGround;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Update(BlackBook book) {
		this.book = book;
		setTitle("Black Book");
		setIconImage(Toolkit.getDefaultToolkit().getImage("res/imgs/ICON.png"));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
				
		//comboBox
		JComboBox comboBoxUpdateSystem = new JComboBox();
		for(Car c:book.getCarList())
		{
			comboBoxUpdateSystem.addItem(c.toString());
		}
		comboBoxUpdateSystem.setSelectedItem(null);
		comboBoxUpdateSystem.setBounds(328, 85, 424, 21);
		contentPane.add(comboBoxUpdateSystem);

		//beginning of Labels
		JLabel lblUpdateSystem = new JLabel("Choose a Car to Update");
		lblUpdateSystem.setForeground(Color.WHITE);
		lblUpdateSystem.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblUpdateSystem.setBounds(60, 77, 208, 32);
		contentPane.add(lblUpdateSystem);
		
		JLabel lblUpdateCar = new JLabel("Update Car");
		lblUpdateCar.setForeground(Color.WHITE);
		lblUpdateCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateCar.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblUpdateCar.setBounds(203, 178, 191, 21);
		contentPane.add(lblUpdateCar);
		
		JLabel lblCarManufacturer = new JLabel("Car Manufacturer");
		lblCarManufacturer.setForeground(Color.WHITE);
		lblCarManufacturer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarManufacturer.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCarManufacturer.setBounds(120, 248, 114, 32);
		contentPane.add(lblCarManufacturer);
				
		JLabel lblCarYear = new JLabel("Car Year");
		lblCarYear.setForeground(Color.WHITE);
		lblCarYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarYear.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCarYear.setBounds(120, 293, 114, 32);
		contentPane.add(lblCarYear);
		
		JLabel lblCarModel = new JLabel("Car Model");
		lblCarModel.setForeground(Color.WHITE);
		lblCarModel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarModel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCarModel.setBounds(131, 345, 114, 32);
		contentPane.add(lblCarModel);
		
		JLabel lblVin = new JLabel("VIN");
		lblVin.setForeground(Color.WHITE);
		lblVin.setHorizontalAlignment(SwingConstants.CENTER);
		lblVin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblVin.setBounds(131, 398, 114, 32);
		contentPane.add(lblVin);
		
		JLabel lblBodyStyle = new JLabel("Body Style");
		lblBodyStyle.setForeground(Color.WHITE);
		lblBodyStyle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBodyStyle.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBodyStyle.setBounds(131, 455, 114, 32);
		contentPane.add(lblBodyStyle);
		
		JLabel lblValue1 = new JLabel("Value");
		lblValue1.setForeground(Color.WHITE);
		lblValue1.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblValue1.setBounds(131, 500, 114, 32);
		contentPane.add(lblValue1);
		
		JLabel show_validation_here = new JLabel("");
		show_validation_here.setForeground(Color.RED);
		show_validation_here.setBounds(370, 328, 90, 13);
		contentPane.add(show_validation_here);
		
		JLabel lblInvalidEntry = new JLabel("");
		lblInvalidEntry.setForeground(Color.RED);
		lblInvalidEntry.setBounds(370, 532, 90, 13);
		contentPane.add(lblInvalidEntry);
		
		//beginning of TextFields
		txtManufacturer = new JTextField();
		txtManufacturer.setHorizontalAlignment(SwingConstants.CENTER);
		txtManufacturer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtManufacturer.setText(null);
		txtManufacturer.setColumns(10);
		txtManufacturer.setBounds(364, 254, 96, 19);
		contentPane.add(txtManufacturer);
		
		//convert lowercase letters to upperCase
		txtManufacturer.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
					//get user input from textField
					int position = txtManufacturer.getCaretPosition();
					txtManufacturer.setText(txtManufacturer.getText().toUpperCase());
					txtManufacturer.setCaretPosition(position);
			}
		});
		//do not allow spaces
		txtManufacturer.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
					String n = txtManufacturer.getText().trim();
					txtManufacturer.setText(n);
			}
		});
		
		txtYear = new JTextField();
		txtYear.setToolTipText("Enter only numbers!");
		txtYear.setHorizontalAlignment(SwingConstants.CENTER);
		txtYear.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtYear.setText(null);
		txtYear.setColumns(10);
		txtYear.setBounds(364, 299, 96, 19);
		contentPane.add(txtYear);
		
		//checks if user enters only numbers or not
				txtYear.addKeyListener(new KeyAdapter()
				{
					public void keyPressed(KeyEvent e)
					{
						try {
							//get user input from textField
							int updateYear = Integer.parseInt(txtYear.getText().toString());
							show_validation_here.setText("");
							}
							catch(NumberFormatException e1)
							{
								show_validation_here.setText("Invalid entry!");
							}
					}
				});
				//do not allow spaces
				txtYear.addKeyListener(new KeyAdapter()
				{
					public void keyReleased(KeyEvent e)
					{
							String n = txtYear.getText().trim();
							txtYear.setText(n);
					}
				});
				
		
		txtModel = new JTextField();
		txtModel.setHorizontalAlignment(SwingConstants.CENTER);
		txtModel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtModel.setText(null);
		txtModel.setColumns(10);
		txtModel.setBounds(364, 351, 96, 19);
		contentPane.add(txtModel);
		
		//convert lowercase letters to upperCase
		txtModel.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
					//get user input from textField
					int position = txtModel.getCaretPosition();
					txtModel.setText(txtModel.getText().toUpperCase());
					txtModel.setCaretPosition(position);
			}
		});
		//do not allow spaces
		txtModel.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
					String n = txtModel.getText().trim();
					txtModel.setText(n);
			}
		});
		
		txtVIN = new JTextField();
		txtVIN.setToolTipText("Enter the first 5 of the VIN!");
		txtVIN.setHorizontalAlignment(SwingConstants.CENTER);
		txtVIN.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtVIN.setText(null);
		txtVIN.setColumns(10);
		txtVIN.setBounds(364, 404, 96, 19);
		contentPane.add(txtVIN);
		
		//convert lowercase letters to upperCase
		txtVIN.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
					//get user input from textField
					int position = txtVIN.getCaretPosition();
					txtVIN.setText(txtVIN.getText().toUpperCase());
					txtVIN.setCaretPosition(position);
			}
		});
		//do not allow spaces
		txtVIN.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
					String n = txtVIN.getText().trim();
					txtVIN.setText(n);
			}
		});
		//only allows 5 characters
		txtVIN.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)
			{
					if(txtVIN.getText().length() >= 5)
						e.consume();
			}
		});
		
		txtBodyStyle = new JTextField();
		txtBodyStyle.setHorizontalAlignment(SwingConstants.CENTER);
		txtBodyStyle.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtBodyStyle.setText(null);
		txtBodyStyle.setBounds(364, 461, 96, 19);
		//txtBodyStyle.replaceAll("\\s+","");
		contentPane.add(txtBodyStyle);
		txtBodyStyle.setColumns(10);
		
		//convert lowercase letters to upperCase
		txtBodyStyle.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
					//get user input from textField
					int position = txtBodyStyle.getCaretPosition();
					txtBodyStyle.setText(txtBodyStyle.getText().toUpperCase());
					txtBodyStyle.setCaretPosition(position);
			}
		});
		//do not allow spaces
		txtBodyStyle.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
					String n = txtBodyStyle.getText().trim();
					txtBodyStyle.setText(n);
			}
		});
		
		txtValue = new JTextField();
		txtValue.setToolTipText("Enter only numbers!");
		txtValue.setText(null);
		txtValue.setHorizontalAlignment(SwingConstants.CENTER);
		txtValue.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtValue.setColumns(10);
		txtValue.setBounds(364, 513, 96, 19);
		contentPane.add(txtValue);
		
		//checks if user enters only numbers or not
		txtValue.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				try {
					//get user input from textField
					double updateValue = Double.parseDouble(txtValue.getText().toString());
					lblInvalidEntry.setText("");
					}
					catch(NumberFormatException e1)
					{
						lblInvalidEntry.setText("Invalid entry!");
					}
			}
		});
		//do not allow spaces
		txtValue.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent e)
			{
					String n = txtValue.getText().trim();
					txtValue.setText(n);
			}
		});
		
				//update button
				JButton btnUpdate = new JButton("Update");
				btnUpdate.setBackground(Color.WHITE);
				//notifying the user to click into the textBox to activate the update button
				btnUpdate.setToolTipText("Click in text box to activate the update button");
				btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 15));
				btnUpdate.setBounds(717, 513, 85, 21);
				btnUpdate.setEnabled(false);
				contentPane.add(btnUpdate);
				
				//user inputs information before pressing the update button
				txtManufacturer.addMouseListener(new MouseListener()
				{
					public void mouseClicked(MouseEvent e)
					{
						//checks if the user inputs anything
						if(checkInput())
						{
							//if they input anything then the button is activated by mouse click
							btnUpdate.setEnabled(true);
						}
						else
						{
							//else they do not input anything then the button stays disabled
							btnUpdate.setEnabled(false);
						}
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				//user inputs information before pressing the update button
				txtYear.addMouseListener(new MouseListener()
				{
					public void mouseClicked(MouseEvent e)
					{
						//checks if the user inputs anything
						if(checkInput())
						{
							//if they input anything then the button is activated by mouse click
							btnUpdate.setEnabled(true);
						}
						else
						{
							//else they do not input anything then the button stays disabled
							btnUpdate.setEnabled(false);
						}
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				//user inputs information before pressing the update button
				txtModel.addMouseListener(new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent e) {
						//checks if the user inputs anything
						if(checkInput())
						{
							//if they input anything then the button is activated by mouse click
							btnUpdate.setEnabled(true);
						}
						else
						{
							//else they do not input anything then the button stays disabled
							btnUpdate.setEnabled(false);
						}
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
				//user inputs information before pressing the update button
				txtVIN.addMouseListener(new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent e) {
						//checks if the user inputs anything
						if(checkInput())
						{
							//if they input anything then the button is activated by mouse click
							btnUpdate.setEnabled(true);
						}
						else
						{
							//else they do not input anything then the button stays disabled
							btnUpdate.setEnabled(false);
						}
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				//user inputs information before pressing the update button
				txtBodyStyle.addMouseListener(new MouseListener()
				{
					public void mouseClicked(MouseEvent e)
					{
						//checks if the user inputs anything
						if(checkInput())
						{
							//if they input anything then the button is activated by mouse click
							btnUpdate.setEnabled(true);
						}
						else
						{
							//else they do not input anything then the button stays disabled
							btnUpdate.setEnabled(false);
						}
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				//user inputs information before pressing the update button
				txtValue.addMouseListener(new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent e) {
						//checks if the user inputs anything
						if(checkInput())
						{
							//if they input anything then the button is activated by mouse click
							btnUpdate.setEnabled(true);
						}
						else
						{
							//else they do not input anything then the button stays disabled
							btnUpdate.setEnabled(false);
						}
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
				//action of the update button
				btnUpdate.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e)
					{
						try {
						String selectedItem = comboBoxUpdateSystem.getSelectedItem().toString();
						//split method is used to split a string into an array 
						//of substrings and returns the new array 
						//which in this case would be what the user selected from the comboBox
						String[] carItems = selectedItem.split(" ");
						for(int i = 0; i < carItems.length; i++)
						{
							System.out.println(carItems[i]);
						}
						//gets the user entry from the textField
						String updateManufacturer = txtManufacturer.getText().toString();
						int updateYear = Integer.parseInt(txtYear.getText().toString());
						String updateModel = txtModel.getText().toString();
						String updateVIN = txtVIN.getText().toString();
						String updateBodyStyle = txtBodyStyle.getText().toString();
						double updateValue = Double.parseDouble(txtValue.getText().toString());
						
							Car c = new Car(updateManufacturer, updateYear, updateModel, updateVIN, updateBodyStyle, updateValue);
							//adds a new car to the text file
							book.getCarList().add(c);
							
							//removes the old car with the new car that was added
							book.update(carItems[0],Integer.parseInt(carItems[1]),carItems[2],carItems[3],carItems[4],Double.parseDouble(carItems[5]));
							System.out.println(book.getCarList());
							//pop-up alert message
							JOptionPane.showMessageDialog(null, "Car Updated Successfully!","Alert", JOptionPane.WARNING_MESSAGE);
						}
						catch(NullPointerException np)
						{
							//pop-up error message
							JOptionPane.showMessageDialog(null, "Your update was not successful.\nRe-update by choosing a car to update then enter the correct Car Manufacturer, Car Year and the Car Model, Car VIN, Car BodyStyle, Car Value.", "Return for Re-Update", JOptionPane.ERROR_MESSAGE);
							//dispose(); close a frame while opening another one
							dispose();
							//sends the user back to the mainMenu
							new MainMenu().setVisible(true);
						}
						catch(NumberFormatException n)
						{
							//pop-up error message
							JOptionPane.showMessageDialog(null, "Re-enter a number for the Car Year and Car Value of the Updated Car.", "Return for Re-Entry", JOptionPane.ERROR_MESSAGE);
							//dispose(); close a frame while opening another one
							dispose();
							//sends the user back to the mainMenu
							new MainMenu().setVisible(true);
						}
					}
					
				});
				
				//return button
				JButton btnReturn = new JButton("Return");
				btnReturn.setBackground(Color.WHITE);
				btnReturn.setFont(new Font("Times New Roman", Font.BOLD, 15));
				btnReturn.setBounds(717, 426, 85, 21);
				contentPane.add(btnReturn);
				
				//return button goes to the mainMenu screen
				btnReturn.addActionListener(new ActionListener() 
				{	
					public void actionPerformed(ActionEvent e)
					{
						//save file before the system ends
						book.saveFile();
						//dispose(); close a frame while opening another one
						dispose();
						//sends the user back to the mainMenu
						new MainMenu().setVisible(true);
						btnReturn.setVisible(false);
					}
				});
				
				JLabel lblBackGround = new JLabel();
				lblBackGround.setIcon(new ImageIcon("res/imgs/sm.jpg"));
				lblBackGround.setBounds(-94, -135, 2220, 982);
				contentPane.add(lblBackGround);
				
				//makes the exit button work and gives a confirmation message
				addWindowListener(new WindowAdapter() 
				{
					public void windowClosing(WindowEvent e)
					{
						int result = JOptionPane.showConfirmDialog(null,"Would you like to Exit?", "Exit BlackBook",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
							if(result == JOptionPane.YES_OPTION)
							{
								//save file before the system ends
								book.saveFile();
								//ends the system
								System.exit(0);
							}
							else
							{
								//do nothing
							}
					}
				
				});
	}
	//checks the users input
	private boolean checkInput()
	{
		String updateManufacturer = txtManufacturer.getText().toString();
		String updateYear = txtYear.getText().toString();
		String updateModel = txtModel.getText().toString();
		String updateVIN = txtVIN.getText().toString();
		String updateBodyStyle = txtBodyStyle.getText().toString();
		String updateValue = txtValue.getText().toString();
		
		//user does not enter any information
		if(updateManufacturer.length()>0 && updateYear.length()>0 && updateModel.length()>0 && updateVIN.length()>0 && updateBodyStyle.length()>0 && updateValue.length()>0)
		{
			//system returns true
			return true;
		}
		else
		{
			//system return false
			return false;
		}
	}
}
