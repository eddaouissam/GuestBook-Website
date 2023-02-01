/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;


import MesBeans.Utilisateur;
import java.util.List;

/**
 *
 * @author eddao
 */
public interface IUtilisateur {
    public String authentification(Utilisateur u);
    public String creerUtilisateur(Utilisateur u);
    
}
