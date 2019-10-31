/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Dialog.AlertDialog;
import entité.Actualite;
import entité.Sponsoring;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import service.ActualiteService;
import service.SponsoringService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ConsultersponsoringController implements Initializable {

    @FXML
    private TableColumn<Sponsoring, Integer> colref;
    @FXML
    private TableColumn<Sponsoring, Date> coldate;
    @FXML
    private TableColumn<Sponsoring, String> pdf;
    @FXML
    private TextField tfref;
    @FXML
    private DatePicker date_sp;
    @FXML
    private Label lbldate;
    @FXML
    private Button btn_ajout;
    @FXML
    private Button delete;
    @FXML
    private Button update;
    @FXML
    private Button exporter;
    @FXML
    private TableView<Sponsoring> table;
    @FXML
    private TextField tfdesc;
    @FXML
    private Button actualite;
    @FXML
    private Button publicite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        // TODO
        
          SponsoringService ss = new SponsoringService();
        ArrayList<Sponsoring> act = (ArrayList<Sponsoring>) ss.readAll();
        ObservableList<Sponsoring> obs = FXCollections.observableArrayList(act);
        table.setItems(obs);

        btn_ajout.setOnAction((ActionEvent e) -> {
           
            
            if (tfdesc.getText().isEmpty()) {

                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Valider vos champs");
                alert1.setHeaderText(null);
                alert1.setContentText("Veuillez remplir les champs ");
                alert1.showAndWait();
                
                } else if (!tfdesc.getText().matches("^[a-zA-Z\\s]*$")) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Valider les noms du propriétaire");
                alert1.setHeaderText(null);
                alert1.setContentText("Veuillez saisir nom convenable ");
                alert1.showAndWait();
            
            
         

        } else if (date_sp.getValue() == null) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Valider vos champs");
                alert1.setHeaderText(null);
                alert1.setContentText("Veuillez remplir les champs ");
                alert1.showAndWait();
                
                  } else if (LocalDate.now().isAfter(date_sp.getValue())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Date de la demande de sponsoring saisie est incorrecte vous avez saisi une date inférieure à celle d'aujourd'hui !");
                alert.setContentText("Erreur");
                alert.showAndWait();
                  }else{
                       java.sql.Date d = java.sql.Date.valueOf(date_sp.getValue());
            Sponsoring s = new Sponsoring(d,tfdesc.getText());
            ss.insertPst(s);

            AlertDialog.display("Done", "L'Ajout est réussi");

            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("consultersponsoring.fxml"));
                btn_ajout.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(ConsulteractualiteController.class.getName()).log(Level.SEVERE, null, ex);
            }

    
            }
        });

        colref.setCellValueFactory(new PropertyValueFactory<>("ref"));
      
        coldate.setCellValueFactory(new PropertyValueFactory<>("date_contrat"));
        pdf.setCellValueFactory(new PropertyValueFactory<>("description"));
     
        delete.setOnAction((ActionEvent e) -> {

            Sponsoring sp = (Sponsoring) table.getSelectionModel().getSelectedItem();
           if (sp!=null){
            
            int a = sp.getRef();

            table.getItems().remove(sp);
            ss.delete(a);
            tfdesc.setText(String.valueOf(sp.getDescription()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("CONFIRMATION dELETE");
                alert.setHeaderText("DELETE DONE");
                Optional<ButtonType> result = alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("CONFIRMATION dELETE");
                alert.setHeaderText("sélectionner une demande de sponsoring");
                Optional<ButtonType> result = alert.showAndWait();
           
            }
        });
    
    
     update.setOnAction((ActionEvent e) -> {

              
                 if (tfdesc.getText().isEmpty()) {

                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Valider vos champs");
                alert1.setHeaderText(null);
                alert1.setContentText("Veuillez remplir les champs ");
                alert1.showAndWait();
                
                } else if (!tfdesc.getText().matches("^[a-zA-Z\\s]*$")) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Valider les noms du propriétaire");
                alert1.setHeaderText(null);
                alert1.setContentText("Veuillez saisir nom convenable ");
                alert1.showAndWait();
            
            
         

        } else if (date_sp.getValue() == null) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Valider vos champs");
                alert1.setHeaderText(null);
                alert1.setContentText("Veuillez remplir les champs ");
                alert1.showAndWait();
                
                  } else if (LocalDate.now().isAfter(date_sp.getValue())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Date de la demande de sponsoring saisie est incorrecte vous avez saisi une date inférieure à celle d'aujourd'hui !");
                alert.setContentText("Erreur");
                alert.showAndWait();
                  }else{
                        java.sql.Date d = java.sql.Date.valueOf(date_sp.getValue());

               Sponsoring sp = new Sponsoring(Integer.parseInt(tfref.getText()),  d, tfdesc.getText());

                ss.update(sp, sp.getRef());
                lbldate.setText(date_sp.getValue().toString());

                act.clear();

                ArrayList<Sponsoring> acts = (ArrayList<Sponsoring>) ss.readAll();

                ObservableList<Sponsoring> nobs = FXCollections.observableArrayList(acts);
                table.setItems(nobs);

                colref.setCellValueFactory(new PropertyValueFactory<>("ref"));
             
                coldate.setCellValueFactory(new PropertyValueFactory<>("date_contrat"));
                pdf.setCellValueFactory(new PropertyValueFactory<>("description"));
                
            }
            });
            table.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {

            Sponsoring sp = (Sponsoring) table.getSelectionModel().getSelectedItem();

            tfref.setText(String.valueOf(sp.getRef()));
         //   tftitre.setText(String.valueOf(p.getTitre()));

           // tfdes.setText(String.valueOf(p.getDescription()));
            date_sp.setValue(null);
            tfdesc.setText(String.valueOf(sp.getDescription()));
            lbldate.setText(String.valueOf(sp.getDate_contrat()));

        
     });

    }

    ;     

    

    @FXML
    private void selectDate(MouseEvent event) {
         lbldate.setText(date_sp.getValue().toString());
    }

    @FXML
    private void exporter(ActionEvent event) throws IOException {
        
        
        
       Sponsoring p = (Sponsoring) table.getSelectionModel().getSelectedItem();
        String c;
        pdf.setText(String.valueOf(p.getDescription()));
        c = pdf.getText();

        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\GestionActualité\\" + c + ".pdf");

    }

    @FXML
    private void actualite(ActionEvent event) throws IOException {
        Parent root;
            root=FXMLLoader.load(getClass().getResource("consulteractualite.fxml"));
             actualite.getScene().setRoot(root);
    }

    @FXML
    private void publicite(ActionEvent event) throws IOException {
        Parent root;
            root=FXMLLoader.load(getClass().getResource("consulterpublicite.fxml"));
            publicite.getScene().setRoot(root);
    }
    }


