package project;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class HomePage implements ActionListener   {
	 JFrame frame;
     JMenuItem takeattendance;
	 JMenuItem viewattendance;
	 JMenuItem update;
	 JMenuItem addnew;
	 JMenu mnStudent;
	 JMenu mnAdmin;
	 JMenu mnTeacher;
	 private JMenu mnViewRecord;
	 private JMenuItem viewbyida;
	 private JMenuItem viewalla;
	 private JMenu mnExit;
	 JMenuItem logout;
	 private JMenu mnViewAttendance;
	 private JMenuItem mntmById_1;
	 private JMenuItem mntmAll_1;
	  JMenuItem delete;
	  private JMenuItem report;
	
	void adminlog()
	{
		mnStudent.setEnabled(false);
		mnTeacher.setEnabled(false);
		
	}
	
	void studentlog()
	{
		mnAdmin.setEnabled(false);
		mnTeacher.setEnabled(false);
		
	}
	
	void teacherlog()
	{
		mnStudent.setEnabled(false);
		mnAdmin.setEnabled(false);
		
	}
	
	
	

	public HomePage() {
		frame=new JFrame();
		frame.setTitle("HomePage");
		frame.setSize(frame.getMaximumSize());
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnAdmin = new JMenu("Admin");
		menuBar.add(mnAdmin);
		
		addnew = new JMenuItem("New");
		mnAdmin.add(addnew);
		
		delete = new JMenuItem("Delete");
		mnAdmin.add(delete);
		
		update = new JMenuItem("Update");
		mnAdmin.add(update);
		
		mnViewRecord = new JMenu("View Record");
		mnAdmin.add(mnViewRecord);
		
		viewbyida = new JMenuItem("By Id");
		mnViewRecord.add(viewbyida);
		
		viewalla = new JMenuItem("All");
		mnViewRecord.add(viewalla);
		update.addActionListener(this);
		addnew.addActionListener(this);
		
		mnStudent = new JMenu("Student");
		menuBar.add(mnStudent);
		
	    viewattendance = new JMenuItem("View Attendance");
	    mnStudent.add(viewattendance);
	    viewattendance.addActionListener(this);
		
		mnTeacher = new JMenu("Teacher");
		menuBar.add(mnTeacher);
		
		takeattendance = new JMenuItem("Take Attendance");
		mnTeacher.add(takeattendance);
		
		mnViewAttendance = new JMenu("View Attendance");
		mnTeacher.add(mnViewAttendance);
		
		mntmById_1 = new JMenuItem("By Id");
		mnViewAttendance.add(mntmById_1);
		
		mntmAll_1 = new JMenuItem("All");
		mnViewAttendance.add(mntmAll_1);
		
		report = new JMenuItem("Report");
		mnTeacher.add(report);
		
		mnExit = new JMenu("Exit");
		menuBar.add(mnExit);
		
		logout = new JMenuItem("Logout");
		mnExit.add(logout);
		
		logout.addActionListener(this);
		viewbyida.addActionListener(this);
		report.addActionListener(this);
		
		
		takeattendance.addActionListener(this);
		
		if(Login.usertype=="Admin")
		{
		 adminlog();
		}
		else if(Login.usertype=="Student")
		{
			studentlog();
		}
		else if(Login.usertype=="Teacher")
		{
			teacherlog();
		}
		frame.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HomePage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==logout)
		{
			
			
			new Login();
			System.exit(0);
			
		
		}
		else if(ob==addnew)
		{
			new AddNew();
		}
		else if(ob==delete)
		{
			
		}
		else if(ob==viewbyida)
		{
			String s=JOptionPane.showInputDialog(null,"Enter Id");
			
			int n;	
			n=Integer.parseInt(s);
			new ViewbyId(n); 
			
		}
		else if(ob==viewalla)
		{
			
		}
		else if(ob==takeattendance)
		{
			new Attendance();
		}
		else if(ob==report)
		{
        String s1=JOptionPane.showInputDialog(null,"Enter date");
			
			String n;	
			n=s1.toString();
String s2=JOptionPane.showInputDialog(null,"Enter subject code");
			
			String n1;	
			n1=s2.toString();
			new Report(n,n1); 
			
		}
		
	}

	

}
