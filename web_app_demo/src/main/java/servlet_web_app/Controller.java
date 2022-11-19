package servlet_web_app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/new")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Controller() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("firstName");
		String city =request.getParameter("city");
		String email =request.getParameter("email");
		String mobile =request.getParameter("mobile");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/demodb","root","test");
			System.out.println(con);
			
		
			 Statement stmnt = con.createStatement();
			 stmnt.executeUpdate("insert into student values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
			 

			 con.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
