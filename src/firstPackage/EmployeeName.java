package firstPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;

public class EmployeeName extends JDialog implements ActionListener{
	private JTextField txteid;
	private JTextField txtename;
	private JTextField txtebasic;
	private JTextField txteda;
	private JTextField txtetax;
	private JLabel lblId;
	private JButton submit;
	private JButton cancel;
	private JRadioButton f;
	private JComboBox txtecity;
	private JComboBox txtedept;
	private JRadioButton m;
	private ButtonGroup bg1;
	
	int id;
	void getId()
	{
		String s="select max(eid) from employee";
				Connection con =MyConnection.connect();
		try
		{
			PreparedStatement ps=con.prepareStatement(s);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{id=rs.getInt(1);
			
			}
		}
catch(SQLException se)
{
	se.printStackTrace();
}
	++id;
	txteid.setText(String.valueOf(id));
	}
	
	public EmployeeName() {
		getContentPane().setBackground(new Color(255, 255, 153));
		// TODO Auto-generated constructor stub
		getContentPane().setLayout(null);
		
		lblId = new JLabel("Id");
		lblId.setBounds(27, 11, 46, 14);
		getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(27, 36, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(27, 61, 46, 14);
		getContentPane().add(lblGender);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(27, 86, 46, 14);
		getContentPane().add(lblCity);
		
		JLabel lblDept = new JLabel("Dept");
		lblDept.setBounds(27, 111, 46, 14);
		getContentPane().add(lblDept);
		
		JLabel lblBasic = new JLabel("Basic");
		lblBasic.setBounds(27, 136, 46, 14);
		getContentPane().add(lblBasic);
		
		JLabel lblDa = new JLabel("DA");
		lblDa.setBounds(27, 166, 46, 14);
		getContentPane().add(lblDa);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setBounds(27, 191, 46, 14);
		getContentPane().add(lblTax);
		
		submit = new JButton("Submit");
		submit.setBounds(27, 216, 89, 23);
		getContentPane().add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(127, 216, 89, 23);
		getContentPane().add(cancel);
		txteid = new JTextField();
		
		
		
		txteid.setEditable(false);
		
		
		
		
		txteid.setBounds(72, 8, 86, 20);
		getContentPane().add(txteid);
		txteid.setColumns(10);
		
		txtename = new JTextField();
		txtename.setBounds(72, 33, 86, 20);
		getContentPane().add(txtename);
		txtename.setColumns(10);
		
		 m = new JRadioButton("Male");
		m.setBounds(72, 57, 63, 23);
		getContentPane().add(m);
	
		f = new JRadioButton("Female");
		f.setBounds(142, 57, 74, 23);
		getContentPane().add(f);
		
		txtecity = new JComboBox();
		txtecity.setModel(new DefaultComboBoxModel(new String[] {"Lucknow", "Kanpur", "Gorakhpur", "Varanasi"}));
		txtecity.setBounds(72, 83, 106, 20);
		getContentPane().add(txtecity);
		
		txtedept = new JComboBox();
		txtedept.setModel(new DefaultComboBoxModel(new String[] {"cse", "ec", "it", "me", "ce", "ee"}));
		txtedept.setBounds(72, 111, 106, 20);
		getContentPane().add(txtedept);
		
		txtebasic = new JTextField();
		txtebasic.setBounds(72, 136, 86, 20);
		getContentPane().add(txtebasic);
		txtebasic.setColumns(10);
		
		txteda = new JTextField();
		txteda.setBounds(72, 161, 86, 20);
		getContentPane().add(txteda);
		txteda.setColumns(10);
		
		txtetax = new JTextField();
		txtetax.setBounds(72, 188, 86, 20);
		getContentPane().add(txtetax);
		txtetax.setColumns(10);
		setSize(600,500);
		submit.addActionListener(this);
		cancel.addActionListener(this);
		
		bg1=new ButtonGroup();
	    bg1.add(m);
        bg1.add(f);
        
        
		
		getId();
		setModal(true);
		
		
		
		setVisible(true);

	}
	
	public static void main(String ar[])
	{
		new EmployeeName();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Object b=e.getSource();
		if(b==cancel)
		{
			dispose();
			
		}
		else if(b==submit)
		{
			String n=txtename.getText();
			String g=null;
			if(m.isSelected())
			{
				g="male";
			}
			else
			{
				g="female";
			}
			String c=txtecity.getSelectedItem().toString();
			String d=txtedept.getSelectedItem().toString();
			int bal=Integer.parseInt(txtebasic.getText());
			int da=Integer.parseInt(txteda.getText());
			int tax=Integer.parseInt(txtetax.getText());
		String s="insert into employee(ename,egender,ecity,edept,eid,ebasic,eda,etax) values (?,?,?,?,?,?,?,?)";
		Connection con=MyConnection.connect();
		try{
		PreparedStatement ps=con.prepareStatement(s);
		ps.setInt(5,id);
		ps.setInt(6,bal);
		ps.setInt(7,da);
		ps.setInt(8,tax);
		ps.setString(1,n);
		ps.setString(2,g);
		ps.setString(3,c);
		ps.setString(4,d);
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null,"added","Swings",1);
		dispose();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		}
		
	}
}