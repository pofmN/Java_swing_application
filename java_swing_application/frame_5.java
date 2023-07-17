package Do_an_own;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class frame_5 extends JFrame {

	private JPanel contentPane;
	JTable table;
	private JTextField textFieldIDproject;
	private JTextField textFieldNameProject;
	private JTextField textFieldidemploy;
	private JTextField textFielddeadline;
	private JTextField textFieldsearch;
	int selectedrow = 0;
	Vector vector = new Vector();
	Vector vectordata = new Vector();
	static Connection conn;
	static PreparedStatement prs;
	static ResultSet rs;

	JComboBox comboBoxstatus = new JComboBox();
	DefaultTableModel dft;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame_5 frame = new frame_5();
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
	public frame_5() {
		setTitle("PROJECT MANAGEMENT - System Administrator");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\ACER\\Dropbox\\PC\\Downloads\\Actions-project-open-icon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		reload();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 361, 840, 270);
		contentPane.add(scrollPane);

		table = new JTable(vectordata, vector);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedrow = table.getSelectedRow();
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("ID_Project");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(127, 110, 80, 23);
		contentPane.add(lblNewLabel);

		textFieldIDproject = new JTextField();
		textFieldIDproject.setColumns(10);
		textFieldIDproject.setBounds(217, 110, 220, 23);
		contentPane.add(textFieldIDproject);

		JLabel lblFullname = new JLabel("Name of Project");
		lblFullname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFullname.setBounds(486, 108, 118, 23);
		contentPane.add(lblFullname);

		textFieldNameProject = new JTextField();
		textFieldNameProject.setColumns(10);
		textFieldNameProject.setBounds(614, 110, 220, 23);
		contentPane.add(textFieldNameProject);

		JLabel lblRole = new JLabel("Status");
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRole.setBounds(158, 199, 51, 23);
		contentPane.add(lblRole);
		comboBoxstatus.setModel(new DefaultComboBoxModel(new String[] { "Finished", "Unfinished" }));

		comboBoxstatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxstatus.setBounds(217, 198, 152, 24);
		contentPane.add(comboBoxstatus);

		JLabel lblIdemployee = new JLabel("ID_Employee Implement");
		lblIdemployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdemployee.setBounds(31, 153, 189, 23);
		contentPane.add(lblIdemployee);

		textFieldidemploy = new JTextField();
		textFieldidemploy.setColumns(10);
		textFieldidemploy.setBounds(217, 155, 220, 23);
		contentPane.add(textFieldidemploy);

		JLabel lblDate = new JLabel("Deadline");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(540, 153, 64, 23);
		contentPane.add(lblDate);

		textFielddeadline = new JTextField();
		textFielddeadline.setColumns(10);
		textFielddeadline.setBounds(614, 155, 220, 23);
		contentPane.add(textFielddeadline);

		JButton btnAdd = new JButton("Add ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add();
			}
		});
		btnAdd.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-add-user-male-material-filled\\icons8-add-user-male-18.png"));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(407, 265, 130, 37);
		contentPane.add(btnAdd);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 254, 884, 14);
		contentPane.add(separator);

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearch.setBounds(360, 320, 102, 24);
		contentPane.add(lblSearch);

		textFieldsearch = new JTextField();
		textFieldsearch.setColumns(10);
		textFieldsearch.setBounds(428, 320, 275, 24);
		contentPane.add(textFieldsearch);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-search-material-filled\\icons8-search-18.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(736, 314, 130, 37);
		contentPane.add(btnNewButton);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-trash-material-filled\\icons8-trash-18.png"));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(736, 265, 130, 37);
		contentPane.add(btnDelete);

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
		btnHomepage.setBounds(722, 10, 144, 37);
		contentPane.add(btnHomepage);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit();
			}
		});
		btnEdit.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-edit-material-filled\\icons8-edit-18.png"));
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdit.setBounds(575, 265, 130, 37);
		contentPane.add(btnEdit);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp();
			}
		});
		btnRefresh.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-refresh-material-filled\\icons8-refresh-18.png"));
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRefresh.setBounds(236, 265, 130, 37);
		contentPane.add(btnRefresh);
	}

	public void reload() {

		try {
			String sqlServer = "jdbc:sqlserver://LAPTOP-RG5QA0PH:1433;databasename=EmployeeManagement;user=sa;password=12032003";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection(sqlServer);
			Statement stm = connection.createStatement();
			ResultSet rst = stm.executeQuery(
					"Select Project_Manage.ID_Project, Project_Manage.ProjectName, Project_Manage.ID_EmployeeImplement, EmployInfor.Fullname, EmployInfor.Phonenumber, EmployInfor.Email, Project_Manage.Deadline, Project_Manage.Status from Project_Manage\r\n"
							+ "INNER JOIN EmployInfor ON Project_Manage.ID_EmployeeImplement = EmployInfor.ID_Employee");

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
			String sqlServer = "jdbc:sqlserver://LAPTOP-RG5QA0PH:1433;databasename=EmployeeManagement;user=sa;password=12032003";
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
					"Select Project_Manage.ID_Project, Project_Manage.ProjectName, Project_Manage.ID_EmployeeImplement, EmployInfor.Fullname, EmployInfor.Phonenumber, EmployInfor.Email, Project_Manage.Deadline, Project_Manage.Status from Project_Manage\r\n"
							+ "INNER JOIN EmployInfor ON Project_Manage.ID_EmployeeImplement = EmployInfor.ID_Employee");
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

			String sql = "Insert into Project_Manage (ID_Project, ProjectName, ID_EmployeeImplement, Deadline, Status) values ("
					+ textFieldIDproject.getText() + ",'" + textFieldNameProject.getText() + "', '"
					+ textFieldidemploy.getText() + "','" + textFielddeadline.getText() + "','"
					+ comboBoxstatus.getSelectedItem().toString() + "')";

			String sql2 = "SELECT * FROM EmployInfor WHERE ID_Employee = " + textFieldidemploy.getText();
			temp();
			PreparedStatement prs1 = conn.prepareStatement(sql2);
			ResultSet rs1 = prs1.executeQuery();

			if (rs1.next()) {
				String sql3 = "Select * from Project_Manage where ProjectName = '" + textFieldNameProject.getText()
						+ "' and  ID_EmployeeImplement = " + textFieldidemploy.getText();
				temp();
				PreparedStatement prs2 = conn.prepareStatement(sql3);
				ResultSet rs2 = prs2.executeQuery();
				if (rs2.next()) {
					JOptionPane.showMessageDialog(null, "This Employee receiving this project already exists!");
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
					"Delete from Project_Manage where ID_Project =" + table.getValueAt(selectedrow, 0).toString());
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

			String sql = "Select * from Project_Manage WHERE (ID_Project LIKE '%" + textFieldsearch.getText()
					+ "%') OR (ID_EmployeeImplement LIKE '%" + textFieldsearch.getText() + "%') OR (ProjectName LIKE '%"
					+ textFieldsearch.getText() + "%') OR (Status = '" + textFieldsearch.getText() + "')";
			prs = conn.prepareStatement(sql);
			rs = prs.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	public void edit() {
		try {
			String sql = "UPDATE Project_Manage SET ProjectName = '" + table.getValueAt(selectedrow, 1).toString()
					+ "' ,ID_EmployeeImplement = " + table.getValueAt(selectedrow, 2).toString() + ",Deadline = '"
					+ table.getValueAt(selectedrow, 3).toString() + "', Status = '"
					+ table.getValueAt(selectedrow, 4).toString() + "' WHERE ID_Project = "
					+ table.getValueAt(selectedrow, 0).toString();

			String sql2 = "SELECT * FROM EmployInfor WHERE ID_Employee = "
					+ table.getValueAt(selectedrow, 2).toString();
			temp();
			PreparedStatement ps1 = conn.prepareStatement(sql2);
			ResultSet rs1 = ps1.executeQuery();

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
}
