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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Firas
 */
public class EnligneController implements Initializable {

    @FXML
    private WebView webview;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        WebEngine engine=webview.getEngine();
        engine.load("https://www.espace-musculation.com/programmes/");
                  retour.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("UserCourse.fxml"));//////////
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
