<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="Model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Display All Users</title>
</head>
<body>
    <h1>List of Users</h1>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Score</th>
        </tr>

        <% 
            // Retrieve the list of users from the request attribute
            List<User> users = (List<User>) request.getAttribute("users");

            // Loop through each user and display their details
            for (User user : users) {
        %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getName() %></td>
                <td><%= user.getScore() %></td>
            </tr>
        <% 
            }
        %>
    </table>
</body>
</html>
