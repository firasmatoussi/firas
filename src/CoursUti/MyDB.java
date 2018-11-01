/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoursUti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Firas
 */
public class MyDB {
            final String url="jdbc:mysql://localhost/dev-crew";
        final String login="root";
        final String mdp="";
        Connection connexion;
        static MyDB instance;
        
        private MyDB() {
            try {
                connexion = DriverManager.getConnection(url, login,mdp);
                System.out.println("Connexion etablie");
            } catch (SQLException ex) {
            System.out.println("Erreur de connexion a la base de donnée");
        }
        }
                
        static public MyDB getInstance() {
            if (instance==null) 
                instance= new MyDB();
                return instance;
            }
        
        
        public Connection getConnection() {
            return connexion;
        }
        
    
}