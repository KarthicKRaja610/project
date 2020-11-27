package database;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.StudentBean;

public class StudentDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "1234");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(StudentBean e){
		int status=0;
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO users" + "(name, rollno, email, address, cgpa, attendance) VALUES "
					+ " (?, ?, ?, ?, ?, ?);");
			ps.setString(1,e.getName());
			ps.setString(2,e.getRollno());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getAddress());
			ps.setString(5,e.getCgpa());
			ps.setString(6,e.getattendance());
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(StudentBean e){
		int status=0;
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update users set name = ?, rollno = ?,email= ?, address = ?, cgpa = ?,attendance =? where id = ?;");
			ps.setString(1,e.getName());
			ps.setString(2,e.getRollno());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getAddress());
			ps.setString(5,e.getCgpa());
			ps.setString(6,e.getattendance());
			ps.setInt(7,e.getId());
			System.out.println(ps);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from users where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static StudentBean getStudentById(int id){
		StudentBean e=new StudentBean();
		
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from users where id=?");
			ps.setInt(1,id);
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
	public static List<StudentBean> getAllStudents(){
		List<StudentBean> list=new ArrayList<StudentBean>();
		
		try{
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=null;
			System.out.println(ps);
			ps=con.prepareStatement("select * from users;");
			System.out.println(ps);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StudentBean e=new StudentBean();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setRollno(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setAddress(rs.getString(5));
				e.setCgpa(rs.getString(6));
				e.setattendance(rs.getString(7));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}
