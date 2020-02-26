package duties;

import roles.Student;
import utils.Commons;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created By ReddyGadu
 * Created On 2/24/20
 * Project Name StudentList
 **/
public class AddPassword extends  JFrame{
    private JPanel contentPane;
    public JPasswordField pwdBox;
    public JButton submitBtn;
    private String password;

    public AddPassword(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 508, 333);
        contentPane = Commons.definePanel(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel label = Commons.defineLabel("Create a session password to conitnue",
                new Font("Roboto", Font.BOLD, 16),94, 61, 319, 33);
        contentPane.add(label);

        pwdBox = new JPasswordField();
        pwdBox.setBounds(133, 125, 224, 33);
        contentPane.add(pwdBox);

        submitBtn = Commons.defineButton(null, null,null,"Submit",201, 198, 97, 33);
        contentPane.add(submitBtn);
    }

    public void insertPwd(Student student){
        student.setPwd(pwdBox.getPassword().toString());
    }

}
