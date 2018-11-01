/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseFXML;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import gestiondecours.CoursServices.CoursServices;
import gestiondecours.CoursServices.Reservation;
import gestiondecours.CoursServices.reservationServices;
import gestiondecours.Entities.Cours;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Firas
 */
public class UserCourseController implements Initializable {

    @FXML
    private JFXTextField lib_ajt;
    @FXML
    private JFXTextField nom_ajt;
    @FXML
    private JFXTextField phone_ajt;
    @FXML
    private JFXButton part_btn;
    @FXML
    private JFXButton reset_btn;
    @FXML
    private JFXButton select;
    @FXML
    private ListView<Cours> lv;
    @FXML
    private JFXTextField salle_aff;
    @FXML
    private JFXTextField nom_aff;
    @FXML
    private DatePicker date_aff;
    @FXML
    private Label lab_ajt;
    @FXML
    private Pane pan_view;
    @FXML
    private JFXButton firas_btn;
    @FXML
    private ImageView retour_btn;
    @FXML
    private JFXButton part_btn1;
    @FXML
    private JFXButton internet;

    /**
     * Initializes the controller class.
     */
    
            public boolean verifierlib(String s){
            String c=s.toLowerCase();
            for(int i=0;i<s.length();i++){
                if((c.charAt(i))<'a'||(c.charAt(i)>'z')){
                    return true;
                }     
            }
            return false;
        }
        	public boolean estUnEntier(String chaine) {
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e){
			return true;
		}
 
		return false;
	}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        (pan_view).setVisible(false);
                 CoursServices cs=new CoursServices();
        try {
             
            ArrayList<Cours> cours = (ArrayList <Cours>) cs.getLibCours();
            ObservableList obs= FXCollections.observableArrayList(cours);
           
            
            lv.setItems(obs); 
             //.setCellValueFactory(new PropertyValueFactory<>("titre"));
            
    }      
        catch (SQLException ex) {
            Logger.getLogger(UserCourseController.class.getName()).log(Level.SEVERE, null, ex);
        }

    part_btn.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                try {
                    if((lib_ajt.getText().length()<1)&&(nom_ajt.getText().length()<1)&&(phone_ajt.getText().length()<1)){
                        lab_ajt.setText("Vérifier les champs sont remplis");
                    }else if(verifierlib(nom_ajt.getText())){
                        lab_ajt.setText("Nom Complet ne comporte pas des caractères spécifiques");
                    }else if((estUnEntier(phone_ajt.getText()))&&(phone_ajt.getText().length()!=8)){
                        lab_ajt.setText("Téléphone doit comporter 8 chiffres");
                    }
                    else{
                        Reservation p=new Reservation(lib_ajt.getText(),nom_ajt.getText(),phone_ajt.getText());
                        reservationServices cs=new reservationServices();
                        if( cs.ajouterReservation(p))
                    {
                        FXMLLoader loader= new  FXMLLoader(getClass().getResource("UserCourse.fxml"));
                        Parent root;
                        root=loader.load();
                        part_btn.getScene().setRoot(root);
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Notification");
                        alert.setContentText("Réservation ajoutée avec succés");
                        alert.showAndWait();
                   }
                   else
                   {
                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                             
                             alerta.setTitle("Notification");
                             alerta.setContentText("ECHEC de réservation");
                             alerta.showAndWait();
                   }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         
    reset_btn.setOnAction((ActionEvent event) -> {
        nom_ajt.clear();
        phone_ajt.clear();
        });
      
    
       firas_btn.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
        (pan_view).setVisible(true);

                 CoursServices cs=new CoursServices();
                 try {int a= lv.getSelectionModel().getSelectedIndex() ;
                     
                     ArrayList<Cours> cours = (ArrayList <Cours>) cs.getAllCours();
                     Cours c = cours.get(a) ;
                                 salle_aff.setText(c.getSalle());
            nom_aff.setText(c.getCoach_name());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
            LocalDate localDate = LocalDate.parse(c.getDate(),formatter);
            date_aff.setValue(localDate);
            } catch (SQLException ex) {
                     Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }        
    
});
       
            select.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
      //  (conf).setVisible(true);         
        //  (ann).setVisible(true);
         

                 CoursServices cs=new CoursServices();
                  try {int a= lv.getSelectionModel().getSelectedIndex() ;
                     
                     ArrayList<Cours> cours = (ArrayList <Cours>) cs.getLibCours();
                     Cours e = cours.get(a) ;
                     lib_ajt.setText(e.getLib());
                     } catch (SQLException ex) {
                     Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                 }
       
       
      
           
            
             }
    });
          internet.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("Enligne.fxml"));//////////
                    Parent root;
                    try{
                        root= loader.load();
                        internet.getScene().setRoot(root);
                        }catch (IOException ex) {
                             Logger.getLogger(GerantController.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                }
            });
}
}
