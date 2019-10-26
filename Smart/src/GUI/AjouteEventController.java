/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import smart.Entity.Evenement;
import smartService.EvenementBD;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AjouteEventController implements Initializable {

    @FXML
    private TextField idcategorie;
    @FXML
    private TextField titre;
    @FXML
    private TextField image;
    @FXML
    private TextField lieu;
    @FXML
    private TextField description;
    @FXML
    private DatePicker date_event;
    @FXML
    private TextField nbplace;
    @FXML
    private Button ajouterbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ajouterbtn.setOnAction((ActionEvent e)
                -> {
            java.sql.Date d = java.sql.Date.valueOf(date_event.getValue());
            Evenement p = new Evenement(Integer.parseInt(idcategorie.getText()),titre.getText(), image.getText(), lieu.getText(), description.getText(), d, Integer.parseInt(nbplace.getText()));
            EvenementBD ps = new EvenementBD();
            ps.insertPst(p);
            Parent root;
            try {
               root = FXMLLoader.load(getClass().getResource("AfficherEvent.fxml"));
                ajouterbtn.getScene().setRoot(root);
            } catch (IOException ex) {
                //Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }    
    
}
