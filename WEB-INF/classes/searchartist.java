import java.io.*;  
import javax.servlet.*; 
import javax.servlet.http.*;
import java.sql.*; 
import java.util.*; 
public class searchartist extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException 
{ 





HttpSession session = request.getSession(false);


response.setContentType("text/html");
PrintWriter out = response.getWriter();
try
{
ArtistDAO aDAO = new ArtistDAO(); 

String name = request.getParameter("name"); 
String p = request.getParameter("password"); 

ArrayList artistList = aDAO.retrieveArtistList(name,p); 
request.setAttribute("list", artistList);
boolean ans = artistList.isEmpty();

if(ans == false )
{
     
RequestDispatcher rd = request.getRequestDispatcher("Item.jsp") ;
	rd.forward(request,response);
 
}

else
{

RequestDispatcher rd = request.getRequestDispatcher("/addartist.jsp") ;
	rd.forward(request,response);
   
}

} catch(Exception ex)
{

System.out.println(ex);
}
}
}