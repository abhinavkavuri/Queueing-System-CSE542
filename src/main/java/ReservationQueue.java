
/**
 * @author ${ Abhinav }
 * <p>
 * ${ Main Frame class }
 */

import duties.*;
import roles.Student;
import utils.Commons;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ReservationQueue {

    private JFrame mainFrame;
    protected static JTable displayTable;
    public static Map<String, String[]> map = new HashMap<>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReservationQueue window = new ReservationQueue();
                    window.mainFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ReservationQueue() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        mainFrame = new JFrame();
        mainFrame.setBounds(100, 100, 1000, 800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setLayout(null);

        JLabel header = Commons.defineLabel("Reservation Queue",
                new Font("SansSerif", Font.BOLD, 20),
                400, 50, 189, 26);
        mainFrame.getContentPane().add(header);


        JButton addBtn = Commons.defineButton(new Font("Roboto", Font.BOLD, 14),
                Color.WHITE, Color.BLACK, "Add User", 137, 120, 129, 38);
        mainFrame.getContentPane().add(addBtn);

        addBtn.addActionListener(e -> {
            AddUser user = new AddUser();
            user.setVisible(true);
            addUser(user);


        });

        JButton removeBtn = Commons.defineButton(new Font("Roboto", Font.BOLD, 14),
                Color.WHITE, Color.BLACK, "Remove User", 307, 120, 149, 38);
        removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
                int selectedRow = displayTable.getSelectedRow();
                removeUser(model, selectedRow);
            }
        });
        mainFrame.getContentPane().add(removeBtn);


        JButton pauseBtn = Commons.defineButton(new Font("Roboto", Font.BOLD, 14),
                Color.GREEN, Color.BLACK, "Pause", 521, 120, 129, 38);
        mainFrame.getContentPane().add(pauseBtn);
        pauseBtn.addActionListener(e -> {
            TableModel modelPause = displayTable.getModel();
            int selectedRowPause = displayTable.getSelectedRow();
            pauseUser(modelPause, selectedRowPause);
        });


        JButton upauseBtn = Commons.defineButton(new Font("Roboto", Font.BOLD, 14),
                Color.RED, Color.BLACK, "UnPause", 696, 120, 163, 38);
        mainFrame.getContentPane().add(upauseBtn);
        upauseBtn.addActionListener(e -> {
            TableModel modelUnpause = displayTable.getModel();
            int selectedRowUnpause = displayTable.getSelectedRow();
            unPauseUser(modelUnpause, selectedRowUnpause);
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(138, 248, 721, 415);
        mainFrame.getContentPane().add(scrollPane);
        Object[] headers = new String[]{"Email", "Name", "Status"};
        Object[][] data = {{"xy2gmail.com", "vamsi", Student.Status.UNPAUSE.toString()}, {"xy2gmail.com", "vamsi", Student.Status.UNPAUSE.toString()}};
        displayTable = new JTable(new DefaultTableModel(data, headers));
        scrollPane.setViewportView(displayTable);
    }

    public void addEntryToTable(Object[] object) {
        DefaultTableModel table = (DefaultTableModel) displayTable.getModel();
        table.addRow(object);
    }

    public void pauseUser(TableModel model, int row) {
        PauseUser pause = new PauseUser();
        pause.pauseUser(model, row);
    }

    public void unPauseUser(TableModel model, int row) {
        UnPauseUser unPause = new UnPauseUser();
        unPause.unPauseUser(model, row);
    }

    public void addUser(AddUser user) {
        user.submitBtn.addActionListener(e1 -> {
            Student student = user.addEntry();
            user.dispose();
            AddPassword pwd = new AddPassword();
            pwd.setVisible(true);
            addPassword(pwd, student);
        });
    }

    public void addPassword(AddPassword pwd, Student student) {
        pwd.submitBtn.addActionListener(e2 -> {
            pwd.insertPwd(student);
            pwd.dispose();
            map.put(student.getEmail(), new String[]{student.getUserName(), student.getPwd()});
            addEntryToTable(new Object[]{student.getEmail(), student.getUserName(), student.getStatus()});
        });
    }

    public void removeUser(DefaultTableModel model, int row) {
        RemoveUser user = new RemoveUser();
        user.removeUser(model, row);
    }
}
