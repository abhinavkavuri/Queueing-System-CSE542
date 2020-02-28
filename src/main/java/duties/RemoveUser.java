package duties;

import roles.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * Created By ReddyGadu
 * Created On 2/23/20
 * Project Name StudentList
 **/
public class RemoveUser {
    public void removeUser(DefaultTableModel model, int row, DefaultTableModel table, JFrame mainFrame, JLabel emptyLabel){
        if(row < 0){
            JOptionPane.showMessageDialog(new JFrame(), "Please select a user", "Error Message", JOptionPane.WARNING_MESSAGE);
            return;
        }
//        String email = (String) model.getValueAt(row, 0);
        AddPassword pwd = new AddPassword();
        pwd.setVisible(true);
        pwd.submitBtn.addActionListener(e -> {
            //TODO validate pwd
            model.removeRow(row);
            setRowIds(model);
            if(checkForEmpty(table)){
                mainFrame.getContentPane().add(emptyLabel);
                emptyLabel.setVisible(true);
            }   else{
                emptyLabel.setVisible(false);
                mainFrame.getContentPane().remove(emptyLabel);
            }
            pwd.dispose();
        });
    }

    public void setRowIds(DefaultTableModel displayTable){
        int count = displayTable.getRowCount();
        for(int i=0;i<count;i++){
            displayTable.setValueAt(i+1, i,0);
        }
    }


    public static boolean checkForEmpty(DefaultTableModel displayTable){
        return displayTable.getRowCount() == 0;
    }
}
