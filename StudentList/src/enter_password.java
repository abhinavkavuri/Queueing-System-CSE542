import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class enter_password extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private String password = "";
	private enter_password current;

	protected String getPwd() {
		return password;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					enter_password frame = new enter_password();
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
	public enter_password() {
		current = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Create a session password to conitnue");
		lblNewLabel.setBounds(94, 61, 319, 33);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 16));
		contentPane.add(lblNewLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(133, 125, 224, 33);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(201, 198, 97, 33);
		contentPane.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				current.password = passwordField.getPassword().toString();
				current.dispose();
			}
		});
	}
}
