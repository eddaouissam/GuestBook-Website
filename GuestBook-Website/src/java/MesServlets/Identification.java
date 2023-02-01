/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MesServlets;

import DAO.UtilisateurDAO;
import MesBeans.Utilisateur;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author eddao
 */
@WebServlet(name = "Identification", urlPatterns = {"/Identification"})
public class Identification extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
//Récupération des paramètres saisis via le formulaire 
        String pseudo = request.getParameter("pseudo");
        String mdp = request.getParameter("mdp");
        String message;
        if (pseudo.equals("") || (mdp.equals(""))) {
            message = "Remplir les champs";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/Identification.jsp").forward(request, response);
        } else {
            //Création d’un objet bean de type UtilisateurBeans
            Utilisateur ub = new Utilisateur();
            ub.setPseudo(pseudo);
            ub.setMotDePasse(mdp);
            //Création de l’objet UtilisateurDAO. Cette classe contient la logique de notre application
            UtilisateurDAO us = new UtilisateurDAO();
            //Appel à la fonction Authentification dans la classe UtilisateurDAO
            String result = us.authentification(ub);
            if (!result.equals("KO")) {//Si la fonction renvoie la chaine Ok alors on redirige vers la page Accueil.jsp
                HttpSession session = request.getSession();
                session.setAttribute("UserConnected",result);
                session.setAttribute("pseudo",pseudo);
                getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
            } else {//Si la fonction renvoie autre que la chaine la chaine Ok alors on redirige vers la page Identfication.jsp

                message = "Nom d'utilisateur ou mot de passe incorrect";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/Identification.jsp").forward(request, response);
            }
        }
    }catch(Exception e){
    }
    }
}
