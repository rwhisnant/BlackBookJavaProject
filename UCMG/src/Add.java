//**************************************************************
//Course: CISS 481
//Author: Rebecca Whisnant
//Date: April 17, 2020
//Synopsis: This Java program will add a car to the text file.
//**************************************************************
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

public class Add extends JFrame{
	private BlackBook book;
	private JPanel contentPane;
	private JLabel lblAddCar;
	private JLabel lblManufacturer;
	private JLabel lblYear;
	private JLabel lblModel;
	private JLabel lblVIN;
	private JLabel lblBodyStyle;
	private JLabel lblValue;
	private JLabel show_validation_here;
	private JLabel lblInvalidEntry;
	private JTextField txtManufacturer;
	private JTextField txtYear;
	private JTextField txtModel;
	private JTextField txtVIN;
	private JTextField txtBodyStyle;
	private JTextField txtValue;
	private JButton btnAdd;
	private JButton btnReturn;
	private JLabel lblBackGround;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
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
	public Add(BlackBook book) {
		this.book = book;
		setTitle("Black Book");
		setIconImage(Toolkit.getDefaultToolkit().getImage("res/imgs/ICON.png"));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(300,200);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		//beginning of Labels
		JLabel lblAddCar = new JLabel("Add Car");
		lblAddCar.setForeground(new Color(255, 255, 255));
		lblAddCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCar.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblAddCar.setBounds(140, 20, 233, 48);
		contentPane.add(lblAddCar);
		
		JLabel lblManufacturer = new JLabel("Car Manufacturer");
		lblManufacturer.setForeground(new Color(255, 255, 255));
		lblManufacturer.setHorizontalAlignment(SwingConstants.CENTER);
		lblManufacturer.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblManufacturer.setBounds(54, 83, 121, 32);
		contentPane.add(lblManufacturer);
		
		JLabel lblYear = new JLabel("Car Year");
		lblYear.setForeground(new Color(255, 255, 255));
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblYear.setBounds(61, 117, 114, 32);
		contentPane.add(lblYear);
		
		JLabel lblModel = new JLabel("Car Model");
		lblModel.setForeground(new Color(255, 255, 255));
		lblModel.setHorizontalAlignment(SwingConstants.CENTER);
		lblModel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblModel.setBounds(61, 159, 114, 32);
		contentPane.add(lblModel);
		
		JLabel lblVIN = new JLabel("VIN");
		lblVIN.setForeground(new Color(255, 255, 255));
		lblVIN.setHorizontalAlignment(SwingConstants.CENTER);
		lblVIN.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblVIN.setBounds(61, 201, 114, 32);
		contentPane.add(lblVIN);
		
		JLabel lblBodyStyle = new JLabel("Body Style");
		lblBodyStyle.setForeground(new Color(255, 255, 255));
		lblBodyStyle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBodyStyle.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBodyStyle.setBounds(61, 243, 114, 32);
		contentPane.add(lblBodyStyle);
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setForeground(new Color(255, 255, 255));
		lblValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblValue.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblValue.setBounds(61, 285, 114, 32);
		contentPane.add(lblValue);
		
		JLabel show_validation_here = new JLabel("");
		show_validation_here.setForeground(Color.RED);
		show_validation_here.setBounds(289, 146, 90, 13);
		contentPane.add(show_validation_here);
		
		JLabel lblInvalidEntry = new JLabel("");
		lblInvalidEntry.setForeground(Color.RED);
		lblInvalidEntry.setBounds(283, 318, 90, 13);
		contentPane.add(lblInvalidEntry);
		
		//beginning of TextFields
		txtManufacturer = new JTextField();
		txtManufacturer.setText(null);
		txtManufacturer.setHorizontalAlignment(SwingConstants.CENTER);
		txtManufacturer.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtManufacturer.setColumns(10);
		txtManufacturer.setBounds(283, 89, 96, 19);
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
		txtYear.setText(null);
		txtYear.setHorizontalAlignment(SwingConstants.CENTER);
		txtYear.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtYear.setColumns(10);
		txtYear.setBounds(283, 125, 96, 19);
		contentPane.add(txtYear);
		
		//checks if user enters only numbers or not
		txtYear.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				try {
					//get user input from textField
					int addYear = Integer.parseInt(txtYear.getText().toString());
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
		txtModel.setText(null);
		txtModel.setHorizontalAlignment(SwingConstants.CENTER);
		txtModel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtModel.setColumns(10);
		txtModel.setBounds(283, 169, 96, 19);
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
		txtVIN.setText(null);
		txtVIN.setHorizontalAlignment(SwingConstants.CENTER);
		txtVIN.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtVIN.setColumns(10);
		txtVIN.setBounds(283, 212, 96, 19);
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
		txtBodyStyle.setText(null);
		txtBodyStyle.setHorizontalAlignment(SwingConstants.CENTER);
		txtBodyStyle.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtBodyStyle.setColumns(10);
		txtBodyStyle.setBounds(283, 258, 96, 19);
		contentPane.add(txtBodyStyle);
		
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
		txtValue.setBounds(283, 298, 96, 19);
		contentPane.add(txtValue);
		
		//checks if user enters only numbers or not
				txtValue.addKeyListener(new KeyAdapter()
				{
					public void keyPressed(KeyEvent e)
					{
						try {
							//get user input from textField
							double addValue = Double.parseDouble(txtValue.getText().toString());
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
				
		//add button
		JButton btnAdd = new JButton("Add");
		//notifying the user to click into the textBox to activate the add button
		btnAdd.setToolTipText("Click in text box to activate the add button");
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(457, 291, 85, 21);
		btnAdd.setEnabled(false);
		contentPane.add(btnAdd);
		
		//user inputs information before pressing the add button
		txtManufacturer.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{
				//checks if the user inputs anything
				if(checkInput())
				{
					//if they input anything then the button is activated by mouse click
					btnAdd.setEnabled(true);
				}
				else
				{
					//else they do not input anything then the button stays disabled
					btnAdd.setEnabled(false);
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
		//user inputs information before pressing the add button
		txtYear.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{
				//checks if the user inputs anything
				if(checkInput())
				{
					//if they input anything then the button is activated by mouse click
					btnAdd.setEnabled(true);
				}
				else
				{
					//else they do not input anything then the button stays disabled
					btnAdd.setEnabled(false);
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
		//user inputs information before pressing the add button
		txtModel.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				//checks if the user inputs anything
				if(checkInput())
				{
					//if they input anything then the button is activated by mouse click
					btnAdd.setEnabled(true);
				}
				else
				{
					//else they do not input anything then the button stays disabled
					btnAdd.setEnabled(false);
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
		
		//user inputs information before pressing the add button
		txtVIN.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				//checks if the user inputs anything
				if(checkInput())
				{
					//if they input anything then the button is activated by mouse click
					btnAdd.setEnabled(true);
				}
				else
				{
					//else they do not input anything then the button stays disabled
					btnAdd.setEnabled(false);
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
		//user inputs information before pressing the add button
		txtBodyStyle.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{
				//checks if the user inputs anything
				if(checkInput())
				{
					//if they input anything then the button is activated by mouse click
					btnAdd.setEnabled(true);
				}
				else
				{
					//else they do not input anything then the button stays disabled
					btnAdd.setEnabled(false);
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
		//user inputs information before pressing the add button
		txtValue.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				//checks if the user inputs anything
				if(checkInput())
				{
					//if they input anything then the button is activated by mouse click
					btnAdd.setEnabled(true);
				}
				else
				{
					//else they do not input anything then the button stays disabled
					btnAdd.setEnabled(false);
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
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
				
				//get user input from textField
				String addManufacturer = txtManufacturer.getText().toString();
				int addYear = Integer.parseInt(txtYear.getText().toString());
				String addModel = txtModel.getText().toString();
				String addVIN = txtVIN.getText().toString();
				String addBodyStyle = txtBodyStyle.getText().toString();
				double addValue = Double.parseDouble(txtValue.getText().toString());
				
					//get user input from textField
					Car c = new Car(addManufacturer, addYear, addModel, addVIN, addBodyStyle, addValue);
					
					//adds a car to the text file
					book.getCarList().add(c);
					
					//pop-up alert message
					JOptionPane.showMessageDialog(null, "Car Added Successfully!","Alert", JOptionPane.WARNING_MESSAGE);
				}
				catch(NumberFormatException n)
				{
					//pop-up error message
					JOptionPane.showMessageDialog(null, "Re-enter a number for the Car Year and Car Value of the Added Car.", "Return for Re-Entry", JOptionPane.ERROR_MESSAGE);
					//dispose(); close a frame while opening another one
					dispose();
					//sends the user back to the mainMenu
					new MainMenu().setVisible(true);
				}
			}
		});
		
				//return button
				JButton btnReturn = new JButton("Return");
				btnReturn.setFont(new Font("Times New Roman", Font.BOLD, 15));
				btnReturn.setBackground(Color.WHITE);
				btnReturn.setBounds(457, 229, 85, 21);
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
				lblBackGround.setIcon(new ImageIcon("res/imgs/kia.jpg"));
				lblBackGround.setBounds(-16, -23, 652, 395);
				contentPane.add(lblBackGround);	
				
		//makes the exit button work and gives a pop message
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
			String addManufacturer = txtManufacturer.getText().toString();
			String addYear = txtYear.getText().toString();
			String addModel = txtModel.getText().toString();
			String addVIN = txtVIN.getText().toString();
			String addBodyStyle = txtBodyStyle.getText().toString();
			String addValue = txtValue.getText().toString();
			
			//user does not enter any information
			if(addManufacturer.length()>0 && addYear.length()>0 && addModel.length()>0 && addVIN.length()>0 && addBodyStyle.length()>0 && addValue.length()>0)
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