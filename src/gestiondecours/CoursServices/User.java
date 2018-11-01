/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondecours.CoursServices;

import gestiondecours.Entities.Cours;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author Firas
 */
public class User {
    private String user;
    private String pass;

    public User() {
    }

    public User(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    private static final Logger LOG = Logger.getLogger(User.class.getName());

    @Override
    public String toString() {
        return "User{" + "user=" + user + ", pass=" + pass + '}';
    }
    

    
    

    
}
