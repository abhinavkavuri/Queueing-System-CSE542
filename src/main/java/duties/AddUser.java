package duties;

import roles.Student;
import utils.Commons;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created By ReddyGadu
 * Created On 2/23/20
 * Project Name StudentList
 **/
public class AddUser extends JFrame {
    private JTextField userBox;
    private JTextField emailBox;
    private JPanel contentPane;
    public JButton submitBtn;
    private AddUser user;

    public AddUser() {
        user = this;
        contentPane = Commons.definePanel(new EmptyBorder(5, 5, 5, 5));
        this.setBounds(100, 100, 600, 400);
        this.setContentPane(contentPane);

        userBox = Commons.defineTextField(new Font("SansSerif", Font.PLAIN, 14),
                "Enter your name", 241, 129, 201, 36, 10);
        contentPane.add(userBox);

        emailBox = Commons.defineTextField(new Font("SansSerif", Font.PLAIN, 14),
                "Enter your mail", 241, 204, 201, 36, 10);
        contentPane.add(emailBox);

        JLabel userLbl = Commons.defineLabel("Username:",
                new Font("Roboto", Font.BOLD, 14), 122, 133, 91, 26);
        contentPane.add(userLbl);

        JLabel emailLbl = Commons.defineLabel("Email:",
                new Font("Roboto", Font.BOLD, 14), 141, 208, 56, 26);
        contentPane.add(emailLbl);

        submitBtn = Commons.defineButton(null, null, null, "Proceed", 339, 264, 103, 26);
        contentPane.add(submitBtn);
    }

    public Student addEntry() {
        String username = userBox.getText();
        String email = emailBox.getText();
        final Student student = new Student(username, email, Student.Status.UNPAUSE);
        return student;
    }

}
