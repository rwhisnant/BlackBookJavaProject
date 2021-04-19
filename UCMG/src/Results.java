//****************************************************************************
//Course: CISS 481
//Author: Rebecca Whisnant
//Date: April 17, 2020
//Synopsis: This Java program will give the users results of a searched car.
//***************************************************************************
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Canvas;
import javax.swing.JEditorPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;

public class Results extends JFrame {

	private ArrayList<Car> car_result_list;
	private JPanel contentPane;
	private String s = "";
	private JLabel lblBmwX;
	private JTable table;
	private JScrollPane scrollpane;
	private JButton btnReturn;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Results frame = new Results();
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
	public Results(ArrayList<Car> car_result_list) {
		
		this.car_result_list = car_result_list;
		setTitle("Black Book");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("res/imgs/ICON.png"));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		//displays the users selections
		JLabel lblBmwX = new JLabel(car_result_list.get(0).getManufacturer()+" "+car_result_list.get(0).getYear()+" "+car_result_list.get(0).getModel());
		lblBmwX.setForeground(new Color(192, 192, 192));
		lblBmwX.setBounds(182, 37, 299, 56);
		lblBmwX.setBackground(new Color(255, 255, 255));
		lblBmwX.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblBmwX);
		
		//display a table of the car search results	
		AbstractTableModel dataModel = new AbstractTableModel()
		{
			String col[] = new String[] {"VIN", "Body Styles", "Values"};
			
			public int getColumnCount()
			{
				return 3;
			}
			public int getRowCount()
			{
				return car_result_list.size();
			}
			//this code get the header and calls String col[]
			public String getColumnName(int column)
			{
				return col[column];
			}
			public Object getValueAt(int row, int column)
			{
				if(column == 0)
					{
						return car_result_list.get(row).getVIN();
					}
					else if(column == 1)
					{
						return car_result_list.get(row).getBodyStyle();
					}
					else
					{
						//string.format("$%,.0f" does $1,000)
						return String.format("$%,.0f",car_result_list.get(row).getValue());
						
					}
				
			}
		};
				JTable table = new JTable(dataModel);
				JScrollPane scrollpane = new JScrollPane(table);
				scrollpane.setBounds(66, 113, 445,70);
				contentPane.add(scrollpane);
				

				//return button
				JButton btnReturn = new JButton("Return");
				btnReturn.setFont(new Font("Times New Roman", Font.BOLD, 15));
				btnReturn.setBackground(new Color(255, 255, 255));
				btnReturn.setBounds(428, 210, 87, 28);
				contentPane.add(btnReturn);
		
				//return button goes to the mainMenu screen
				btnReturn.addActionListener(new ActionListener() 
				{
					
					public void actionPerformed(ActionEvent e)
					{
						//dispose(); close a frame while opening another one
						dispose();
						//sends the user back to the mainMenu						
						new MainMenu().setVisible(true);
						btnReturn.setVisible(false);
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
