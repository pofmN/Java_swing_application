package Do_an_own;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicTabbedPaneUI.TabbedPaneLayout;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Window.Type;

public class frame_2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table_1;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField txtIdemployee;
	private JTextField textField_7;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame_2 frame = new frame_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frame_2() {
		setTitle("System Administrator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//		URL url = frame_1.class.getResource("1.png");
//		Image image = Toolkit.getDefaultToolkit().createImage(url);
//		this.setIconImage(image);

		JButton btnNewButton = new JButton("Employee management");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frame_4 frame4 = new frame_4();
				frame4.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Preppy-icon.png"));
		btnNewButton.setBounds(28, 123, 227, 47);
		contentPane.add(btnNewButton);
		JButton btnProjectManagement = new JButton("Project management");
		btnProjectManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frame_5 frame5 = new frame_5();
				frame5.setVisible(true);
			}
		});
		btnProjectManagement
				.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Actions-project-open-icon.png"));
		btnProjectManagement.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnProjectManagement.setBounds(292, 123, 234, 47);
		contentPane.add(btnProjectManagement);

		JButton btnDepartmentManager = new JButton("Department management");
		btnDepartmentManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frame_6 frame6 = new frame_6();
				frame6.setVisible(true);
			}
		});
		btnDepartmentManager.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Management-icon.png"));
		btnDepartmentManager.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnDepartmentManager.setBounds(562, 123, 245, 47);
		contentPane.add(btnDepartmentManager);

		JLabel lblNewLabel = new JLabel("WELCOME TO SYSTEM ADMINISTRATOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(168, 49, 495, 39);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\system_admin_pic.jpg"));
		lblNewLabel_1.setBounds(118, 195, 612, 306);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Close\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(745, 510, 77, 27);
		contentPane.add(btnNewButton_2);

	}
}
