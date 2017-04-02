package firstPackage;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.jdbc.PreparedStatement;

public class ShowAll {
	private JTable table;
	private JScrollPane jsp;
	private JButton back;
	private JDialog jd;



	public ShowAll() {
		// TODO Auto-generated constructor stub
		jd=new JDialog();
		jd.setTitle("tabular view");
		jd.setLayout(null);
		jd.setSize(400, 500);
		All();
		jd.setVisible(true);
	}
	


	void All()
	{
		String s="select * from employee";
		java.sql.Connection con=MyConnection.connect();
		try
		{
			PreparedStatement ps=(PreparedStatement) con.prepareStatement(s);
			ResultSet rs=ps.executeQuery();
			int cnt=0,r=0,c=0;
			String columns[]={"Emp id","name","gender","City","Department","Basic","da","I tax"};
			rs.last();
			cnt=rs.getRow();
			rs.beforeFirst();
			String data[][]=new String[cnt][8];
			
		while(rs.next())
		{
			data[r][c]=String.valueOf(rs.getInt("eid")); ++c;
			data[r][c]=rs.getString("ename"); ++c;
			data[r][c]=rs.getString("egender"); ++c;
			data[r][c]=rs.getString("ecity"); ++c;
			data[r][c]=rs.getString("edept"); ++c;
			data[r][c]=String.valueOf(rs.getInt("ebasic")); ++c;
			data[r][c]=String.valueOf(rs.getInt("eda")); ++c;
			data[r][c]=String.valueOf(rs.getInt("etax"));
			c=0;
			++r;
			
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
