
/**
 * @author ${ Abhinav }
 * <p>
 * ${ Main Frame class }
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import duties.AddPassword;
import duties.AddUser;
import duties.PauseUser;
import duties.RemoveUser;
import duties.UnPauseUser;
import roles.Student;
import utils.Commons;

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

		JLabel header = Commons.defineLabel("Student Reservation Queue", new Font("SansSerif", Font.BOLD, 18), 400, 50, 189,
				26);
		mainFrame.getContentPane().add(header);

		JLabel emptyLabel = Commons.defineLabel("Queue is Empty", new Font("SansSerif", Font.PLAIN, 15), 435, 198, 205,
				37);

		JButton addBtn = Commons.defineButton(new Font("Roboto", Font.BOLD, 14), Color.WHITE, Color.BLACK, "Add User",
				137, 120, 129, 38);
		mainFrame.getContentPane().add(addBtn);

		addBtn.addActionListener(e -> {
			AddUser user = new AddUser();
			user.setVisible(true);
			addUser(user, emptyLabel);
		});

		JButton removeBtn = Commons.defineButton(new Font("Roboto", Font.BOLD, 14), Color.WHITE, Color.BLACK,
				"Remove User", 307, 120, 149, 38);
		removeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
				int selectedRow = displayTable.getSelectedRow();
				removeUser(model, selectedRow, emptyLabel);				
			}
		});
		mainFrame.getContentPane().add(removeBtn);

		JButton pauseBtn = Commons.defineButton(new Font("Roboto", Font.BOLD, 14), Color.GREEN, Color.BLACK, "Pause",
				521, 120, 129, 38);
		mainFrame.getContentPane().add(pauseBtn);
		pauseBtn.addActionListener(e -> {
			TableModel modelPause = displayTable.getModel();
			int selectedRowPause = displayTable.getSelectedRow();
			pauseUser(modelPause, selectedRowPause);
		});

		JButton upauseBtn = Commons.defineButton(new Font("Roboto", Font.BOLD, 14), Color.RED, Color.BLACK, "UnPause",
				696, 120, 163, 38);
		mainFrame.getContentPane().add(upauseBtn);
		upauseBtn.addActionListener(e -> {
			TableModel modelUnpause = displayTable.getModel();
			int selectedRowUnpause = displayTable.getSelectedRow();
			unPauseUser(modelUnpause, selectedRowUnpause);
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 248, 721, 415);
		mainFrame.getContentPane().add(scrollPane);
		Object[] headers = new String[] { "Queue Order", "Name", "Status" };
		int value = new Random().nextInt(4);
		Object[][] data = { { 1, "John", Student.Status.UNPAUSED.toString() }, { 2, "Jane", Student.Status.UNPAUSED.toString() }, { 3, "Joe", Student.Status.UNPAUSED.toString() }, { 4, "Jain", Student.Status.UNPAUSED.toString() }, };
		displayTable = new JTable(new DefaultTableModel(new Object[0][0], headers));
		if (value != 0) {
			for (int i = 0; i < value; i++) {
				DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
				data[i][0] = i + 1;
				model.addRow(data[i]);
			}
		} else {
			mainFrame.getContentPane().add(emptyLabel);
			emptyLabel.setVisible(true);
		}

		scrollPane.setViewportView(displayTable);

//		mainFrame.getContentPane().add(emptyLabel);

		displayTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() == 1) { // to detect doble click events
					DefaultTableModel model = (DefaultTableModel) displayTable.getModel();
					String value =  displayTable.getValueAt(displayTable.getSelectedRow(), 2).toString();
					if (value.equals(Student.Status.UNPAUSED.toString())) {
						upauseBtn.setEnabled(false);
						pauseBtn.setEnabled(true);
					} else {
						upauseBtn.setEnabled(true);
						pauseBtn.setEnabled(false);
					}
				}
			}
		});
	}

	public void addEntryToTable(Object[] object, JLabel emptyLabel) {
		DefaultTableModel table = (DefaultTableModel) displayTable.getModel();
		object[0] = table.getRowCount() + 1;
		 table.addRow(object);
		if (checkForEmpty((DefaultTableModel) displayTable.getModel())) {
			mainFrame.getContentPane().add(emptyLabel);
			emptyLabel.setVisible(true);
		} else {
			emptyLabel.setVisible(false);
			mainFrame.getContentPane().remove(emptyLabel);
		}
	}

	public void pauseUser(TableModel model, int row) {
		PauseUser pause = new PauseUser();
		pause.pauseUser(model, row);
	}

	public void unPauseUser(TableModel model, int row) {
		UnPauseUser unPause = new UnPauseUser();
		unPause.unPauseUser(model, row);
	}

	public void addUser(AddUser user, JLabel emptyLabel) {
		user.submitBtn.addActionListener(e1 -> {
			Student student = user.addEntry();
			if (user.checkUser()) {
				JOptionPane.showMessageDialog(new JFrame(), "Username Or Email cannot be empty", "Error Message",
						JOptionPane.WARNING_MESSAGE);
			} else {
				user.dispose();
				AddPassword pwd = new AddPassword();
				pwd.setVisible(true);
				addPassword(pwd, student, emptyLabel);

			}

		});
	}

	public void addPassword(AddPassword pwd, Student student, JLabel emptyLabel) {
		pwd.submitBtn.addActionListener(e2 -> {
			pwd.insertPwd(student);
			pwd.dispose();
			map.put(student.getEmail(), new String[] { student.getUserName(), student.getPwd() });
			addEntryToTable(new Object[] { 0, student.getUserName(), Student.Status.UNPAUSED.toString() }, emptyLabel);
		});
	}

	public void removeUser(DefaultTableModel model, int row, JLabel emptyLabel) {
		RemoveUser user = new RemoveUser();
		user.removeUser(model, row, (DefaultTableModel) displayTable.getModel(), mainFrame, emptyLabel);		
	}

	public static boolean checkForEmpty(DefaultTableModel displayTable) {
		return displayTable.getRowCount() == 0;
	}
}
