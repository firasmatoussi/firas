/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondecours;

import CoursUti.MyDB;
import gestiondecours.CoursServices.CoursServices;
import gestiondecours.Entities.Cours;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;

/**
 *
 * @author Firas
 */
public class GestiondeCours {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        MyDB database = MyDB.getInstance();
        Connection connexion = MyDB.getInstance().getConnection();
        
        //Cours c1=new Cours("Fitness","Musculation","Houssem","27/10/2018");
        
        //Cours c2=new Cours("Taekwondo","Combat","Akrem","15/10/2018");
        
       // Cours c3=new Cours("Aerobics","Dance","Walid","12/10/2018");
        

        
        
        CoursServices coursservices=new CoursServices();
        try{
            //coursservices.ajouterCours(c3);
            //System.out.println("Ajout avec succes");
            
            //coursservices.SupprimerCours(c3);
            //System.out.println("Supression avec succes");
            
            //coursservices.modifierCours(c3);
            //System.out.println("Modification avec succes");
            
            coursservices.getAllCours();
            
        }catch (SQLException ex) {
            Logger.getLogger(GestiondeCours.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
