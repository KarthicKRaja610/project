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

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String rollno=request.getParameter("rollno");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String cgpa=request.getParameter("cgpa");
		String attendance=request.getParameter("attendance");
		
		StudentBean e=new StudentBean();
		e.setName(name);
		e.setRollno(rollno);
		e.setEmail(email);
		e.setAddress(address);
		e.setCgpa(cgpa);
		e.setattendance(attendance);
		
		int status=StudentDao.save(e);
		if(status>0){
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("AddStudent.html").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}
