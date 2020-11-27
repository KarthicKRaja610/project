package database;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AddStaffBean;

public class AddStaffDAO {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "1234");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(AddStaffBean e){
		int status=0;
		try{
			Connection con=AddStaffDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO login" + "(username, password) VALUES "
					+ " (?, ?);");
			ps.setString(1,e.getName());
			ps.setString(2,e.getpassword());
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
}
