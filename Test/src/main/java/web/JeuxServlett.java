package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DataBaseConnection;
import Model.User;


@WebServlet(name="aa",urlPatterns = {"/jeux"})
public class JeuxServlett extends HttpServlet {
	
       
    



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("jeux.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name"); 
		String geuss=request.getParameter("score");
		System.out.println(name);
		 String	 message ="";
		Connection connection = DataBaseConnection.getConnection();
		int random = 0;
		if(geuss !=null && !geuss.isEmpty())
		{
			
			try {
				 String sql = "SELECT random FROM users WHERE name = ?";
		            PreparedStatement statement = connection.prepareStatement(sql);
		            statement.setString(1, name); 

		            ResultSet resultSet = statement.executeQuery();

		            
		            boolean hasResults = false;
		            while (resultSet.next()) {
		                hasResults = true;
		               
		                 random = resultSet.getInt("random");
		                
		            }
		            resultSet.close();
		            statement.close();
		            
		            if(Integer.parseInt(geuss)==random)
		            {
		            	
		            	System.out.println("you winn");
		            	 message = "rebe7et";
		            	 request.setAttribute("message", message);
		                 request.getRequestDispatcher("jeux.jsp").forward(request, response);
		            }
		            else
		            {
		            if(Integer.parseInt(geuss)<random)
		            {message = "9ribb zid atla3 lfou9 ";
		            
		            
		            
		            
		            
		            }
		            else
		            {
		            	message = "9ribb zid ahbet louta ";
		            	
		            	
		            	
		            	
		            	
		            	
		            	
		            	
		            }
		            }
		            
				
			}
			catch(Exception e)
			{e.printStackTrace();}
			
			
			
			
		}
		System.out.println(name);
		request.setAttribute("message", message);
		response.sendRedirect("jeux.jsp?name=" + name);
			
		}
	}


