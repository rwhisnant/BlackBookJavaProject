//*****************************************************************
//Course: CISS 481
//Author: Rebecca Whisnant
//Date: April 17, 2020
//Synopsis: This Java program will remove a car from the text file.
//*****************************************************************
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Remove extends JFrame {

	private BlackBook book;
	private JPanel contentPane;
	private JLabel lblYear;
	private JLabel lblVin;
	private JLabel show_validation_here;
	private JTextField txtYear;
	private JTextField txtVIN;
	private JButton btnRemove;
	private JButton btnReturn;
	private JLabel lblBackGround;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Remove frame = new Remove();
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
	public Remove(BlackBook book) {
		this.book = book;
		setTitle("Black Book");
		setIconImage(Toolkit.getDefaultToolkit().getImage("res/imgs/ICON.png"));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		//beginning of Labels
		JLabel lblRemoveCar = new JLabel("Remove Car");
		lblRemoveCar.setForeground(new Color(255, 255, 255));
		lblRemoveCar.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblRemoveCar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveCar.setBounds(214, 36, 205, 55);
		contentPane.add(lblRemoveCar);
		
		JLabel lblYear = new JLabel("Car Year");
		lblYear.setForeground(new Color(255, 255, 255));
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblYear.setBounds(129, 117, 75, 42);
		contentPane.add(lblYear);
		
		JLabel lblVin = new JLabel("VIN");
		lblVin.setForeground(Color.WHITE);
		lblVin.setToolTipText("");
		lblVin.setHorizontalAlignment(SwingConstants.CENTER);
		lblVin.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblVin.setBounds(107, 222, 125, 62);
		contentPane.add(lblVin);
		
		JLabel show_validation_here = new JLabel("");
		show_validation_here.setForeground(Color.RED);
		show_validation_here.setBounds(268, 161, 90, 13);
		contentPane.add(show_validation_here);
		
		//beginning of TextFields
		txtYear = new JTextField();
		txtYear.setToolTipText("Enter only numbers and No spaces!");
		txtYear.setHorizontalAlignment(SwingConstants.CENTER);
		txtYear.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtYear.setText(null);
		txtYear.setBounds(258, 130, 190, 19);
		txtYear.setColumns(10);	
		contentPane.add(txtYear);

		//checks if user enters only numbers or not
		txtYear.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				try {
					//get user input from textField
					int removeYear = Integer.parseInt(txtYear.getText());
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
		
		txtVIN = new JTextField();
		txtVIN.setToolTipText("Enter the first 5 of the VIN!");
		txtVIN.setHorizontalAlignment(SwingConstants.CENTER);
		txtVIN.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtVIN.setText(null);
		txtVIN.setBounds(258, 244, 190, 19);
		txtVIN.setColumns(10);
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
	
		//remove button
		JButton btnRemove = new JButton("Remove");
		//notifying the user to click into the textBox to activate the remove button
		btnRemove.setToolTipText("Click in text box to activate the remove button");
		btnRemove.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnRemove.setBackground(Color.WHITE);
		btnRemove.setBounds(476, 310, 96, 21);
		btnRemove.setEnabled(false);
		contentPane.add(btnRemove);
		
		//user inputs information before pressing the remove button
		txtYear.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent e)
			{
				//checks if the user inputs anything
				if(checkInput())
				{
					//if they input anything then the button is activated by mouse click
					btnRemove.setEnabled(true);
				}
				else
				{
					//else they do not input anything then the button stays disabled
					btnRemove.setEnabled(false);
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
		//user inputs information before pressing the remove button
		txtVIN.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) {
				//checks if the user inputs anything
				if(checkInput())
				{
					//if they input anything then the button is activated by mouse click
					btnRemove.setEnabled(true);
				}
				else
				{
					//else they do not input anything then the button stays disabled
					btnRemove.setEnabled(false);
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
		
		//action of the remove button
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try {
				//get user input from textField
				int removeYear = Integer.parseInt(txtYear.getText().toString());
				String removeVIN = txtVIN.getText().toString();
				
				//removes a car from the text file
				boolean flag = book.remove(removeYear, removeVIN);
				
				 if(flag)
					{

					//pop-up error message for re-entry
						JOptionPane.showMessageDialog(null, "Your entry was not found.\nRe-enter a Car Year and a Car VIN?", "Return for Re-Entry", JOptionPane.ERROR_MESSAGE);
					}
				 else
					 {
					 	//pop-up alert message for found car that have been removed
						 JOptionPane.showMessageDialog(null, "Car Successfully Removed!","Alert", JOptionPane.WARNING_MESSAGE);
					 }
				}
				catch(NumberFormatException n)
				{
					//pop-up error message
					JOptionPane.showMessageDialog(null, "Re-enter a number for the Car Year to Remove a Car.", "Return for Re-Entry", JOptionPane.ERROR_MESSAGE);
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
		btnReturn.setBounds(31, 310, 85, 21);
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
		lblBackGround.setIcon(new ImageIcon("res/imgs/avalon.jpg"));
		lblBackGround.setBounds(-11, -30, 729, 414);
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
		String removeYear = txtYear.getText().toString();
		String removeVIN = txtVIN.getText().toString();
		
		//user does not enter any information
		if(removeYear.length()>0 && removeVIN.length()>0)
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