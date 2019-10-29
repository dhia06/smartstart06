/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Categorie;
import Service.CategorieBD;
import Utils.MyBDConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class CategorieEventtController implements Initializable {

    private ObservableList<Categorie> data;

    @FXML
    private Button ajoutecE;
    @FXML
    private Button retourE;
    @FXML
    private TableView<Categorie> tabcatE;
    @FXML
    private TableColumn<Categorie, Integer> idcategorieE;
    @FXML
    private TableColumn<Categorie, String> libellecategoirE;
    
    @FXML
    private TextField idcatE;
    @FXML
    private TextField libellecatE;
    @FXML
    private Button supprimercE;
    @FXML
    private TextField descriptioncE;
    @FXML
    private TableColumn<Categorie, String> descriptioncolE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CategorieBD crud = new CategorieBD();
        // CategorieDB  crud = new  CategorieDB  ();
        data = FXCollections.observableArrayList();

        // Search();
        idcategorieE.setCellValueFactory(new PropertyValueFactory<>("id")); //from entity
        libellecategoirE.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        descriptioncolE.setCellValueFactory(new PropertyValueFactory<>("description"));

        tabcatE.setItems(crud.afficherCategorie());
    }

    @FXML
    private void ajoutercatE(ActionEvent event) {
        if (idcatE.getText().isEmpty() || libellecatE.getText().isEmpty() || descriptioncE.getText().isEmpty()) {

            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider vos champs");
            alert1.setHeaderText(null);
            alert1.setContentText("Veuillez remplir les champs ");
            alert1.showAndWait();

        } else if (!libellecatE.getText().matches("^[a-zA-Z\\s]*$")) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider les noms des acteurs");
            alert1.setHeaderText(null);
            alert1.setContentText("Veuillez les noms des lieu ");
            alert1.showAndWait();
        } else if (!descriptioncE.getText().matches("^[a-zA-Z\\s]*$")) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider le nom du directeur");
            alert1.setHeaderText(null);
            alert1.setContentText("Veuillez verifier le nom du description ");
            alert1.showAndWait();
        } else {
            Categorie C;
            C = new Categorie(Integer.parseInt(idcatE.getText()), libellecatE.getText(), descriptioncE.getText());
            //CategorieDB  crud = new CategorieDB  ();
            CategorieBD crud = new CategorieBD();

            crud.ajouterEvent(C);
            tabcatE.setItems(crud.afficherCategorie());
            Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
            alert3.setTitle("Information Dialog");
            alert3.setHeaderText("Ajout avec Succes");
            Optional<ButtonType> result = alert3.showAndWait();
            if (result.get() == ButtonType.OK) {
                clear();
            }
        }
    }

    @FXML
    private void btnretourE(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminEventt.fxml"));

        Scene newScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    @FXML
    private void suppcategorieE(ActionEvent event) {
        CategorieBD cs = new CategorieBD();
        //CategorieDB  cs = new CategorieDB ();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("you are sure to delete");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ... user chose OK
        } else {
            // ... user chose CANCEL or closed the dialog
        }
        cs.delete_Categorie(tabcatE.getSelectionModel().getSelectedItem());

        tabcatE.setItems(cs.afficherCategorie()); //Affichage après suppression
    }

    private void clear() {
        idcatE.clear();
        libellecatE.clear();
        descriptioncE.clear();
    }

    @FXML
    private void click_afficheCE(MouseEvent event) {
         try
		{
			Categorie categorie=(Categorie)  tabcatE.getSelectionModel().getSelectedItem();
			String query="select * from categorie";
		
   
     
     
     
             Connection mycon = MyBDConnection.getInstanceBD().getConnection(); 
             Statement st = mycon.createStatement();
         
         String str = ""+categorie.getId();
         idcatE.setText(str);
            
           libellecatE.setText(categorie.getLibelle());
             String str2 = ""+categorie.getDescription();
    descriptioncE.setText(str2);
               
            st.executeUpdate(query);
        } catch (SQLException ex) {
           // Logger.getLogger(PersonneDB.class.getName()).log(Level.SEVERE, null, ex);
    }
    }}


