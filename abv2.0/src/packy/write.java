package packy;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class write extends JFrame {
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
	public JTextField txtAddressBar;
	private JTextField txtTitle;
	private JTextArea txtText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					write frame = new write(a,indx);
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
	public write(ArrayList<user> users,int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 401);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JLabel lblSendTo = new JLabel("To:");
		lblSendTo.setForeground(Color.WHITE);
		lblSendTo.setFont(new Font("Poppins", Font.BOLD, 15));
		lblSendTo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSendTo.setBounds(90, 145, 70, 20);
		contentPane.add(lblSendTo);
		
		txtAddressBar = new JTextField();
		txtAddressBar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAddressBar.getText().equals("") ) {
					txtAddressBar.setText(" Email");
					txtAddressBar.setForeground(Color.gray);
					txtAddressBar.setFont(new Font("Tahoma", Font.ITALIC, 11));
				}
			}
		});
		txtAddressBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtAddressBar.getText().equals(" Email") ) {
					txtAddressBar.setText("");
					txtAddressBar.setForeground(Color.black);
					txtAddressBar.setFont(new Font("Poppins", Font.PLAIN, 11));
				}	
			}
		});
		txtAddressBar.setText(" Email");
		txtAddressBar.setForeground(Color.gray);
		txtAddressBar.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtAddressBar.setBounds(180, 146, 369, 20);
		contentPane.add(txtAddressBar);
		txtAddressBar.setColumns(10);
		txtAddressBar.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setFont(new Font("Poppins", Font.BOLD, 15));
		lblTitle.setBounds(90, 175, 70, 20);
		contentPane.add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtTitle.getText().equals("") ) {
					txtTitle.setText("  Title up to 40 characters");
					txtTitle.setForeground(Color.gray);
					txtTitle.setFont(new Font("Tahoma", Font.ITALIC, 11));
				}
			}
		});
		txtTitle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtTitle.getText().equals("  Title up to 40 characters") ) {
					txtTitle.setText("");
					txtTitle.setForeground(Color.black);
					txtTitle.setFont(new Font("Poppins", Font.PLAIN, 11));
				}	
			}
		});
		txtTitle.setBounds(180, 176, 369, 20);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		txtTitle.setText("  Title up to 40 characters");
		txtTitle.setForeground(Color.gray);
		txtTitle.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtTitle.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		
		JLabel lblText = new JLabel("Message:");
		lblText.setFont(new Font("Poppins", Font.BOLD, 15));
		lblText.setHorizontalAlignment(SwingConstants.RIGHT);
		lblText.setForeground(Color.WHITE);
		lblText.setBounds(55, 205, 105, 20);
		contentPane.add(lblText);
		
		JLabel lblLong = new JLabel("Message is over 270 characters");
		lblLong.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		lblLong.setForeground(Color.decode("#dd5245"));
		lblLong.setBounds(180, 335, 182, 30);
		contentPane.add(lblLong);
		lblLong.setVisible(false);
		
		txtText = new JTextArea();
		txtText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtText.getText().equals("") ) {
					txtText.setText(" Write the message here ... (270 characters max)");
					txtText.setForeground(Color.gray);
					txtText.setFont(new Font("Tahoma", Font.ITALIC, 11));
				}
			}
		});
		txtText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtText.getText().equals(" Write the message here ... (270 characters max)") ) {
					txtText.setText("");
					txtText.setForeground(Color.black);
					txtText.setFont(new Font("Poppins", Font.PLAIN, 11));
				}	
			}
		});

		txtText.setText(" Write the message here ... (270 characters max)");
		txtText.setForeground(Color.gray);
		txtText.setFont(new Font("Tahoma", Font.ITALIC, 11));
		contentPane.add(txtText);
		txtText.setBounds(180, 207, 369, 117);
		txtText.setColumns(10);
		txtText.setLineWrap(true);
		txtText.setWrapStyleWord(true);
		txtText.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		//System.out.println(dtf.format(now));
		String date=now.toString();
		
		JButton btnSend = new JButton("Send message");
		btnSend.setBackground(Color.ORANGE);
		btnSend.setFont(new Font("Poppins SemiBold", Font.PLAIN, 12));
		btnSend.setForeground(Color.WHITE);
		btnSend.setBounds(372, 335, 177, 25);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean status= false;
				String sentTo=txtAddressBar.getText();
				
				lblLong.setVisible(false);
				
				if(txtTitle.getText().length()>40) {
					lblLong.setVisible(true);
					lblLong.setText("Title is over 40 characters");
				}else {
					if(txtText.getText().length()>270) {
						lblLong.setVisible(true);
						lblLong.setText("Message is over 270 characters");
					}else {
						for(int i=0;i<users.size();i++) {
							if(users.get(i).address.equals(sentTo)) {
								//adding the message
								users.get(i).inbox.add(new mail(/*sender (the user who is typing aka the id)*/	users.get(index).address,	/*title*/	txtTitle.getText(), /*text*/  txtText.getText(), dtf.format(now) ));
								//checking if the message was actually sent
								status=true;
							}
						}
					
				//	some testing stuff	
	//				System.out.println("reciever "+txtAddressBar.getText());
	//				System.out.println("title " +txtTitle.getText());
	//				System.out.println("text "+txtText.getText());
	//				System.out.println("sender id "+index);
	//				System.out.println("sender address "+users.get(index).address);
					
					menu menu=new menu(users, index);
					menu.setLocationRelativeTo(null);		//sets the window in the middle
					menu.setVisible(true);
					
					afterwrite obj=new afterwrite(users,index,status,sentTo);
					obj.setLocationRelativeTo(null);		//sets the window in the middle
					obj.setVisible(true);
					dispose();
					}
				}
			}
		});
		contentPane.add(btnSend);
		btnSend.setBorder(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 170, 401);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(write.class.getResource("/packy/back_icon_30.png")));
		btnBack.setBackground(Color.ORANGE);
		btnBack.setBounds(0, 0, 40, 40);
		panel.add(btnBack);
		btnBack.setBorder(null);
		
		JLabel lblDickpic = new JLabel("");
		lblDickpic.setIcon(new ImageIcon(write.class.getResource("/packy/pencil_icon_90.png")));
		lblDickpic.setHorizontalAlignment(SwingConstants.CENTER);
		lblDickpic.setBounds(25, 25, 120, 120);
		panel.add(lblDickpic);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(write.class.getResource("/packy/jmail_orange_90.png")));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(180, 11, 369, 124);
		contentPane.add(lblLogo);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu menu=new menu(users,index);
				menu.setLocationRelativeTo(null);		//sets the window in the middle
				menu.setVisible(true);
				dispose();
			}
		});
		
	}
}
