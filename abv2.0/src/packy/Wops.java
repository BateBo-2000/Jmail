/**
 * 
 */
package packy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

/**
 * @author PC
 *
 */
public class Wops extends JFrame {
	
	static ArrayList<user> a=new ArrayList<user>();

	public static ArrayList<user> getA() {
		return a;
	}

	public static void setA(ArrayList<user> a) {
		login.a = a;
	}

	private JPanel contentPane;
	private JTextArea textField;
	private JTextArea textField_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Wops frame = new Wops(a);
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
	public Wops(ArrayList<user> users) {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblLong = new JLabel("Contact or Text too long");
		lblLong.setBounds(111, 270, 197, 14);
		getContentPane().add(lblLong);
		lblLong.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		lblLong.setForeground(Color.decode("#dd5245"));
		contentPane.add(lblLong);
		lblLong.setVisible(false);
		
		
		textField = new JTextArea();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField.getText().equals("") ) {
					textField.setText(" Avalable contact");
					textField.setForeground(Color.gray);
					textField.setFont(new Font("Tahoma", Font.ITALIC, 11));
				}
			}
		});
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().equals(" Avalable contact") ) {
					textField.setText("");
					textField.setForeground(Color.black);
					textField.setFont(new Font("Poppins", Font.PLAIN, 11));
				}	
			}
		});
		textField.setBounds(111, 91, 329, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(" Avalable contact");
		textField.setForeground(Color.gray);
		textField.setFont(new Font("Tahoma", Font.ITALIC, 11));
		textField.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		
		
		
		textField_1 = new JTextArea();
		textField_1.setBounds(111, 122, 329, 133);
		textField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(textField_1.getText().equals("") ) {
					textField_1.setText(" Describe the problem here ... (270 characters max)");
					textField_1.setForeground(Color.gray);
					textField_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
				}
			}
		});
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField_1.getText().equals(" Describe the problem here ... (270 characters max)") ) {
					textField_1.setText("");
					textField_1.setForeground(Color.black);
					textField_1.setFont(new Font("Poppins", Font.PLAIN, 11));
				}	
			}
		});

		textField_1.setText(" Describe the problem here ... (270 characters max)");
		textField_1.setForeground(Color.gray);
		textField_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setLineWrap(true);
		textField_1.setWrapStyleWord(true);
		textField_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		
		//date
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		//System.out.println(dtf.format(now));
		String date=now.toString();
		
		lblLong.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("Send");
		btnNewButton_1.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean status= false;
				
				lblLong.setVisible(false);
				
				if(textField.getText().length()>40) {
					lblLong.setVisible(true);
					lblLong.setText("Title is over 40 characters");
				}else {
					if(textField_1.getText().length()>270) {
						lblLong.setVisible(true);
						lblLong.setText("Message is over 270 characters");
					}else {
								//adding the message
								users.get(0).inbox.add(new mail(/*sender (the user who is typing aka the id)*/	"contact: "+textField.getText(),	/*title*/ "HELP"	, /*text*/  textField_1.getText(), dtf.format(now) ));
								//checking if the message was actually sent
								login log=new login(users);
								log.setLocationRelativeTo(null);		//sets the window in the middle
								log.setVisible(true);
								dispose();
							}
						}	
						
					}
		
		});
		btnNewButton_1.setBounds(318, 266, 122, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.setBorder(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 104, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login log=new login(users);
				log.setLocationRelativeTo(null);		//sets the window in the middle
				log.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(Wops.class.getResource("/packy/back_icon_30.png")));
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(0, 0, 40, 40);
		panel.add(btnNewButton);
		btnNewButton.setBorder(null);
		
		
	}
}
