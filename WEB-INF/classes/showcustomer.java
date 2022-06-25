
import java.io.*;  
import javax.servlet.*; 
import javax.servlet.http.*;
import java.util.*;

public class showcustomer extends HttpServlet {

    public void doGet (HttpServletRequest request,HttpServletResponse response) throws
    ServletException, IOException {
    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

out.println("<html><body><center> ");

out.println("<h2> Online Art Gallery System </h2> ");
out.println("<h3> Following results meet your search criteria</h3> ");

//out.println("<TABLE BORDER="1" > ");

out.println("<TR> ");
out.println( "<TH> Name </TH> ");
 out.println("<TH> Address </TH> ");
out.println( "<TH> PhoneNum </TH> ");
out.println( "<TH>Password </TH> ");
out.println( "<TH> Confirm_Password </TH> ");

out.println("</TR>"); 




 ArrayList customerList = (ArrayList)request.getAttribute("list"); 
 CustomerInfo customer = null; 

for(int i=0; i<customerList.size(); i++) { 
customer = (CustomerInfo)customerList.get(i);  


out.println("<TR>"+ "<TD>"+customer.getName()+ "</TD>");
out.println("<TD>"+ customer.getAddress() +"</TD>");
out.println("<TD>" + customer.getPhoneNum() +"</TD>"); 
out.println("<TD>" + customer.getPassword() + "</TD>");
out.println("<TD>"  +customer.getConfirm_password()+ "</TD>");


out.println("</TR> ");


} 
 

out.println("</TABLE > ");
 
out.println("</center> </body></html> ");
}
}

