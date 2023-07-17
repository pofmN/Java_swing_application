package Do_an_own;

import java.awt.Toolkit;
import javax.imageio.ImageIO;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.tools.Tool;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Font;
import java.awt.Canvas;
import java.awt.image.BufferedImage;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JToolBar;
import javax.swing.Icon;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class frame_1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame_1 frame = new frame_1();
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
	
	public frame_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 296);
		setTitle("Employee Management");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("WELCOME MEMBER LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(190, 10, 250, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblNewLabel);
//		URL url = frame_1.class.getResource("1.png");
//		Image image = Toolkit.getDefaultToolkit().createImage(url);
//		this.setIconImage(image);
//		ImageIcon img = new ImageIcon("image/1.png");
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\user-security-11930.png"));
		lblNewLabel_1.setBounds(0, 43, 170, 173);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("User        ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(190, 65, 77, 18);
		contentPane.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(263, 59, 163, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(190, 112, 77, 13);
		contentPane.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("Sign Up\r\n");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\user-signup-3058.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame_3 view3 = new frame_3();
				view3.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(190, 158, 107, 33);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Sign in");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\user-276.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals("")) {
					JFrame jf1 = new JFrame("Message");
					JOptionPane.showMessageDialog(jf1, "Please enter username!");
				} else {
					if (passwordField.getText().equals("")) {
						JFrame jf1 = new JFrame("Message");
						JOptionPane.showMessageDialog(jf1, "Please enter your password!");
					} else {
						try {
							String sqlServer = "jdbc:sqlserver://LAPTOP-RG5QA0PH:1433;databasename=EmployeeManagement;user=sa;password=12032003";
							Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
							Connection connection = DriverManager.getConnection(sqlServer);
							String sql = "SELECT * FROM Account WHERE Username = ? AND Password = ? ";
							PreparedStatement ps = connection.prepareStatement(sql);
							
							String password_code = ConvertHashtoString(passwordField.getText());
							
							ps.setString(1, textField.getText());
							ps.setString(2, password_code);

							ResultSet rs = ps.executeQuery();
							if (rs.next()) {
								dispose();
								JOptionPane.showMessageDialog(null, "Login success!");
								frame_2 view2 = new frame_2();
								view2.setVisible(true);

							} else {
								JFrame jf2 = new JFrame("Message");
								JOptionPane.showMessageDialog(jf2, "Your login failed! Username or password are incorrect!");
							}
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(319, 158, 107, 33);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_4 = new JLabel("");
//		lblNewLabel_4
//				.setIcon(new ImageIcon("C:\\Users\\ADMIN\\Downloads\\finalexam\\finalexam\\icoin.png"));
		lblNewLabel_4.setBounds(190, 0, 38, 45);
		contentPane.add(lblNewLabel_4);

		passwordField = new JPasswordField();
		passwordField.setBounds(263, 106, 163, 27);
		contentPane.add(passwordField);
		
		JButton btnNewButton_2 = new JButton("Close\r\n");
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(431, 222, 77, 27);
		contentPane.add(btnNewButton_2);
	}
}

