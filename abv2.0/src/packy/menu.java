package packy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.CompoundBorder;
import javax.swing.ListSelectionModel;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;


public class menu extends JFrame {
	static ArrayList<user> a=new ArrayList<user>();
	static int indx;
	
	public static ArrayList<user> getA() {
		return a;
	}

	public static void setA(ArrayList<user> a) {
		menu.a = a;
	}

	public static int getB() {
		return indx;
	}

	public static void setB(int b) {
		menu.indx = b;
	}
	
	
	
	private JPanel contentPane;
	private JTable table_3;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu(a,indx);
					//frame.setLocationRelativeTo(null);		//sets the window in the middle
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public menu(ArrayList<user> users,int index) {
		//frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		//scroll
		JScrollPane scrollPane = new JScrollPane();					//makes column names show
		scrollPane.setBounds(215, 25, 410, 400);
		scrollPane.setToolTipText("");								//scroll if needed
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(scrollPane);
		
		
		
		//table
		DefaultTableModel model = new DefaultTableModel();
		table_3 = new JTable(model)
		{
		    public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
		    {
		        Component c = super.prepareRenderer(renderer, row, column);
		        
		        

		        int modelRow = convertRowIndexToModel(row);
		        String value = (String)getModel().getValueAt(modelRow, 3);
		        Font myFont_1 = new Font("Poppins", Font.BOLD, 12);
		        Font myFont = new Font("Poppins", Font.PLAIN, 12);
		        c.setFont(myFont);
		        c.setBackground(Color.WHITE);
		        
		        
		        if (value.equals("false")) c.setFont(myFont_1);
		        if (column == 1) c.setBackground(Color.decode("#ededed"));  //gray in the middle
		        
		        super.setShowVerticalLines(false);
		        
		        if (isRowSelected(row))
					c.setBackground(Color.LIGHT_GRAY); 						//selection gray

		        
		        return c;
		    }

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		    
		}; 
		
		
		
		///////////////////////////

	    JTableHeader header = table_3.getTableHeader();
	    
	    final DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
	    renderer.setBorder(new LineBorder(Color.WHITE)); //Remove border from the renderer (which is just a JLabel)...
	    renderer.setBackground(Color.ORANGE);
	    
	    //Apply the renderer to all header cells and all data cells:
	    header.setDefaultRenderer(renderer);
	    
		////////////////////////////
		scrollPane.setViewportView(table_3);
		
			// Create a couple of columns 
		model.addColumn("Date"); 
		model.addColumn("Sender"); 
		model.addColumn("Title"); 
		model.addColumn("Status"); 
		
			// Append a row 
		int inboxSize=users.get(index).inbox.size();
		for(int i=0;i<inboxSize;i++) {				
			
			if(users.get(index).inbox.get(i).read) {						//if not read its bold				
				model.addRow(new Object[]{users.get(index).inbox.get(i).date, users.get(index).inbox.get(i).sender, users.get(index).inbox.get(i).title, "true"});
			}else {
				model.addRow(new Object[]{users.get(index).inbox.get(i).date, users.get(index).inbox.get(i).sender, users.get(index).inbox.get(i).title, "false"});
				
			}
						
		}
		
		delTblCol(table_3, 3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 190, 450);
		contentPane.add(panel);
		panel.setLayout(null);
		
			//design
		table_3.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setBorder(new LineBorder(Color.LIGHT_GRAY,3));
		//scrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		table_3.setBorder(BorderFactory.createEmptyBorder());
		table_3.setFillsViewportHeight(true);
		table_3.setBackground(Color.decode("#fff4bb"));
		
		
		
		
		//Logout
		
		JButton btnLogout = new JButton("logout");
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setBounds(0, 175, 190, 25);
		panel.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Bye B1t4");
				login log=new login(users);
				log.setLocationRelativeTo(null);		//sets the window in the middle
				log.setVisible(true);
				dispose();
			}
		});
		btnLogout.setBorder(BorderFactory.createEmptyBorder());
		
		
		//writing
		
		JButton btnWrite = new JButton("write");
		btnWrite.setBackground(Color.WHITE);
		btnWrite.setBounds(0, 362, 190, 25);
		panel.add(btnWrite);
		btnWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				write obj=new write(users,index);
				obj.setLocationRelativeTo(null);		//sets the window in the middle
				obj.setVisible(true);
				dispose();
			}
		});
		btnWrite.setBorder(BorderFactory.createEmptyBorder());
		
		
		//account view
		
		JButton btnMyacc = new JButton("myacc");
		btnMyacc.setBackground(Color.WHITE);
		btnMyacc.setBounds(0, 140, 190, 25);
		panel.add(btnMyacc);
		btnMyacc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myInfo obj=new myInfo(users,index);
				obj.setLocationRelativeTo(null);		//sets the window in the middle
				obj.setVisible(true);
				dispose();
			}
		});
		btnMyacc.setBorder(BorderFactory.createEmptyBorder());
		
		
		//reading
		
			//warning
		JLabel lblNoread = new JLabel("Select message to read!");
		lblNoread.setFont(new Font("Poppins SemiBold", Font.PLAIN, 11));
		lblNoread.setForeground(Color.decode("#dd5245"));
		lblNoread.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoread.setBounds(10, 425, 170, 14);
		panel.add(lblNoread);
		lblNoread.setVisible(false);
		
			//button
		JButton btnRead = new JButton("read");
		btnRead.setBackground(Color.WHITE);
		btnRead.setBounds(0, 396, 190, 25);
		panel.add(btnRead);
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table_3.getSelectedRowCount()==0){
					//sets the warning visible
					lblNoread.setVisible(true);
				}else {
					users.get(index).inbox.get(table_3.getSelectedRow()).read=true; //checking that we have read the message
					read obj=new read(users,index,table_3.getSelectedRow());
					obj.setLocationRelativeTo(null);		//sets the window in the middle
					obj.setVisible(true);
					dispose();
				}
			}
		});
		btnRead.setBorder(null);
		
		
		//icon 1
		JLabel lblI = new JLabel("");
		lblI.setHorizontalAlignment(SwingConstants.CENTER);
		lblI.setIcon(new ImageIcon(menu.class.getResource("/packy/jmail_logo_100.png")));
		lblI.setBounds(10, 205, 170, 150);
		panel.add(lblI);
		
		//icon 2
		JLabel lblI_1 = new JLabel("");
		lblI_1.setIcon(new ImageIcon(menu.class.getResource("/packy/man_icon_circle_100.png")));
		lblI_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblI_1.setBounds(10, 0, 170, 140);
		panel.add(lblI_1);
			
	}
	
//	public void addTblCol(JTable table,String name) {
//	    DefaultTableModel model = (DefaultTableModel)table.getModel();
//	     TableColumn col = new TableColumn(model.getColumnCount());
//
//	    col.setHeaderValue(name);
//	    table.addColumn(col);
//	    model.addColumn(name);
//	      };
	public void delTblCol(JTable table,int index) {
		//deleting the column
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        TableColumn col = table.getColumnModel().getColumn(index);
        table.removeColumn(col);
      	table.revalidate();
	}
	
}
