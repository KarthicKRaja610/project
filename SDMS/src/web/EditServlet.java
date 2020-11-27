package web;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.StudentDao;
import model.StudentBean;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
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
		out.println("<h1>Update Employee</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		StudentBean e=StudentDao.getStudentById(id);
		
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
		out.print("<tr><td>RollNo:</td><td><input type='text' name='rollno' value='"+e.getRollno()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
		out.print("<tr><td>Address:</td><td><input type='text' name='address' value='"+e.getAddress()+"'/></td></tr>");
		out.print("<tr><td>CGPA:</td><td><input type='text' name='cgpa' value='"+e.getCgpa()+"'/></td></tr>");
		out.print("<tr><td>Attendance:</td><td><input type='text' name='attendance' value='"+e.getattendance()+"'/></td></tr>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
