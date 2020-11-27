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
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String rollno=request.getParameter("rollno");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String cgpa=request.getParameter("cgpa");
		String attendance=request.getParameter("attendance");
		
		StudentBean e=new StudentBean();
		e.setId(id);
		e.setName(name);
		e.setRollno(rollno);
		e.setEmail(email);
		e.setAddress(address);
		e.setCgpa(cgpa);
		e.setattendance(attendance);
		
		int status=StudentDao.update(e);
		if(status>0){
			response.sendRedirect("ViewServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
