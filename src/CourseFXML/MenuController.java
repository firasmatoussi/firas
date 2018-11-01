/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseFXML;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import gestiondecours.CoursServices.CoursServices;
import gestiondecours.Entities.Cours;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import com.itextpdf.text.Document;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.LocalDateTime;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Firas
 */


public class MenuController implements Initializable {
    public double xOffset=0;
    public double yOffset=0;
    private FileChooser fc=new FileChooser();
      

@FXML
    private JFXTextField lib_ajt;
@FXML
    private JFXTextField salle_ajt;
@FXML
    private JFXTextField nom_ajt;
@FXML
    private DatePicker date_ajt;
    @FXML
    private JFXButton btn_ajt;
    @FXML
    private JFXButton reset_ajt;
    @FXML
    private TableView<Cours> tab_aff;
    @FXML
    private TableColumn<Cours, String> lib_aff;
    @FXML
    private TableColumn<Cours, String> type_aff;
    @FXML
    private TableColumn<Cours, String> salle_aff;
    @FXML
    private TableColumn<Cours, String> nom_aff;
    @FXML
    private TableColumn<Cours, String> date_aff;
    @FXML
    private ImageView image_view;
    @FXML
    private JFXButton btn_logout;
    @FXML
    private Pane pan_supp;
    @FXML
    private JFXTextField lib_sup;
    @FXML
    private JFXTextField salle_sup;
    @FXML
    private JFXTextField nom_sup;
    @FXML
    private DatePicker date_sup;
    @FXML
    private JFXTextField id_sup;
    @FXML
    private JFXButton supprimer;
    @FXML
    private JFXButton modfifier;
    
@FXML
    private JFXButton valider_supp;
    @FXML
    private JFXButton valider_modif;
    @FXML
    private JFXComboBox<String> combo;
    private ObservableList<String> cathegories= FXCollections.observableArrayList("Musculation", "Fitness","Taekwando","Box","Natation","Box","Lutte Libre","Aerobic sportive");
    @FXML
    private JFXComboBox<String> combo_sup;
    @FXML
    private JFXButton pdt_btn;
    @FXML
    private Label lab_ajt;
    @FXML
    private Label lab_modif;


    //public String getCombo_cathegory_prod(){
    //return (String) combo.getSelectionModel().getSelectedItem();
    //}

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
        

