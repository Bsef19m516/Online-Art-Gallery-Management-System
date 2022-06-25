import java.io.*;  
import javax.servlet.*; 
import javax.servlet.http.*;
import java.sql.*; 
import java.util.*; 
public class searchcustomer extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException 
{ 





HttpSession session = request.getSession(false);


response.setContentType("text/html");
PrintWriter out = response.getWriter();
try
{
CustomerDAO aDAO = new CustomerDAO(); 

String name = request.getParameter("name"); 
String p = request.getParameter("password"); 

ArrayList customerList = aDAO.retrieveCustomerList(name,p); 
request.setAttribute("list", customerList);
boolean ans = customerList.isEmpty();

if(ans == false )
{
     
RequestDispatcher rd = request.getRequestDispatcher("customer.jsp") ;
	rd.forward(request,response);
 
}

else
{

RequestDispatcher rd = request.getRequestDispatcher("/addcustomer.jsp") ;
	rd.forward(request,response);
   
}

} catch(Exception ex)
{

System.out.println(ex);
}
}
}