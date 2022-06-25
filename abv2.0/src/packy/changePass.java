package packy;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;

public class changePass extends JFrame {
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
	private JPasswordField pwdOp;
	private JPasswordField pwdNp;
	private JPasswordField pwdNp_1;
	private JLabel lblNewLabel;
	private JLabel lblPassword;
	private JLabel lblPas;
	private JLabel lblPas_1;
	private JLabel lblPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changePass frame = new changePass(a,indx);
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
	public changePass(ArrayList<user> users,int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		lblPas = new JLabel("");
		lblPas.setForeground(Color.decode("#dd5245"));
		lblPas.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblPas.setBounds(155, 118, 140, 14);
		contentPane.add(lblPas);
		
		lblPas_1 = new JLabel("");
		lblPas_1.setForeground(Color.decode("#dd5245"));
		lblPas_1.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblPas_1.setBounds(155, 157, 140, 14);
		contentPane.add(lblPas_1);
		
		lblPass = new JLabel("");
		lblPass.setForeground(Color.decode("#dd5245"));
		lblPass.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setBounds(0, 235, 450, 14);
		contentPane.add(lblPass);
		
		pwdOp = new JPasswordField();
		pwdOp.setBounds(155, 130, 140, 20);
		contentPane.add(pwdOp);
		pwdOp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdOp.getText().equals(" Old Password") ) {
					pwdOp.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
					//txtPassword. setEchoChar('•');
					pwdOp.setText("");
					pwdOp.setForeground(Color.black);
					pwdOp.setFont(new Font("Tahoma", Font.PLAIN, 11));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdOp.getText().equals("") ) {
					pwdOp. setEchoChar((char)0);
					pwdOp.setText(" Old Password");
					pwdOp.setFont(new Font("Tahoma", Font.ITALIC, 11));
					pwdOp.setForeground(Color.GRAY);   //setForeground(Color.gray);
				}
			}
		});
		pwdOp.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		pwdOp. setEchoChar((char)0);
		pwdOp.setText(" Old Password");
		pwdOp.setFont(new Font("Tahoma", Font.ITALIC, 11));
		pwdOp.setForeground(Color.GRAY);
		
		
		
		pwdNp = new JPasswordField();
		pwdNp.setBounds(155, 170, 140, 20);
		contentPane.add(pwdNp);
		pwdNp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdNp.getText().equals(" New Password") ) {
					pwdNp.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
					//txtPassword. setEchoChar('•');
					pwdNp.setText("");
					pwdNp.setForeground(Color.black);
					pwdNp.setFont(new Font("Tahoma", Font.PLAIN, 11));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdNp.getText().equals("") ) {
					pwdNp. setEchoChar((char)0);
					pwdNp.setText(" New Password");
					pwdNp.setFont(new Font("Tahoma", Font.ITALIC, 11));
					pwdNp.setForeground(Color.GRAY);   //setForeground(Color.gray);
				}
			}
		});
		pwdNp.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		pwdNp. setEchoChar((char)0);
		pwdNp.setText(" New Password");
		pwdNp.setFont(new Font("Tahoma", Font.ITALIC, 11));
		pwdNp.setForeground(Color.GRAY);
		
		
		pwdNp_1 = new JPasswordField();
		pwdNp_1.setBounds(155, 210, 140, 20);
		contentPane.add(pwdNp_1);
		pwdNp_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdNp_1.getText().equals(" Confirm Password") ) {
					pwdNp_1.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
					//txtPassword. setEchoChar('•');
					pwdNp_1.setText("");
					pwdNp_1.setForeground(Color.black);
					pwdNp_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(pwdNp_1.getText().equals("") ) {
					pwdNp_1. setEchoChar((char)0);
					pwdNp_1.setText(" Confirm Password");
					pwdNp_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
					pwdNp_1.setForeground(Color.GRAY);   //setForeground(Color.gray);
				}
			}
		});
		pwdNp_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		pwdNp_1. setEchoChar((char)0);
		pwdNp_1.setText(" Confirm Password");
		pwdNp_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		pwdNp_1.setForeground(Color.GRAY);
		
		@SuppressWarnings("deprecation")
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnSave.setBackground(Color.ORANGE);
		btnSave.setForeground(Color.WHITE);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPass.setText("");
				lblPas_1.setText("");
				lblPas.setText("");
				
				if(pwdNp.getText().equals(pwdNp_1.getText())) {
					if(pwdNp.getText().length()>30) {
						lblPas_1.setText("new password too long");
						//JOptionPane.showMessageDialog(null, "new password too long");
					}else {
						if(pwdNp.getText().length()<6) { 													//if new equals is too short err massage
							lblPas_1.setText("new password too short");
							//JOptionPane.showMessageDialog(null, "new password too short");
						}else {
							if(encrytion(pwdNp.getText()).equals(users.get(index).pass)) { 													//if new equals old pass err massage
								lblPass.setText("can't change password to present password");
								//JOptionPane.showMessageDialog(null, "cant change password to present password");
							}else {
								
								if(encrytion(pwdOp.getText()).equals(users.get(index).pass)) { //if the new passwords are same and the old is correct save the changes
									users.get(index).pass = encrytion(pwdNp.getText());														
									//JOptionPane.showMessageDialog(null, "chenges saved successfully");
									myInfo obj=new myInfo(users,index);
									obj.setLocationRelativeTo(null);		//sets the window in the middle
									obj.setVisible(true);
									dispose();
								}else {
									lblPas.setText("wrong password");
									//JOptionPane.showMessageDialog(null, "wrong password");
								}	
							}
						}
					}
				}else {
					lblPas_1.setText("passwords don't match");
				}
			}
		});
		btnSave.setBounds(174, 250, 89, 23);
		contentPane.add(btnSave);
		btnSave.setBorder(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 450, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("");
		btnBack.setBackground(Color.ORANGE);
		btnBack.setIcon(new ImageIcon(changePass.class.getResource("/packy/back_icon_30.png")));
		btnBack.setBounds(0, 0, 40, 40);
		panel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				myInfo obj=new myInfo(users,index);
				obj.setLocationRelativeTo(null);		//sets the window in the middle
				obj.setVisible(true);
				dispose();
				
			}
		});
		btnBack.setBorder(null);
		
		JLabel lblOldPass = new JLabel("");
		lblOldPass.setIcon(new ImageIcon(changePass.class.getResource("/packy/lock_icon_75.png")));
		lblOldPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblOldPass.setBounds(110, 0, 90, 100);
		panel.add(lblOldPass);
		
		lblNewLabel = new JLabel("Change");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 25));
		lblNewLabel.setBounds(200, 18, 153, 30);
		panel.add(lblNewLabel);
		
		lblPassword = new JLabel("password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Poppins", Font.BOLD, 25));
		lblPassword.setBounds(200, 50, 153, 30);
		panel.add(lblPassword);
		
		
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