        Image image1=new Image("/images/salle.jpg");
        image_view.setImage(image1);
        CoursServices cs=new CoursServices ();
        //make_window_drageable();
        (pan_supp).setVisible(false);
        combo.setItems(cathegories);
        combo_sup.setItems(cathegories);
    

           
        try {
            ArrayList<Cours> cours = (ArrayList <Cours>) cs.getAllCours();
            ObservableList obs= FXCollections.observableArrayList(cours);
            
            tab_aff.setItems(obs);
            
            //id_aff.setCellValueFactory(new PropertyValueFactory<>("id"));
            
            lib_aff.setCellValueFactory(new PropertyValueFactory<>("lib"));
            type_aff.setCellValueFactory(new PropertyValueFactory<>("type"));
            salle_aff.setCellValueFactory(new PropertyValueFactory<>("salle"));
            nom_aff.setCellValueFactory(new PropertyValueFactory<>("coach_name"));
            date_aff.setCellValueFactory(new PropertyValueFactory<>("date"));
        }catch (SQLException ex) {
            Logger.getLogger(LoginMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn_logout.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("Gerant.fxml"));
                    Parent root;
                    try{
                        root= loader.load();
                        btn_logout.getScene().setRoot(root);
                        }catch (IOException ex) {
                             Logger.getLogger(LoginMenuController.class.getName()).log(Level.SEVERE, null, ex);
                        }   
                }
            });
        
        btn_ajt.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                try {
                    if((lib_ajt.getText().length()<1)&&(salle_ajt.getText().length()<1)&&(nom_ajt.getText().length()<1)){
                        lab_ajt.setText("Vérifier les champs sont remplis");
                    }else if(verifierlib(lib_ajt.getText())){
                        lab_ajt.setText("Libelle ne comporte pas des caractères spécifiques");
                    }else if(verifierlib(nom_ajt.getText())){
                        lab_ajt.setText("Nom du coach ne comporte pas des caractères spécifiques");
                    }else if(estUnEntier(salle_ajt.getText())){
                        lab_ajt.setText("la salle doit comporter des chiffres");
                    }else if(date_ajt.getValue()==null){
                        lab_ajt.setText("Vérifier les champs sont remplis");
                    }else if(combo.getValue()==null){
                        lab_ajt.setText("Vérifier les champs sont remplis");
                    }
                    else{
                        Cours p=new Cours(lib_ajt.getText(),salle_ajt.getText(),combo.getSelectionModel().getSelectedItem().toString(), nom_ajt.getText(),date_ajt.getValue().toString());
                        CoursServices cs=new CoursServices();
                        if( cs.ajouterCours(p))
                    {
                        FXMLLoader loader= new  FXMLLoader(getClass().getResource("Menu.fxml"));
                        Parent root;
                        root=loader.load();
                        btn_ajt.getScene().setRoot(root);
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Notification");
                        alert.setContentText("Cours ajouté avec succés");
                        alert.showAndWait();
                   }
                   else
                   {
                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                             
                             alerta.setTitle("Notification");
                             alerta.setContentText("ECHEC de l'ajout");
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
        supprimer.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                (pan_supp).setVisible(true);
               
                (modfifier).setVisible(false);
                (valider_modif).setVisible(false);
                (id_sup).setVisible(false);
                //(annuler_modif).setVisible(false);
                CoursServices ps=new CoursServices();
        Cours c=(Cours) tab_aff.getSelectionModel().getSelectedItem();
        
        String id = String.valueOf(c.getId());
            id_sup.setText(id);
            lib_sup.setText(c.getLib());
            combo_sup.getSelectionModel().select(c.getType());
            salle_sup.setText(c.getSalle());
            nom_sup.setText(c.getCoach_name());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
            LocalDate localDate = LocalDate.parse(c.getDate(),formatter);
            date_sup.setValue(localDate);
            (id_sup).setEditable(false);
            (lib_sup).setEditable(false);
            (combo_sup).setEditable(false);
            (salle_sup).setEditable(false);
            (nom_sup).setEditable(false);
            (date_sup).setEditable(false);     
            }
            });
        
        
     
        valider_supp.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {   
                int b= Integer.parseInt(id_sup.getText());
                CoursServices ps=new CoursServices();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            
                         alert.setTitle("Notification");
                         alert.setContentText("Etes vous sure de vouloir supprimer ce Cours  ?");
                         Optional<ButtonType> result = alert.showAndWait();
                            ButtonType button = result.orElse(ButtonType.CANCEL);
                            if (button == ButtonType.OK) {
                     try {
                         if (ps.SupprimerCours(b)) {
                              FXMLLoader loader= new  FXMLLoader(getClass().getResource("Menu.fxml"));
                              Parent root;
                              root=loader.load();
                              valider_supp.getScene().setRoot(root);
                             alert.setTitle("Notification");
                             alert.setContentText("Cours supprimé avec succés");
                             alert.showAndWait();

                         } else {
                             Alert alerta = new Alert(Alert.AlertType.ERROR);
                             
                             alerta.setTitle("Notification");
                             alerta.setContentText("ECHEC de la suppression");
                             alerta.showAndWait();
                         }  //Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (SQLException ex) {
                         Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                     }               catch (IOException ex) {
                                         Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                                     }
    
                
                
                
                            }}
            });
     
        modfifier.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                (pan_supp).setVisible(true);
                (supprimer).setVisible(false);
                
                (valider_supp).setVisible(false);
                //(annuler_sup).setVisible(false);
                (id_sup).setVisible(false);
                CoursServices ps=new CoursServices();
        Cours c=(Cours) tab_aff.getSelectionModel().getSelectedItem();
        
            String id = String.valueOf(c.getId());
            id_sup.setText(id);
            lib_sup.setText(c.getLib());
            combo_sup.getSelectionModel().select(c.getType());
            salle_sup.setText(c.getSalle());
            nom_sup.setText(c.getCoach_name());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
            LocalDate localDate = LocalDate.parse(c.getDate(),formatter);
            date_sup.setValue(localDate);
                
            }
            });
        
        reset_ajt.setOnAction((ActionEvent event) -> {
         lib_ajt.clear();
         combo.getSelectionModel().clearSelection();
         salle_ajt.clear();
         nom_ajt.clear();
         date_ajt.getEditor().clear();
        });
        
 pdt_btn.setOnAction(new EventHandler<ActionEvent>() {
           @Override
            public void handle(ActionEvent event) {
          
                String ad="C:\\Users\\Firas\\Desktop\\ad.pdf";
                Document doc=new Document();
               try {
                   PdfWriter.getInstance(doc, new FileOutputStream(ad));
               } catch (FileNotFoundException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (DocumentException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               }
               doc.open();
               try {
                    doc.add(new Paragraph("ADFitness"));
                    doc.add(new Paragraph("Rapport des Cours"));
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                    LocalDateTime now = LocalDateTime.now();  
                    String d=dtf.format(now);
                    doc.add(new Paragraph("Date: "+d));
                    doc.add(new Paragraph(" "));
                    doc.add(new Paragraph(" Gerant responsable : " ));
                    doc.add(new Paragraph(" "));
                    PdfPTable table = new PdfPTable(5);
                    PdfPCell c1=new PdfPCell(new Phrase("Libelle"));
                    table.addCell(c1);
                    c1=new PdfPCell(new Phrase("Type"));
                    table.addCell(c1);
                    c1=new PdfPCell(new Phrase("Salle"));
                    table.addCell(c1);
                    c1=new PdfPCell(new Phrase("Nom du coach"));
                    table.addCell(c1);
                    c1=new PdfPCell(new Phrase("Date"));
                    table.addCell(c1);
                    // table.setHeaderRows(0);
                    CoursServices s=new CoursServices();
                    ArrayList<Cours> e =(ArrayList<Cours>)s.getAllCours();
                    for(int i=0;i<e.size();i++)
                    {
                        String n=e.get(i).getLib();
                        table.addCell(n);
                        String r=e.get(i).getType();
                        table.addCell(r);
                        String dom=e.get(i).getSalle();
                        table.addCell(dom);
                        String sa=e.get(i).getCoach_name();
                        table.addCell(sa);
                        String da=e.get(i).getDate();
                        table.addCell(da);
                    }
                    doc.add(table);
               }catch (DocumentException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SQLException ex) {
                   Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
               }
               doc.close();
                }
        }) ;
        
     
        valider_modif.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 
        
                 
                int j ;
                int b= Integer.parseInt(id_sup.getText());
               
                Cours c=new Cours(b,lib_sup.getText(), salle_sup.getText(),combo_sup.getSelectionModel().getSelectedItem().toString(), nom_sup.getText(),date_sup.getValue().toString());
                CoursServices ps=new CoursServices();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Notification");
                alert.setContentText("Etes vous sure de vouloir modifier ?");
                Optional<ButtonType> result = alert.showAndWait();
                ButtonType button = result.orElse(ButtonType.CANCEL);
                if (button == ButtonType.OK) {
                        if (ps.modifierCours(c)) {
                         alert.setTitle("Notification");
                         alert.setContentText("Cours modifié avec succés");
                         alert.showAndWait();
                         
                    }else {
                         Alert alerta = new Alert(Alert.AlertType.ERROR);
                         
                         alerta.setTitle("Notification");
                         alerta.setContentText("ECHEC de la modification");
                         alerta.showAndWait();
                    } // Logger.getLogger(AfficherEquipementsController.class.getName()).log(Level.SEVERE, null, ex);
                
                }
                FXMLLoader loader=new FXMLLoader(getClass().getResource("Menu.fxml"));
                Parent root;
                try {
                root= loader.load();
                valider_modif.getScene().setRoot(root);
            
                } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
       
    });

        
    }
}


