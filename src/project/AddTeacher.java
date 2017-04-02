package project;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class AddTeacher extends JDialog implements ActionListener {
	private JTextField tid;
	private JTextField tname;
	private JTextField textField_3;
	 JButton cancel;
	 JButton save;
	 JComboBox tsub,tdept;
	
	public AddTeacher() {
		// TODO Auto-generated constructor stub
		getContentPane().setLayout(null);
		
		JLabel lblTeachersInformation = new JLabel("Teachers Information");
		lblTeachersInformation.setBounds(205, 34, 144, 14);
		getContentPane().add(lblTeachersInformation);
		
		JLabel lblTeachersId = new JLabel("Teacher Id");
		lblTeachersId.setBounds(61, 93, 89, 14);
		getContentPane().add(lblTeachersId);
		
		JLabel lblTeach = new JLabel("Teacher Name");
		lblTeach.setBounds(61, 132, 89, 14);
		getContentPane().add(lblTeach);
		
		tid = new JTextField();
		tid.setBounds(191, 90, 122, 20);
		getContentPane().add(tid);
		tid.setColumns(10);
		
		tname = new JTextField();
		tname.setBounds(191, 129, 122, 20);
		getContentPane().add(tname);
		tname.setColumns(10);
		
		JLabel lblTeacherDepartment = new JLabel("Teacher Department");
		lblTeacherDepartment.setBounds(61, 175, 133, 14);
		getContentPane().add(lblTeacherDepartment);
		
		JLabel lblTeacherSubject = new JLabel("Teacher Subject");
		lblTeacherSubject.setBounds(61, 219, 109, 14);
		getContentPane().add(lblTeacherSubject);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(61, 261, 69, 14);
		getContentPane().add(lblAddress);
		
		textField_3 = new JTextField();
		textField_3.setBounds(191, 258, 122, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		tsub = new JComboBox();
		tsub.setModel(new DefaultComboBoxModel(new String[] {"Select", "Physics", "Electronics", "Human Values", "Mechanics"}));
		tsub.setBounds(191, 216, 122, 20);
		getContentPane().add(tsub);
		
		 save = new JButton("Save");
		save.setBounds(61, 313, 89, 23);
		getContentPane().add(save);
		
		 cancel = new JButton("Cancel");
		cancel.setBounds(205, 313, 89, 23);
		getContentPane().add(cancel);
		
		tdept = new JComboBox();
		tdept.setModel(new DefaultComboBoxModel(new String[] {"Select", "CSE", "ME", "EE", "EC", "CE"}));
		tdept.setBounds(191, 172, 122, 20);
		getContentPane().add(tdept);
		setSize(500, 400);
		setModal(true);
		save.addActionListener(this);
		cancel.addActionListener(this);
		
		setVisible(true);
		
	}
	

	public static void main(String[] args) {
		new AddTeacher();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		
		if(ob==cancel)
		{
			dispose();
			
		}
		else
			if(ob==save)
			{
				int id=Integer.parseInt(tid.getText());
				String name=tname.getText();
				String dept=tdept.getSelectedItem().toString();
				String sub=tsub.getSelectedItem().toString();
				
				String s="insert into teacher(teacherId,teacherName,teacherDept,teacherSub) values (?,?,?,?)";
				Connection con=MyConnection.connect();
				try
				{
					PreparedStatement ps=con.prepareStatement(s);
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setString(3, dept);
					ps.setString(4, sub);
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
