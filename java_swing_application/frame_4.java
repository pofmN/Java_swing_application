package Do_an_own;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JSeparator;

public class frame_4 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_4;
	private JTextField textField_5;
	JTable table;
	JTable table_1;
	Vector vectordata = new Vector();
	Vector vector = new Vector();
	Vector vectordata1 = new Vector(100, 100);
	Vector vector1 = new Vector();
	DefaultTableModel dft;
	DefaultTableModel dft1;
	int selectedrow = 0;
	int selectedrow1 = 0;
	private JTextField textFieldID_Employ;
	private JTextField textFieldfullname;
	private JTextField textFieldphone;
	private JTextField textFieldemail;
	private JTextField textFieldaddress;
	JComboBox comboBoxrole = new JComboBox();
	static Connection conn;
	static PreparedStatement prs;
	static ResultSet rs;
	private JTextField textFieldbirthday;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame_4 frame = new frame_4();
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
	@SuppressWarnings("unchecked")
	public frame_4() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Preppy-icon.png"));
		setTitle("EMPLOYEE MANAGEMENT - System Administrator");
		setBounds(100, 100, 1014, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(44, 32, 909, 604);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.light"));
		tabbedPane.addTab("Employee Information",
				new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Preppy-icon.png"), panel, null);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-search-material-filled\\icons8-search-18.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(736, 252, 130, 37);
		panel.add(btnNewButton);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});

		btnDelete.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-trash-material-filled\\icons8-trash-18.png"));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(736, 203, 130, 37);
		panel.add(btnDelete);

		comboBoxrole.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxrole.setModel(new DefaultComboBoxModel(new String[] { "", "Network Administrator",
				"Network Engineering", "Application Developer", "Application Quality Tester", "IT Director",
				"Chief Information Officer (CIO)", "Project Manager" }));
		comboBoxrole.setBounds(192, 158, 189, 24);
		panel.add(comboBoxrole);

		JButton btnAdd = new JButton("Add ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});

		btnAdd.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-add-user-male-material-filled\\icons8-add-user-male-18.png"));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(400, 203, 130, 37);
		panel.add(btnAdd);

		reload();

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearch.setBounds(360, 258, 102, 24);
		panel.add(lblSearch);

		textField_5 = new JTextField();

		textField_5.setColumns(10);
		textField_5.setBounds(428, 255, 275, 31);
		panel.add(textField_5);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(39, 297, 827, 257);
		panel.add(scrollPane_1);

		table = new JTable(vectordata, vector);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedrow = table.getSelectedRow();
			}
		});
		scrollPane_1.setViewportView(table);

		JLabel lblNewLabel = new JLabel("ID_Employee");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(72, 24, 110, 23);
		panel.add(lblNewLabel);

		textFieldID_Employ = new JTextField();
		textFieldID_Employ.setBounds(192, 26, 189, 23);
		panel.add(textFieldID_Employ);
		textFieldID_Employ.setColumns(10);

		JLabel lblFullname = new JLabel("Fullname");
		lblFullname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFullname.setBounds(454, 28, 110, 23);
		panel.add(lblFullname);

		textFieldfullname = new JTextField();
		textFieldfullname.setColumns(10);
		textFieldfullname.setBounds(597, 26, 189, 23);
		panel.add(textFieldfullname);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 192, 884, 14);
		panel.add(separator);

		JLabel lblPhonenumber = new JLabel("Phonenumber");
		lblPhonenumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhonenumber.setBounds(454, 68, 110, 23);
		panel.add(lblPhonenumber);

		textFieldphone = new JTextField();
		textFieldphone.setColumns(10);
		textFieldphone.setBounds(597, 68, 189, 23);
		panel.add(textFieldphone);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(72, 110, 110, 23);
		panel.add(lblEmail);

		textFieldemail = new JTextField();
		textFieldemail.setColumns(10);
		textFieldemail.setBounds(192, 112, 189, 23);
		panel.add(textFieldemail);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(454, 112, 110, 23);
		panel.add(lblAddress);

		textFieldaddress = new JTextField();
		textFieldaddress.setColumns(10);
		textFieldaddress.setBounds(597, 112, 189, 23);
		panel.add(textFieldaddress);

		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRole.setBounds(72, 159, 110, 23);
		panel.add(lblRole);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit();
			}
		});
		btnEdit.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-edit-material-filled\\icons8-edit-18.png"));
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdit.setBounds(573, 203, 130, 37);
		panel.add(btnEdit);

		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBirthday.setBounds(72, 68, 110, 23);
		panel.add(lblBirthday);

		textFieldbirthday = new JTextField();
		textFieldbirthday.setColumns(10);
		textFieldbirthday.setBounds(192, 70, 189, 23);
		panel.add(textFieldbirthday);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp();
			}
		});
		btnRefresh.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-refresh-material-filled\\icons8-refresh-18.png"));
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRefresh.setBounds(221, 203, 130, 37);
		panel.add(btnRefresh);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.light"));
		tabbedPane.addTab("Employee Account",
				new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\reseller-account-icon.png"), panel_1, null);
		panel_1.setLayout(null);

		reload2();
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(21, 181, 859, 364);
		panel_1.add(scrollPane1);

		table_1 = new JTable(vectordata1, vector1);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedrow1 = table_1.getSelectedRow();
			}
		});
		scrollPane1.setViewportView(table_1);

		JLabel lblNewLabel_1_1 = new JLabel("Search");
		lblNewLabel_1_1.setBounds(217, 51, 111, 31);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblNewLabel_1_1);

		textField_4 = new JTextField();
		textField_4.setBounds(285, 55, 258, 27);
		textField_4.setColumns(10);
		panel_1.add(textField_4);

		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBounds(570, 51, 111, 31);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sqlServer2 = "jdbc:sqlserver://LAPTOP-EUQVAG1I\\SQLEXPRESS;databasename=EmployeeManagement;user=sa;password=123456789";
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection connection2 = DriverManager.getConnection(sqlServer2);

					String sql2 = "Select * from Account WHERE (Fullname LIKE '%" + textField_4.getText()
							+ "%') OR (ID_Employee LIKE '%" + textField_4.getText() + "%')";

					PreparedStatement ps2 = connection2.prepareStatement(sql2);
					ResultSet rst2 = ps2.executeQuery();

					DefaultTableModel dft2 = (DefaultTableModel) table_1.getModel();
					dft2.setRowCount(0);
					if (rst2 == null) {
						System.out.println("EMPTY");
					}
					while (rst2.next()) {

						String a = rst2.getString("Username");
						String a1 = rst2.getString("Password");
						String a2 = rst2.getString("ID_Employee");
						String a3 = rst2.getString("Fullname");

						dft2.addRow(new Object[] { a, a1, a2, a3 });

					}
					dft2.fireTableDataChanged();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Start-Menu-Search-icon.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete1();

			}
		});
		btnNewButton_1_1.setBounds(701, 51, 111, 31);
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Close-icon.png"));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnNewButton_1_1);

		JButton btnNewButton_1_1_1 = new JButton("Refresh");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp2();
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Button-Refresh-icon.png"));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_1.setBounds(701, 100, 111, 31);
		panel_1.add(btnNewButton_1_1_1);

		JButton btnHomepage = new JButton("Homepage");
		btnHomepage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				frame_2 frame2 = new frame_2();
				frame2.setVisible(true);
			}
		});
		btnHomepage.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\home_icoin0-small_nobg.png"));
		btnHomepage.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHomepage.setBounds(749, 10, 144, 37);
		contentPane.add(btnHomepage);

	}

	public void add() {
		try {

			String sql = "Insert into EmployInfor (ID_Employee, Fullname, Birthday, Phonenumber, Email, Address, Role) values ("
					+ textFieldID_Employ.getText() + ",'" + textFieldfullname.getText() + "', '"
					+ textFieldbirthday.getText() + "', '" + textFieldphone.getText() + "','" + textFieldemail.getText()
					+ "','" + textFieldaddress.getText() + "','" + comboBoxrole.getSelectedItem().toString() + "')";

			int record = executeDB(sql);
			if (record > 0)
				JOptionPane.showMessageDialog(null, "Success");
			temp();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void delete() {
		try {

			int record = executeDB(
					"Delete from EmployInfor where ID_Employee =" + table.getValueAt(selectedrow, 0).toString());
			if (record > 0)
				JOptionPane.showMessageDialog(null, "Success");
			temp();
		} catch (Exception e2) {
			// TODO: handle exception
		}

	}

	public void reload() {

		try {
			String sqlServer = "jdbc:sqlserver://LAPTOP-RG5QA0PH:1433;databasename=EmployeeManagement;user=sa;password=12032003";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection(sqlServer);
			Statement stm = connection.createStatement();
			ResultSet rst = stm.executeQuery("Select * from EmployInfor");

			ResultSetMetaData rstmeta = rst.getMetaData();
			int column = rstmeta.getColumnCount();

			for (int i = 1; i <= column; i++) {
				vector.add(rstmeta.getColumnLabel(i));
			}

			while (rst.next()) {
				Vector row = new Vector(column);
				for (int i = 1; i <= column; i++) {
					row.add(rst.getString(i));
				}
				vectordata.add(row);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void search() {
		try {
			connect();

			String sql = "Select * from EmployInfor WHERE (Fullname LIKE '%" + textField_5.getText()
					+ "%') OR (ID_Employee LIKE '" + textField_5.getText() + "') OR (Role LIKE '%"
					+ textField_5.getText() + "%')";

			prs = conn.prepareStatement(sql);
			rs = prs.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void reload2() {

		try {
			String sqlServer1 = "jdbc:sqlserver://LAPTOP-RG5QA0PH:1433;databasename=EmployeeManagement;user=sa;password=123456789";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection1 = DriverManager.getConnection(sqlServer1);
			Statement stm1 = connection1.createStatement();
			ResultSet rst1 = stm1
					.executeQuery("Select Account.Username, Account.ID_Employee, Account.Fullname from Account");

			ResultSetMetaData rstmeta1 = rst1.getMetaData();
			int column1 = rstmeta1.getColumnCount();

			for (int i = 1; i <= column1; i++) {
				vector1.add(rstmeta1.getColumnLabel(i));
			}

			while (rst1.next()) {
				Vector row1 = new Vector(column1);
				for (int i = 1; i <= column1; i++) {
					row1.add(rst1.getString(i));
				}
				vectordata1.add(row1);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void temp() {
		try {
			connect();
			prs = conn.prepareStatement("Select * from EmployInfor");
			rs = prs.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void connect() {
		try {
			String sqlServer = "jdbc:sqlserver://LAPTOP-RG5QA0PH:1433;databasename=EmployeeManagement;user=sa;password=123456789";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(sqlServer);
			Statement stm = conn.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public int executeDB(String sql) {
		int record = 0;// number of records have been changed in db
		try {
			connect();
			Statement stmt = conn.createStatement();
			record = stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return record;
	}

	public void edit() {
		try {

			String sql = "UPDATE EmployInfor SET Fullname = '" + table.getValueAt(selectedrow, 1).toString()
					+ "' , Birthday = '" + table.getValueAt(selectedrow, 2).toString() + "',Phonenumber = '"
					+ table.getValueAt(selectedrow, 3).toString() + "',Email = '"
					+ table.getValueAt(selectedrow, 4).toString() + "',Address = '"
					+ table.getValueAt(selectedrow, 5).toString() + "', Role = '"
					+ table.getValueAt(selectedrow, 6).toString() + "' WHERE ID_Employee = "
					+ table.getValueAt(selectedrow, 0).toString();

			int record = executeDB(sql);

			if (record > 0)
				JOptionPane.showMessageDialog(null, "Success");
			temp();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void delete1() {
		try {

			int record = executeDB(
					"Delete from Account where Username ='" + table_1.getValueAt(selectedrow1, 0).toString() + "'");
			if (record > 0)
				JOptionPane.showMessageDialog(null, "Success");
			temp2();
		} catch (Exception e2) {
			// TODO: handle exception
		}

	}

	public void temp2() {
		try {
			connect();
			prs = conn.prepareStatement("Select Account.Username, Account.ID_Employee, Account.Fullname from Account");
			rs = prs.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
