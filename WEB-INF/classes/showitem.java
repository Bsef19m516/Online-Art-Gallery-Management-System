
import java.io.*;  
import javax.servlet.*; 
import javax.servlet.http.*;
import java.util.*;

public class showitem extends HttpServlet {

    public void doGet (HttpServletRequest request,HttpServletResponse response) throws
    ServletException, IOException {
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

out.println("<html><body><center> ");

out.println("<h2> Online Art Gallery System </h2> ");
out.println("<h3> Following results meet your search criteria</h3> ");

out.println("<TABLE BORDER=1 > ");

out.println("<TR> ");
out.println( "<TH> Name </TH> ");
 out.println("<TH> Address </TH> ");
out.println( "<TH> PhoneNum </TH> ");
out.println( "<TH>Password </TH> ");
out.println( "<TH> Confirm_Password </TH> ");
out.println( "<TH> ItemId </TH>" );
out.println( "<TH> Price </TH> ");
out.println("</TR>"); 




 ArrayList artistList = (ArrayList)request.getAttribute("list"); 
 ArtistInfo artist = null; 

for(int i=0; i<artistList.size(); i++) { 
artist = (ArtistInfo)artistList.get(i);  


out.println("<TR>"+ "<TD>"+artist.getName()+ "</TD>");
out.println("<TD>"+ artist.getAddress() +"</TD>");
out.println("<TD>" + artist.getPhoneNum() +"</TD>"); 
out.println("<TD>" + artist.getPassword() + "</TD>");
out.println("<TD>"  +artist.getConfirm_password()+ "</TD>");
out.println("<TD>" + artist.getId() +"</TD>"); 
out.println("<TD>" + artist.getPrice()+ "</TD>"); 

out.println("</TR> ");


} 
 

out.println("</TABLE > ");
 
out.println("</center> </body></html> ");
}
}

