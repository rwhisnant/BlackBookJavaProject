//*********************************************************************
//Course: CISS 481
//Author: Rebecca Whisnant
//Date: April 17, 2020
//Synopsis: This Java program will search for a car from the text file.
//*********************************************************************
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Search extends JFrame {

	private BlackBook book;
	private JPanel contentPane;
	private final JButton btnSearch = new JButton("Search");
	private JLabel lblChooseManufacturer;
	private JLabel lblChooseYear;
	private JLabel lblChooseModel;
	private JLabel lblBackGround;
	private JLabel show_validation_here;
	private JComboBox carManufacturer;
	private JComboBox carYear;
	private JComboBox carModel;
	private JButton btnReturn;
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
		public Search(BlackBook book) {
			this.book = book;
	JLabel background;
	setSize(100,100);
	ImageIcon img = new ImageIcon("images.jpg");
	background = new JLabel("",img,JLabel.CENTER);
	background.setBounds(100, 100, 550, 300);
	getContentPane().add(background);
	
	setBackground(new Color(51, 102, 153));
	setTitle("Black Book");
	setIconImage(Toolkit.getDefaultToolkit().getImage("res/imgs/ICON.png"));
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(0, 0, 0));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setResizable(false);
	
	//beginning of Labels
	JLabel lblChooseManufacturer = new JLabel("Choose a Car Manufacturer");
	lblChooseManufacturer.setForeground(Color.WHITE);
	lblChooseManufacturer.setBackground(new Color(153, 204, 204));
	lblChooseManufacturer.setFont(new Font("Times New Roman", Font.BOLD, 15));
	lblChooseManufacturer.setHorizontalAlignment(SwingConstants.CENTER);
	lblChooseManufacturer.setBounds(108, 22, 207, 21);
	contentPane.add(lblChooseManufacturer);
	
	JLabel lblChooseYear = new JLabel("Choose a Car Year");
	lblChooseYear.setForeground(Color.WHITE);
	lblChooseYear.setHorizontalAlignment(SwingConstants.CENTER);
	lblChooseYear.setFont(new Font("Times New Roman", Font.BOLD, 15));
	lblChooseYear.setBackground(new Color(153, 204, 204));
	lblChooseYear.setBounds(108, 86, 207, 21);
	contentPane.add(lblChooseYear);
	
	JLabel lblChooseModel = new JLabel("Choose a Car Model");
	lblChooseModel.setForeground(Color.WHITE);
	lblChooseModel.setHorizontalAlignment(SwingConstants.CENTER);
	lblChooseModel.setFont(new Font("Times New Roman", Font.BOLD, 15));
	lblChooseModel.setBackground(new Color(153, 204, 204));
	lblChooseModel.setBounds(108, 146, 207, 21);
	contentPane.add(lblChooseModel);
	
	JLabel show_validation_here = new JLabel("");
	show_validation_here.setForeground(Color.RED);
	show_validation_here.setBounds(212, 159, 90, 13);
	contentPane.add(show_validation_here);
	
	//beginning of comboBox's	
	JComboBox carManufacturer = new JComboBox();
	
	//LIST OF MANUFACTURERS
	ArrayList <String> manufacturers =  new ArrayList<String>();
	//LOOK THROUGH THE LIST OF YOUR CARS
	//CREATE A FOR LOOP
	for(Car c : book.getCarList())
	{
		//if the manufacturer that was added into the text file 
		//is not in the comboBox it will be added
		if(!manufacturers.contains( c.getManufacturer()) )
		{
			manufacturers.add(c.getManufacturer());
		}
	}
	for(String x : manufacturers)
	{
		//this adds the manufacturer to the comboBox
		carManufacturer.addItem(x);
	}
	carManufacturer.setSelectedItem(null);
	carManufacturer.setToolTipText("CarManufacturer");
	carManufacturer.setBackground(Color.WHITE);
	carManufacturer.setBounds(108, 55, 207, 21);
	contentPane.add(carManufacturer);
	
	
	
	JComboBox carYear = new JComboBox();
	ArrayList <Integer> years =  new ArrayList<Integer>();
	//LOOK THROUGH THE LIST OF YOUR CARS
	//CREATE A FOR LOOP
	for(Car c : book.getCarList())
	{
		//if the year that was added into the text file 
		//is not in the comboBox it will be added
		if(!years.contains( c.getYear()) )
		{
			years.add(c.getYear());
		}
	}
	for(int x : years)
	{
		//this adds the year to the comboBox
		carYear.addItem(x);
	}
	carYear.setSelectedItem(null);
	carYear.setToolTipText("carYear");
	carYear.setBackground(Color.WHITE);
	carYear.setBounds(108, 115, 207, 21);
	contentPane.add(carYear);
	
	JComboBox carModel = new JComboBox();
	ArrayList <String> models =  new ArrayList<String>();
	//LOOK THROUGH THE LIST OF YOUR CARS
	//CREATE A FOR LOOP
	for(Car c : book.getCarList())
	{
		//if the model that was added into the text file 
		//is not in the comboBox it will be added
		if(!models.contains( c.getModel()) )
		{
			models.add(c.getModel());
		}
	}
	for(String x : models)
	{
		//this adds the model to the comboBox
		carModel.addItem(x);
	}
	carModel.setSelectedItem(null);
	carModel.setToolTipText("carModel");
	carModel.setBackground(Color.WHITE);
	carModel.setBounds(108, 178, 207, 21);
	contentPane.add(carModel);
	
	//return button
	JButton btnReturn = new JButton("Return");
	btnReturn.setFont(new Font("Times New Roman", Font.BOLD, 15));
	btnReturn.setBackground(Color.WHITE);
	btnReturn.setBounds(23, 232, 85, 21);
	contentPane.add(btnReturn);
	
	//return button goes to the mainMenu screen
	btnReturn.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e)
		{
			dispose();
			new MainMenu().setVisible(true);
			btnReturn.setVisible(false);
		}

	});
	
	//search button
	JButton btnSearch = new JButton("Search");
	//notifying the user to click into the textBox to activate the search button
	btnSearch.setToolTipText("Click in drop-down box to activate the search button");
	btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
	btnSearch.setBackground(Color.WHITE);
	btnSearch.setBounds(341, 232, 85, 21);
	contentPane.add(btnSearch);
	
	//action of the search button
	btnSearch.addActionListener(new ActionListener() 
	{
		public void actionPerformed(ActionEvent e)
		{
			try 
			{
				//get selected value from comboBox
				String selectedManufacturer = carManufacturer.getSelectedItem().toString();
				int selectedYear = Integer.parseInt(carYear.getSelectedItem().toString());
				String selectedModel = carModel.getSelectedItem().toString();
				
				
				//this is the list pass it to the result gui class
				ArrayList<Car> car_result_list = book.search(selectedManufacturer, selectedYear, selectedModel);
				
				//if the text file is empty the user will receive a message else it will open the results menu
				if(car_result_list.size() == 0)
				{
					//pop-up error message
					JOptionPane.showMessageDialog(null, "Your search was not found.\nRe-search the correct Car Manufacturer, Car Year and the Car Model.", "Return for Re-Search", JOptionPane.ERROR_MESSAGE);
					dispose();
					new MainMenu().setVisible(true);
				}
				else
				{
					car_result_list.size();
				}
				//dispose(); close a frame while opening another one
				dispose();
		
				//display results
				new Results(car_result_list).setVisible(true);
			}
					catch(IndexOutOfBoundsException a)
					{
						System.out.println(a.getMessage());
					}
					//if user decides to press search button without selecting comboBoxs
					catch(NullPointerException n)
					{
						//pop-up error message
						JOptionPane.showMessageDialog(null, "Your search was not found.\nRe-search the correct Car Manufacturer, Car Year and the Car Model.", "Return for Re-Search", JOptionPane.ERROR_MESSAGE);
						//dispose(); close a frame while opening another one
						dispose();
						//sends the user back to the mainMenu
						new MainMenu().setVisible(true);
					}
		}

	});
	JLabel lblBackGround = new JLabel();
	lblBackGround.setIcon(new ImageIcon("res/imgs/kia.jpg"));
	lblBackGround.setBounds(-32, -22, 527, 332);
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
	
}
