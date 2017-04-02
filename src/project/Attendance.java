package project;

import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dialog;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JCheckBox;

public class Attendance extends JDialog implements ActionListener, ItemListener {
	JTextField textField;
	JComboBox subject;
	 JPanel panel=null;
//	 Connection con=MyConnection.connect();
	 JCheckBox[] st;
	 int n;
	JTextField edate;
 JButton cancel;
JButton save;
String sub;

	public Attendance() {
		st=new JCheckBox[0];
		getContentPane().setLayout(null);
		

        subject = new JComboBox();
        subject.setModel(new DefaultComboBoxModel(new String[] {"Select Subject Code", "BCS 01", "BCS 02", "BCS 03", "BCS 04"}));
		subject.setBounds(166, 39, 312, 20);
		getContentPane().add(subject);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(714, 627, 89, 23);
		getContentPane().add(cancel);
		
		save = new JButton("Save");
		save.setBounds(609, 627, 89, 23);
		getContentPane().add(save);
		
		panel = new JPanel();
//		panel.setBackground(SystemColor.WHITE);
		panel.setBounds(10, 98, 864, 522);
		
		
//		getContentPane().add(panel);
//		panel.setLayout(null);
		
		edate = new JTextField();
		edate.setBounds(717, 39, 86, 20);
		getContentPane().add(edate);
		edate.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(671, 42, 46, 14);
		getContentPane().add(lblDate);
		
		setSize(900, 700);
		
		save.addActionListener(this);
		cancel.addActionListener(this);
		subject.addItemListener(this);
		
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/YYYY");
		java.util.Date d=new java.util.Date();
		String date=sdf.format(d);
	    edate.setText(date);
		
		
	
		setModal(true);
		
		setVisible(true);
		
		
		
	}
	public static void main(String[] args) {
		new Attendance();
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		if(ob==cancel)
		{
			
		}
		else
			if(ob==save)
			{
				
			}
			
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o==subject)
		{ panel.removeAll();
			String s="select count(*) from student ";
			
	Connection con =MyConnection.connect();
			try
			{
				PreparedStatement ps=con.prepareStatement(s);
				ResultSet rs=ps.executeQuery(s);
				while(rs.next())
				{
					n=rs.getInt(1);
				}
				
				System.out.println(n);
			}
		catch(SQLException se)
		{
		se.printStackTrace();
		}
			sub=subject.getSelectedItem().toString();
			st=new JCheckBox[n];
			int i=0,top=10,left=10;
			String s1="select * from student where subjectcode=? ";
			
		Connection con1 =MyConnection.connect();
			try
			{
				PreparedStatement ps1=con.prepareStatement(s1);
				ps1.setString(1,sub);
				
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next())
				{
					
				String t=rs1.getString("studName");
				st[i]=new JCheckBox(t);
				st[i].setBounds(left, top, 100, 30);
				top=top+35;
				panel.add(st[i]);
				++i;
				if(i>=9)
				{
					left=left+120;
					top+=100;
				}
				}
				
				
			}
		catch(SQLException se)
		{
		se.printStackTrace();
		}
			
		getContentPane().add(panel);
		setVisible(true);
		
		}
		
	}
	
}
