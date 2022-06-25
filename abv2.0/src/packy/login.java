package packy;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class login extends JFrame {
	//adding the data in the frame creator
	
	static ArrayList<user> a=new ArrayList<user>();

	public static ArrayList<user> getA() {
		return a;
	}

	public static void setA(ArrayList<user> a) {
		login.a = a;
	}
	

	private JPanel contentPane;
	private JTextField txtName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//creating the frame
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login(a);
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
	public login(ArrayList<user> users) {
		//System.out.println(users.get(0).fname+" "+users.get(0).lname+" "+users.get(0).uname+" "+users.get(0).pass+" "+users.get(0).age+" "+users.get(0).id+" login ***");
		//System.out.println(users.get(0).inbox.get(0).sender+" "+users.get(0).inbox.get(0).title+" "+users.get(0).inbox.get(0).text);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		label.setBounds(270, 191, 330, 14);
		label.setForeground(Color.decode("#dd5245"));
		contentPane.add(label);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnLogIn.setBackground(Color.ORANGE);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.print(txtPassword.getText());
				boolean check=false;
				int index=-1;
				// checking if the credentials are correct and getting id
				
				for(int i=0;i<users.size();i++) {
					
					if(  users.get(i).uname.equals(txtName.getText())  &&  users.get(i).pass.equals(encrytion(txtPassword.getText()))) {
						index=i;
						check=true;
					}
			}
				
				if(check){
					
					//System.out.println("we are in boyyyyy");
					
					//JOptionPane.showMessageDialog(null, "Welcome "+ users.get(index).fname);
					
					menu menu=new menu(users,index);
					
					menu.setLocationRelativeTo(null);		//sets the window in the middle
					menu.setVisible(true);
					dispose();
				}else {
					//JOptionPane.showMessageDialog(null, "username and password dont match");
					
					label.setText("username and password don't match");
					
				// 	code for reseting the window
//					login log=new login(users);
//					log.setVisible(true);
//					dispose();
				}
				
				
				
			}
		});
		
		
		btnLogIn.setBounds(333, 214, 201, 25);
		contentPane.add(btnLogIn);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnLogIn.setBorder(emptyBorder);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(323, 82, 255, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtName = new JTextField();
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtName.getText().equals("") ) {
					txtName.setText(" Enter Username");
					txtName.setForeground(Color.gray);
					txtName.setFont(new Font("Tahoma", Font.ITALIC, 11));
				}
			}
		});
		txtName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtName.getText().equals(" Enter Username") ) {
					txtName.setText("");
					txtName.setForeground(Color.black);
					txtName.setFont(new Font("Tahoma", Font.PLAIN, 11));
				}	
			}
		});
		txtName.setForeground(new Color(128, 128, 128));
		txtName.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtName.setText(" Enter Username");
		txtName.setBackground(Color.WHITE);
		txtName.setBounds(10, 10, 200, 30);
		panel.add(txtName);
		txtName.setToolTipText("Username");
		txtName.setColumns(10);
		txtName.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setIcon(new ImageIcon(login.class.getResource("/packy/person_30.png")));
		lblNewLabel_1.setBounds(215, 7, 30, 30);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(323, 143, 255, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtPassword.setForeground(Color.GRAY);
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPassword.getText().equals(" Enter Password") ) {
					txtPassword.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
					//txtPassword. setEchoChar('•');
					txtPassword.setText("");
					txtPassword.setForeground(Color.black);
					txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPassword.getText().equals("") ) {
					txtPassword. setEchoChar((char)0);
					txtPassword.setText(" Enter Password");
					txtPassword.setFont(new Font("Tahoma", Font.ITALIC, 11));
					txtPassword.setForeground(Color.GRAY);   //setForeground(Color.gray);
				}
			}
		});
		txtPassword.setBounds(10, 10, 200, 30);
		panel_1.add(txtPassword);
		txtPassword.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		txtPassword. setEchoChar((char)0);
		txtPassword.setText(" Enter Password");
		
		JLabel lblNewLabel = new JLabel("password");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/packy/lock_30.png")));
		lblNewLabel.setBounds(215, 9, 30, 30);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(0, 0, 271, 300);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnSignIn = new JButton("Sign Up");
		btnSignIn.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setBackground(Color.ORANGE);
		btnSignIn.setBounds(97, 251, 83, 23);
		panel_2.add(btnSignIn);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signin sign=new signin(users);
				sign.setLocationRelativeTo(null);		//sets the window in the middle
				sign.setVisible(true);
				dispose();
			}
		});
		btnSignIn.setBorder(new LineBorder(Color.WHITE, 3));
		
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(login.class.getResource("/packy/sign_up_page_small.png")));
		lblLogo.setBounds(10, 27, 251, 213);
		panel_2.add(lblLogo);
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.WHITE);
		btnExit.setForeground(Color.GRAY);
		btnExit.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnExit.setBounds(333, 250, 201, 25);
		contentPane.add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBorder(new LineBorder(Color.GRAY, 2));
		
		JButton btnNewButton = new JButton("Can't login?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Wops obj=new Wops(users);
				obj.setLocationRelativeTo(null);		//sets the window in the middle
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setBounds(388, 277, 97, 23);
		contentPane.add(btnNewButton);
		btnNewButton.setBorder(null);
		
		
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
