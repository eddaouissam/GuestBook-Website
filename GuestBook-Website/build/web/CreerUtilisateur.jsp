<%-- 
    Document   : CreerUtilisateur
    Created on : Dec 28, 2022, 8:52:53 AM
    Author     : eddao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="MaPageErreur.jsp"%> 
<!DOCTYPE html>
<html>
    <head>
        <title>Examen</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
    <center>
        <div>Formulaire d'ajout: </div>       
        <div>
             <% String msg = (String) request.getAttribute("message");
             if (msg == null) {
                 msg = "";
             }%>       

        <font COLOR=" #ff0000"><%=msg%></font>
            <form method="POST" action="CreerUtilisateur">
                <div class="form-row">
                    <table  class="table-borderless"  >
                        <tr>  
                            <td><label for="Nom" class="form-label">Nom:</label></td>
                            <td><input type="text" name="Nom"  ></td>
                        </tr>
                        <tr>  
                            <td><label for="Prenom" class="form-label">Prenom:</label></td>
                            <td><input type="text" name="Prenom"></td>
                        </tr>
                        <tr>  
                            <td><label for="Pseudo" class="form-label">Pseudo:</label></td>
                            <td><input type="text" name="Pseudo"></td>
                        </tr>
                        <tr>  
                            <td><label for="mdp" class="form-label">Mot de passe:</label></td>
                            <td><input type="password" name="mdp"></td>
                        </tr>
                        <tr>  
                            <td> <INPUT type="submit" value="Creer Utilisateur" class="btn btn-primary"></td>
                            <td><input type="reset" value="Effacer" class="btn btn-primary"></td>
                            
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

