package tech.nk.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tech.nk.model.ContactPojo;
import tech.nk.service.ContactServiceImpl;


@WebServlet("/ReadMessageServlet")
public class ReadMessageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		HttpSession session=request.getSession();
		ContactServiceImpl contactServiceImpl=new ContactServiceImpl();
		ArrayList<ContactPojo> arrayList=contactServiceImpl.readContactService();
		
		if(arrayList==null)
		{
			session.setAttribute("msg", "SOMETHING WENT WRONG ");
			response.sendRedirect("admin.jsp");
		}
		else if(arrayList.isEmpty())
		{
			session.setAttribute("msg", "SOMETHING WENT WRONG");
			response.sendRedirect("admin.jsp");
		}
		else
		{
			String datetime=arrayList.get(0).getDatetime();
			if(datetime.equals("ne"))
			{
				session.setAttribute("msg", "DATA DOES NOT EXISTS");
				response.sendRedirect("admin.jsp");
			
			}
			else
			{
				session.setAttribute("contactdata", arrayList);
				response.sendRedirect("readcontact.jsp");
			
			}
		}
	
	}

	
	
}
