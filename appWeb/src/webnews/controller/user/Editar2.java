package webnews.controller.user;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import webnews.model.usuarios.*;

@WebServlet("/Editar2")  
public class Editar2 extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        
        String email=request.getParameter("txtMail");
        String password=request.getParameter("txtPass");  
          
  
          
        user e=new user();  
        e.setId(id);  
        e.setCorreo(email);
        e.setPassword(password);  
         
    
        int status=registroDAO.update(e);  
        if(status>0){  
            response.sendRedirect("Ver");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
} 