package packy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class editProf extends JFrame {
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
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtUname;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editProf frame = new editProf(a,indx);
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
	public editProf(ArrayList<user> users,int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		txtPass = new JPasswordField();
		txtPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPass.getText().equals(" Enter Password") ) {
					txtPass.setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
					//txtPassword. setEchoChar('•');
					txtPass.setText("");
					txtPass.setForeground(Color.black);
					txtPass.setFont(new Font("Tahoma", Font.PLAIN, 11));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPass.getText().equals("") ) {
					txtPass. setEchoChar((char)0);
					txtPass.setText(" Enter Password");
					txtPass.setFont(new Font("Tahoma", Font.ITALIC, 11));
					txtPass.setForeground(Color.GRAY);   //setForeground(Color.gray);
				}
			}
		});
		txtPass.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		txtPass. setEchoChar((char)0);
		txtPass.setText(" Enter Password");
		txtPass.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtPass.setForeground(Color.GRAY);
		txtPass.setBounds(125, 225, 200, 20);
		contentPane.add(txtPass);
		
		JLabel lblNewName = new JLabel("First name");
		lblNewName.setForeground(Color.DARK_GRAY);
		lblNewName.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		lblNewName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewName.setBounds(130, 115, 80, 15);
		contentPane.add(lblNewName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setForeground(Color.DARK_GRAY);
		lblLastName.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(130, 140, 80, 15);
		contentPane.add(lblLastName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.DARK_GRAY);
		lblUsername.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(130, 165, 80, 15);
		contentPane.add(lblUsername);
		
		txtFname = new JTextField();
		txtFname.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		txtFname.setText("fname");
		txtFname.setBounds(225, 110, 163, 20);
		contentPane.add(txtFname);
		txtFname.setColumns(10);
		
		txtLname = new JTextField();
		txtLname.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		txtLname.setText("lname");
		txtLname.setBounds(225, 135, 163, 20);
		contentPane.add(txtLname);
		txtLname.setColumns(10);
		
		txtUname = new JTextField();
		txtUname.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		txtUname.setText("uname");
		txtUname.setBounds(225, 160, 163, 20);
		contentPane.add(txtUname);
		txtUname.setColumns(10);
		
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
		        setForeground(Color.BLACK);
		        super.paint(g);
		    }
		});
		comboBox.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		contentPane.add(comboBox);
		comboBox.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		//comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70"}));
		comboBox.setBounds(225, 185, 62, 22);
		contentPane.add(comboBox);
		
		// setting the old data for users ease
		txtFname.setText(users.get(index).fname);
		txtLname.setText(users.get(index).lname);
		txtUname.setText(users.get(index).uname);
		
		JLabel lblUname = new JLabel("");
		lblUname.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblUname.setForeground(Color.decode("#dd5245"));
		lblUname.setBounds(388, 163, 62, 14);
		contentPane.add(lblUname);
		
		JLabel lblPass = new JLabel("");
		lblPass.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblPass.setForeground(Color.decode("#dd5245"));
		lblPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblPass.setBounds(125, 210, 200, 14);
		contentPane.add(lblPass);
		
		JLabel lblLname = new JLabel("");
		lblLname.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblLname.setForeground(Color.decode("#dd5245"));
		lblLname.setBounds(388, 140, 62, 14);
		contentPane.add(lblLname);
		
		JLabel lblFname = new JLabel("");
		lblFname.setFont(new Font("Poppins Medium", Font.PLAIN, 11));
		lblFname.setForeground(Color.decode("#dd5245"));
		lblFname.setBounds(388, 115, 62, 14);
		contentPane.add(lblFname);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.ORANGE);
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFname.setText("");
				lblLname.setText("");
				lblUname.setText("");
				lblPass.setText("");
				
					if(txtFname.getText().length()>20){
						lblFname.setText("too long");
						}else {
						if(txtLname.getText().length()>20){
							lblLname.setText("too long");
							}else {
							if(txtUname.getText().length()>20){
								lblUname.setText("too long");
								}else {	
								//if the password is  correct just do the changes and return to info menu
								if(check(txtUname.getText(),users,index,lblUname)) {
									if(encrytion(txtPass.getText()).equals(users.get(index).pass)) {
										users.get(index).fname = txtFname.getText();
										users.get(index).lname = txtLname.getText();
										users.get(index).uname = txtUname.getText();
										
										//JOptionPane.showMessageDialog(null, "chenges saved successfully");
										
										myInfo obj=new myInfo(users,index);
										obj.setLocationRelativeTo(null);		//sets the window in the middle
										obj.setVisible(true);
										dispose();
									}else {
										lblPass.setText("wrong password");
										//JOptionPane.showMessageDialog(null, "wrong password");
									}
								}else {
									lblUname.setText("taken");
									//JOptionPane.showMessageDialog(null, "username taken");
								}
							}
						}
				}
			}
		});
		btnSave.setBounds(150, 260, 150, 20);
		contentPane.add(btnSave);
		btnSave.setBorder(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 450, 105);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(editProf.class.getResource("/packy/back_icon_30.png")));
		btnBack.setBackground(Color.ORANGE);
		btnBack.setBounds(0, 0, 40, 40);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(editProf.class.getResource("/packy/man_icon_80.png")));
		lblNewLabel.setBounds(125, -5, 105, 105);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Edit");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Poppins SemiBold", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(225, 30, 100, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Profile");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Poppins SemiBold", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(225, 60, 100, 30);
		panel.add(lblNewLabel_2);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myInfo obj=new myInfo(users,index);
				obj.setLocationRelativeTo(null);		//sets the window in the middle
				obj.setVisible(true);
				dispose();
			}
		});
		btnBack.setBorder(null);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		lblAge.setForeground(Color.DARK_GRAY);
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setBounds(130, 190, 80, 15);
		contentPane.add(lblAge);
		
	}
	public static String encrytion(String pass) {
		char passCh[]=pass.toCharArray();
		for(int i=0;i<passCh.length;i++) {
			passCh[i]=(char)((int)passCh[i]+4);
		}
		String str = String. valueOf(passCh);
		return str;
	}
	public static boolean check(String uname, ArrayList<user> a,int indx,JLabel lblUname) {
		boolean check=true;
		
			if(a.get(indx).uname.equals(uname)==false) {
				if(uname.length()<6){
					lblUname.setText("too short");
					check=false;
				}else {
					for(int i=0;i<a.size();i++) {
						if(a.get(i).uname.equals(uname)){
							check=false;
						}
					}
				}
				
			}
		return check;
	}
}
