package firstPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Retrieval extends JDialog implements ActionListener  {
	private JTextField u;
	private JTextField q;
	private JPasswordField a;
	private JTextField p;
	private JButton back;
	private JButton get;
	String uans,tans,pass;
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
				tans=rs.getString("answer");
				pass=rs.getString("password");
				q.setText(rs.getString("question"));
			
			}
		
		}
catch(SQLException se)
{
	se.printStackTrace();
}
		
	
	}
	
	public Retrieval() {
		getContentPane().setBackground(SystemColor.activeCaptionBorder);
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(31, 30, 63, 14);
		getContentPane().add(lblUsername);
		
		
		
		u = new JTextField(Login.user);
		
		

		u.setBounds(104, 27, 86, 20);
		getContentPane().add(u);
		u.setColumns(10);
		
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setBounds(31, 64, 63, 14);
		getContentPane().add(lblQuestion);
		
		q = new JTextField();
		q.setBounds(104, 61, 199, 20);
		getContentPane().add(q);
		q.setColumns(10);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(31, 100, 46, 14);
		getContentPane().add(lblAnswer);
		
		a = new JPasswordField();
		a.setBounds(104, 97, 86, 20);
		getContentPane().add(a);
		
		
		get = new JButton("Get Password");
		get.setBounds(45, 146, 130, 23);
		getContentPane().add(get);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(31, 193, 63, 14);
		getContentPane().add(lblPassword);
		
		p = new JTextField();
		p.setBounds(104, 190, 86, 20);
		getContentPane().add(p);
		p.setColumns(10);
		
	    back = new JButton("Back To Login");
		back.setBounds(45, 228, 130, 23);
		getContentPane().add(back);
		setSize(500,600);
		
		
		get.addActionListener(this);
		back.addActionListener(this);
		
		
		u.setEditable(false);
		p.setEditable(false);
		q.setEditable(false);
		
		
		getInfo();
		
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new Retrieval();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==back)
		{
			new Login();
			dispose();
		}
		else if(ob==get)
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
		
	}
}

