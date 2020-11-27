package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.LoginDao;
import database.ViewStudentDAO;
import model.LoginBean;
import model.StudentBean;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

private LoginDao loginDao;
   
    
    public void init() {
        loginDao = new LoginDao();
    }
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		HttpSession session=request.getSession();
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
        session.setAttribute("username", username);
        System.out.println(password);
        try {
            if (loginDao.validate(loginBean)) {
           	 if(loginBean.getPassword().equals("admin")) {
           		 response.sendRedirect("ViewStaffServlet");
           	 }
           	 else if(loginBean.getPassword().equals("kce")) {
          		 response.sendRedirect("ViewServlet");
          	 }
           	 else {         	
           			response.setContentType("text/html");
           			PrintWriter out1=response.getWriter();
           			out1.println("<table width=\"100%\">\r\n" + 
           					"		<tr height=\"90px\">\r\n" + 
           					"			<td width=\"40%\"><center><img src=\"https://nkstudios.in/kce/new/wp-content/uploads/2020/01/KCELogo.png\" alt=\"image not found\" height=\"70px\" width=\"60%\"></center></td><td  width=\"20%\"><center><a href=\"tel:+91-4222619005\" >+91 -4222619005 <center></td><td width=\"20%\"><center><a href=\"mailto:info@kce.ac.in\"> info@kce.ac.in <center></td><td width=\"9%\"><center><a href=\"CollagePage.jsp\" > About us</center></td>\r\n" + 
           					"		</tr>\r\n" + 
           					"	</table>\r\n" + 
           					"	<hr>");
           			out1.println("<body background='backgrnd[2].gif' text=black>");
           			session.invalidate();
           			session=request.getSession();
           			out1.println("	<button><a href=\"login.html\">Logout</a></button>");
           			
           			out1.println("<h1>Student List</h1>");
           			
           			System.out.println(username);
           			StudentBean e=ViewStudentDAO.getStudentById(username);
           			
           			out1.print("<table border='1' width='100%'");
           			out1.print("<tr><th>Id</th><th>Name</th><th>Rollno</th><th>Email</th><th>Address</th><th>CGPA</th><th>Attendance</th>");
           			
           			out1.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getRollno()+"</td><td>"+e.getEmail()+"</td><td>"+e.getAddress()+"</td><td>"+e.getCgpa()+"</td><td>"+e.getattendance()+"</td>");
           			
           			out1.print("</table>");
           			out1.print("</body>");
           			out1.close();
           		}

           	 }
            else {
            	out.print("<p>Enter Correct Password!</p>");
            	request.getRequestDispatcher("login.html").include(request, response);
                
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
