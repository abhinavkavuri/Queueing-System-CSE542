import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Add_Entry extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterUsername;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private String userName;
	private String email;
	private String status;
	private Add_Entry current;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Entry frame = new Add_Entry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public String getUserName() {
		return this.userName;
	}

	public String getEmail() {
		return this.email;
	}

	public String getStatus() {
		return this.status;
	}

	/**
	 * Create the frame.
	 */
	public Add_Entry() {
		current = this;
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtEnterUsername = new JTextField();
		txtEnterUsername.setFont(new Font("SansSerif", Font.PLAIN, 14));
		txtEnterUsername.setToolTipText("Enter your name");
		txtEnterUsername.setBounds(241, 129, 201, 36);
		contentPane.add(txtEnterUsername);
		txtEnterUsername.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		textField_1.setToolTipText("Enter your e-mail");
		textField_1.setBounds(241, 204, 201, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(122, 133, 91, 26);
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 14));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("E-mail:");
		lblNewLabel_1.setBounds(141, 208, 56, 26);
		lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 14));
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Type username and email to enter queue");
		lblNewLabel_2.setBounds(122, 45, 324, 36);
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 16));
		contentPane.add(lblNewLabel_2);

		btnNewButton = new JButton("proceed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String username = txtEnterUsername.getText();
				String email = textField_1.getText();
				String status = "unpaused";
				DefaultTableModel table = (DefaultTableModel) mainFRame.table.getModel();
				table.addRow(new Object[] { email, username, status });
				current.dispose();
				enter_password newpass = new enter_password();
				newpass.setVisible(true);
				String pwd = newpass.getPwd();
				mainFRame.map.put(email, new String[] { username, pwd });
				System.out.println(pwd);
				System.out.println(mainFRame.map);
			}
		});
		btnNewButton.setBounds(339, 264, 103, 26);
		contentPane.add(btnNewButton);
	}
}
