package packy;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class deleteProfile extends JFrame {
	static ArrayList<user> a=new ArrayList<user>();
	static int indx;
	
	public static ArrayList<user> getA() {
		return a;
	}

	public static void setA(ArrayList<user> a) {
		write.a = a;
	}

	public static int getId() {
		return indx;
	}

	public static void setId(int id) {
		write.indx = id;
	}
	
	
	

	private JPanel contentPane;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteProfile frame = new deleteProfile(a,indx);
					//frame.setLocationRelativeTo(null);		//sets the window in the middle
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
	public deleteProfile(ArrayList<user> users,int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblNewLabel.setForeground(Color.decode("#dd5245"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(100, 188, 250, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.GRAY);
		btnBack.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(142, 266, 165, 25);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myInfo obj=new myInfo(users,index);
				obj.setVisible(true);
				obj.setLocation(null);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnBack);
		btnBack.setBorder(new LineBorder(Color.GRAY, 2));
		
		JButton btnDeleteAndReturn = new JButton("Delete and return to login");
		btnDeleteAndReturn.setForeground(Color.WHITE);
		btnDeleteAndReturn.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnDeleteAndReturn.setBackground(Color.decode("#dd5245"));
		btnDeleteAndReturn.setBounds(142, 232, 165, 25);
		btnDeleteAndReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clearing yje old attempts
				lblNewLabel.setText("");
				// removing the profile if the password is correct
				if(encrytion(pwdPassword.getText()).equals(users.get(index).pass)) {
					users.remove(index);
					login obj=new login(users);
					obj.setLocationRelativeTo(null);		//sets the window in the middle
					obj.setVisible(true);
					dispose();
				}else {
					lblNewLabel.setText("wrong password");
					//JOptionPane.showMessageDialog(null, "wrong password");
				}		
				
				
			}
		});
		contentPane.add(btnDeleteAndReturn);
		btnDeleteAndReturn.setBorder(null);
		
		pwdPassword = new JPasswordField();
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdPassword.getText().equals(" Enter Password") ) {
					pwdPassword.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
					//txtPassword. setEchoChar('•');
					pwdPassword.setText("");
					pwdPassword.setForeground(Color.black);
					pwdPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdPassword.getText().equals("") ) {
					pwdPassword. setEchoChar((char)0);
					pwdPassword.setText(" Enter Password");
					pwdPassword.setFont(new Font("Tahoma", Font.ITALIC, 11));
					pwdPassword.setForeground(Color.GRAY);   //setForeground(Color.gray);
				}
			}
		});
		pwdPassword.setBounds(100, 201, 250, 20);
		contentPane.add(pwdPassword);
		pwdPassword.setBorder(new LineBorder(Color.GRAY, 2));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#dd5245"));
		panel.setBounds(0, 0, 450, 190);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblThisWillPermanently = new JLabel("This will delete your profile");
		lblThisWillPermanently.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisWillPermanently.setFont(new Font("Poppins SemiBold", Font.PLAIN, 25));
		lblThisWillPermanently.setBackground(Color.WHITE);
		lblThisWillPermanently.setBounds(0, 71, 450, 45);
		panel.add(lblThisWillPermanently);
		lblThisWillPermanently.setForeground(Color.WHITE);
		
		JLabel lblDoTouStill = new JLabel("Do you still want to continue?");
		lblDoTouStill.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblDoTouStill.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoTouStill.setBounds(0, 150, 450, 25);
		panel.add(lblDoTouStill);
		lblDoTouStill.setForeground(Color.WHITE);
		
		JLabel lblEndterPassword = new JLabel(" with all of it's data!");
		lblEndterPassword.setForeground(Color.WHITE);
		lblEndterPassword.setFont(new Font("Poppins SemiBold", Font.PLAIN, 25));
		lblEndterPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndterPassword.setBounds(0, 108, 450, 32);
		panel.add(lblEndterPassword);
		
		JLabel lblI = new JLabel("");
		lblI.setHorizontalAlignment(SwingConstants.CENTER);
		lblI.setIcon(new ImageIcon(deleteProfile.class.getResource("/packy/warning_icon_60.png")));
		lblI.setBounds(190, 0, 70, 70);
		panel.add(lblI);
		
	}
	public static String encrytion(String pass) {
		char passCh[]=pass.toCharArray();
		for(int i=0;i<passCh.length;i++) {
			passCh[i]=(char)((int)passCh[i]+4);
		}
		String str = String. valueOf(passCh);
		return str;
	}
}
