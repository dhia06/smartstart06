/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Evenement;
import Entity.Participation;
import Entity.User;
import Service.CategorieBD;
import Service.PartivipationService;
import Utils.MyBDConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class ParticipationController implements Initializable {

    @FXML
    private Button ajoutereventt;
    @FXML
    private Button retourE;
    @FXML
    private ComboBox<User> id_user;
    @FXML
    private ComboBox<Evenement> id_event;
    @FXML
    private TableView<Participation> table;
    @FXML
    private TableColumn<Participation,Integer> idparcoll;
    @FXML
    private TableColumn<Participation, Integer> idusercoll;
    @FXML
    private TableColumn<Participation, Integer> id_evnet_coll;
    @FXML
    private Button suppparticipant;
           Connection mycon = MyBDConnection.getInstanceBD().getConnection(); 

 Evenement l = new Evenement();
    PartivipationService ae =new PartivipationService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<Participation> npe = (ArrayList<Participation>) ae.displayparticipant();
        ObservableList<Participation> nob = FXCollections.observableArrayList(npe);
        table.setItems(nob);
          PartivipationService crud = new PartivipationService();
idparcoll.setCellValueFactory(new PropertyValueFactory<>("paticipant_id")); //from entity
        idusercoll.setCellValueFactory(new PropertyValueFactory<>("event_id"));
       id_evnet_coll.setCellValueFactory(new PropertyValueFactory<>("id"));

     
             

         List<Evenement> list = new ArrayList();
        String requete = "select * from evenement ";
        PreparedStatement pst;
        try {
            pst = mycon.prepareStatement(requete);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                int idv =result.getInt(1);
                String titre = result.getString(2);
                list.add(new Evenement(idv,titre));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<Evenement> li = FXCollections.observableArrayList(list);
        li.addAll(list);
       id_event.getItems().addAll(list);
       id_event.setConverter(new EventtConverter());
       
       
       
        List<User> lis = new ArrayList();
        String req = "select * from user ";
        PreparedStatement ps;
        try {
            ps = mycon.prepareStatement(req);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                int ids =result.getInt(1);

                String nom= result.getString(5);
              
                lis.add(new User (ids,nom));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<User> l = FXCollections.observableArrayList(lis);
        l.addAll(lis);
       id_user.getItems().addAll(lis);
id_user.setConverter(new UserConverter());


      
    }    

    @FXML
    private void ajouterparticipation(ActionEvent event) {
        
        int ide=id_event.getSelectionModel().getSelectedItem().getId();
        int idu=id_user.getSelectionModel().getSelectedItem().getId();
        Participation p =new Participation(ide, idu);
        ae.ajouterParticipation(p);
          ArrayList<Participation> nper = (ArrayList<Participation>) ae.displayparticipant();
                ObservableList<Participation> nobs = FXCollections.observableArrayList(nper);
                table.setItems(nobs);
                idparcoll.setCellValueFactory(new PropertyValueFactory<>("paticipant_id")); //from entity
        idusercoll.setCellValueFactory(new PropertyValueFactory<>("event_id"));
       id_evnet_coll.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    @FXML
    private void btnretourE(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("eventt.fxml"));
        Scene newScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void suppparticipant(ActionEvent event) {
       Participation p = (Participation) table.getSelectionModel().getSelectedItem();
            if (p != null) {
                int a = p.getPaticipant_id();

                ae.suprrimerParticipation(p,a);
                ArrayList<Participation> nper = (ArrayList<Participation>) ae.displayparticipant();
                ObservableList<Participation> nobs = FXCollections.observableArrayList(nper);
                table.setItems(nobs);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("supprission terminé avec succé!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("il faut selectinner un participant!");
                alert.showAndWait();
            }
        
        
    }
    
    
}
