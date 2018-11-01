/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondecours.CoursServices;

import CoursUti.MyDB;
import gestiondecours.Entities.Cours;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Firas
 */
public class UserServices {
        Connection connexion;
    public UserServices(){
        connexion=MyDB.getInstance().getConnection();
    }
    

    
        
        public void insertUser(User u) throws SQLException{
        String req="INSERT INTO `users` (`username`,`password`) values( ?, ?);";
        PreparedStatement ps=connexion.prepareStatement(req);
        ps.setString(1,u.getUser());
        ps.setString(2,u.getPass());
        ps.executeUpdate();
        
        }
          public List<User> getAllusers() throws SQLException
    {   
        List <User> users= new ArrayList<>();
        String req="SELECT * FROM users";
        Statement stm=connexion.createStatement();
        ResultSet rst=stm.executeQuery(req);
        while (rst.next()){
            User p=new User(rst.getString("username"),rst.getString("password"));
            users.add(p);
        }
        return users;
    } 
    
}

