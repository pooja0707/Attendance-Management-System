package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JDialog implements ActionListener {
	private JTextField u;
	private JPasswordField p;
	private JComboBox loginas;
	 JButton forgot;
	private JButton login;
	static String user;
	private JButton cancel;
	static String usertype;

	public Login() {
		
		getContentPane().setLayout(null);
		
		JLabel lblLoginAs = new JLabel("Login As");
		lblLoginAs.setBounds(55, 62, 73, 20);
		getContentPane().add(lblLoginAs);
		
		loginas = new JComboBox();
		loginas.setModel(new DefaultComboBoxModel(new String[] {"Select", "Admin", "Student", "Teacher"}));
		loginas.setBounds(176, 62, 122, 20);
		getContentPane().add(loginas);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(55, 118, 73, 20);
		getContentPane().add(lblUsername);
		
		u = new JTextField();
		u.setBounds(175, 118, 123, 20);
		getContentPane().add(u);
		u.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(55, 170, 61, 14);
		getContentPane().add(lblPassword);
		
		p = new JPasswordField();
		p.setBounds(176, 167, 122, 20);
		getContentPane().add(p);
		
		login = new JButton("Login");
		login.setBounds(55, 255, 89, 23);
		getContentPane().add(login);
		
	    
		forgot = new JButton("Forgot");
		forgot.setBounds(55, 303, 89, 23);
		getContentPane().add(forgot);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(198, 255, 89, 23);
		getContentPane().add(cancel);
		setTitle("Login Page");
		
//		setSize(1367,770);
		setSize(600,500);
		setModal(true);
		
		login.addActionListener(this);
		forgot.addActionListener(this);
		cancel.addActionListener(this);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		
new Login();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		user=u.getText();
		String pass=new String(p.getPassword());
		usertype=loginas.getSelectedItem().toString();
		
		
		Object ob=e.getSource();
		
		if(ob==cancel)
		{
			dispose();
		}
	
		else if(ob==login)
		{
			
			String s="select * from login where username=? and password=? and usertype=?";
			Connection con=MyConnection.connect();
			try
			{
				PreparedStatement ps=con.prepareStatement(s);
				ps.setString(1,user);
				ps.setString(2,pass);
				ps.setString(3,usertype);
				
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					
						dispose();
					new HomePage();
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid","Swings",0);
				}
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
		
		
		}
		else if(ob==forgot)
		{
			dispose();
			new ForgotPassword();
		}
		
	}
}

