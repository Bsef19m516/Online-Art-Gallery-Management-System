import java.io.*;  
import javax.servlet.*; 
import javax.servlet.http.*;
import java.sql.*; 
public class addartist extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException 
{ try 

{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
 ArtistDAO aDAO = new ArtistDAO(); 

 ArtistInfo artist = new ArtistInfo();

 String pName = request.getParameter("name"); 
 artist.setName(pName); 

 String add = request.getParameter("address"); 
 artist.setAddress(add); 
 
 String pNo = request.getParameter("phoneNum"); 
 int phoneNum = Integer.parseInt(pNo); 
 artist.setPhoneNum(phoneNum); 


 String pass = request.getParameter("password"); 
 artist.setPassword(pass); 

 String cpass = request.getParameter("confirm_password"); 
 artist.setConfirm_password(cpass); 

 String id = request.getParameter("id"); 
 artist.setId(id); 

 String pr = request.getParameter("price"); 
 artist.setPrice(pr); 

aDAO.addArtist(artist); 


RequestDispatcher rd = request.getRequestDispatcher("savesession") ;
rd.forward(request,response);
}catch (SQLException sqlex){ 

// setting SQLException instance 
request.setAttribute("javax.servlet.jsp.JspException" , sqlex);
RequestDispatcher rd = request.getRequestDispatcher("addbookerror.jsp"); 
rd.forward(request, response); } 

catch (ClassNotFoundException cnfe){ 

 // setting ClassNotFoundException instance 
request.setAttribute("javax.servlet.jsp.JspException" , cnfe); 
RequestDispatcher rd = request.getRequestDispatcher("addbookerror.jsp");
rd.forward(request,response); 
} 

}// end addperson() 
}