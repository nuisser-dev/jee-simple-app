package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DataBaseConnection;
import Model.User;

@WebServlet(name="DisplayDataServlet", urlPatterns = {"/winer"})
public class winerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        
        try {
           
            Connection connection = DataBaseConnection.getConnection();
            String sql = "SELECT * FROM users";  
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
           
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id")); 
                user.setName(resultSet.getString("name"));
                user.setScore(resultSet.getInt("score"));
                users.add(user);
            }

            resultSet.close();
            statement.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("users", users);
     
        req.getRequestDispatcher("allScore.jsp").forward(req, resp);
    }
}