//    public static void main(String[] args) {
//
//        try {
//
//            OutputStream file = new FileOutputStream(new File("D:\\Test.pdf"));
//
//
//            Document document = new Document();
//
//            PdfWriter.getInstance(document, file);
//
//
//            document.open();
//
//            document.add(new Paragraph("Hello World, iText"));
//
//            document.add(new Paragraph(new Date().toString()));
//
//
//            document.close();
//
//            file.close();
//
//
//        } catch (Exception e) {
//
//
//            e.printStackTrace();
//
//        }
//
//    }

    
    
        /*annuler_sup.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                (pan_supp).setVisible(false);
               
                (modfifier).setVisible(true);
            }
            });
        annuler_modif.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                                (pan_supp).setVisible(false);
               
                (supprimer).setVisible(true);
            }
            });*/
    

    /*private void make_window_drageable(){
        parent.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        parent.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Launch.stage.setX(event.getScreenX() - xOffset);
                Launch.stage.setY(event.getScreenY() - yOffset);
                Launch.stage.setOpacity(0.7f);
            }
        });
        parent.setOnDragDone((e) -> {
            Launch.stage.setOpacity(1.0f);
        });
        parent.setOnMouseReleased((e) -> {
            Launch.stage.setOpacity(1.0f);
        });

    }  */ 
    
    /*private void setTableEditable() {
        
        tab_aff.setEditable(true);
        // allows the individual cells to be selected
        tab_aff.getSelectionModel().cellSelectionEnabledProperty().set(true);
        // when character or numbers pressed it will start edit in editable
        // fields
        tab_aff.setOnKeyPressed((KeyEvent event) -> {
            if (event.getCode().isLetterKey() || event.getCode().isDigitKey()) {
                editFocusedCell();
            } else if (event.getCode() == KeyCode.RIGHT ||
                event.getCode() == KeyCode.TAB) {
                tab_aff.getSelectionModel().selectNext();
                event.consume();
            } else if (event.getCode() == KeyCode.LEFT) {
                // work around due to
                // TableView.getSelectionModel().selectPrevious() due to a bug
                // stopping it from working on
                // the first column in the last row of the table
                //selectPrevious();
                event.consume();
            }
    });
    }
        private void editFocusedCell() {
        final TablePosition < Cours, ? > focusedCell = tab_aff.focusModelProperty().get().focusedCellProperty().get();
        tab_aff.edit(focusedCell.getRow(), focusedCell.getTableColumn());
    }
        
    private void selectPrevious() {
        if (tab_aff.getSelectionModel().isCellSelectionEnabled()) {
            // in cell selection mode, we have to wrap around, going from
            // right-to-left, and then wrapping to the end of the previous line
            TablePosition < Cours, ? > pos = tab_aff.getFocusModel().getFocusedCell();
            if (pos.getColumn() - 1 >= 0) {
                // go to previous row
                tab_aff.getSelectionModel().select(pos.getRow(),getTableColumn(pos.getTableColumn(), -1));
            } else if (pos.getRow() < tab_aff.getItems().size()) {
                // wrap to end of previous row
                tab_aff.getSelectionModel().select(pos.getRow() - 1,tab_aff.getVisibleLeafColumn(tab_aff.getVisibleLeafColumns().size() - 1));
            }
        } else {
            int focusIndex = tab_aff.getFocusModel().getFocusedIndex();
            if (focusIndex == -1) {
                tab_aff.getSelectionModel().select(tab_aff.getItems().size() - 1);
            } else if (focusIndex > 0) {
                tab_aff.getSelectionModel().select(focusIndex - 1);
            }
        }
    }*/
    
    
