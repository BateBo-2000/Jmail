package packy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class afterwrite extends JFrame {
	static ArrayList<user> a=new ArrayList<user>();
	static int indx;
	static boolean b;
	static String r;
	
	public static String getR() {
		return r;
	}

	public static void setR(String r) {
		afterwrite.r = r;
	}

	public static boolean isB() {
		return b;
	}

	public static void setB(boolean b) {
		afterwrite.b = b;
	}

	public static ArrayList<user> getA() {
		return a;
	}

	public static void setA(ArrayList<user> a) {
		afterwrite.a = a;
	}

	public static int getId() {
		return indx;
	}

	public static void setId(int id) {
		afterwrite.indx = id;
	}

	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afterwrite frame = new afterwrite(a,indx,b,r);
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
	public afterwrite(ArrayList<user> users,int index,boolean status,String reciever) {
		String stat="a";
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		
		contentPane.setLayout(null);
		
		JLabel lblStatus_1 = new JLabel("Massage sent");
		lblStatus_1.setForeground(Color.ORANGE);
		lblStatus_1.setFont(new Font("Poppins SemiBold", Font.PLAIN, 20));
		lblStatus_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus_1.setBounds(0, 125, 450, 35);
		contentPane.add(lblStatus_1);
		

		
		JPanel panel = new JPanel();
		
		panel.setBounds(0, 225, 450, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNext = new JButton("Okay");
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Poppins SemiBold", Font.BOLD, 13));
		btnNext.setBounds(180, 26, 90, 25);
		panel.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				//System.out.println(users.get(0).inbox.get(1).sender+ " " + users.get(0).inbox.get(1).title + " " + users.get(0).inbox.get(1).text);
			}
		});
		btnNext.setBorder(new LineBorder(Color.WHITE , 2));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel.setBounds(0, 10, 450, 90);
		contentPane.add(lblNewLabel);
		
		JLabel lblStatus = new JLabel();
		
		if(status) {
			stat="successfully";
			panel.setBackground(Color.ORANGE);
			lblNewLabel.setIcon(new ImageIcon(afterwrite.class.getResource("/packy/message_successful_80.png")));
			btnNext.setBackground(Color.ORANGE);
			lblStatus_1.setForeground(Color.ORANGE);
			lblStatus.setForeground(Color.ORANGE);
		}else {
			stat="UNSUCCESSFULLY";
			panel.setBackground(Color.decode("#dd5245"));
			lblNewLabel.setIcon(new ImageIcon(afterwrite.class.getResource("/packy/message_unsuccessful_80.png")));
			btnNext.setBackground(Color.decode("#dd5245"));
			lblStatus_1.setForeground(Color.decode("#dd5245"));
			lblStatus.setForeground(Color.decode("#dd5245"));
			
		}
		
		lblStatus.setText(stat+"!");
		lblStatus.setFont(new Font("Poppins SemiBold", Font.PLAIN, 20));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(0, 160, 450, 35);
		contentPane.add(lblStatus);
	}

}
