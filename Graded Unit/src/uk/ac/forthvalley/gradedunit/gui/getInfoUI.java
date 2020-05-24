package uk.ac.forthvalley.gradedunit.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uk.ac.forthvalley.gradedunit.dataaccess.DatabaseManager;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * The Class that deal with the GUI to display and retrieve information
 * @author Davide Kovac 
 *
 */
public class getInfoUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	DatabaseManager db= new DatabaseManager();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getInfoUI frame = new getInfoUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public getInfoUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblGetInfo = new JLabel("Get Info ");
		panel.add(lblGetInfo);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(110, 47, 45, 13);
		panel_1.add(lblType);
		
		JRadioButton rdbtnClient = new JRadioButton("Client");
		rdbtnClient.setBounds(203, 19, 103, 21);
		panel_1.add(rdbtnClient);
		
		JRadioButton rdbtnOrder = new JRadioButton("Order");
		rdbtnOrder.setBounds(203, 43, 103, 21);
		panel_1.add(rdbtnOrder);
		
		JRadioButton rdbtnSupplier = new JRadioButton("Supplier");
		rdbtnSupplier.setBounds(203, 66, 103, 21);
		panel_1.add(rdbtnSupplier);
		
		ButtonGroup editableGroup = new ButtonGroup();
	    editableGroup.add(rdbtnClient);
	    editableGroup.add(rdbtnSupplier);
	    editableGroup.add(rdbtnOrder);
		
		JLabel lblId = new JLabel("Id Number");
		lblId.setBounds(110, 139, 58, 13);
		panel_1.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(210, 136, 96, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(false);
				JPanel panel_3 = new JPanel();
				contentPane.add(panel_3, BorderLayout.CENTER);
				panel_3.setLayout(null);
				JTextField show= new JTextField();
				show.setBounds(10,10,400,250);
				panel_3.add(show);
				
				if(rdbtnClient.isSelected())
				{
					int clientID=Integer.parseInt(textField.getText());
					db.getClient(clientID);
					show.setText(db.getClient(clientID));

				}
				else if(rdbtnSupplier.isSelected())
				{
					int supplierID=Integer.parseInt(textField.getText());
					db.getSupplier(supplierID);
					show.setText(db.getSupplier(supplierID));
					
					
				}
				else if(rdbtnOrder.isSelected())
				{
					int orderID=Integer.parseInt(textField.getText());
					db.getOrder(orderID);
					show.setText(db.getOrder(orderID));
					
					
				}
				
			}
		});
		panel_2.add(btnConfirm);
		
	}
}

