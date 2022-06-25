package packy;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class read extends JFrame {
	static ArrayList<user> a=new ArrayList<user>();
	static int indx;
	static int indx2;
	
	public static int getIndx2() {
		return indx2;
	}
	public static void setIndx2(int indx2) {
		read.indx2 = indx2;
	}
	public static ArrayList<user> getA() {
		return a;
	}
	public static void setA(ArrayList<user> a) {
		read.a = a;
	}
	public static int getIndx() {
		return indx;
	}
	public static void setIndx(int indx) {
		read.indx = indx;
	}
	
	boolean del=false;
	
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					read frame = new read(a,indx,indx2);
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
	public read(ArrayList<user> users, int index,int mailindex) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		
		JButton btnRespond = new JButton("Reply");
		btnRespond.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnRespond.setForeground(Color.WHITE);
		btnRespond.setBackground(Color.ORANGE);
		btnRespond.setBounds(100, 366, 130, 25);
		btnRespond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				write obj=new write(users,index);
				obj.setLocationRelativeTo(null);		//sets the window in the middle
				obj.setVisible(true);
				obj.txtAddressBar.setText(users.get(index).inbox.get(mailindex).sender);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnRespond);
		btnRespond.setBorder(null);
		
		//warning
		
		JLabel lblPermaBan = new JLabel("Do you want to delete this message permanently?");
		lblPermaBan.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		lblPermaBan.setBounds(98, 345, 402, 14);
		lblPermaBan.setForeground(Color.decode("#dd5245"));
		lblPermaBan.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPermaBan);
		lblPermaBan.setVisible(false);
		
		
		//deleting the message
		
		JButton btnDelmes = new JButton("Delete message");
		btnDelmes.setBackground(Color.decode("#dd5245"));
		btnDelmes.setForeground(Color.WHITE);
		btnDelmes.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnDelmes.setBounds(370, 366, 130, 25);
		btnDelmes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(del) {
					boolean b = (users.get(index).inbox.remove(mailindex) != null);
					menu obj=new menu(users,index);
					obj.setLocationRelativeTo(null);		//sets the window in the middle
					obj.setVisible(true);
					dispose();
					
				}else{
					del=true;
					lblPermaBan.setVisible(true);
				}
				
			}
		});
		contentPane.add(btnDelmes);
		btnDelmes.setBorder(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 170);
		panel.setBackground(Color.ORANGE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("");
		btnBack.setBounds(0, 0, 40, 40);
		panel.add(btnBack);
		btnBack.setIcon(new ImageIcon(read.class.getResource("/packy/back_icon_30.png")));
		btnBack.setBackground(Color.ORANGE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu obj=new menu(users,index);
				obj.setLocationRelativeTo(null);		//sets the window in the middle
				obj.setVisible(true);
				dispose();
			}
		});
		btnBack.setBorder(null);
		
		JLabel lblMan = new JLabel("");
		lblMan.setHorizontalAlignment(SwingConstants.CENTER);
		lblMan.setIcon(new ImageIcon(read.class.getResource("/packy/man_icon_120.png")));
		lblMan.setBounds(110, 11, 140, 140);
		panel.add(lblMan);
		
		//sender
		
		JLabel label = new JLabel("By "+users.get(index).inbox.get(mailindex).sender);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Poppins SemiBold", Font.PLAIN, 18));
		label.setBounds(260, 100, 340, 30);
		panel.add(label);
		
		JTextArea label_1 = new JTextArea();
		label_1.setEditable(false);
		label_1.setBackground(Color.ORANGE);
		label_1.setText(users.get(index).inbox.get(mailindex).title);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Poppins", Font.BOLD, 22));
		label_1.setBounds(260, 30, 340, 60);
		panel.add(label_1);
		label_1.setLineWrap(true);
		label_1.setWrapStyleWord(true);
		
		JTextArea label_2 = new JTextArea();
		label_2.setBounds(100, 175, 400, 160);
		contentPane.add(label_2);
		label_2.setBackground(Color.WHITE);
		label_2.setFont(new Font("Poppins", Font.PLAIN, 13));
		label_2.setEditable(false);
		label_2.setText(users.get(index).inbox.get(mailindex).text);
		label_2.setBorder(null);
		label_2.setLineWrap(true);
		label_2.setWrapStyleWord(true);
		
		
	}
}
