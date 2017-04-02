package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;

public class Report {
	JDialog jd;
	JTable table;
	JScrollPane jsp;
	JButton back;
	String date,subcode;
	
	
	Report(String date,String subcode)
	{
		this.date=date;
		this.subcode=subcode;
		jd=new JDialog();
		jd.setTitle("tabular view");
		jd.getContentPane().setLayout(null);
		jd.setSize(400, 500);
		showTable();
	}
	
void showTable()
	{
		String s="select studid,studname from Attendance where date=? and status='p' and subject=? ";
Connection con=MyConnection.connect();
try
{
	PreparedStatement ps=con.prepareStatement(s);
	ps.setString(1, date);
	ps.setString(2, subcode);
	ResultSet rs=ps.executeQuery();
	
	int cnt=0,r=0,c=0;
	String columns[]={"StudentId","StudentName"};
	rs.last();
	int f=0;
	cnt=rs.getRow();
	rs.beforeFirst();
	String data[][]=new String[cnt][8];
	
while(rs.next())
{
	++f;
	data[r][c]=String.valueOf(rs.getInt("StudId")); ++c;
	data[r][c]=rs.getString("StudName"); ++c;
	
	
	c=0;
	++r;
	
}
if(f==0)
{
	JOptionPane.showMessageDialog(null,"Invalid data","swings",1);
	return;
	
}
table=new JTable(data,columns);
jsp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
jsp.setBounds(10, 80, 300, 200);
jd.getContentPane().add(jsp);
back=new JButton("back");
back.setBounds(10, 10, 80, 30);

back.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		jd.dispose();
	}
});
jd.getContentPane().add(back);


jd.setVisible(true);
}
catch(SQLException se)
{
	se.printStackTrace();
}
	

}	
}