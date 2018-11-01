/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseFXML;

import com.jfoenix.controls.JFXButton;
import gestiondecours.CoursServices.CoursServices;
import gestiondecours.CoursServices.Reservation;
import gestiondecours.CoursServices.reservationServices;
import gestiondecours.Entities.Cours;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Firas
 */
public class ReservController implements Initializable {

    @FXML
    private ListView<Cours> lv1;
    @FXML
    private JFXButton choisir;
    @FXML
    private JFXButton retour_btn;
    @FXML
    private TableColumn<Reservation, String> lib_aff;
    @FXML
    private TableColumn<Reservation, String> nom_aff;
    @FXML
    private TableColumn<Reservation, String> phone_aff;
    @FXML
    private TableView<Reservation> tab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tab.setVisible(false);
        // TODO
     try {
             CoursServices cs=new CoursServices();
           ArrayList<Cours> cours = (ArrayList <Cours>) cs.getAllCours();
            ObservableList obs= FXCollections.observableArrayList(cours);
           
            
            lv1.setItems(obs); 
             //.setCellValueFactory(new PropertyValueFactory<>("titre"));
            
    }      
        catch (SQLException ex) {
            Logger.getLogger(UserCourseController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
                    choisir.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
      //  (conf).setVisible(true);         
        //  (ann).setVisible(true);
         
                    tab.setVisible(true);
                 reservationServices cs=new reservationServices();
                 try {
                      Cours a= lv1.getSelectionModel().getSelectedItems().get(0);
                     
                        System.out.println(a.getLib());
                     ArrayList<Reservation> reservations = (ArrayList <Reservation>) cs.getReservation(a.getLib());
                                          
                     
                                ObservableList obs= FXCollections.observableArrayList(reservations);
            
           tab.setItems(obs);
           lib_aff.setCellValueFactory(new PropertyValueFactory<>("lib"));
            nom_aff.setCellValueFactory(new PropertyValueFactory<>("full_name"));
            phone_aff.setCellValueFactory(new PropertyValueFactory<>("phone"));
                     } catch (SQLException ex) {
                     Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                 }
       
       
      
           
            
             }
    });
                retour_btn.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("Gerant.fxml"));
                    Parent root;
                    try{
                        root= loader.load();
                        retour_btn.getScene().setRoot(root);
                        }catch (IOException ex) {
                             Logger.getLogger(LoginMenuController.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                }
            });
                            }  
    
}
