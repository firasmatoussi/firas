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
public class reservationServices {
        Connection connexion;
    public reservationServices(){
        connexion=MyDB.getInstance().getConnection();
    }
    
            public boolean ajouterReservation(Reservation r) throws SQLException{
        String req="INSERT INTO `reservation` (`lib`,`full_name`,`phone`) values( ?,?,?);";
        PreparedStatement ps=connexion.prepareStatement(req);
        ps.setString(1,r.getLib());
        ps.setString(2,r.getFull_name());
        ps.setString(3,r.getPhone());
        ps.executeUpdate();
        return true;
    }
            
            
        public List<Reservation> getAllreserv() throws SQLException
    {   
        List <Reservation> reservations= new ArrayList<>();
        String req="SELECT * FROM reservation";
        PreparedStatement ps=connexion.prepareStatement(req);
        ResultSet rst=ps.executeQuery(req);
        while (rst.next()){
            Reservation c=new Reservation(rst.getInt("id"),rst.getString("lib"),rst.getString("full_name"),rst.getString("phone"));
            reservations.add(c);
        }
        return reservations;
    
    
}
               public List<Reservation> getReservation(String r) throws SQLException
    { 
        List <Reservation> reservations= new ArrayList<>();
        String req="SELECT * FROM reservation where lib='"+r+"'";
        Statement ps=connexion.createStatement();
        //ps.setString(1,r);
        ResultSet rst=ps.executeQuery(req);
        while (rst.next()){
            Reservation c=new Reservation(rst.getInt("id"),rst.getString("lib"),rst.getString("full_name"),rst.getString("phone"));
            reservations.add(c);
        }
        return reservations;
    
    
}
        }
