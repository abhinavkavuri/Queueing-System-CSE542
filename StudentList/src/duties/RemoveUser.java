package duties;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Created By ReddyGadu
 * Created On 2/23/20
 * Project Name StudentList
 **/
public class RemoveUser {
    public void removeUser(DefaultTableModel model, int row){
        if(row < 0){
            JOptionPane.showMessageDialog(new JFrame(), "Please select a user", "Error Message", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String email = (String) model.getValueAt(row, 0);

        model.removeRow(row);
    }
}
