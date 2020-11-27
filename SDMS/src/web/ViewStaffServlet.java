package web;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.StudentDao;
import model.StudentBean;
@WebServlet("/ViewStaffServlet")
public class ViewStaffServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<table width=\"100%\">\r\n" + 
				"		<tr height=\"90px\">\r\n" + 
				"			<td width=\"40%\"><center><img src=\"https://nkstudios.in/kce/new/wp-content/uploads/2020/01/KCELogo.png\" alt=\"image not found\" height=\"70px\" width=\"60%\"></center></td><td  width=\"20%\"><center><a href=\"tel:+91-4222619005\" >+91 -4222619005 <center></td><td width=\"20%\"><center><a href=\"mailto:info@kce.ac.in\"> info@kce.ac.in <center></td><td width=\"9%\"><center><a href=\"CollagePage.jsp\" > About us</center></td>\r\n" + 
				"		</tr>\r\n" + 
				"	</table>\r\n" + 
				"	<hr>");
		out.println("<body background='backgrnd[2].gif' text=black>");
	
		out.println("	<button><a href='AddStudent.html'>Add New Student</a></button>&nbsp&nbsp&nbsp&nbsp" + 
				"<button><a href='AddStaff.html'>Add New Staff</a></button>	&nbsp&nbsp&nbsp&nbsp <button><a href=\"login.html\">Logout</a></button>");
		out.println("<h1>Student List</h1>");
		
		List<StudentBean> list=StudentDao.getAllStudents();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Rollno</th><th>Email</th><th>Address</th><th>CGPA</th><th>Attendance</th><th>Edit</th><th>Delete</th></tr>");
		for(StudentBean e:list){
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getRollno()+"</td><td>"+e.getEmail()+"</td><td>"+e.getAddress()+"</td><td>"+e.getCgpa()+"</td><td>"+e.getattendance()+"</td><td><a href='EditServlet?id="+e.getId()+"'>Edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>Delete</a></td></tr>");
		}
		out.print("</table>");
		out.print("</body>");
		out.close();
	}
}
