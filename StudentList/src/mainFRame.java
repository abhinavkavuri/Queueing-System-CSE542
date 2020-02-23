
/**
 * @author ${ Abhinav }
 *
 * ${ Main Frame class }
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class mainFRame {

	private JFrame frame;
	protected static JTable table;
	public static Map<String, String[]> map = new HashMap<String, String[]>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFRame window = new mainFRame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainFRame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Queueing System");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel.setBounds(400, 50, 189, 26);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("+ Add Entry");
		btnNewButton.setBounds(137, 120, 129, 38);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Roboto", Font.BOLD, 14));
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Entry newbox = new Add_Entry();
				newbox.setVisible(true);

			}
		});

		JButton btnNewButton_1 = new JButton("- Remove Entry");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setFont(new Font("Roboto", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(307, 120, 149, 38);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("> Pause");
		btnNewButton_2.setBounds(521, 120, 129, 38);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Roboto", Font.BOLD, 14));
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("< Unpause");
		btnNewButton_3.setBounds(696, 120, 163, 38);
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setFont(new Font("Roboto", Font.BOLD, 14));
		frame.getContentPane().add(btnNewButton_3);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(138, 248, 721, 415);
		frame.getContentPane().add(scrollPane);
		Object[] headers = new String[] { "Email", "Name", "Status" };
		Object[][] data = { { "xy2gmail.com", "vamsi", "unpause" }, { "xy2gmail.com", "vamsi", "unpause" } };
		table = new JTable(new DefaultTableModel(data, headers));
		scrollPane.setViewportView(table);
	}
}
