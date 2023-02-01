/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MesServlets;

import DAO.MessagesDAO;
import MesBeans.Messages;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "Accueil", urlPatterns = {"/Accueil"})
public class Accueil extends HttpServlet {

    private MessagesDAO user;

    @Override
    public void init() throws ServletException {
        user = new MessagesDAO();
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       List< Messages> listMess = user.getListMess();
           request.setAttribute("listMess", listMess);
            getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
            
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session=request.getSession();
        String texte=request.getParameter("texte");
        if(texte.equals("")){
            String message="Remplir les champs";
            request.setAttribute("message",message);
           
        }else{
             List< Messages> listMess = user.getListMess();
           request.setAttribute("listMess", listMess);
            if(session.getAttribute("UserConnected")==null){
             String message="Vous devrez être connectés";
            request.setAttribute("message",message);
            }else{
            String message;
            Messages ub = new Messages();
            ub.setDate(new Date());
            ub.setMessage(texte);
            ub.setPseudo((String)session.getAttribute("pseudo"));
           
            MessagesDAO con = new MessagesDAO();
            
            String result = con.ajouterMessage(ub);
            if (result.equals("OK")) {
                message = "Message créé avec succés";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
            } else {

            message = "Une erreur est survenu lors de traitement de la requête";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
            }
            }
        }
        getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
    
    }

}
