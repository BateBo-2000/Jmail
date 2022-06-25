package packy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Graphics;

public class signin extends JFrame {
	static ArrayList<user> a=new ArrayList<user>();

	public static ArrayList<user> getA() {
		return a;
	}

	public static void setA(ArrayList<user> a) {
		login.a = a;
	}
	
	
	

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtLname;
	private JTextField txtUsername;
	private JTextField txtAddress;
	private JPasswordField txtPass;
	private JPasswordField txtPass_1;
	private JLabel lblFname;
	private JLabel lblLname;
	private JLabel lblUsername;
	private JLabel lblAddress;
	private JLabel lblPasswords;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signin frame = new signin(a);
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
	public signin(ArrayList<user> users) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(0, 0, 271, 300);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(login.class.getResource("/packy/sign_up_page_small.png")));
		lblLogo.setBounds(10, 27, 251, 213);
		panel_2.add(lblLogo);
		
		JButton btnLogin = new JButton("login");
		btnLogin.setBackground(Color.ORANGE);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnLogin.setBounds(95, 251, 83, 23);
		panel_2.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login log=new login(users);
				log.setLocationRelativeTo(null);		//sets the window in the middle
				log.setVisible(true);
				dispose();		
			}
		});
		btnLogin.setBorder(new LineBorder(Color.WHITE, 3));
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.WHITE);
		btnExit.setForeground(Color.GRAY);
		btnExit.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(333, 250, 201, 25);
		contentPane.add(btnExit);
		btnExit.setBorder(new LineBorder(Color.GRAY, 2));
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtName.getText().equals("") ) {
					txtName.setText("First Name");
					txtName.setForeground(Color.gray);
					txtName.setFont(new Font("Tahoma", Font.ITALIC, 11));
				}
			}
		});
		txtName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtName.getText().equals("First Name") ) {
					txtName.setText("");
					txtName.setForeground(Color.black);
					txtName.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
				}	
			}
		});
		txtName.setBounds(316, 38, 117, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		txtName.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		txtName.setText("First Name");
		txtName.setForeground(Color.gray);
		
		txtLname = new JTextField();
		txtLname.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtLname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtLname.getText().equals("") ) {
					txtLname.setText("Last Name");
					txtLname.setForeground(Color.gray);
					txtLname.setFont(new Font("Tahoma", Font.ITALIC, 11));
				}
			}
		});
		txtLname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtLname.getText().equals("Last Name") ) {
					txtLname.setText("");
					txtLname.setForeground(Color.black);
					txtLname.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
				}	
			}
		});
		txtLname.setBounds(443, 38, 117, 20);
		contentPane.add(txtLname);
		txtLname.setColumns(10);
		txtLname.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		txtLname.setText("Last Name");
		txtLname.setForeground(Color.gray);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUsername.getText().equals("") ) {
					txtUsername.setText("User Name");
					txtUsername.setForeground(Color.gray);
					txtUsername.setFont(new Font("Tahoma", Font.ITALIC, 11));
				}
			}
		});
		txtUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtUsername.getText().equals("User Name") ) {
					txtUsername.setText("");
					txtUsername.setForeground(Color.black);
					txtUsername.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
				}	
			}
		});
		txtUsername.setBounds(316, 73, 244, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		txtUsername.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		txtUsername.setText("User Name");
		txtUsername.setForeground(Color.gray);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAddress.getText().equals("") ) {
					txtAddress.setText("Email Address");
					txtAddress.setForeground(Color.gray);
					txtAddress.setFont(new Font("Tahoma", Font.ITALIC, 11));
				}
			}
		});
		txtAddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtAddress.getText().equals("Email Address") ) {
					txtAddress.setText("");
					txtAddress.setForeground(Color.black);
					txtAddress.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
				}	
			}
		});
		txtAddress.setBounds(316, 108, 182, 20);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		txtAddress.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		txtAddress.setText("Email Address");
		txtAddress.setForeground(Color.gray);
		
		JLabel lblNewLabel = new JLabel("@jmail.bg\r\n");
		lblNewLabel.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(503, 110, 57, 14);
		contentPane.add(lblNewLabel);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPass.getText().equals("") ) {
					txtPass.setEchoChar((char)0);
					txtPass.setText("Password");
					txtPass.setForeground(Color.gray);
					txtPass.setFont(new Font("Tahoma", Font.ITALIC, 11));
				}
			}
		});
		txtPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtPass.getText().equals("Password") ) {
					txtPass.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
					txtPass.setText("");
					txtPass.setForeground(Color.black);
					txtPass.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
				}	
			}
		});
		txtPass.setBounds(316, 146, 117, 20);
		contentPane.add(txtPass);
		txtPass.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		txtPass.setEchoChar((char)0);
		txtPass.setText("Password");
		txtPass.setForeground(Color.gray);
		
		txtPass_1 = new JPasswordField();
		txtPass_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtPass_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPass_1.getText().equals("") ) {
					txtPass_1.setEchoChar((char)0);
					txtPass_1.setText("Confirm password");
					txtPass_1.setForeground(Color.gray);
					txtPass_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
				}
			}
		});
		txtPass_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtPass_1.getText().equals("Confirm password") ) {
					txtPass_1.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
					txtPass_1.setText("");
					txtPass_1.setForeground(Color.black);
					txtPass_1.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
				}	
			}
		});
		txtPass_1.setBounds(443, 146, 117, 20);
		contentPane.add(txtPass_1);
		txtPass_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		txtPass_1.setEchoChar((char)0);
		txtPass_1.setText("Confirm password");
		txtPass_1.setForeground(Color.gray);
		
		JComboBox comboBox = new JComboBox();
		////////cobobox UI
		comboBox.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                return new BasicComboPopup(comboBox) {
                    @Override
                    protected JScrollPane createScroller() {
                        JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                        
                        scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                        	
                            @Override
                            protected JButton createDecreaseButton(int orientation) {
                                return createZeroButton();
                            }

                            @Override
                            protected JButton createIncreaseButton(int orientation) {
                                return createZeroButton();
                            }

                            @Override
                            public Dimension getPreferredSize(JComponent c) {
                                return new Dimension(10, super.getPreferredSize(c).height);
                            }

                            private JButton createZeroButton() {
                                return new JButton() {
                                    @Override
                                    public Dimension getMinimumSize() {
                                        return new Dimension(new Dimension(0, 0));
                                    }

                                    @Override
                                    public Dimension getPreferredSize() {
                                        return new Dimension(new Dimension(0, 0));
                                    }

                                    @Override
                                    public Dimension getMaximumSize() {
                                        return new Dimension(new Dimension(0, 0));
                                    }
                                };
                            }
                        });
                        return scroller;
                    }
                };
            }
        });
		comboBox.setRenderer(new DefaultListCellRenderer() {
		    @Override
		    public void paint(Graphics g) {
		        setBackground(Color.WHITE);
		        setForeground(Color.DARK_GRAY);
		        super.paint(g);
		    }
		});
		contentPane.add(comboBox);
		comboBox.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		//comboBox.setForeground(Color.DARK_GRAY);
		//comboBox.setBackground(Color.blue);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70"}));
		comboBox.setBounds(413, 172, 50, 22);
		comboBox.setBorder(new LineBorder(Color.GRAY, 1));
		
		
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnSignIn.setBackground(Color.ORANGE);
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if the credentials are correct create a new window for the main menu
			int index=users.size();	
			int age = Integer.parseInt((String)comboBox.getSelectedItem());
			
			//System.out.println(age);
				 
			//encrytion system
			//no is a method
