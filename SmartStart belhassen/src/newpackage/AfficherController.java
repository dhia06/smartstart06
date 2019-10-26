/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import entite.Projet;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.ProjetService;

/**
 * FXML Controller class
 *
 * @author belhassan
 */
public class AfficherController implements Initializable {

    @FXML
    private TableView<Projet> table;
    @FXML
    private TableColumn<Projet, Integer> idcoll;
    @FXML
    private TableColumn<Projet, String> titrecoll;
    @FXML
    private TableColumn<Projet, String> objetcifcool;
    @FXML
    private TableColumn<Projet, String> deurrecoll;
    @FXML
    private TableColumn<Projet, String> descriptioncoll;
    @FXML
    private TextField id;
    @FXML
    private TextField titre;
    @FXML
    private TextField duree;
    @FXML
    private TextField description;
    @FXML
    private TextField objectif;
    @FXML
    private Button showbnt;
    @FXML
    private Button Suppbtn;
    @FXML
    private Button modifierbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ProjetService ps = new ProjetService();
        ArrayList<Projet> pers = (ArrayList<Projet>) ps.readAll();
        ObservableList<Projet> obs = FXCollections.observableArrayList(pers);
        table.setItems(obs);
        idcoll.setCellValueFactory(new PropertyValueFactory<>("id"));
        titrecoll.setCellValueFactory(new PropertyValueFactory<>("titre"));
        objetcifcool.setCellValueFactory(new PropertyValueFactory<>("objectif"));
        deurrecoll.setCellValueFactory(new PropertyValueFactory<>("duree"));
        descriptioncoll.setCellValueFactory(new PropertyValueFactory<>("description"));

        Suppbtn.setOnAction((ActionEvent e) -> {

            Projet p = (Projet) table.getSelectionModel().getSelectedItem();
            int a = p.getId();

            table.getItems().remove(p);
            ps.delete(a);

        });
        modifierbtn.setOnAction((ActionEvent e) -> {

            Projet a = new Projet(Integer.parseInt(id.getText()), titre.getText(), objectif.getText(), duree.getText(), description.getText());

            ps.update(a, a.getId());

            obs.clear();

            ArrayList<Projet> acts = (ArrayList<Projet>) ps.readAll();

            ObservableList<Projet> nobs = FXCollections.observableArrayList(acts);
            table.setItems(nobs);
            idcoll.setCellValueFactory(new PropertyValueFactory<>("id"));
            titrecoll.setCellValueFactory(new PropertyValueFactory<>("titre"));
            objetcifcool.setCellValueFactory(new PropertyValueFactory<>("objectif"));
            deurrecoll.setCellValueFactory(new PropertyValueFactory<>("duree"));
            descriptioncoll.setCellValueFactory(new PropertyValueFactory<>("description"));

        });
        showbnt.setOnAction(((event) -> {
            Projet p = (Projet) table.getSelectionModel().getSelectedItem();

            id.setText(String.valueOf(p.getId()));
            titre.setText(String.valueOf(p.getTitre()));
            objectif.setText(String.valueOf(p.getObjectif()));
            duree.setText(String.valueOf(p.getDuree()));

            description.setText(String.valueOf(p.getDescription()));
           

        }));

    }

}
