import java.io.*;  
import javax.servlet.*; 
import javax.servlet.http.*;
import java.sql.*; 
public class additem extends HttpServlet {
public void doGet (HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException 
{ 

response.setContentType("text/html");
PrintWriter out = response.getWriter();
HttpSession session = request.getSession(false);

if (session != null) {
   try{
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
  out.println("<html><body> <centre>Your item has added successfully"  + "</centre></body></html>");

aDAO.addArtist(artist); 

}catch(Exception ex)
{System.out.println(ex);}
}

else
{
   out.println("<html><body> Go to login page"  + "</body></html>");
}


} 
}

