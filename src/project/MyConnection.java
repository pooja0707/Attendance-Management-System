package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	static Connection c;
	 public static Connection connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","pooja");
			System.out.println("connected");
		}
		catch(ClassNotFoundException se)
		{
			System.out.println(se);
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return c;
	}

}
