/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseFXML;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import gestiondecours.CoursServices.User;
import gestiondecours.CoursServices.UserServices;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author Firas
 */
public class LoginMenuController implements Initializable {



    @FXML
    private Button btn_login;
    @FXML

    private Label verif;
    @FXML
    private ImageView imageview;
    @FXML
    private ImageView back;
    @FXML
    private JFXTextField user;
    @FXML
    private JFXPasswordField pass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Image image=new Image("/images/logo.jpg");
         imageview.setImage(image);
        Image image1=new Image("/images/salle.jpg");
         back.setImage(image1);
         
         
         /*Parent login_parent;
        try {
            login_parent = FXMLLoader.load(getClass().getResource("LoginMenu.fxml"));
                    Scene login_scene=new Scene(login_parent);
        String css= LoginMenuController.class.getResource("test.css").toExternalForm();
        login_scene.getStylesheets().add(css);
        } catch (IOException ex) {
            Logger.getLogger(LoginMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
 
         
       btn_login.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                UserServices us=new UserServices();
                try{
                    ArrayList<User> users = (ArrayList <User>) us.getAllusers();
                    for (User u : users) {
                        if((u.getPass().equals(pass.getText()))&&(u.getUser().equals(user.getText())))
                        {
                            FXMLLoader loader=new FXMLLoader(getClass().getResource("Menu.fxml"));
                            Parent root;
                            try{
                                root= loader.load();
                                btn_login.getScene().setRoot(root);
                            }catch (IOException ex) {
                                Logger.getLogger(LoginMenuController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else{
                            verif.setText("Verifier votre Login ou password");
                        }
                    }
                    
                    
                }catch (SQLException ex) {
                    Logger.getLogger(LoginMenuController.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
    });
 
    }
}

