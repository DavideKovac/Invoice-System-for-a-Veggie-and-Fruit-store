package uk.ac.forthvalley.gradedunit.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * The Class that deal with Menu choice
 * @author Davide Kovac 
 *
 */
public class menuUI {

	private JFrame frame;
	
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuUI window = new menuUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public menuUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblADay = new JLabel("5 a day");
		panel.add(lblADay);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JButton btnUpdateStock = new JButton("Update Stock");
		btnUpdateStock.setBounds(168, 30, 119, 21);
		btnUpdateStock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 EnterStockChangesUI enterStock=new EnterStockChangesUI();
				enterStock.setVisible(true);;
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnUpdateStock);
		
		JButton btnNewButton = new JButton("Get Info");
		btnNewButton.setBounds(168, 86, 119, 21);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getInfoUI getInfoui=new getInfoUI();
				getInfoui.setVisible(true);
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create Report");
		btnNewButton_1.setBounds(168, 142, 119, 21);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateReportUI createReportUI=new CreateReportUI();
				createReportUI.setVisible(true);
				
			}
		});
		panel_1.add(btnNewButton_1);
	}
}
	
