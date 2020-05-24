package uk.ac.forthvalley.gradedunit.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * The Class that deal with the GUI to select if is a new or an old user
 * @author Davide Kovac 
 *
 */
public class EnterStockChangesUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterStockChangesUI frame = new EnterStockChangesUI();
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
	public EnterStockChangesUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblEnterStockChanges = new JLabel("Enter Stock changes");
		panel.add(lblEnterStockChanges);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("New user");
		btnNewButton.setBounds(166, 30, 101, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUserUI userUI=new NewUserUI();
				userUI.setVisible(true);
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Old User");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addingStockUI addingStockUI= new addingStockUI();
				addingStockUI.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(166, 116, 101, 21);
		panel_1.add(btnNewButton_1);
	}

}
