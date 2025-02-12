package tech.nk.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.nk.service.AdminLoginServiceImpl;

@WebServlet("/AdminLoginServlet2")
public class AdminLoginServlet2 extends HttpServlet {
	  
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		AdminLoginServiceImpl adminLoginServiceImpl=new AdminLoginServiceImpl();
	
		String result=adminLoginServiceImpl.adminLoginService2(username, password);
	
		if(result.equals("EXIST"))
		{
			//admin panel
			session.setAttribute("adminlogin", result);
			response.sendRedirect("admin.jsp");
			
		}
		else
		{
			session.setAttribute("msg", "NOT EXIST");
			response.sendRedirect("adminlogin.jsp");
		
		}
	
	
	}

}
