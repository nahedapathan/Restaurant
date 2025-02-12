package tech.nk.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.nk.service.ContactServiceImpl;
import tech.nk.service.ServiceModuleServiceImpl;


@WebServlet("/DeleteServiceModuleServlet")
public class DeleteServiceModuleServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 HttpSession session=request.getSession();
			
	     String sn=request.getParameter("sn");
	     
	      ServiceModuleServiceImpl serviceModuleServiceImpl=new ServiceModuleServiceImpl();
	      String result=serviceModuleServiceImpl.deleteService(sn);
	     
	     session.setAttribute("msg", result);
	     response.sendRedirect("ReadServiceDeleteUpdateModule");
	
	}

}