//				char passCh[]=txtPass.getText().toCharArray();
//				for(int i=0;i<passCh.length;i++) {
//					passCh[i]=(char)((int)passCh[i]+4);
//				}
//				String EncPass = String. valueOf(passCh);
//			
				if(inputCheck(users , txtName. getText(), txtLname.getText(), txtUsername.getText(), txtPass.getText(), txtPass_1.getText(), txtAddress.getText(), lblFname, lblLname, lblUsername, lblAddress, lblPasswords)){				//if data is correct
					
					users.add(new user( txtName.getText() , txtLname.getText() , txtUsername.getText() , encrytion(txtPass.getText()) ,txtAddress.getText()+"@abv.bg",age));			//adding user
					
					//JOptionPane.showMessageDialog(null, "Hello mr. "+ users.get(index).lname);	
					//hello window
					menu menu=new menu(users, index);
					menu.setLocationRelativeTo(null);		//sets the window in the middle
					menu.setVisible(true);
					dispose();
				}
				
			}
		});
		btnSignIn.setBounds(333, 214, 201, 25);
		contentPane.add(btnSignIn);
		Border emptyBorder = BorderFactory.createEmptyBorder();
		btnSignIn.setBorder(emptyBorder);
		
		lblFname = new JLabel("");
		lblFname.setForeground(Color.decode("#dd5245"));
		lblFname.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblFname.setBounds(316, 22, 117, 14);
		contentPane.add(lblFname);
		
		lblLname = new JLabel("");
		lblLname.setForeground(Color.decode("#dd5245"));
		lblLname.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblLname.setBounds(443, 22, 117, 14);
		contentPane.add(lblLname);
		
		lblUsername = new JLabel("");
		lblUsername.setForeground(Color.decode("#dd5245"));
		lblUsername.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblUsername.setBounds(316, 61, 244, 14);
		contentPane.add(lblUsername);
		
		lblAddress = new JLabel("");
		lblAddress.setForeground(Color.decode("#dd5245"));
		lblAddress.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblAddress.setBounds(316, 94, 244, 14);
		contentPane.add(lblAddress);
		
		lblPasswords = new JLabel("");
		lblPasswords.setForeground(Color.decode("#dd5245"));
		lblPasswords.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblPasswords.setBounds(316, 133, 244, 14);
		contentPane.add(lblPasswords);
		
	}
	
	public static boolean inputCheck(ArrayList<user> a,String fname, String lname,String uname,String pass1,String pass2,String address, JLabel Fname, JLabel Lname, JLabel Username, JLabel Address, JLabel Passwords) {
		boolean bool=true;
		
		//	just for testing purposes
//			System.out.println(" fn: "+fname);
//			System.out.println(" ln: "+lname);
//			System.out.println(" un: "+uname);
//			System.out.println(" p1: "+pass1);
//			System.out.println(" p2: "+pass2);
//			System.out.println(" ad: "+address);
		
			//refreshing the invalid stuff from last attempt
			Fname.setText("");
			Lname.setText("");
			Username.setText("");
			Address.setText("");
			Passwords.setText("");
		
			// username check
			for(int i=0;i<a.size();i++) {
				if(a.get(i).uname.equals(uname)){
					bool=false;
					Username.setText("username taken");
					//JOptionPane.showMessageDialog(null, "username taken");
				
				}		
			}
			
			// pass checking
			
			if(pass1.equals(pass2)==false) {
				
				//System.out.println(" ckeck: "+pass1.equals(pass2));
				Passwords.setText("passwords don't match");
				bool=false;
				//JOptionPane.showMessageDialog(null, "passwords dont match");
			}
			
			//address checking
			
			for(int i=0;i<a.size();i++) {
				if(a.get(i).address.equals(address)){
					bool=false;
					//JOptionPane.showMessageDialog(null, "address taken");
				}		
			}
			
			// name and password lengths
			
			if(fname.length()>20){
				bool=false;
				Fname.setText("first name too long");
				//JOptionPane.showMessageDialog(null, "first name too long");
			}
			if(lname.length()>20){
				bool=false;
				Lname.setText("last name too long");
				//JOptionPane.showMessageDialog(null, "last name too long");
			}
			if(uname.length()>20){
				bool=false;
				Username.setText("username too long");
				//JOptionPane.showMessageDialog(null, "username too long");
			}
			if(pass1.length()>30){
				bool=false;
				Passwords.setText("password too long");
				//JOptionPane.showMessageDialog(null, "password too long");
			}
			if(address.length()>30){
				bool=false;
				Address.setText("address too long");
				//JOptionPane.showMessageDialog(null, "password too long");
			}
			
			
			
			if(fname.length()<4){
				bool=false;
				Fname.setText("first name too short");
				//JOptionPane.showMessageDialog(null, "first name too short");
			}
			if(lname.length()<4){
				bool=false;
				Lname.setText("last name too short");
				//JOptionPane.showMessageDialog(null, "last name too short");
			}
			if(uname.length()<4){
				bool=false;
				Username.setText("username too short");
				//JOptionPane.showMessageDialog(null, "username too short");
			}
			if(pass1.length()<6){
				bool=false;
				Passwords.setText("password too short");
				//JOptionPane.showMessageDialog(null, "password too short");
			}
			if(address.length()<6){
				bool=false;
				Address.setText("address too short");
				//JOptionPane.showMessageDialog(null, "password too short");
			}
				
		return bool;
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
