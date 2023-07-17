package Do_an_own;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class frame_6 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldsearch;
	private JTextField textFieldIDdepartLeader;
	private JTextField textFieldnamedepart;
	private JTextField textFieldIDdepart;
	int selectedrow = 0;
	int selectedrow1 = 0;
	int selectedrow2 = 0;
	int selectedrow3 = 0;
	Vector vector = new Vector();
	Vector vectordata = new Vector();
	Vector vector1 = new Vector();
	Vector vectordata1 = new Vector();
	Vector vector2 = new Vector();
	Vector vectordata2 = new Vector();
	Vector vector3 = new Vector();
	Vector vectordata3 = new Vector();
	static Connection conn;
	static PreparedStatement prs;
	static ResultSet rs;

	JComboBox comboBoxstatus = new JComboBox();
	DefaultTableModel dft;
	DefaultTableModel dft1;
	JTable table;
	private JTextField textFieldIDemployee;
	private JTextField textFieldsearch1;
	private JTextField textFieldIDexma;
	JTable table_1;
	private JTextField textFieldIDAppPro;
	private JTextField textFieldIDemploy3;
	private JTextField textFieldsearch3;
	JTable table_2;
	private JTextField textFieldNetAd;
	private JTextField textFieldIDemploy4;
	private JTextField textFieldsearch4;
	JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame_6 frame = new frame_6();
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
	public frame_6() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Management-icon.png"));
		setTitle("DEPARTMENT MANAGEMENT - System Administrator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
		btnHomepage.setBounds(740, 10, 144, 37);
		contentPane.add(btnHomepage);

		reload();

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 62, 893, 590);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Department Information",
				new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\reseller-account-icon (1).png"), panel, null);
		panel.setLayout(null);

		JLabel lblIddepartment = new JLabel("ID_Department");
		lblIddepartment.setBounds(10, 20, 130, 23);
		panel.add(lblIddepartment);
		lblIddepartment.setFont(new Font("Tahoma", Font.BOLD, 14));

		textFieldIDdepart = new JTextField();
		textFieldIDdepart.setBounds(165, 22, 220, 23);
		panel.add(textFieldIDdepart);
		textFieldIDdepart.setColumns(10);

		JLabel lblNameOfDepartment = new JLabel("Name of Department");
		lblNameOfDepartment.setBounds(10, 65, 176, 23);
		panel.add(lblNameOfDepartment);
		lblNameOfDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));

		textFieldnamedepart = new JTextField();
		textFieldnamedepart.setBounds(165, 67, 220, 23);
		panel.add(textFieldnamedepart);
		textFieldnamedepart.setColumns(10);

		textFieldIDdepartLeader = new JTextField();
		textFieldIDdepartLeader.setBounds(616, 65, 152, 23);
		panel.add(textFieldIDdepartLeader);
		textFieldIDdepartLeader.setColumns(10);

		JLabel lblIdOfDepartment = new JLabel("ID of Department Leader");
		lblIdOfDepartment.setBounds(427, 63, 220, 23);
		panel.add(lblIdOfDepartment);
		lblIdOfDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 269, 863, 262);
		panel.add(scrollPane);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedrow = table.getSelectedRow();
			}
		});

		table = new JTable(vectordata, vector);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedrow3 = table_3.getSelectedRow();
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(340, 216, 102, 24);
		panel.add(lblSearch);
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 14));

		textFieldsearch = new JTextField();
		textFieldsearch.setBounds(408, 216, 275, 24);
		panel.add(textFieldsearch);
		textFieldsearch.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(744, 210, 130, 37);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-search-material-filled\\icons8-search-18.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(576, 163, 130, 37);
		panel.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit();
			}
		});
		btnEdit.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-edit-material-filled\\icons8-edit-18.png"));
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(744, 163, 130, 37);
		panel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-trash-material-filled\\icons8-trash-18.png"));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 150, 893, 14);
		panel.add(separator);

		JButton btnAdd = new JButton("Add ");
		btnAdd.setBounds(744, 103, 130, 37);
		panel.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		btnAdd.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-add-user-male-material-filled\\icons8-add-user-male-18.png"));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp();
			}
		});
		btnRefresh.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-refresh-material-filled\\icons8-refresh-18.png"));
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRefresh.setBounds(414, 163, 130, 37);
		panel.add(btnRefresh);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Executive - Management ",
				new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\User-Executive-Green-icon (1).png"), panel_1,
				null);
		panel_1.setLayout(null);

		JLabel lblIdexcutemana = new JLabel("ID_Excute_Mana");
		lblIdexcutemana.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdexcutemana.setBounds(48, 33, 130, 23);
		panel_1.add(lblIdexcutemana);

		JLabel lblIdemployee = new JLabel("ID_Employee");
		lblIdemployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdemployee.setBounds(409, 33, 176, 23);
		panel_1.add(lblIdemployee);

		textFieldIDemployee = new JTextField();
		textFieldIDemployee.setColumns(10);
		textFieldIDemployee.setBounds(532, 35, 220, 23);
		panel_1.add(textFieldIDemployee);

		JButton btnAdd_1 = new JButton("Add ");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add1();
			}
		});
		btnAdd_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Button-Add-icon.png"));
		btnAdd_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd_1.setBounds(744, 87, 130, 37);
		panel_1.add(btnAdd_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 134, 893, 14);
		panel_1.add(separator_1);

		JButton btnEdit_1 = new JButton("Edit");
		btnEdit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit1();
			}
		});
		btnEdit_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Actions-document-edit-icon.png"));
		btnEdit_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdit_1.setBounds(575, 178, 130, 37);
		panel_1.add(btnEdit_1);

		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete1();
			}
		});
		btnDelete_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Close-icon.png"));
		btnDelete_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete_1.setBounds(744, 178, 130, 37);
		panel_1.add(btnDelete_1);

		JLabel lblSearch_1 = new JLabel("Search");
		lblSearch_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearch_1.setBounds(340, 231, 102, 24);
		panel_1.add(lblSearch_1);

		textFieldsearch1 = new JTextField();
		textFieldsearch1.setColumns(10);
		textFieldsearch1.setBounds(408, 231, 275, 24);
		panel_1.add(textFieldsearch1);

		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search1();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Start-Menu-Search-icon.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(744, 225, 130, 37);
		panel_1.add(btnNewButton_1);

		textFieldIDexma = new JTextField();
		textFieldIDexma.setColumns(10);
		textFieldIDexma.setBounds(188, 35, 152, 23);
		panel_1.add(textFieldIDexma);

		reload1();
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 293, 837, 254);
		panel_1.add(scrollPane_1);

		table_1 = new JTable(vectordata1, vector1);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedrow1 = table_1.getSelectedRow();
			}
		});
		scrollPane_1.setViewportView(table_1);

		JButton btnRefresh_1 = new JButton("Refresh");
		btnRefresh_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp1();
			}
		});
		btnRefresh_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Button-Refresh-icon.png"));
		btnRefresh_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRefresh_1.setBounds(409, 178, 130, 37);
		panel_1.add(btnRefresh_1);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Application Programming ",
				new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Preppy-icon (1).png"), panel_2, null);
		panel_2.setLayout(null);

		JLabel lblIdApp = new JLabel("ID Application Programming");
		lblIdApp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdApp.setBounds(48, 32, 205, 23);
		panel_2.add(lblIdApp);

		textFieldIDAppPro = new JTextField();
		textFieldIDAppPro.setColumns(10);
		textFieldIDAppPro.setBounds(261, 34, 152, 23);
		panel_2.add(textFieldIDAppPro);

		JLabel lblIdemployee_1 = new JLabel("ID_Employee");
		lblIdemployee_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdemployee_1.setBounds(464, 32, 176, 23);
		panel_2.add(lblIdemployee_1);

		textFieldIDemploy3 = new JTextField();
		textFieldIDemploy3.setColumns(10);
		textFieldIDemploy3.setBounds(577, 34, 176, 23);
		panel_2.add(textFieldIDemploy3);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(0, 133, 893, 14);
		panel_2.add(separator_1_1);

		JButton btnAdd_1_1 = new JButton("Add ");
		btnAdd_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add2();
			}
		});
		btnAdd_1_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Button-Add-icon.png"));
		btnAdd_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd_1_1.setBounds(744, 86, 130, 37);
		panel_2.add(btnAdd_1_1);

		JButton btnEdit_1_1 = new JButton("Edit");
		btnEdit_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit2();
			}
		});
		btnEdit_1_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Actions-document-edit-icon.png"));
		btnEdit_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdit_1_1.setBounds(574, 177, 130, 37);
		panel_2.add(btnEdit_1_1);

		JButton btnDelete_1_1 = new JButton("Delete");
		btnDelete_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete2();
			}
		});
		btnDelete_1_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Close-icon.png"));
		btnDelete_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete_1_1.setBounds(744, 177, 130, 37);
		panel_2.add(btnDelete_1_1);

		JButton btnNewButton_1_1 = new JButton("Search");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search2();
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Start-Menu-Search-icon.png"));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.setBounds(744, 224, 130, 37);
		panel_2.add(btnNewButton_1_1);

		textFieldsearch3 = new JTextField();
		textFieldsearch3.setColumns(10);
		textFieldsearch3.setBounds(408, 230, 275, 24);
		panel_2.add(textFieldsearch3);

		JLabel lblSearch_1_1 = new JLabel("Search");
		lblSearch_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearch_1_1.setBounds(340, 230, 102, 24);
		panel_2.add(lblSearch_1_1);

		reload2();
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(37, 293, 820, 249);
		panel_2.add(scrollPane_2);

		table_2 = new JTable(vectordata2, vector2);
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedrow2 = table_2.getSelectedRow();
			}
		});
		scrollPane_2.setViewportView(table_2);

		JButton btnRefresh_2 = new JButton("Refresh");
		btnRefresh_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp2();
			}
		});
		btnRefresh_2.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Button-Refresh-icon.png"));
		btnRefresh_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRefresh_2.setBounds(408, 177, 130, 37);
		panel_2.add(btnRefresh_2);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Network Administrator ",
				new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\administrator-icon.png"), panel_3, null);
		panel_3.setLayout(null);

		JLabel lblIdNetworkAdministrtor = new JLabel("ID Network Administrator");
		lblIdNetworkAdministrtor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdNetworkAdministrtor.setBounds(48, 35, 205, 23);
		panel_3.add(lblIdNetworkAdministrtor);

		textFieldNetAd = new JTextField();
		textFieldNetAd.setColumns(10);
		textFieldNetAd.setBounds(261, 37, 152, 23);
		panel_3.add(textFieldNetAd);

		JLabel lblIdemployee_1_1 = new JLabel("ID_Employee");
		lblIdemployee_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdemployee_1_1.setBounds(464, 35, 176, 23);
		panel_3.add(lblIdemployee_1_1);

		textFieldIDemploy4 = new JTextField();
		textFieldIDemploy4.setColumns(10);
		textFieldIDemploy4.setBounds(577, 37, 176, 23);
		panel_3.add(textFieldIDemploy4);

		JButton btnAdd_1_1_1 = new JButton("Add ");
		btnAdd_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add3();
			}
		});
		btnAdd_1_1_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Button-Add-icon.png"));
		btnAdd_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd_1_1_1.setBounds(744, 89, 130, 37);
		panel_3.add(btnAdd_1_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(0, 136, 893, 14);
		panel_3.add(separator_1_1_1);

		JButton btnEdit_1_1_1 = new JButton("Edit");
		btnEdit_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit3();
			}
		});
		btnEdit_1_1_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Actions-document-edit-icon.png"));
		btnEdit_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdit_1_1_1.setBounds(574, 180, 130, 37);
		panel_3.add(btnEdit_1_1_1);

		JButton btnDelete_1_1_1 = new JButton("Delete");
		btnDelete_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete3();
			}
		});
		btnDelete_1_1_1.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Close-icon.png"));
		btnDelete_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete_1_1_1.setBounds(744, 180, 130, 37);
		panel_3.add(btnDelete_1_1_1);

		JButton btnNewButton_1_1_1 = new JButton("Search");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search3();
			}
		});
		btnNewButton_1_1_1
				.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Start-Menu-Search-icon.png"));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1_1.setBounds(744, 227, 130, 37);
		panel_3.add(btnNewButton_1_1_1);

		textFieldsearch4 = new JTextField();
		textFieldsearch4.setColumns(10);
		textFieldsearch4.setBounds(408, 233, 275, 24);
		panel_3.add(textFieldsearch4);

		JLabel lblSearch_1_1_1 = new JLabel("Search");
		lblSearch_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearch_1_1_1.setBounds(340, 233, 102, 24);
		panel_3.add(lblSearch_1_1_1);

		reload3();
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(31, 289, 820, 257);
		panel_3.add(scrollPane_3);

		table_3 = new JTable(vectordata3, vector3);
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedrow3 = table_3.getSelectedRow();
			}
		});
		scrollPane_3.setViewportView(table_3);

		JButton btnRefresh_3 = new JButton("Refresh");
		btnRefresh_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp3();
			}
		});
		btnRefresh_3.setIcon(new ImageIcon("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Button-Refresh-icon.png"));
		btnRefresh_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRefresh_3.setBounds(408, 180, 130, 37);
		panel_3.add(btnRefresh_3);

	}

	public void reload() {

		try {
			String sqlServer = "jdbc:sqlserver://LAPTOP-RG5QA0PH:1433;databasename=EmployeeManagement;user=sa;password=123456789";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection(sqlServer);
			Statement stm = connection.createStatement();
			ResultSet rst = stm.executeQuery(
					"Select DepartmentInfor.ID_Department, DepartmentInfor.DepartmentName, DepartmentInfor.ID_EmployeeLead, EmployInfor.Fullname from DepartmentInfor\r\n"
							+ "INNER JOIN EmployInfor ON DepartmentInfor.ID_EmployeeLead = EmployInfor.ID_Employee");

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

	public void temp() {
		try {
			connect();
			prs = conn.prepareStatement(
					"Select DepartmentInfor.ID_Department, DepartmentInfor.DepartmentName, DepartmentInfor.ID_EmployeeLead, EmployInfor.Fullname from DepartmentInfor\r\n"
							+ "INNER JOIN EmployInfor ON DepartmentInfor.ID_EmployeeLead = EmployInfor.ID_Employee");
			rs = prs.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int executeDB(String sql) {
		int record = 0;
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

	public void add() {
		try {

			String sql = "Insert into DepartmentInfor (ID_Department, DepartmentName, ID_EmployeeLead) values ("
					+ textFieldIDdepart.getText() + ",'" + textFieldnamedepart.getText() + "', '"
					+ textFieldIDdepartLeader.getText() + "')";

			String sql2 = "SELECT * FROM EmployInfor WHERE ID_Employee = " + textFieldIDdepartLeader.getText();
			temp();
			PreparedStatement prs1 = conn.prepareStatement(sql2);
			ResultSet rs1 = prs1.executeQuery();

			if (rs1.next()) {
				String sql3 = "Select * from DepartmentInfor where ID_EmployeeLead = "
						+ textFieldIDdepartLeader.getText();
				temp();
				PreparedStatement prs2 = conn.prepareStatement(sql3);
				ResultSet rs2 = prs2.executeQuery();

				if (rs2.next()) {
					JOptionPane.showMessageDialog(null, "This ID_Employee is already exist!");
				} else {
					int record = executeDB(sql);
					if (record > 0)
						JOptionPane.showMessageDialog(null, "Success");
					temp();
				}

			} else {
				JOptionPane.showMessageDialog(null, "This ID_Employee was not found!");
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void delete() {
		try {

			int record = executeDB(
					"Delete from DepartmentInfor where ID_Department =" + table.getValueAt(selectedrow, 0).toString());
			if (record > 0)
				JOptionPane.showMessageDialog(null, "Success");
			temp();
		} catch (Exception e2) {
			// TODO: handle exception
		}

	}

	public void search() {
		try {
			connect();

			String sql = "Select * from DepartmentInfor WHERE (ID_Department LIKE '" + textFieldsearch.getText()
					+ "') OR (DepartmentName LIKE '%" + textFieldsearch.getText() + "%') OR (ID_EmployeeLead LIKE '"
					+ textFieldsearch.getText() + "') OR (ID_EmployeeLead LIKE '" + textFieldsearch.getText() + "')";

			prs = conn.prepareStatement(sql);
			rs = prs.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void edit() {
		try {
			String sql = "UPDATE DepartmentInfor SET DepartmentName = '" + table.getValueAt(selectedrow, 1).toString()
					+ "' ,ID_EmployeeLead = " + table.getValueAt(selectedrow, 2).toString() + "WHERE ID_Department = "
					+ table.getValueAt(selectedrow, 0).toString();

			String sql2 = "SELECT * FROM EmployInfor WHERE ID_Employee = "
					+ table.getValueAt(selectedrow, 2).toString();
			temp();
			PreparedStatement prs1 = conn.prepareStatement(sql2);
			ResultSet rs1 = prs1.executeQuery();

			if (rs1.next()) {
				int record = executeDB(sql);
				if (record > 0)
					JOptionPane.showMessageDialog(null, "Success");
				temp();

			} else {
				JOptionPane.showMessageDialog(null, "This ID_Employee was not found!");
			}

		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void reload1() {

		try {
			String sqlServer = "jdbc:sqlserver://LAPTOP-RG5QA0PH:1433;databasename=EmployeeManagement;user=sa;password=123456789";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection(sqlServer);
			Statement stm = connection.createStatement();
			ResultSet rst = stm.executeQuery(
					"SELECT DISTINCT Executive_Manage_Depart.ID_Execute_Mana, Executive_Manage_Depart.ID_Employee, EmployInfor.Fullname , EmployInfor.Birthday , EmployInfor.Phonenumber, EmployInfor.Email, EmployInfor.Address, EmployInfor.Role FROM Executive_Manage_Depart\r\n"
							+ "INNER JOIN EmployInfor ON  Executive_Manage_Depart.ID_Employee =  EmployInfor.ID_Employee");

			ResultSetMetaData rstmeta = rst.getMetaData();
			int column = rstmeta.getColumnCount();

			for (int i = 1; i <= column; i++) {
				vector1.add(rstmeta.getColumnLabel(i));
			}

			while (rst.next()) {
				Vector row1 = new Vector(column);
				for (int i = 1; i <= column; i++) {
					row1.add(rst.getString(i));
				}
				vectordata1.add(row1);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void temp1() {
		try {
			connect();
			prs = conn.prepareStatement(
					"SELECT DISTINCT Executive_Manage_Depart.ID_Execute_Mana, Executive_Manage_Depart.ID_Employee, EmployInfor.Fullname , EmployInfor.Birthday , EmployInfor.Phonenumber, EmployInfor.Email, EmployInfor.Address, EmployInfor.Role FROM Executive_Manage_Depart\r\n"
							+ "INNER JOIN EmployInfor ON  Executive_Manage_Depart.ID_Employee =  EmployInfor.ID_Employee");
			rs = prs.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add1() {
		try {

			String sql = "Insert into Executive_Manage_Depart (ID_Execute_Mana, ID_Employee) values ("
					+ textFieldIDexma.getText() + "," + textFieldIDemployee.getText() + ")";

			String sql2 = "SELECT * FROM EmployInfor WHERE ID_Employee = " + textFieldIDemployee.getText();
			temp1();

			PreparedStatement prs1 = conn.prepareStatement(sql2);
			ResultSet rs1 = prs1.executeQuery();

			if (rs1.next()) {
				String sql3 = "Select * from Executive_Manage_Depart where ID_Employee = "
						+ textFieldIDemployee.getText();
				temp1();

				PreparedStatement prs2 = conn.prepareStatement(sql3);
				ResultSet rs2 = prs2.executeQuery();

				if (rs2.next()) {
					JOptionPane.showMessageDialog(null, "This employee already exists!");
				} else {
					int record = executeDB(sql);
					if (record > 0)
						JOptionPane.showMessageDialog(null, "Success");
					temp1();
				}
			} else {
				JOptionPane.showMessageDialog(null, "This ID_Employee was not found!");
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void delete1() {
		try {

			int record = executeDB("Delete from Executive_Manage_Depart where ID_Execute_Mana ="
					+ table_1.getValueAt(selectedrow1, 0).toString());
			if (record > 0)
				JOptionPane.showMessageDialog(null, "Success");
			temp1();
		} catch (Exception e2) {
			// TODO: handle exception
		}

	}

	public void search1() {
		try {
			connect();

			String sql = "SELECT DISTINCT Executive_Manage_Depart.ID_Execute_Mana, Executive_Manage_Depart.ID_Employee, EmployInfor.Fullname , EmployInfor.Birthday , EmployInfor.Phonenumber, EmployInfor.Email, EmployInfor.Address, EmployInfor.Role FROM Executive_Manage_Depart\r\n"
					+ "INNER JOIN EmployInfor ON  Executive_Manage_Depart.ID_Employee =  EmployInfor.ID_Employee WHERE (Executive_Manage_Depart.ID_Execute_Mana LIKE '"
					+ textFieldsearch1.getText() + "') OR (Executive_Manage_Depart.ID_Employee LIKE '"
					+ textFieldsearch1.getText() + "') OR (EmployInfor.Fullname LIKE '%" + textFieldsearch1.getText()
					+ "%')";

			prs = conn.prepareStatement(sql);
			rs = prs.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void edit1() {
		try {

			String sql = "UPDATE Executive_Manage_Depart SET ID_Employee = "
					+ table_1.getValueAt(selectedrow1, 1).toString() + "WHERE ID_Execute_Mana = "
					+ table_1.getValueAt(selectedrow1, 0).toString();

			String sql2 = "SELECT * FROM EmployInfor WHERE ID_Employee = "
					+ table_1.getValueAt(selectedrow1, 1).toString();
			temp1();

			PreparedStatement ps1 = conn.prepareStatement(sql2);
			ResultSet rs1 = ps1.executeQuery();

			if (rs1.next()) {
				int record = executeDB(sql);
				if (record > 0)
					JOptionPane.showMessageDialog(null, "Success");
				temp1();
			} else {
				JOptionPane.showMessageDialog(null, "This ID_Employee was not found!");
			}

		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void reload2() {

		try {
			String sqlServer = "jdbc:sqlserver://LAPTOP-RG5QA0PH:1433;databasename=EmployeeManagement;user=sa;password=123456789";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection(sqlServer);
			Statement stm = connection.createStatement();
			ResultSet rst = stm.executeQuery(
					"SELECT DISTINCT App_Program_Depart.ID_AppPro, App_Program_Depart.ID_Employee, EmployInfor.Fullname , EmployInfor.Birthday , EmployInfor.Phonenumber, EmployInfor.Email, EmployInfor.Address, EmployInfor.Role FROM  App_Program_Depart\r\n"
							+ "INNER JOIN EmployInfor ON  App_Program_Depart.ID_Employee =  EmployInfor.ID_Employee");

			ResultSetMetaData rstmeta = rst.getMetaData();
			int column = rstmeta.getColumnCount();

			for (int i = 1; i <= column; i++) {
				vector2.add(rstmeta.getColumnLabel(i));
			}

			while (rst.next()) {
				Vector row1 = new Vector(column);
				for (int i = 1; i <= column; i++) {
					row1.add(rst.getString(i));
				}
				vectordata2.add(row1);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void temp2() {
		try {
			connect();
			prs = conn.prepareStatement(
					"SELECT DISTINCT App_Program_Depart.ID_AppPro, App_Program_Depart.ID_Employee, EmployInfor.Fullname , EmployInfor.Birthday , EmployInfor.Phonenumber, EmployInfor.Email, EmployInfor.Address, EmployInfor.Role FROM  App_Program_Depart\r\n"
							+ "INNER JOIN EmployInfor ON  App_Program_Depart.ID_Employee =  EmployInfor.ID_Employee");
			rs = prs.executeQuery();
			table_2.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add2() {
		try {

			String sql = "Insert into App_Program_Depart (ID_AppPro, ID_Employee) values ("
					+ textFieldIDAppPro.getText() + "," + textFieldIDemploy3.getText() + ")";

			String sql2 = "SELECT * FROM EmployInfor WHERE ID_Employee = " + textFieldIDemploy3.getText();
			temp2();

			PreparedStatement prs1 = conn.prepareStatement(sql2);
			ResultSet rs1 = prs1.executeQuery();

			if (rs1.next()) {
				String sql3 = "Select * from App_Program_Depart where ID_Employee = " + textFieldIDemploy3.getText();
				temp2();

				PreparedStatement prs2 = conn.prepareStatement(sql3);
				ResultSet rs2 = prs2.executeQuery();

				if (rs2.next()) {
					JOptionPane.showMessageDialog(null, "This Employee already exists!");
				} else {
					int record = executeDB(sql);
					if (record > 0)
						JOptionPane.showMessageDialog(null, "Success");
					temp2();

				}

			} else {
				JOptionPane.showMessageDialog(null, "This ID_Employee was not found!");
			}

		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void delete2() {
		try {

			int record = executeDB("Delete from App_Program_Depart where ID_AppPro ="
					+ table_2.getValueAt(selectedrow2, 0).toString());
			if (record > 0)
				JOptionPane.showMessageDialog(null, "Success");
			temp2();
		} catch (Exception e2) {
			// TODO: handle exception
		}

	}

	public void search2() {
		try {
			connect();

			String sql = "SELECT DISTINCT App_Program_Depart.ID_AppPro, App_Program_Depart.ID_Employee, EmployInfor.Fullname , EmployInfor.Birthday , EmployInfor.Phonenumber, EmployInfor.Email, EmployInfor.Address, EmployInfor.Role FROM App_Program_Depart\r\n"
					+ "INNER JOIN EmployInfor ON  App_Program_Depart.ID_Employee =  EmployInfor.ID_Employee WHERE (App_Program_Depart.ID_AppPro LIKE '"
					+ textFieldsearch3.getText() + "') OR ( App_Program_Depart.ID_Employee LIKE '"
					+ textFieldsearch3.getText() + "') OR (EmployInfor.Fullname LIKE '%" + textFieldsearch3.getText()
					+ "%')";

			prs = conn.prepareStatement(sql);
			rs = prs.executeQuery();
			table_2.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void edit2() {
		try {
			String sql = "UPDATE App_Program_Depart SET ID_Employee = " + table_2.getValueAt(selectedrow2, 1).toString()
					+ "WHERE ID_AppPro = " + table_2.getValueAt(selectedrow2, 0).toString();

			String sql2 = "SELECT * FROM EmployInfor WHERE ID_Employee = "
					+ table_2.getValueAt(selectedrow2, 1).toString();
			temp2();
			PreparedStatement ps1 = conn.prepareStatement(sql2);
			ResultSet rs1 = ps1.executeQuery();

			if (rs1.next()) {
				int record = executeDB(sql);
				if (record > 0)
					JOptionPane.showMessageDialog(null, "Success");
				temp2();

			} else {
				JOptionPane.showMessageDialog(null, "This ID_Employee was not found!");
			}

		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void reload3() {

		try {
			String sqlServer = "jdbc:sqlserver://LAPTOP-RG5QA0PH:1433;databasename=EmployeeManagement;user=sa;password=123456789";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection(sqlServer);
			Statement stm = connection.createStatement();
			ResultSet rst = stm.executeQuery(
					"SELECT Network_Administrator_Depart.ID_NetworkAdmin, Network_Administrator_Depart.ID_Employee, EmployInfor.Fullname , EmployInfor.Birthday , EmployInfor.Phonenumber, EmployInfor.Email, EmployInfor.Address, EmployInfor.Role FROM Network_Administrator_Depart\r\n"
							+ "INNER JOIN EmployInfor ON  Network_Administrator_Depart.ID_Employee =  EmployInfor.ID_Employee");

			ResultSetMetaData rstmeta = rst.getMetaData();
			int column = rstmeta.getColumnCount();

			for (int i = 1; i <= column; i++) {
				vector3.add(rstmeta.getColumnLabel(i));
			}

			while (rst.next()) {
				Vector row1 = new Vector(column);
				for (int i = 1; i <= column; i++) {
					row1.add(rst.getString(i));
				}
				vectordata3.add(row1);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void temp3() {
		try {
			connect();
			prs = conn.prepareStatement(
					"SELECT Network_Administrator_Depart.ID_NetworkAdmin, Network_Administrator_Depart.ID_Employee, EmployInfor.Fullname , EmployInfor.Birthday , EmployInfor.Phonenumber, EmployInfor.Email, EmployInfor.Address, EmployInfor.Role FROM Network_Administrator_Depart\r\n"
							+ "INNER JOIN EmployInfor ON  Network_Administrator_Depart.ID_Employee =  EmployInfor.ID_Employee");
			rs = prs.executeQuery();
			table_3.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add3() {
		try {

			String sql = "Insert into Network_Administrator_Depart (ID_NetworkAdmin, ID_Employee) values ("
					+ textFieldNetAd.getText() + "," + textFieldIDemploy4.getText() + ")";

			String sql2 = "SELECT * FROM EmployInfor WHERE ID_Employee = " + textFieldIDemploy4.getText();
			temp3();

			PreparedStatement prs1 = conn.prepareStatement(sql2);
			ResultSet rs1 = prs1.executeQuery();

			if (rs1.next()) {
				String sql3 = "Select * from  Network_Administrator_Depart where ID_Employee = "
						+ textFieldIDemploy4.getText();
				temp3();

				PreparedStatement prs2 = conn.prepareStatement(sql3);
				ResultSet rs2 = prs2.executeQuery();
				if (rs2.next()) {
					JOptionPane.showMessageDialog(null, "This Employee already exists!");
				} else {
					int record = executeDB(sql);
					if (record > 0)
						JOptionPane.showMessageDialog(null, "Success");
					temp3();
				}

			} else {
				JOptionPane.showMessageDialog(null, "This ID_Employee was not found!");
			}

		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void delete3() {
		try {

			int record = executeDB("Delete from Network_Administrator_Depart where ID_NetworkAdmin ="
					+ table_3.getValueAt(selectedrow3, 0).toString());
			if (record > 0)
				JOptionPane.showMessageDialog(null, "Success");
			temp3();
		} catch (Exception e2) {
			// TODO: handle exception
		}

	}

	public void search3() {
		try {
			connect();

			String sql = "SELECT DISTINCT Network_Administrator_Depart.ID_NetworkAdmin, Network_Administrator_Depart.ID_Employee, EmployInfor.Fullname , EmployInfor.Birthday , EmployInfor.Phonenumber, EmployInfor.Email, EmployInfor.Address, EmployInfor.Role FROM Network_Administrator_Depart\r\n"
					+ "INNER JOIN EmployInfor ON  Network_Administrator_Depart.ID_Employee =  EmployInfor.ID_Employee WHERE (Network_Administrator_Depart.ID_NetworkAdmin LIKE '"
					+ textFieldsearch4.getText() + "') OR ( Network_Administrator_Depart.ID_Employee LIKE '"
					+ textFieldsearch4.getText() + "') OR (EmployInfor.Fullname LIKE '%" + textFieldsearch4.getText()
					+ "%')";
			prs = conn.prepareStatement(sql);
			rs = prs.executeQuery();
			table_3.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void edit3() {
		try {
			String sql = "UPDATE Network_Administrator_Depart SET ID_Employee = "
					+ table_3.getValueAt(selectedrow3, 1).toString() + " WHERE ID_NetworkAdmin = "
					+ table_3.getValueAt(selectedrow3, 0).toString();

			String sql2 = "SELECT * FROM EmployInfor WHERE ID_Employee = "
					+ table_3.getValueAt(selectedrow3, 1).toString();
			temp3();

			PreparedStatement ps1 = conn.prepareStatement(sql2);
			ResultSet rs1 = ps1.executeQuery();

			if (rs1.next()) {
				int record = executeDB(sql);
				if (record > 0)
					JOptionPane.showMessageDialog(null, "Success");
				temp3();

			} else {
				JOptionPane.showMessageDialog(null, "This ID_Employee was not found!");
			}

		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}

//Select * from EmployInfor ORDER BY Fullname ASC