//           private void pdfs() 
//          throws Exception{
//        try {
//           Class.forName("com.mysql.jdbc.Driver");
//               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
//  Statement stmt = con.createStatement();
//                    /* Define the SQL query */
//                    ResultSet query_set = stmt.executeQuery("SELECT *From tablename");
//                    /* Step-2: Initialize PDF documents - logical objects */
//                    Document my_pdf_report = new Document();
//                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report_from_sql_using_java.pdf"));
//                    my_pdf_report.open();            
//                    //we have four columns in our table
//                    PdfPTable my_report_table = new PdfPTable(4);
//                    //create a cell object
//                    PdfPCell table_cell;
//
//                    while (query_set.next()) {                
//                                    String dept_id = query_set.getString("code");
//                                    table_cell=new PdfPCell(new Phrase(dept_id));
//                                    my_report_table.addCell(table_cell);
//                                    String dept_name=query_set.getString("category");
//                                    table_cell=new PdfPCell(new Phrase(dept_name));
//                                    my_report_table.addCell(table_cell);
//                                    String manager_id=query_set.getString("total");
//                                    table_cell=new PdfPCell(new Phrase(manager_id));
//                                    my_report_table.addCell(table_cell);
//                                    String location_id=query_set.getString("Sum");
//                                    table_cell=new PdfPCell(new Phrase(location_id));
//                                    my_report_table.addCell(table_cell);
//                                    }
//                    /* Attach report table to PDF */
//                    my_pdf_report.add(my_report_table);                       
//                    my_pdf_report.close();
//
//                    /* Close all DB related objects */
//                    query_set.close();
//                    stmt.close(); 
//                    con.close();               
//
//
//
//    } catch (FileNotFoundException e) {
//    // TODO Auto-generated catch block
//    e.printStackTrace();
//    } catch (DocumentException e) {
//    // TODO Auto-generated catch block
//    e.printStackTrace();
//    }
//           
//    }

