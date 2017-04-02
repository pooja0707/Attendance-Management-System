package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ForgotPassword extends JDialog implements ActionListener{
 JTextField u;
	JTextField q;
	 JTextField a;
	 JTextField p;
    JButton backtologin;
	JButton getpassword;
	 String tans;
     String pass;
	String uans;
	private JLabel lblUsertype;
	private JTextField ut;
	
	void getInfo()
	{
		String s="select * from login where username=?";
				Connection con =MyConnection.connect();
		try
		{
			PreparedStatement ps=con.prepareStatement(s);
			ps.setString(1,Login.user);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				tans=rs.getString("Answer");
				pass=rs.getString("Password");
				q.setText(rs.getString("Question"));
				
			
			}
		
		}
catch(SQLException se)
{
	se.printStackTrace();
}
		
	
	}
	
	public ForgotPassword() {
		
		
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(65, 27, 73, 14);
		getContentPane().add(lblUsername);
		
		u = new JTextField(Login.user);
		u.setBounds(148, 24, 139, 20);
		getContentPane().add(u);
		u.setColumns(10);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setBounds(65, 106, 73, 14);
		getContentPane().add(lblQuestion);
		
		q = new JTextField();
		q.setBounds(148, 103, 222, 20);
		getContentPane().add(q);
		q.setColumns(10);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(65, 157, 54, 14);
		getContentPane().add(lblAnswer);
		
		a = new JTextField();
		a.setBounds(148, 157, 139, 20);
		getContentPane().add(a);
		a.setColumns(10);
		
		getpassword = new JButton("Get Password");
		getpassword.setBounds(65, 202, 130, 23);
		getContentPane().add(getpassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(65, 264, 73, 14);
		getContentPane().add(lblPassword);
		
		p = new JTextField();
		p.setBounds(148, 261, 139, 20);
		getContentPane().add(p);
		p.setColumns(10);
		
		backtologin = new JButton("Back to Login");
		backtologin.setBounds(65, 307, 130, 23);
		getContentPane().add(backtologin);
		setSize(500,500);
		
		getpassword.addActionListener(this);
		backtologin.addActionListener(this);
		
		u.setEditable(false);
		p.setEditable(false);
		q.setEditable(false);
		
		lblUsertype = new JLabel("Usertype");
		lblUsertype.setBounds(65, 65, 63, 14);
		getContentPane().add(lblUsertype);
		
		ut = new JTextField(Login.usertype);
		ut.setBounds(148, 62, 139, 20);
		getContentPane().add(ut);
		ut.setColumns(10);
		
		
		getInfo();
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
     new ForgotPassword();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		
		 if(ob==getpassword)
		{
		
			 uans=a.getText();
			if(uans.equals(tans))
			{
				p.setText(pass);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Wrong answer");
				a.setText("");
				a.requestFocusInWindow();
			}
		}
		 else if(ob==backtologin)
		 {
			 new Login();
		 }
		
	}
}
