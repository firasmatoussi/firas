/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondecours.CoursServices;

/**
 *
 * @author Firas
 */
public class Reservation {
    private int id;
    private String lib;
    private String full_name;
    private String phone;

    public Reservation() {
    }
    
    
    public Reservation(String lib, String full_name, String phone) {
        this.lib = lib;
        this.full_name = full_name;
        this.phone = phone;
    }

    public Reservation(int id, String lib, String full_name, String phone) {
        this.id = id;
        this.lib = lib;
        this.full_name = full_name;
        this.phone = phone;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getLib() {
        return lib;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return lib;
    }
    
    
    
    
    
    
    
    
    
}
