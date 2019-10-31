/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Dialog.AlertDialog;
import entité.Actualite;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import service.ActualiteService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ConsulteractualiteController implements Initializable {

    @FXML
    private TextField tfid;
    @FXML
    private TextField tftitre;
    @FXML
    private TextArea tfdes;
    @FXML
    private DatePicker date_ac;
    @FXML
    private TextField tfimg;
    @FXML
    private Button uploadImage;
    @FXML
    private Button ajout_btn;
    @FXML
    private Button delete;
    @FXML
    private Button update;
    @FXML
    private TableColumn<Actualite, Integer> colid;
    @FXML
    private TableColumn<Actualite, String> coldescr;

    @FXML
    private TableColumn<Actualite, Date> coldate;
    @FXML
    private TableColumn<Actualite, String> coltitre;
    @FXML
    private Label lbldate;
    @FXML
    private TableView<Actualite> table;
    private String imageUpload;
    @FXML
    private ImageView UploadImage;
    private String name;
    @FXML
    private TableColumn<Actualite, String> colimg;
    @FXML
    private Button publicite;
    @FXML
    private Button sponsoring;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ActualiteService as = new ActualiteService();
        ArrayList<Actualite> act = (ArrayList<Actualite>) as.readAll();
        ObservableList<Actualite> obs = FXCollections.observableArrayList(act);
        table.setItems(obs);

        ajout_btn.setOnAction((ActionEvent e) -> {
          

            //   lbldate.setText(String.valueOf(a.getDate()));
            if (tftitre.getText().isEmpty() || tfdes.getText().isEmpty() || tfimg.getText().isEmpty()) {

                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Valider vos champs");
                alert1.setHeaderText(null);
                alert1.setContentText("Veuillez remplir les champs ");
                alert1.showAndWait();

            } else if (date_ac.getValue() == null) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Valider vos champs");
                alert1.setHeaderText(null);
                alert1.setContentText("Veuillez remplir les champs ");
                alert1.showAndWait();

            } else if (imageUpload == null) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Valider vos champs");
                alert1.setHeaderText(null);
                alert1.setContentText("Veuillez choisir une image ");
                alert1.showAndWait();

            } else if (!tftitre.getText().matches("^[a-zA-Z\\s]*$")) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Valider les titres des actualités");
                alert1.setHeaderText(null);
                alert1.setContentText("Veuillez saisir un titre convenable ");
                alert1.showAndWait();

            } else if (LocalDate.now().isAfter(date_ac.getValue())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Date de l'actualité saisie est incorrect vous avez saisi une date inférieure à celle d'aujourd'hui !");
                alert.setContentText("Erreur");
                alert.showAndWait();
            } else {
  java.sql.Date d = java.sql.Date.valueOf(date_ac.getValue());
                Actualite p = new Actualite(Integer.parseInt(tfid.getText()), tftitre.getText(), d, tfdes.getText(), tfimg.getText());
                as.insertPst(p);

                AlertDialog.display("Done", "L'Ajout est réussi");

                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("consulteractualite.fxml"));
                    ajout_btn.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(ConsulteractualiteController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        coldescr.setCellValueFactory(new PropertyValueFactory<>("description"));
        colimg.setCellValueFactory(new PropertyValueFactory<>("img"));

        delete.setOnAction((ActionEvent e) -> {

            Actualite p = (Actualite) table.getSelectionModel().getSelectedItem();
            if (p != null) {
                int a = p.getId();

                table.getItems().remove(p);
                as.delete(a);
                tftitre.setText(String.valueOf(p.getTitre()));

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("CONFIRMATION dELETE");
                alert.setHeaderText("DELETE DONE");
                Optional<ButtonType> result = alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("CONFIRMATION dELETE");
                alert.setHeaderText("sélectionner une actualité");
                Optional<ButtonType> result = alert.showAndWait();
            }
        });

//imageUpload=table.getSelectionModel().getSelectedItems().getimg();
            //   Image images =new Image("c:\\Images"+p);
            //UploadImage.setImage("images");
            /*  String x=table.getSelectionModel().getSelectedItem().getimg();
          File file =new File("C:\\Images"+x);
             
            Image image=new Image(file.toURI().toString());
          
          UploadImage.setImage(image);*/
            update.setOnAction((ActionEvent e) -> {

                

                if (tftitre.getText().isEmpty() || tfdes.getText().isEmpty() || tfimg.getText().isEmpty()) {

                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("Valider vos champs");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Veuillez remplir les champs ");
                    alert1.showAndWait();

                } else if (date_ac.getValue() == null) {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("Valider vos champs");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Veuillez remplir les champs ");
                    alert1.showAndWait();

              /*  } else if (imageUpload == null) {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("Valider vos champs");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Veuillez choisir une image ");
                    alert1.showAndWait();*/

                } else if (!tftitre.getText().matches("^[a-zA-Z\\s]*$")) {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("Valider les titres des actualités");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Veuillez saisir un titre convenable ");
                    alert1.showAndWait();

                } else if (LocalDate.now().isAfter(date_ac.getValue())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Date de l'actualité saisie est incorrect vous avez saisi une date inférieure à celle d'aujourd'hui !");
                    alert.setContentText("Erreur");
                    alert.showAndWait();
                } else {
                    
                     java.sql.Date d = java.sql.Date.valueOf(date_ac.getValue());

                Actualite pa = new Actualite(Integer.parseInt(tfid.getText()), tftitre.getText(), d, tfdes.getText(), tfimg.getText());

                as.update(pa, pa.getId());
                lbldate.setText(date_ac.getValue().toString());
                AlertDialog.display("Done", "modification terminée");

               act.clear();

                ArrayList<Actualite> acts = (ArrayList<Actualite>) as.readAll();

                ObservableList<Actualite> nobs = FXCollections.observableArrayList(acts);

                table.setItems(nobs);

                colid.setCellValueFactory(new PropertyValueFactory<>("id"));
                coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
                coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
                coldescr.setCellValueFactory(new PropertyValueFactory<>("description"));
                colimg.setCellValueFactory(new PropertyValueFactory<>("img"));
               // colprop.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));
                   
                    

                }
            });

       
        table.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {

            Actualite p = (Actualite) table.getSelectionModel().getSelectedItem();

            tfid.setText(String.valueOf(p.getId()));
            tftitre.setText(String.valueOf(p.getTitre()));

            tfdes.setText(String.valueOf(p.getDescription()));
            date_ac.setValue(null);
            tfimg.setText(String.valueOf(p.getimg()));
            lbldate.setText(String.valueOf(p.getDate()));
 });

    }

    ;     

      @FXML
    private void selectDate(MouseEvent event) {
         lbldate.setText(date_ac.getValue().toString());
    }

    @FXML
    private void uploadImage(ActionEvent event) throws IOException {

        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)", "*.png");
        fc.getExtensionFilters().addAll(ext1, ext2);
        Stage stage = new Stage();
        File file = fc.showOpenDialog(stage);
        BufferedImage bf;
        if (file != null) {
            bf = ImageIO.read(file);
            tfimg.setText(file.getAbsolutePath());
            name = file.getName();
            javafx.scene.image.Image image = SwingFXUtils.toFXImage(bf, null);
            UploadImage.setImage(image);
            FileInputStream fin = new FileInputStream(file);
            imageUpload = file.getName();
        }

    }

    @FXML
    private void publicite(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("consulterpublicite.fxml"));
        publicite.getScene().setRoot(root);
    }

  
    @FXML
    private void sponsoring(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("consultersponsoring.fxml"));
        sponsoring.getScene().setRoot(root);

    }

   

  

}
