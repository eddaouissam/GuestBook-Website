<%-- 
    Document   : Accueil
    Created on : Dec 28, 2022, 8:46:24 AM
    Author     : eddao
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="MaPageErreur.jsp"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Examen</title>
    </head>
    <body>
        <center>
        <% String user = (String) session.getAttribute("UserConnected");
             if (user == null) {
                 user = "";
             }%>
        <div>Bonjour <font color="red"><%=user%></font> mon site, laissez moi un message:</div><br>
        <% String msg = (String) request.getAttribute("message");
             if (msg == null) {
                 msg = "";
             }%>  
             <font COLOR=" #ff0000"><%=msg%></font>
        <form method="POST" action="Accueil">
            <table>
                <tr>
                    <td>Message:</td>
                    <td><textarea rows="3" name="texte"></textarea></td>
                </tr>
                <tr> 
                <tr> 
                    <td><input type="submit" value="Poster"></td>
                    <td><a href="Identification.jsp">Se connecter</a></td>
                </tr>
                
                <tr>
                    <td><a href="Deconnexion">Deconnexion</a></td>
                </tr>
                <center>
                 <c:forEach var="mess" items="${listMess}">
                    <tr>
                        <td><c:out value="${mess.message}" /></td>
                    </tr>
                </c:forEach>
                </center>
            </table>
        </form>
    </center>
    </body>
</html>
