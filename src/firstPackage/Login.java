package firstPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Login extends JDialog implements ActionListener{
	static String user;
	private JTextField u;
	private JPasswordField p;
	JButton submit,forgot;
	Login()
	{
		getContentPane().setBackground(new Color(0, 255, 255));
		getContentPane().setForeground(new Color(0, 0, 255));
		getContentPane().setLayout(null);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUserName.setForeground(new Color(255, 0, 0));
		lblUserName.setBounds(98, 42, 75, 30);
		getContentPane().add(lblUserName);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setBackground(new Color(50, 205, 50));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Yu Mincho", Font.BOLD, 11));
		lblNewLabel.setBounds(98, 111, 61, 14);
		getContentPane().add(lblNewLabel);
		
		u = new JTextField();
		u.setBounds(193, 47, 86, 20);
		getContentPane().add(u);
		u.setColumns(10);
		
		p = new JPasswordField();
		p.setBounds(193, 108, 86, 20);
		getContentPane().add(p);
		
		submit = new JButton("login");
		submit.setBackground(new Color(0, 255, 0));
		submit.setMnemonic('l');
		submit.setBounds(84, 187, 89, 23);
		getContentPane().add(submit);
		
		setSize(500, 400);
		setLocationRelativeTo(null);
		getRootPane().setDefaultButton(submit);
		
		forgot = new JButton("Forgot");
		forgot.setBounds(222, 187, 89, 23);
		getContentPane().add(forgot);
		setTitle("Login Here");
		
		submit.addActionListener(this);
		forgot.addActionListener(this);
		setVisible(true);
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
new Login();
//MyConnection.connect();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		user=u.getText();
		Object ob=e.getSource();
		if(ob==forgot)
		{
			new Retrieval();
			dispose();
			
		}
		else if(ob==submit)
		{
			String pass=new String(p.getPassword());
			String s="select * from login where username=? and password=? ";
			Connection con=MyConnection.connect();
			try
			{
				PreparedStatement ps=con.prepareStatement(s);
				ps.setString(1,user);
				ps.setString(2,pass);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					//JOptionPane.showMessageDialog(null,"ok","Swings",1);
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
	}
}
