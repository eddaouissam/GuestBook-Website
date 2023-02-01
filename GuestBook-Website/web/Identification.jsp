<%-- 
    Document   : Identification
    Created on : Dec 28, 2022, 8:47:58 AM
    Author     : eddao
--%>
<html>
    <head>
        <title>Connexion</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
    <center>
        <div>Formulaire de connexion: </div>
        <% String msg = (String) request.getAttribute("message");
             if (msg == null) {
                 msg = "";
             }%>       

        <font COLOR=" #ff0000"><%=msg%></font>
        <div>
            <form method="POST" action="Identification">
                <div class="form-row">
                    <table  class="table-borderless"  >
                        <tr>  
                            <td><label for="pseudo" class="form-label">Pseudo:</label></td>
                            <td><input type="text" name="pseudo"></td>
                        </tr>
                        <tr>  
                            <td><label for="mdp" class="form-label">Mot de passe:</label></td>
                            <td><input type="password" name="mdp"></td>
                        </tr>
                        <tr>  
                            <td></td><td> <INPUT type="submit" value="Connexion" name="Connexion"  class="btn btn-primary"></td>

                        </tr>
                        <tr>
                            <td><a href="CreerUtilisateur.jsp">Creer utilisateur</a></td>
                           
                        </tr>
                        <tr>
                             <td><a href="Accueil.jsp">Retour</a></td>
                        </tr>
                    </table>
                </div> 
            </form>  
        </div>
    </center>
    </body>
</html>
