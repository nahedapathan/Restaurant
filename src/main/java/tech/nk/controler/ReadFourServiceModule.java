package tech.nk.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.nk.model.ServiceModulePojo;
import tech.nk.service.ServiceModuleServiceImpl;


@WebServlet("/ReadFourServiceModule")
public class ReadFourServiceModule extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session=request.getSession();
		
		ServiceModuleServiceImpl serviceModuleServiceImpl=new ServiceModuleServiceImpl();
		ArrayList<ServiceModulePojo> arrayList=serviceModuleServiceImpl.readFourService();
		
		session.setAttribute("check", "FROM SERVLET");
		
		if(arrayList==null)
		{
			session.setAttribute("msg", "SERVICE UNAVAILABLE ");
			
			response.sendRedirect("index.jsp");
		}
		else if(arrayList.isEmpty())
		{
			session.setAttribute("msg", "SERVICE UNAVAILABLE");
			response.sendRedirect("index.jsp");
		}
		else
		{
			String datetime=arrayList.get(0).getDatetime();
			if(datetime.equals("ne"))
			{
				session.setAttribute("msg", "SERVICE UNAVAILABLE");
				response.sendRedirect("index.jsp");
			
			}
			else
			{
				session.setAttribute("servicedata", arrayList);
				response.sendRedirect("index.jsp");
			
			}
		}
	
	

		
	
		
	}

}
