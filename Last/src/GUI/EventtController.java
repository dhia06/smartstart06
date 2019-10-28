/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Evenement;
import Service.EvenementBD;
import Utils.MyBDConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class EventtController implements Initializable {

    @FXML
    private TableView<Evenement> Event_tab;
    @FXML
    private TableColumn<Evenement,Integer> id_COL;
    @FXML
    private TableColumn<Evenement, String> titre_COL;
    @FXML
    private TableColumn<Evenement, String> lieu_COL;
    @FXML
    private TableColumn<Evenement, String> description_COL;
    @FXML
    private TableColumn<Evenement, Date> date_event_COL;
    @FXML
    private TableColumn<Evenement, Integer> nbplace_COL;
    @FXML
    private TableColumn<Evenement, String> nom_image_COL;
    @FXML
    private TableColumn<Evenement, Integer> categorie_COL;
    @FXML
    private TextField q1_aff;
    @FXML
    private TextField q2_aff;
    @FXML
    private TextField q3_aff;
    @FXML
    private TextField q4_aff;
    @FXML
    private TextField q5_aff;
    @FXML
    private TextField q6_aff;
    @FXML
    private TextField q7_aff;
    @FXML
    private TextField q8_aff;
    public static int IdpourReserver;
    @FXML
    private Button supprimer;
    @FXML
    private Button reservation;
    @FXML
    private Button b1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EvenementBD crud =new EvenementBD();
       // EvenementDB  crud = new  EvenementDB  ();
          id_COL.setCellValueFactory(new PropertyValueFactory<>("id")); //from entity
     titre_COL.setCellValueFactory(new PropertyValueFactory<>("titre"));
    lieu_COL.setCellValueFactory(new PropertyValueFactory<>("lieu"));
   description_COL.setCellValueFactory(new PropertyValueFactory<>("description")); //from entity
   date_event_COL.setCellValueFactory(new PropertyValueFactory<>("date_event"));
  nbplace_COL.setCellValueFactory(new PropertyValueFactory<>("nbplace"));
  nom_image_COL.setCellValueFactory(new PropertyValueFactory<>("nom_image"));

  categorie_COL.setCellValueFactory(new PropertyValueFactory<>("id_categorie"));
  	
        
 Event_tab.setItems(crud.afficherEvent());
    }    

    @FXML
    private void supprimer_evenement(ActionEvent event) {
        EvenementBD cs=new EvenementBD();
       // EvenementDB  cs = new EvenementDB ();
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
  cs.delete_Event(Event_tab.getSelectionModel().getSelectedItem());
    
        
      Event_tab.setItems(cs.afficherEvent()); //Affichage après suppression
   
    
    }

    @FXML
    private void click_affiche(MouseEvent event) {
         try
		{
			Evenement evenement=(Evenement)   Event_tab.getSelectionModel().getSelectedItem();
			String query="select * from evenement";
		
             Connection mycon = MyBDConnection.getInstanceBD().getConnection(); 
             Statement st = mycon.createStatement();
         
         String str = ""+evenement.getId();
        q1_aff.setText(str);
            
            q2_aff.setText(evenement.getTitre());
             String str2 = ""+evenement.getLieu();
        q3_aff.setText(str2);
             String str3 = ""+evenement.getDescription();
    q4_aff.setText(str3);
      String str4 = ""+evenement.getDate_event();
   q5_aff.setText(str4);
          String str5 = ""+evenement.getNbplace();
   q6_aff.setText(str5);    
	  String str6 = ""+evenement.getNom_image();
   q7_aff.setText(str6);  
     String str7 = ""+evenement.getId_categorie();
   q8_aff.setText(str7);  
            st.executeUpdate(query);
        } catch (SQLException ex) {
           // Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
        }
			
    }

    @FXML
    private void save_reservation(ActionEvent event) throws SQLException, IOException {
        ObservableList<Evenement> selectedRows, AllCovs;
        AllCovs = Event_tab.getItems();

        //this gives us the rows that were selected
        selectedRows =Event_tab.getSelectionModel().getSelectedItems();
        for ( Evenement c : selectedRows) {

            try {
                IdpourReserver = c.getId();

            } catch (NumberFormatException e) {

            }

        }

        //loop over the selected rows and remove the Person objects from the table
        EvenementBD crud =new EvenementBD();
              // EvenementDB  crud= new EvenementDB();
      // crud.Reserver(IdpourReserver);
        crud.quantiteReduce(IdpourReserver);
        Event_tab.setItems(crud.afficherEvent());
    }

    @FXML
    private void Ajout_Event(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ajoutEventt.fxml"));
        Scene newScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
    }


    

