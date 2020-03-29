package uk.ac.forthvalley.gradedunit.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;

public class NewUserUI extends JFrame {

	private JPanel contentPane;

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
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JRadioButton rdbtnClient = new JRadioButton("Client");
		GridBagConstraints gbc_rdbtnClient = new GridBagConstraints();
		gbc_rdbtnClient.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnClient.gridx = 3;
		gbc_rdbtnClient.gridy = 1;
		panel_1.add(rdbtnClient, gbc_rdbtnClient);
		
		JLabel lblNewLabel = new JLabel("Type");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JRadioButton rdbtnSupplier = new JRadioButton("Supplier");
		GridBagConstraints gbc_rdbtnSupplier = new GridBagConstraints();
		gbc_rdbtnSupplier.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnSupplier.gridx = 3;
		gbc_rdbtnSupplier.gridy = 2;
		panel_1.add(rdbtnSupplier, gbc_rdbtnSupplier);
	}

}
