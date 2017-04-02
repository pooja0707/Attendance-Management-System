package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;

public class AddStudent extends JDialog implements ActionListener{
	private JTextField sid;
	private JTextField sname;
	private JTextField saddress;
	JComboBox scourse;
    JComboBox sbranch;
    JComboBox ssemester;
	JButton save;
	JButton cancel;
	int id;
 JComboBox scode;
	void getId()
	{
		String s="select max(studid) from student";
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
	sid.setText(String.valueOf(id));
	}
	
	public AddStudent() {
		getContentPane().setLayout(null);
		
		JLabel lblStudentInformation = new JLabel("Student Information");
		lblStudentInformation.setFont(new Font("Tempus Sans ITC", Font.BOLD, 16));
		lblStudentInformation.setBounds(165, 26, 195, 20);
		getContentPane().add(lblStudentInformation);
		
		JLabel lblNewLabel = new JLabel("Student Id");
		lblNewLabel.setBounds(70, 81, 96, 14);
		getContentPane().add(lblNewLabel);
		
		sid = new JTextField();
		sid.setBounds(165, 78, 123, 20);
		getContentPane().add(sid);
		sid.setColumns(10);
		sid.setEditable(false);
		
		
		JLabel lblStudent = new JLabel("Student Name");
		lblStudent.setBounds(70, 124, 83, 14);
		getContentPane().add(lblStudent);
		
		sname = new JTextField();
		sname.setBounds(165, 121, 123, 20);
		getContentPane().add(sname);
		sname.setColumns(10);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(70, 163, 83, 14);
		getContentPane().add(lblCourse);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(70, 207, 72, 14);
		getContentPane().add(lblBranch);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(70, 240, 72, 14);
		getContentPane().add(lblSemester);
		
		scourse = new JComboBox();
		scourse.setModel(new DefaultComboBoxModel(new String[] {"Select", "B. Tech", "M Tech", "MCA"}));
		scourse.setBounds(165, 160, 123, 20);
		getContentPane().add(scourse);
		
		sbranch = new JComboBox();
		sbranch.setModel(new DefaultComboBoxModel(new String[] {"Select", "CSE", "EE", "EC", "CE", "ME"}));
		sbranch.setBounds(165, 204, 123, 20);
		getContentPane().add(sbranch);
		
		ssemester = new JComboBox();
		ssemester.setModel(new DefaultComboBoxModel(new String[] {"Select", "1", "2", "3", "4", "5", "6", "7", "8"}));
		ssemester.setBounds(165, 237, 123, 20);
		getContentPane().add(ssemester);
		
		 save = new JButton("Save");
		save.setBounds(70, 347, 89, 23);
		getContentPane().add(save);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(212, 347, 89, 23);
		getContentPane().add(cancel);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(70, 277, 72, 14);
		getContentPane().add(lblAddress);
		
		saddress = new JTextField();
		saddress.setBounds(165, 274, 123, 20);
		getContentPane().add(saddress);
		saddress.setColumns(10);
		
		JLabel lblSubjectCode = new JLabel("Subject Code");
		lblSubjectCode.setBounds(70, 313, 75, 14);
		getContentPane().add(lblSubjectCode);
		
		scode = new JComboBox();
		scode.setModel(new DefaultComboBoxModel(new String[] {"Select", "BCS 01", "BCS 02", "BCS 03", "BCS 04"}));
		scode.setBounds(165, 310, 123, 20);
		getContentPane().add(scode);
		setSize(480, 420);
		getId();
		setModal(true);
		save.addActionListener(this);
		cancel.addActionListener(this);
		
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new AddStudent();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		
		if(ob==cancel)
		{
			dispose();
		
			new AddNew();
		}
		if(ob==save)
		{
			System.out.println("1");
			String name=sname.getText();
			String course=scourse.getSelectedItem().toString();
			String branch=sbranch.getSelectedItem().toString();
			String sem=ssemester.getSelectedItem().toString();
			String subcode=scode.getSelectedItem().toString();
			String address=saddress.getText();
			
			
			String s="insert into student(studid,studname,course,semester,branch,address,subjectcode) values (?,?,?,?,?,?,?)";
			Connection con=MyConnection.connect();
			try{
			PreparedStatement ps=con.prepareStatement(s);
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setString(3,course);
			ps.setString(4,sem);
			ps.setString(5,branch);
			ps.setString(6,address);
			ps.setString(7,subcode);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null,"added","Swings",1);
		}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		
	}
}
}
