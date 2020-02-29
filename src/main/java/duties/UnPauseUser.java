package duties;

/**
 * Created By ReddyGadu
 * Created On 2/23/20
 * Project Name StudentList
 **/

import roles.Student;

import javax.swing.*;
import javax.swing.table.TableModel;

/**
 * Created By ReddyGadu
 * Created On 2/23/20
 * Project Name StudentList
 **/
public class UnPauseUser {

    public void unPauseUser(TableModel model, int row) {
        if (row < 0) {
            JOptionPane.showMessageDialog(new JFrame(), "Please select a user", "Error Message", JOptionPane.WARNING_MESSAGE);
            return;
        }
//        String email = (String) model.getValueAt(row, 0);
        String status = (String) model.getValueAt(row, 2);
        if (!status.equals("UNPAUSE")) {
            AddPassword pwd = new AddPassword();
            pwd.setVisible(true);
            pwd.submitBtn.addActionListener(e -> {
                //TODO validate pwd
                model.setValueAt(Student.Status.UNPAUSE.toString(), row, 2);
                pwd.dispose();
            });
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "This entry is already unpaused", "Error Message", JOptionPane.WARNING_MESSAGE);
        }

    }
}
