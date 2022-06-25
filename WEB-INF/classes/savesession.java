import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class savesession extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    String str = "click.count";
	res.setContentType("text/html");
    PrintWriter out = res.getWriter();

   

    HttpSession session = req.getSession(true);
  String name = (String)session.getAttribute("name");
   String password = (String)session.getAttribute("password");
       
    if (session != null){
      RequestDispatcher rd = req.getRequestDispatcher("/Item.jsp") ;
      rd.forward(req,res);
    
            }
    else 
      {

        RequestDispatcher rd = req.getRequestDispatcher("/addartist.jsp") ;
	rd.forward(req,res);
      
         }
  }
}
