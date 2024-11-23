package web;
import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="cs",urlPatterns = {"/fs"})
public class ControleurServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("vue.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String number=req.getParameter("score");
		Connection connection = DataBaseConnection.getConnection();
		 
		if(name !=null && !name.isEmpty())
		{
			
			try {
				Random random = new Random();
		        int randomNumber = random.nextInt(10) + 1;
				User us=new User();
				us.setName(name);
				us.setScore(0);
				us.setRandom(randomNumber);
				String sql = "INSERT INTO users (name, score, random) VALUES (?, ?, ?)";
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setString(1, us.getName());
	            statement.setInt(2, us.getScore());
	            statement.setInt(3, us.getRandom());
	            statement.executeUpdate();
	            statement.close();
	            resp.sendRedirect("jeux.jsp?name=" + name);
				
			}
			catch(Exception e)
			{e.printStackTrace();}
			
			
			
			
		}
		
		else
		{
			
            req.getRequestDispatcher("vue.jsp").forward(req, resp);
			
			
		}
	
	}

}
