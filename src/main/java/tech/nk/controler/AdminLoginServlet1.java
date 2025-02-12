package tech.nk.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.nk.service.AdminLoginServiceImpl;


@WebServlet("/AdminLoginServlet1")
public class AdminLoginServlet1 extends HttpServlet {
	private String result;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		AdminLoginServiceImpl adminLoginServiceImpl=new AdminLoginServiceImpl();
		result=adminLoginServiceImpl.adminLoginService1(username, password);
		System.out.println(result);
		if(result.equals("VALID"))
		{
			//forward
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("AdminLoginServlet2");
			requestDispatcher.forward(request, response);
		}
		else
		{
			session.setAttribute("msg", result);
			response.sendRedirect("adminlogin.jsp");
		}
		
	}

}
