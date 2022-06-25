import java.io.*;  
import javax.servlet.*; 
import javax.servlet.http.*;
import java.sql.*; 
public class addcustomer extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException 
{ try 

{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
 CustomerDAO cDAO = new CustomerDAO(); 

 CustomerInfo customer = new CustomerInfo();

 String pName = request.getParameter("name"); 
 customer.setName(pName); 

 String add = request.getParameter("address"); 
customer.setAddress(add); 
 
 String pNo = request.getParameter("phoneNum"); 
 int phoneNum = Integer.parseInt(pNo); 
customer.setPhoneNum(phoneNum); 


 String pass = request.getParameter("password"); 
 customer.setPassword(pass); 

 String cpass = request.getParameter("confirm_password"); 
customer.setConfirm_password(cpass); 



cDAO.addCustomer(customer); 


RequestDispatcher rd = request.getRequestDispatcher("sesession") ;
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