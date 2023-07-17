package Do_an_own;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.DropMode;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.UIManager;

public class frame_3 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_5;
	private JPasswordField passwordFieldpass;
	private JLabel lblNewLabel_1_2_4;
	private JPasswordField passwordFieldretypepass;
	private JLabel lblNewLabel_1_2_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame_3 frame = new frame_3();
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
	
	private static final String DatatypeConverter = null;
	public String ConvertHashtoString(String text) throws NoSuchAlgorithmException {
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 byte[] hashInBytes = md.digest(text.getBytes(StandardCharsets.UTF_8));
		 StringBuilder sb = new StringBuilder();
		 for (byte b : hashInBytes) {
			 sb.append(String.format("%02x", b));
		 }
		 return sb.toString();
	  }
	
	public frame_3() {
		setTitle("Sign up");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 820, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//		URL url = frame_1.class.getResource("1.png");
//		Image image = Toolkit.getDefaultToolkit().createImage(url);
//		this.setIconImage(image);

		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\icons8-user-engagement-male-material-filled\\icons8-user-engagement-male-18.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JFrame jf1 = new JFrame("Message");
					JOptionPane.showMessageDialog(jf1, "Please enter your ID_Employee!");
				} else {
					if (textField_3.getText().equals("")) {
						JFrame jf1 = new JFrame("Message");
						JOptionPane.showMessageDialog(jf1, "Please enter your fullname!");
					} else {
						if (textField_5.getText().equals("")) {
							JFrame jf1 = new JFrame("Message");
							JOptionPane.showMessageDialog(jf1, "Please enter your username!");

						} else {
							if (passwordFieldpass.getText().equals("")) {
								JFrame jf1 = new JFrame("Message");
								JOptionPane.showMessageDialog(jf1, "Please enter your password!");

							} else {
								if (passwordFieldretypepass.getText().equals("")) {
									JFrame jf1 = new JFrame("Message");
									JOptionPane.showMessageDialog(jf1, "Please retype your password!");

								} else {
									try {
										String sqlServer = "jdbc:sqlserver://LAPTOP-RG5QA0PH:1433;databasename=EmployeeManagement;user=sa;password=12032003";
										Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
										Connection connection = DriverManager.getConnection(sqlServer);
										Statement stm = connection.createStatement();
										
										String password_code = ConvertHashtoString(passwordFieldpass.getText());
										
										String insert = "Insert into Account values('" + textField_5.getText() + "','"
												+ password_code + "','" + textField.getText() + "','"
												+ textField_3.getText() + "')";

//										String sql1 = "SELECT * FROM EmployInfor WHERE ID_EMPLOYEE = ?";
//										PreparedStatement ps1 = connection.prepareStatement(sql1);
//										ps1.setString(1, textField.getText());
//										ResultSet rs1 = ps1.executeQuery();

//										if (rs1.next()) {
											String sql = "SELECT * FROM Account WHERE Username = ?";
											PreparedStatement ps = connection.prepareStatement(sql);
											ps.setString(1, textField_5.getText());

											ResultSet rs = ps.executeQuery();
											if (rs.next()) {
												JFrame jf1 = new JFrame("Message");
												JOptionPane.showMessageDialog(jf1,
														"Error creating new account! The account name is already exist!");
											} else {
												String password_code_retype = ConvertHashtoString(passwordFieldretypepass.getText());
												Boolean check = password_code_retype
														.matches(password_code);
												if (check == false) {
													JOptionPane.showMessageDialog(null,
															"Password does not match above!");
												} else {
													int record = stm.executeUpdate(insert);
													JFrame jf2 = new JFrame("Message");
													
													JOptionPane.showMessageDialog(jf2,
															"Create new account successfully!");
													dispose();	
												}
											}
//										}
//										else {
//											JOptionPane.showMessageDialog(null, "This ID_Employee was not found!");
//										}

									} catch (Exception e2) {
										// TODO: handle exception
									}
								}

							}
						}
					}
				}
			}

		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(624, 271, 135, 37);
		contentPane.add(btnNewButton);

		passwordFieldretypepass = new JPasswordField();
		passwordFieldretypepass.setBounds(489, 194, 239, 27);
		contentPane.add(passwordFieldretypepass);

		lblNewLabel_1_2_5 = new JLabel("Retype your password:");
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_5.setBounds(340, 192, 145, 31);
		contentPane.add(lblNewLabel_1_2_5);

		lblNewLabel_1_2_4 = new JLabel("Password:");
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_4.setBounds(340, 151, 101, 31);
		contentPane.add(lblNewLabel_1_2_4);

		passwordFieldpass = new JPasswordField();
		passwordFieldpass.setBounds(489, 150, 239, 27);
		contentPane.add(passwordFieldpass);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(489, 110, 239, 27);
		contentPane.add(textField_5);

		JLabel lblNewLabel_1_2_3 = new JLabel("Username:");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3.setBounds(340, 109, 101, 31);
		contentPane.add(lblNewLabel_1_2_3);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(489, 66, 239, 27);
		contentPane.add(textField_3);

		JLabel lblNewLabel_1_2_1 = new JLabel("Fullname:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(340, 62, 101, 31);
		contentPane.add(lblNewLabel_1_2_1);

		textField = new JTextField();
		textField.setBounds(489, 22, 242, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID_Employee");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(340, 22, 101, 31);
		contentPane.add(lblNewLabel_1);

		JEditorPane dtrpndfasdf = new JEditorPane();
		dtrpndfasdf.setEditable(false);
		dtrpndfasdf.setEnabled(false);
		dtrpndfasdf.setBackground(UIManager.getColor("Button.light"));
		dtrpndfasdf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dtrpndfasdf.setBounds(320, 10, 476, 311);
		contentPane.add(dtrpndfasdf);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\Employee_icoin_big_nobg.png"));
		lblNewLabel.setBounds(0, 22, 310, 306);
		contentPane.add(lblNewLabel);
	}
}

// ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$
//"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$"
//"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=()-])(?=\\S+$).{8,20}$";
//String regrex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=()-])(?=\\S+$).{8,20}$";
//Boolean a = passwordField.getText().matches(regrex);
//email : ^[\\w-]+@([\\w-]+\\.)+[\\w-]+$
//"^(.+)@(\\S+)$"
//^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$
