package webnews.controller.publicaciones;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

import webnews.model.publicaciones.*;

/*
 *  VER PUBLICACION
 *  
 * */
@WebServlet("/VerPubli")  
public class Ver extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
         
        request.getRequestDispatcher("index.jsp").include(request, response); 
        List<Publicacion> list=publicacionDAO.getAllEmployees();  
          
        out.print("<table  width='100%'");  
          
        for(Publicacion e:list){  
         out.print("<tr><td><a href="+e.getUrl()+">"+e.getTitulo()+"<a> <br><br> </td></tr>");
         		
        		// "</td><td><a href='Editar?id="+e.getIDNoticia()+"'>edit</a></td>  <td><a href='Borrar?id="+e.getIDNoticia()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  
