/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Hibernate.NewHibernateUtil;
import MesBeans.Messages;
import java.util.List;
import metier.IMessages;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author eddao
 */
public class MessagesDAO implements IMessages{

    @Override
    public List<Messages> getListMess() {
        List< Messages> listeUser = null;
        try {
            Session se = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = se.beginTransaction();
            listeUser = se.createQuery("From Messages").list();

            // commit transaction
            tr.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return listeUser;
    }

    @Override
    public String ajouterMessage(Messages m) {
        try {
            Session se = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = se.beginTransaction();
            se.save(m);
            tr.commit();
            return "OK";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "KO";
    }
    
}
