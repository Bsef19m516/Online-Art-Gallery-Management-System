import java.io.*;  
import javax.servlet.*; 
import javax.servlet.http.*;
import java.util.*;
public class searchcart extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException 
{ 

response.setContentType("text/html");
PrintWriter out = response.getWriter();
HttpSession session = request.getSession(false);

if (session != null) {
try
{
ArtistDAO aDAO = new ArtistDAO(); 



ArrayList artistList = aDAO.retrieveArtistlist(); 
request.setAttribute("list", artistList); 
boolean ans = artistList.isEmpty();


RequestDispatcher rd = request.getRequestDispatcher("showcart") ;
	rd.forward(request,response);


}catch(Exception ex)

{
System.out.println(ex);
}
}

else
{
   out.println("<html><body><centre> Go to login page"  + "</centre></body></html>");
}
}
}