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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class myInfo extends JFrame {
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myInfo frame = new myInfo(a,indx);
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
	public myInfo(ArrayList<user> users,int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		//delete profile
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setForeground(Color.decode("#dd5245"));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setFont(new Font("Poppins SemiBold", Font.BOLD, 15));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteProfile obj=new deleteProfile(users,index);
				obj.setLocationRelativeTo(null);		//sets the window in the middle
				obj.setVisible(true);
				dispose();
			}
		});
		btnDelete.setBounds(280, 230, 90, 40);
		contentPane.add(btnDelete);
		btnDelete.setBorder(new LineBorder(Color.decode("#dd5245"), 3));
		
		//changing data
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setBackground(Color.ORANGE);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editProf obj=new editProf(users,index);
				obj.setLocationRelativeTo(null);		//sets the window in the middle
				obj.setVisible(true);
				dispose();
				
			}
		});
		btnEdit.setBounds(30, 216, 105, 25);
		contentPane.add(btnEdit);
		btnEdit.setBorder(null);
		
		
		//changing pass
		JButton btnChangePass = new JButton("Change Password");
		btnChangePass.setForeground(Color.WHITE);
		btnChangePass.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnChangePass.setBackground(Color.ORANGE);
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				changePass obj=new changePass(users,index);
				obj.setLocationRelativeTo(null);		//sets the window in the middle
				obj.setVisible(true);
				dispose();
				
			}
		});
		btnChangePass.setBorder(null);
		btnChangePass.setBounds(30, 257, 105, 25);
		contentPane.add(btnChangePass);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setForeground(Color.ORANGE);
		panel.setBounds(0, 0, 400, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFname = new JLabel("fname");
		lblFname.setForeground(Color.WHITE);
		lblFname.setFont(new Font("Poppins SemiBold", Font.PLAIN, 20));
		lblFname.setBounds(200, 30, 190, 25);
		panel.add(lblFname);
		
		// setting the labels
		lblFname.setText(users.get(index).fname);
		
		JLabel lblLname = new JLabel("lname");
		lblLname.setForeground(Color.WHITE);
		lblLname.setFont(new Font("Poppins SemiBold", Font.PLAIN, 20));
		lblLname.setBounds(200, 55, 190, 25);
		panel.add(lblLname);
		lblLname.setText(users.get(index).lname);
		
		JLabel lblUname = new JLabel("uname");
		lblUname.setForeground(Color.WHITE);
		lblUname.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		lblUname.setBounds(200, 90, 190, 15);
		panel.add(lblUname);
		lblUname.setText("a.k.a. "+users.get(index).uname);
		
		JLabel lblAdd = new JLabel("add");
		lblAdd.setForeground(Color.WHITE);
		lblAdd.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		lblAdd.setBounds(200, 115, 190, 15);
		panel.add(lblAdd);
		lblAdd.setText(users.get(index).address);
		
		JLabel lblAge_1 = new JLabel("age");
		lblAge_1.setForeground(Color.WHITE);
		lblAge_1.setFont(new Font("Poppins Medium", Font.PLAIN, 15));
		lblAge_1.setBounds(200, 140, 190, 15);
		panel.add(lblAge_1);
		lblAge_1.setText(Integer.toString(users.get(index).age)+" years old");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(myInfo.class.getResource("/packy/man_icon_120.png")));
		lblNewLabel.setBounds(35, 35, 130, 120);
		panel.add(lblNewLabel);
		
		
		
		//buttons 
	
		//back button
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(myInfo.class.getResource("/packy/back_icon_30.png")));
		btnBack.setBackground(Color.ORANGE);
		btnBack.setBounds(0, 0, 45, 45);
		panel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu obj=new menu(users,index);
				obj.setLocationRelativeTo(null);		//sets the window in the middle
				obj.setVisible(true);
				dispose();
			}
		});
		btnBack.setBorder(null);
	}
}
