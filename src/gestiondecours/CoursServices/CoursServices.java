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
import static jdk.nashorn.internal.runtime.Debug.id;
import static org.omg.CORBA.AnySeqHelper.id;
import static org.omg.CORBA.PolicyTypeHelper.id;

/**
 *
 * @author Firas
 */
public class CoursServices {
    Connection connexion;
    public CoursServices(){
        connexion=MyDB.getInstance().getConnection();
    }
    
    
        public boolean ajouterCours(Cours c) throws SQLException{
        String req="INSERT INTO `cours` (`lib`,`type`,`salle`,`coach_name`,`date`) values( ?,?,?,?,?);";
        PreparedStatement ps=connexion.prepareStatement(req);
        ps.setString(1,c.getLib());
        ps.setString(2,c.getType());
        ps.setString(3,c.getSalle());
        ps.setString(4,c.getCoach_name());
        ps.setString(5,c.getDate());
        ps.executeUpdate();
        return true;
    }
        /*public boolean ajouterCours(Cours c) throws SQLException{
        String req="INSERT INTO `cours` (`lib`,`type`,`salle`,`coach_name`,`date`) values('"+c.getLib()+"','"+c.getType()+"','"+c.getSalle()+"','"+c.getCoach_name()+"','"+c.getDate()+"')";
        PreparedStatement ps=connexion.prepareStatement(req);
        
        int a=st.executeUpdate(req);
        if(a>0)
        {
            System.out.println("l'equipement e ete inseré avec succé");
            return true;
        }
        else
            System.out.println("echec de l'insertion");
        return false;
    }*/
        
        
    public boolean SupprimerCours(int id) throws SQLException{
        String req="DELETE FROM cours WHERE id= "+id;
        Statement st=connexion.createStatement();
        int a = st.executeUpdate(req);
         if(a>0)
        {
            System.out.println("Cours a ete supprimé de la base de données");
            return true;
        }
        else
            System.out.println("echec de la suppression ");
         return false;
    }
    
        /*public void modifierCours(Cours c) throws SQLException{
        String req="UPDATE `cours` SET `lib`=?,`type`=?,`salle`=?,`coach_name`=?,`date`=? where `lib`=?";
        PreparedStatement ps=connexion.prepareStatement(req);
        Statement stm=connexion.createStatement();
        ps.setString(1,c.getLib());
        ps.setString(2,c.getType());
        ps.setString(3,c.getSalle());
        ps.setString(4,c.getCoach_name());
        ps.setString(5,c.getDate());
        ps.setString(6,c.getLib());
        
        ps.executeUpdate();
        
    }*/
            public boolean modifierCours(Cours c) {
        try {
            String requete = "UPDATE `cours` SET `lib`=?,`type`=?,`salle`=?,`coach_name`=?,`date`=? where `id`=?";
            PreparedStatement pst = connexion.prepareStatement(requete);
           
            
            pst.setString(1, c.getLib());
            pst.setString(2, c.getType());
            pst.setString(3, c.getSalle());
            pst.setString(4, c.getCoach_name());
            pst.setString(5, c.getDate());
            pst.setInt(6, c.getId());
            
            
        
            int a=pst.executeUpdate();
             if(a>0)
        {
            System.out.println("la modification a ete affectué avec succé");
            return true;
        }
        else
            System.out.println("echec de la modification");
         return false;
             
       
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
        return false;
       
    }
        
        public List<Cours> getAllCours() throws SQLException
    {   
        List <Cours> cours= new ArrayList<>();
        String req="SELECT * FROM cours";
        Statement stm=connexion.createStatement();
        ResultSet rst=stm.executeQuery(req);
        while (rst.next()){
            Cours c=new Cours(rst.getInt("id"),rst.getString("lib"),rst.getString("salle"),rst.getString("type"),rst.getString("coach_name"),rst.getString("date"));
            cours.add(c);
        }
        return cours;
    }    
                public List<Cours> getLibCours() throws SQLException
    {   
        List <Cours> cours= new ArrayList<>();
        String req="SELECT lib FROM cours;";
        Statement stm=connexion.createStatement();
        ResultSet rst=stm.executeQuery(req);
        while (rst.next()){
            Cours c=new Cours(rst.getString("lib"));
          //  c.setLib(req);
            cours.add(c);
        }
        return cours;
    }  
    
}
