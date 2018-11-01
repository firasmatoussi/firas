/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseFXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Firas
 */
public class GerantController implements Initializable {

    @FXML
    private Button gestion;
    @FXML
    private Button reservation;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                gestion.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("Menu.fxml"));
                    Parent root;
                    try{
                        root= loader.load();
                        gestion.getScene().setRoot(root);
                        }catch (IOException ex) {
                             Logger.getLogger(GerantController.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                }
            });
                                reservation.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("Reserv.fxml"));
                    Parent root;
                    try{
                        root= loader.load();
                        reservation.getScene().setRoot(root);
                        }catch (IOException ex) {
                             Logger.getLogger(GerantController.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                }
            });
          retour.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("Reserv.fxml"));//////////
                    Parent root;
                    try{
                        root= loader.load();
                        retour.getScene().setRoot(root);
                        }catch (IOException ex) {
                             Logger.getLogger(GerantController.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                }
            });
    }    
    
}
