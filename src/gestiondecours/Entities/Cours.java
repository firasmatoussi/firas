/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondecours.Entities;

import java.time.format.DateTimeFormatter;
import javafx.scene.control.DatePicker;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Firas
 */
public class Cours {

    
    
    private int id;
    private String lib;
    private String type;
    private String salle;
    private String coach_name;
    private String date;

    public Cours() {
    }

    public Cours(int id, String lib, String type,String salle, String coach_name, String date) {
        this.id = id;
        this.lib = lib;
        this.type = type;
        this.salle = salle;
        this.coach_name = coach_name;
        this.date = date;
    }

    public Cours(String lib) {
        this.lib = lib;
    }
    

    public Cours(String lib, String type,String salle, String coach_name, String date) {
        this.lib = lib;
        this.type = type;
        this.salle = salle;
        this.coach_name = coach_name;
        this.date = date;
    }

    

    public int getId() {
        return id;
    }

    public String getLib() {
        return lib;
    }

    public String getType() {
        return type;
    }

    public String getSalle() {
        return salle;
    }
    

    public String getCoach_name() {
        return coach_name;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }
    

    public void setCoach_name(String coach_name) {
        this.coach_name = coach_name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return lib;
    }

    
}