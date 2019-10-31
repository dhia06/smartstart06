/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Dialog.AlertDialog;
import entité.Actualite;
import entité.Publicite;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import service.ActualiteService;
import service.PubliciteService;
import org.controlsfx.control.NotificationPane;
import org.controlsfx.control.Notifications;
import utile.DataSource;

public class ConsulterpubliciteController implements Initializable {

    @FXML
    private Button btn_ajout;
    @FXML
    private Button delete;
    @FXML
    private Button update;
    @FXML
    private TextField tfid;
    @FXML
    private TextField tftitre;
    @FXML
    private TextField tfimg;
    @FXML
    private TextArea tfdesc;
    @FXML
    private ImageView UploadImage;
    @FXML
    private DatePicker date_pub;
    @FXML
    private Label lbl_date;
    @FXML
    private TextField tfprop;
    @FXML
    private Button uploadImage;
    @FXML
    private TableView<Publicite> table;
    @FXML
    private TableColumn<Publicite, Integer> colid;
    @FXML
    private TableColumn<Publicite, String> coltitre;
    @FXML
    private TableColumn<Publicite, String> coldescr;
    @FXML
    private TableColumn<Publicite, Date> coldate;
    @FXML
    private TableColumn<Publicite, String> colprop;
    @FXML
    private TableColumn<Publicite, String> colimg;
    private String name;
    private String imageUpload;
    @FXML
    private Button actualite;
    @FXML
    private Button sponsoring;
    @FXML
    private Button media;
    @FXML
    private TextField filterField;
    private ObservableList<Publicite> masterData = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Publicite, Integer> collike;
    @FXML
    private Button like;
    @FXML
    private Button dislike;
    @FXML
    private Button actualiser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        actualiser.setOnAction((ActionEvent e) ->{
        PubliciteService pss=new PubliciteService();
          ArrayList<Publicite> pub11 = (ArrayList<Publicite>) pss.readAll();
          ObservableList<Publicite> obsn1 = FXCollections.observableArrayList(pub11);
          table.setItems(obsn1);
           colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        coldescr.setCellValueFactory(new PropertyValueFactory<>("description"));
        colimg.setCellValueFactory(new PropertyValueFactory<>("affiche"));
        colprop.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));
        collike.setCellValueFactory(new PropertyValueFactory<>("likes"));
        });
          
        
        
    ;
        PubliciteService ps = new PubliciteService();
        ArrayList<Publicite> pub1 = (ArrayList<Publicite>) ps.readAll();
        ObservableList<Publicite> obsn = FXCollections.observableArrayList(pub1);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            ArrayList<Publicite> pub = (ArrayList<Publicite>) ps.readAll();
            ObservableList<Publicite> obs = FXCollections.observableArrayList(pub);
            ps.readAll();
            FilteredList<Publicite> filteredData = new FilteredList<>(obs, p -> true);
            filteredData.setPredicate(Publicite -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (Publicite.getTitre().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (Publicite.getProprietaire().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });

            SortedList<Publicite> sortedData = new SortedList<>(filteredData);

            sortedData.comparatorProperty().bind(table.comparatorProperty());

            // 5. Add sorted (and filtered) data to the table.
            table.setItems(sortedData);

        });
        table.setItems(obsn);

        btn_ajout.setOnAction((ActionEvent e) -> {

            if (tftitre.getText().isEmpty() || tfdesc.getText().isEmpty() || tfimg.getText().isEmpty()) {

                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Valider vos champs");
                alert1.setHeaderText(null);
                alert1.setContentText("Veuillez remplir les champs ");
                alert1.showAndWait();

            } else if (date_pub.getValue() == null) {
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

            } else if (!tftitre.getText().matches("^[a-z A-Z\\s]*$")) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Valider les titres des actualités");
                alert1.setHeaderText(null);
                alert1.setContentText("Veuillez saisir un titre convenable ");
                alert1.showAndWait();

            } else if (LocalDate.now().isAfter(date_pub.getValue())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Date de l'actualité saisie est incorrect vous avez saisi une date inférieure à celle d'aujourd'hui !");
                alert.setContentText("Erreur");
                alert.showAndWait();
            } else {
                java.sql.Date dd = java.sql.Date.valueOf(date_pub.getValue());

                Publicite p = new Publicite(tftitre.getText(), dd, tfdesc.getText(), tfimg.getText(), tfprop.getText());
                ps.insertPst(p);

                AlertDialog.display("Done", "L'Ajout est réussi");

                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("consulterpublicite.fxml"));
                    btn_ajout.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(ConsulteractualiteController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        coldescr.setCellValueFactory(new PropertyValueFactory<>("description"));
        colimg.setCellValueFactory(new PropertyValueFactory<>("affiche"));
        colprop.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));
        collike.setCellValueFactory(new PropertyValueFactory<>("likes"));

        delete.setOnAction((ActionEvent e) -> {

            Publicite p = (Publicite) table.getSelectionModel().getSelectedItem();
            if (p != null) {
                int a = p.getId();
                //table.getItems().remove(p);
                ps.delete(a);

                ArrayList<Publicite> pub11 = (ArrayList<Publicite>) ps.readAll();
                ObservableList<Publicite> obs1 = FXCollections.observableArrayList(pub11);
                table.setItems(obs1);
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

        update.setOnAction((ActionEvent e) -> {

           

            if (tftitre.getText().isEmpty() || tfdesc.getText().isEmpty() || tfimg.getText().isEmpty() || tfprop.getText().isEmpty()) {

                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Valider vos champs");
                alert1.setHeaderText(null);
                alert1.setContentText("Veuillez remplir les champs ");
                alert1.showAndWait();

            } else if (date_pub.getValue() == null) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Valider vos champs");
                alert1.setHeaderText(null);
                alert1.setContentText("Veuillez remplir les champs ");
                alert1.showAndWait();

           /* } else if (imageUpload == null) {
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

            } else if (!tfprop.getText().matches("^[a-zA-Z\\s]*$")) {
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Valider les noms des propriétaires");
                alert1.setHeaderText(null);
                alert1.setContentText("Veuillez saisir un nom convenable ");
                alert1.showAndWait();

            } else if (LocalDate.now().isAfter(date_pub.getValue())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Date de la publicité saisie est incorrect!! vous avez saisi une date inférieure à celle d'aujourd'hui !");
                alert.setContentText("Erreur");
                alert.showAndWait();
            } else {
                 java.sql.Date d = java.sql.Date.valueOf(date_pub.getValue());

                Publicite pa = new Publicite(Integer.parseInt(tfid.getText()), tftitre.getText(), d, tfdesc.getText(), tfimg.getText(), tfprop.getText());

                ps.update(pa, pa.getId());
                lbl_date.setText(date_pub.getValue().toString());

                pub1.clear();

                ArrayList<Publicite> acts = (ArrayList<Publicite>) ps.readAll();

                ObservableList<Publicite> nobs = FXCollections.observableArrayList(acts);

                table.setItems(nobs);

                colid.setCellValueFactory(new PropertyValueFactory<>("id"));
                coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
                coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
                coldescr.setCellValueFactory(new PropertyValueFactory<>("description"));
                colimg.setCellValueFactory(new PropertyValueFactory<>("affiche"));
                colprop.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));
            }
        });
        table.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {

            Publicite p = (Publicite) table.getSelectionModel().getSelectedItem();

            tfid.setText(String.valueOf(p.getId()));
            tftitre.setText(String.valueOf(p.getTitre()));

            tfdesc.setText(String.valueOf(p.getDescription()));
            date_pub.setValue(null);
            tfimg.setText(String.valueOf(p.getAffiche()));
            lbl_date.setText(String.valueOf(p.getDate()));
            tfprop.setText(String.valueOf(p.getProprietaire()));
            String path = new File("c:\\Images").getAbsolutePath();
        });

    }

    ;     

        

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
    private void selectDate(MouseEvent event) {
        lbl_date.setText(date_pub.getValue().toString());
    }

    @FXML
    private void actualite(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("consulteractualite.fxml"));
        actualite.getScene().setRoot(root);
    }

    @FXML
    private void sponsoring(ActionEvent event) throws IOException {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("consultersponsoring.fxml"));
        sponsoring.getScene().setRoot(root);
    }

    @FXML
    private void media(ActionEvent event) throws IOException {

        Parent root;
        root = FXMLLoader.load(getClass().getResource("media.fxml"));
        media.getScene().setRoot(root);

      //  Image image = new Image("Images\\u.png");
        Notifications notificationBuilder = Notifications.create()
                .title("Notification")
                .text("un utilisateur a consulté vos vidéos")
                //.graphic(new ImageView(image))
                .hideAfter(Duration.seconds(5))
                .position(Pos.TOP_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();

    }

    @FXML
    private void like(ActionEvent event) {

        Connection cnx = DataSource.getInstance().getConnexion();
        Statement ste;
        PreparedStatement pst;
        //ResultSet rs;

        Publicite p = (Publicite) table.getSelectionModel().getSelectedItem();
        if(p!=null){
        int a = p.getId();

        String req = "UPDATE publicite SET likes= likes +1 WHERE id=" + a;

        try {
            PreparedStatement e = cnx.prepareStatement(req);
            e.executeUpdate(req);
            // int likes=rs.getInt();
            PubliciteService ps = new PubliciteService();

            ArrayList<Publicite> pub1 = (ArrayList<Publicite>) ps.readAll();
            ObservableList<Publicite> obsn = FXCollections.observableArrayList(pub1);

            colid.setCellValueFactory(new PropertyValueFactory<>("id"));
            coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
            coldescr.setCellValueFactory(new PropertyValueFactory<>("description"));
            colimg.setCellValueFactory(new PropertyValueFactory<>("affiche"));
            colprop.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));
            collike.setCellValueFactory(new PropertyValueFactory<>("likes"));

        } catch (SQLException ex) {
            Logger.getLogger(ConsulterpubliciteController.class.getName()).log(Level.SEVERE, null, ex);

        }
         } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("SELECTION D'UNE PUBLICITE");
                alert.setHeaderText("sélectionner une publicité à aimer");
                Optional<ButtonType> result = alert.showAndWait();
        }

    }

    @FXML
    private void dislike(ActionEvent event) {

        Connection cnx = DataSource.getInstance().getConnexion();
        Statement ste;
        PreparedStatement pst;
        //ResultSet rs;

        Publicite p = (Publicite) table.getSelectionModel().getSelectedItem();
         if(p!=null){
        int a = p.getId();

        String req = "UPDATE publicite SET likes= likes -1 WHERE id=" + a;

        try {
            PreparedStatement e = cnx.prepareStatement(req);
            e.executeUpdate(req);
            // int likes=rs.getInt();
            PubliciteService ps = new PubliciteService();

            ArrayList<Publicite> pub1 = (ArrayList<Publicite>) ps.readAll();
            ObservableList<Publicite> obsn = FXCollections.observableArrayList(pub1);

            colid.setCellValueFactory(new PropertyValueFactory<>("id"));
            coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
            coldescr.setCellValueFactory(new PropertyValueFactory<>("description"));
            colimg.setCellValueFactory(new PropertyValueFactory<>("affiche"));
            colprop.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));
            collike.setCellValueFactory(new PropertyValueFactory<>("likes"));

        } catch (SQLException ex) {
            Logger.getLogger(ConsulterpubliciteController.class.getName()).log(Level.SEVERE, null, ex);

        }
         } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("SELECTION D'UNE PUBLICITE");
                alert.setHeaderText("sélectionner la publicité dont vous voulez enlever votre like");
                Optional<ButtonType> result = alert.showAndWait();
        }

    }
}
