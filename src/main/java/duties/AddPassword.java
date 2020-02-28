package duties;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import roles.Student;
import utils.Commons;

/**
 * Created By ReddyGadu Created On 2/24/20 Project Name StudentList
 **/
public class AddPassword extends JFrame {
	private JPanel contentPane;
	public JPasswordField pwdBox;
	public JButton submitBtn;
	private String password;

	public AddPassword() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 508, 333);
		contentPane = Commons.definePanel(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel label = Commons.defineLabel("Create a session password to conitnue", new Font("Roboto", Font.BOLD, 16),
				94, 61, 319, 33);
		contentPane.add(label);

		pwdBox = new JPasswordField();
		pwdBox.setBounds(133, 125, 224, 33);
		contentPane.add(pwdBox);

		submitBtn = Commons.defineButton(null, null, null, "Submit", 201, 198, 97, 33);
		contentPane.add(submitBtn);
	}

	public void insertPwd(Student student) {
		student.setPwd(pwdBox.getPassword().toString());
	}

}
