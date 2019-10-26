/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entité.Actualite;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import service.ActualiteService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterActualiteController implements Initializable {

    @FXML
    private TextField tftitre;
    @FXML
    private TextArea tfdes;
    @FXML
    private Button ajout_btn;
    @FXML
    private TextField tfimg;
    @FXML
    private DatePicker date_ac;
    @FXML
    private Label lbldate;
    @FXML
    private Button inserer;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        
     
       
        
        
        
         ajout_btn.setOnAction((ActionEvent e)->{
         java.sql.Date d = java.sql.Date.valueOf(date_ac.getValue());
         Actualite a = new Actualite(tftitre.getText(),d,tfdes.getText(),tfimg.getText());
                 ActualiteService as = new ActualiteService();
                 
                
                 
        
               


               
                as.insertPst(a);
                
                Parent root;
                 try {
                root=FXMLLoader.load(getClass().getResource("AfficherActualite.fxml"));
                ajout_btn.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(AjouterActualiteController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
    }    

    @FXML
    private void selectDate(ActionEvent event) {
        lbldate.setText(date_ac.getValue().toString());
    }
    
}
