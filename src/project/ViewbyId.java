package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ViewbyId {
	JDialog jd;
	JTable table;
	JScrollPane jsp;
	JButton back;
	int id;
	
	ViewbyId(int id)
	{
		this.id=id;
		jd=new JDialog();
		jd.setTitle("tabular view");
		jd.setLayout(null);
		jd.setSize(400, 500);
		showTable();
	}
	
void showTable()
	{
		String s="select * from Attendance where StudId=?";
Connection con=(Connection) MyConnection.connect();
try
{
	PreparedStatement ps=(PreparedStatement) con.prepareStatement(s);
	ps.setInt(1, id);
	ResultSet rs=ps.executeQuery();
	
	int cnt=0,r=0,c=0;
	String columns[]={"StudentId","StudentName","Subject","status"};
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
	data[r][c]=rs.getString("Subject"); ++c;
	data[r][c]=rs.getString("Status"); ++c;
	
	c=0;
	++r;
	
}
if(f==0)
{
	JOptionPane.showMessageDialog(null,"Invalid id","swings",1);
	return;
	
}
table=new JTable(data,columns);
jsp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
jsp.setBounds(10, 80, 300, 200);
jd.add(jsp);
back=new JButton("back");
back.setBounds(10, 10, 80, 30);
back.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		jd.dispose();
	}
});
jd.add(back);
jd.setVisible(true);
}
catch(SQLException se)
{
	se.printStackTrace();
}
	

}}
