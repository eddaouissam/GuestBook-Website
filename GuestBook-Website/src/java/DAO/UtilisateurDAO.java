/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.NewHibernateUtil;
import MesBeans.Utilisateur;
import java.util.List;
import metier.IUtilisateur;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author eddao
 */
public class UtilisateurDAO implements IUtilisateur{

    @Override
    public String authentification(Utilisateur u) {
        
        //Conserver les valeurs saisies par l’utilisateur dans des variables temporaires
        String pseudo = u.getPseudo();
        String mdp = u.getMotDePasse();
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = se.beginTransaction();
        Utilisateur user = (Utilisateur) se.get(Utilisateur.class, pseudo);
        if (user != null) {
            if (user.getPseudo().equals(pseudo)&& (user.getMotDePasse().equals(mdp))) {
                return user.getPrenom();
            } else {

                return "KO";
            }
        } else {
            return "KO";
    }}

    @Override
    public String creerUtilisateur(Utilisateur u) {
        try {
            Session se = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = se.beginTransaction();
            se.save(u);
            tr.commit();
            return "OK";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "KO";
    }
    
}
