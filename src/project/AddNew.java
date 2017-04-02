package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JButton;

public class AddNew extends JDialog implements ActionListener {
	
 JButton logout;
 JButton addteacher;
JButton addstudent;
JButton cancel;

	public AddNew() {
		
		getContentPane().setLayout(null);
		
		addteacher = new JButton("Add Teacher");
		addteacher.setBounds(140, 127, 123, 39);
		getContentPane().add(addteacher);
		
		addstudent = new JButton("Add Student");
		addstudent.setBounds(308, 127, 123, 39);
		getContentPane().add(addstudent);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(308, 207, 123, 39);
		getContentPane().add(cancel);
		
		
		logout = new JButton("Logout");
		logout.setBounds(139, 207, 124, 39);
		getContentPane().add(logout);
		setSize(600, 500);
		
		addteacher.addActionListener(this);
		addstudent.addActionListener(this);
		logout.addActionListener(this);
		cancel.addActionListener(this);
		
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new AddNew();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob=e.getSource();
		
		if(ob==cancel)
		{
			dispose();
			//new HomePage();
		}
		
		else
			if(ob==logout)
		{
				dispose();
			new Login();
		}
		
		else 
			if(ob==addstudent)
		{
				dispose();
			new AddStudent();
		}
			else
				
				if(ob==addteacher)
			{
					dispose();
				new AddTeacher();
			}
	}
}
