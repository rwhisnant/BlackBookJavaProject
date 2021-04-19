//***********************************************************
//Course: CISS 481
//Author: Rebecca Whisnant
//Date: April 17, 2020
//Synopsis: This Java program will represent the main menu.
//***********************************************************
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame {
	

	private JPanel contentPane;
	private BlackBook book;
	private JLabel lblSearchForA;
	private JLabel lblWelcomeToBlack;
	private JLabel lblUpdateTheSystem;
	private JLabel lblAddCar;
	private JLabel lblRemoveCar;
	private JLabel lblUpdateCar;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnRemove;
	private JButton btnSearch;
	
	

	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}
*/
	/**
	 * Create the frame.
	 */
	public MainMenu() {
		book = new BlackBook();
		book.readFile();
		JLabel background;
		setSize(400,400);
		ImageIcon img = new ImageIcon("res/imgs/avalion.jpg");
		background = new JLabel("",img,JLabel.CENTER);
		background.setBounds(100, 100, 500, 300);
		getContentPane().add(background);
		
		setBackground(new Color(51, 102, 153));
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
		
		
		JLabel lblSearchForA = new JLabel("Search for a Car");
		lblSearchForA.setForeground(Color.WHITE);
		lblSearchForA.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchForA.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblSearchForA.setBackground(new Color(153, 204, 204));
		lblSearchForA.setBounds(234, 141, 153, 33);
		contentPane.add(lblSearchForA);
		
		JLabel lblWelcomeToBlack = new JLabel("Welcome to Black Book");
		lblWelcomeToBlack.setForeground(Color.WHITE);
		lblWelcomeToBlack.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToBlack.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblWelcomeToBlack.setBackground(new Color(153, 204, 204));
		lblWelcomeToBlack.setBounds(108, 35, 373, 93);
		contentPane.add(lblWelcomeToBlack);
		
		JLabel lblUpdateTheSystem = new JLabel("Update the System");
		lblUpdateTheSystem.setForeground(Color.WHITE);
		lblUpdateTheSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateTheSystem.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblUpdateTheSystem.setBackground(new Color(153, 204, 204));
		lblUpdateTheSystem.setBounds(0, 266, 153, 33);
		contentPane.add(lblUpdateTheSystem);
		
		JLabel lblAddACar = new JLabel("Add a Car");
		lblAddACar.setForeground(Color.WHITE);
		lblAddACar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddACar.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAddACar.setBackground(new Color(153, 204, 204));
		lblAddACar.setBounds(443, 266, 153, 33);
		contentPane.add(lblAddACar);
		
		JLabel lblRemoveACar = new JLabel("Remove a Car");
		lblRemoveACar.setForeground(Color.WHITE);
		lblRemoveACar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoveACar.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblRemoveACar.setBackground(new Color(153, 204, 204));
		lblRemoveACar.setBounds(234, 266, 153, 33);
		contentPane.add(lblRemoveACar);
		
		//beginning of Buttons
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(24, 308, 120, 33);
		contentPane.add(btnUpdate);
		
		//update button goes to the update screen
		btnUpdate.addActionListener(new ActionListener() 
		{
				public void actionPerformed(ActionEvent e)
				{
					//dispose(); is to close a frame while opening another one
					dispose();
					//sends the user back to the update screen
					new Update(book).setVisible(true);
					btnUpdate.setVisible(false);
				}
		
		});
	
		//remove button
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnRemove.setBackground(Color.WHITE);
		btnRemove.setBounds(260, 308, 109, 35);
		contentPane.add(btnRemove);
		
		//remove button goes to the remove screen
		btnRemove.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				//dispose(); is to close a frame while opening another one
				dispose();
				//sends the user back to the remove screen
				new Remove(book).setVisible(true);
				btnRemove.setVisible(false);
			}
	
		});
		
		//add button
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.setBounds(469, 309, 100, 33);
		contentPane.add(btnAdd);
		//add button goes to the add screen
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				//dispose(); is to close a frame while opening another one
				dispose();
				//sends the user back to the add screen
				new Add(book).setVisible(true);
				btnAdd.setVisible(false);
			}
	
		});
		
		//search button
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(248, 182, 118, 33);
		contentPane.add(btnSearch);
		
		//search button goes to the search screen
		btnSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				//dispose(); is to close a frame while opening another one
				dispose();
				//sends the user back to the search screen
				new Search(book).setVisible(true);
				btnSearch.setVisible(false);
			}
	
		});
		
		
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
	
}
