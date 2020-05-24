package uk.ac.forthvalley.gradedunit.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import uk.ac.forthvalley.gradedunit.dataaccess.DatabaseManager;

import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * The Class that deal with the GUI to add newStock and Orders
 * @author Davide Kovac 
 *
 */
public class addingStockUI extends JFrame {
	//private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private DatabaseManager db=new DatabaseManager();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public addingStockUI() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblEnterStockChanges = new JLabel("Enter Stock Changes");
		panel.add(lblEnterStockChanges);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(10, 23, 45, 13);
		panel_1.add(lblType);
		
		JRadioButton rdbtnClient = new JRadioButton("Client");
		rdbtnClient.setBounds(41, 6, 103, 21);
		panel_1.add(rdbtnClient);
		rdbtnClient.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
		if(rdbtnClient.isSelected())
		{
			textField_2.setEditable(false);
			textField_3.setEditable(false);
			textField_4.setEditable(false);
			
		}
		}
		});
		
		JRadioButton rdbtnSupplier = new JRadioButton("Supplier");
		rdbtnSupplier.setBounds(41, 33, 103, 21);
		panel_1.add(rdbtnSupplier);
		rdbtnSupplier.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			if(rdbtnSupplier.isSelected())
			{
				textField_2.setEditable(true);
				textField_3.setEditable(true);
				textField_4.setEditable(true);
				
			}
			}
			});
			
		
		ButtonGroup editableGroup1 = new ButtonGroup();
	    editableGroup1.add(rdbtnClient);
	    editableGroup1.add(rdbtnSupplier);
	    
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(275, 23, 45, 13);
		panel_1.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(330, 20, 96, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblOrderInfo = new JLabel("Order Info");
		lblOrderInfo.setBounds(185, 58, 57, 13);
		panel_1.add(lblOrderInfo);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 144, 416, 71);
		panel_1.add(textArea);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setBounds(10, 83, 77, 13);
		panel_1.add(lblProductName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 80, 96, 19);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(211, 83, 45, 13);
		panel_1.add(lblPrice);
		
		textField_2 = new JTextField();
		textField_2.setBounds(244, 80, 39, 19);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Provenance");
		lblQuantity.setBounds(293, 83, 57, 13);
		panel_1.add(lblQuantity);
		
		textField_3 = new JTextField();
		textField_3.setBounds(358, 81, 78, 16);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(10, 114, 57, 13);
		panel_1.add(lblDescription);
		
		textField_4 = new JTextField();
		textField_4.setBounds(94, 108, 96, 19);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblQuantity_1 = new JLabel("Quantity");
		lblQuantity_1.setBounds(197, 114, 45, 13);
		panel_1.add(lblQuantity_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(244, 108, 39, 19);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblType_1 = new JLabel("Type");
		lblType_1.setBounds(293, 114, 45, 13);
		panel_1.add(lblType_1);
		
		JRadioButton rdbtnVeggie = new JRadioButton("Veggie");
		rdbtnVeggie.setBounds(323, 102, 57, 21);
		panel_1.add(rdbtnVeggie);
		
		JRadioButton rdbtnFruit = new JRadioButton("Fruit");
		rdbtnFruit.setBounds(323, 121, 57, 21);
		panel_1.add(rdbtnFruit);
		ButtonGroup editableGroup2 = new ButtonGroup();
	    editableGroup2.add(rdbtnFruit);
	    editableGroup2.add(rdbtnVeggie);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(181, 219, 85, 21);
		panel_1.add(btnConfirm);
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnClient.isSelected()) {
				int clientID=Integer.parseInt(textField.getText());
				db.addOrder(clientID);
				}
			    System.exit(0);
			}
		});
		JButton btnAdd = new JButton("Add");
		
		btnAdd.setBounds(375, 121, 61, 21);
		panel_1.add(btnAdd);
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(rdbtnClient.isSelected())
				{
					String productName=textField_1.getText();
					int productQuantity=Integer.parseInt(textField_5.getText());
					db.addToOrderedItems(productName, productQuantity);
					
				}
				if(rdbtnSupplier.isSelected())
				{
				String productName=textField_1.getText();
				int productQuantity=Integer.parseInt(textField_5.getText());
				double productPrice=Double.parseDouble(textField_2.getText());
				String productProvenance=textField_3.getText();
				String productDescription=textField_4.getText();
				int productType=0;
				if(rdbtnVeggie.isSelected())
				{
					productType=1;
				}
				int supplierID=Integer.parseInt(textField.getText());
				db.insertNewProduct(productName, productQuantity, productPrice, productProvenance, productDescription, productType, supplierID);
			
				}
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				editableGroup2.clearSelection();
				
		}
		
	});

	}
}
