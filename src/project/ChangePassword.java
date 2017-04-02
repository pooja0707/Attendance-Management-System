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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ChangePassword extends JDialog implements ActionListener {
	private JPasswordField c;
	private JPasswordField n;
	private JPasswordField cn;
    JButton ok;
	JButton cancel;
	private JLabel lblUsername;
	private JTextField u;
	
	
	public ChangePassword() {
		// TODO Auto-generated constructor stub
		getContentPane().setLayout(null);
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setBounds(89, 93, 127, 14);
		getContentPane().add(lblCurrentPassword);
		
		c = new JPasswordField();
		c.setBounds(226, 90, 127, 20);
		getContentPane().add(c);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(89, 139, 127, 14);
		getContentPane().add(lblNewPassword);
		
		n = new JPasswordField();
		n.setBounds(226, 136, 127, 20);
		getContentPane().add(n);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password");
		lblConfirmNewPassword.setBounds(89, 180, 127, 14);
		getContentPane().add(lblConfirmNewPassword);
		
		cn = new JPasswordField();
		cn.setBounds(226, 177, 127, 20);
		getContentPane().add(cn);
		
		ok = new JButton("OK");
		ok.setBounds(107, 252, 72, 23);
		getContentPane().add(ok);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(238, 252, 89, 23);
		getContentPane().add(cancel);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(89, 53, 90, 14);
		getContentPane().add(lblUsername);
		
		u = new JTextField();
		u.setBounds(226, 50, 127, 20);
		getContentPane().add(u);
		u.setColumns(10);
		setSize(600,500);
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ChangePassword();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user=u.getText();
		String currentpassword=new String(c.getPassword());
		String newpassword=new String(n.getPassword());
		String confirmpassword=new String(cn.getPassword());
		
		Object ob=e.getSource();
		
		if(ob==cancel)
		{
			dispose();
		}
		else
			if(ob==ok)
			{
				String s="select * from login where username=? and password=?";
				Connection con=MyConnection.connect();
				try
				{
					PreparedStatement ps=con.prepareStatement(s);
					ps.setString(1,user);
					ps.setString(2,currentpassword);
					
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{
						String update="update login set password=?";
						Connection con1=MyConnection.connect();
						try{
						PreparedStatement ps1=con1.prepareStatement(s);
						ps1.setString(1,newpassword.toString());
						System.out.println("changed");
						}
						catch(SQLException se)
						{
							se.printStackTrace();
						}
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
