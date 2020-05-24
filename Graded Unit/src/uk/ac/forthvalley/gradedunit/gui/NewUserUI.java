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
 * The Class that deal with the GUI to add new client or supplier
 * @author Davide Kovac 
 *
 */
public class NewUserUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private DatabaseManager db=new DatabaseManager();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUserUI frame = new NewUserUI();
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
	public NewUserUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewUser = new JLabel("New User");
		panel.add(lblNewUser);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(10, 31, 34, 13);
		panel_1.add(lblType);
		
		JRadioButton rdbtnSupplier = new JRadioButton("Supplier");
		rdbtnSupplier.setBounds(58, 16, 103, 21);
		panel_1.add(rdbtnSupplier);
		
		
		JRadioButton rdbtnClient = new JRadioButton("Client");
		rdbtnClient.setBounds(58, 45, 103, 21);
		panel_1.add(rdbtnClient);
		
		ButtonGroup editableGroup = new ButtonGroup();
	    editableGroup.add(rdbtnClient);
	    editableGroup.add(rdbtnSupplier);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(265, 31, 45, 13);
		panel_1.add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(320, 28, 96, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblCompanyName = new JLabel("Company name");
		lblCompanyName.setBounds(10, 123, 77, 13);
		panel_1.add(lblCompanyName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 120, 96, 19);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(253, 123, 83, 13);
		panel_1.add(lblPhoneNumber);
		
		textField_2 = new JTextField();
		textField_2.setBounds(332, 120, 84, 19);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addingStockUI addingStock=new addingStockUI();
				addingStock.setVisible(true);
				if(rdbtnClient.isSelected()) {
				String companyName=textField_1.getText();
				String companyEmail=textField.getText();
				String clientPhoneNumber=textField_2.getText();
				db.insertClient(companyName, companyEmail, clientPhoneNumber);
				}
				else if(rdbtnSupplier.isSelected())
				{
					String companyName=textField_1.getText();
					String companyEmail=textField.getText();
					String clientPhoneNumber=textField_2.getText();
					db.insertNewSupplier(companyName, companyEmail, clientPhoneNumber);
					
			
			}
				editableGroup.clearSelection();
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		panel_2.add(btnConfirm);
	}	
}
