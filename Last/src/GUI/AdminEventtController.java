/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Evenement;
import Service.EvenementBD;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AdminEventtController implements Initializable {

    @FXML
    private Button categorie;
    @FXML
    private Button statisque;
    @FXML
    private TableView<Evenement> tabevent;
    @FXML
    private Button ajouteer;
    @FXML
    private Button modifev;
    @FXML
    private Button supprimerevnt;
    @FXML
    private TableColumn<Evenement, Integer> idcolE;
    @FXML
    private TableColumn<Evenement,String> titrecolE;
    @FXML
    private TableColumn<Evenement,String> lieucolE;
    @FXML
    private TableColumn<Evenement, String> descriptioncollE;
    @FXML
    private TableColumn<Evenement, Date> date_evnetcollE;
    @FXML
    private TableColumn<Evenement, Integer> nbplacecollE;
    @FXML
    private TableColumn<Evenement, String> nom_imagecollE;
    @FXML
    private TableColumn<Evenement, Integer> categoriecollE;
    public static int IdpourModifier;
     private ImageView UploadImage;
     private String imageUpload;
     private ObservableList<Evenement> data;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        EvenementBD crud =new EvenementBD();
        // EvenementDB  crud = new  EvenementDB  ();
         Evenement e  ;
          data = FXCollections.observableArrayList();
         idcolE.setCellValueFactory(new PropertyValueFactory<>("id")); //from entity
     titrecolE.setCellValueFactory(new PropertyValueFactory<>("titre"));
    lieucolE.setCellValueFactory(new PropertyValueFactory<>("lieu"));
   descriptioncollE.setCellValueFactory(new PropertyValueFactory<>("description")); //from entity
   date_evnetcollE.setCellValueFactory(new PropertyValueFactory<>("date_event"));
  nbplacecollE.setCellValueFactory(new PropertyValueFactory<>("nbplace"));
 nom_imagecollE.setCellValueFactory(new PropertyValueFactory<>("nom_image"));

  categoriecollE.setCellValueFactory(new PropertyValueFactory<>("id_categorie"));
  
  tabevent.setItems(crud.afficherEvent());
  
    }    

    @FXML
    private void categorieEventbtn(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("categorieEventt.fxml"));
                
        Scene newScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void statbtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("statist.fxml"));
                
        Scene newScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void ajoutbtnEvent(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ajoutEventt.fxml"));
                
        Scene newScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void modifbtnEvent(ActionEvent event) throws IOException {
         //go to modifier page

        ObservableList<Evenement> selectedRows, AllCovs;
        AllCovs =tabevent.getItems();

        //this gives us the rows that were selected
        selectedRows = tabevent.getSelectionModel().getSelectedItems();

        //loop over the selected rows and remove the Person objects from the table
        for (Evenement c : selectedRows) {

            try {
                IdpourModifier = c.getId();

            } catch (NumberFormatException e) {

            }

        }
        System.out.println("Id pour modifier :  " + IdpourModifier);
        if (IdpourModifier != 0) {

            Parent tableViewParent = FXMLLoader.load(getClass().getResource("modifiereventt.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            //This line gets the Stage information
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();

        } else {
            JOptionPane.showMessageDialog(null, "tu dois selectionner le champs a modifier ");
        }
    }
    

    @FXML
    private void supprimer_evenement(ActionEvent event) {
        EvenementBD cs =new EvenementBD();
        //EvenementDB  cs = new EvenementDB ();
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Confirmation Dialog");
alert.setHeaderText("Look, a Confirmation Dialog");
alert.setContentText("you are sure to delete");

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == ButtonType.OK){
    // ... user chose OK
} else {
    // ... user chose CANCEL or closed the dialog
}
  cs.delete_Event( tabevent.getSelectionModel().getSelectedItem());
    
        
       tabevent.setItems(cs.afficherEvent()); //Affichage après suppression
    }
    
}
