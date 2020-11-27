package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.StudentBean;

public class ViewStudentDAO {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "1234");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static StudentBean getStudentById(String id){
		StudentBean e=new StudentBean();
		
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from users where rollno=?");
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setRollno(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setAddress(rs.getString(5));
				e.setCgpa(rs.getString(6));
				e.setattendance(rs.getString(7));
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}

}
