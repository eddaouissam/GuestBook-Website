/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MesServlets;

import DAO.UtilisateurDAO;
import MesBeans.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CreerUtilisateur", urlPatterns = {"/CreerUtilisateur"})
public class CreerUtilisateur extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      try{
        String pseudo = request.getParameter("Pseudo");
        String nom = request.getParameter("Nom");
        String prenom = request.getParameter("Prenom");
        String mdp = request.getParameter("mdp");
        if (pseudo.equals("") || (mdp.equals(""))) {
            String message = "Remplir les champs";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/CreerUtilisateur.jsp").forward(request, response);
        } else {
           String message;
            //Création d’un objet bean de type UtilisateurBeans
            Utilisateur ub = new Utilisateur();
            ub.setNom(nom);
            ub.setPrenom(prenom);
            ub.setMotDePasse(mdp);
            ub.setPseudo(pseudo);
            //Création de l’objet UtilisateurDAO. Cette classe contient la logique de notre application
            UtilisateurDAO con = new UtilisateurDAO();
            //Appel à la fonction ajouterUtilisateur dans la classe UtilisateurDAO
            String result = con.creerUtilisateur(ub);
            if (result.equals("OK")) {//Si la fonction renvoie la chaine Ok alors on redirige vers la page CreerUtilisateur.jsp
                HttpSession session=request.getSession();
                session.setAttribute("UserConnected",prenom);
                session.setAttribute("pseudo",pseudo);
                getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
            } else {//Si la fonction renvoie autre que la chaine la chaine Ok alors on redirige vers la page CreerUtilisateur.jsp

            message = "Une erreur est survenu lors de traitement de la requête";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/CreerUtilisateur.jsp").forward(request, response);
            }
            }
    }catch(Exception e){
}
    }


}
