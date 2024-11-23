<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Jeux</title>
</head>
<body>
    <h1>Bienvenue dans le jeu 
        <% 
            String name = request.getParameter("name"); 
           out.print(name);
        %> 
    </h1>
    <form action="jeux" method="post">
        <input type="hidden" name="name" value="<%= request.getParameter("name") %>" />
        <br><br>
        <label for="score">Votre numero:</label>
        <input type="text" id="score" name="score" required>
        <br><br>
        <button type="submit">Valider</button>
    </form>
<form action="winer" method="get">
    <button type="submit">winner page </button>
</form>
    <div>
    
        <h2>
            <% 
                String message = (String) request.getAttribute("message");
                if (message != null) {
                    out.print(message);
                }
            %>
        </h2>
    </div>
</body>
</html>
