/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import smart.Entity.Evenement;
import smartService.EvenementBD;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AfficherEventController implements Initializable {

    @FXML
    private TableColumn<Evenement, Integer> idcoll;
    @FXML
    private TableColumn<Evenement, String> catcoll;
    @FXML
    private TableColumn<Evenement, String> titcoll;
    @FXML
    private TableColumn<Evenement, String> imagecoll;
    @FXML
    private TableColumn<Evenement, String> lieucoll;
    @FXML
    private TableColumn<Evenement, String> description;
    @FXML
    private TableColumn<Evenement, Date> datecoll;
    @FXML
    private TableColumn<Evenement, String> nbplacecool;
    @FXML
    private TableView<Evenement> table;
    @FXML
    private Button modif;
    @FXML
    private Button showbtn;
    @FXML
    private Button supp;
    @FXML
    private TextField id;
    @FXML
    private TextField categorie;
    @FXML
    private TextField titre;
    @FXML
    private TextField image;
    @FXML
    private TextField lieu;
    @FXML
    private TextField descripition;
    @FXML
    private TextField nbplace;
    @FXML
    private DatePicker date;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        EvenementBD ps = new EvenementBD();
        ArrayList<Evenement> pers = (ArrayList<Evenement>) ps.readAll();
        ObservableList<Evenement> obs = FXCollections.observableArrayList(pers);
        table.setItems(obs);
        idcoll.setCellValueFactory(new PropertyValueFactory<>("id"));
        catcoll.setCellValueFactory(new PropertyValueFactory<>("id_categorie"));
        titcoll.setCellValueFactory(new PropertyValueFactory<>("titre"));
        imagecoll.setCellValueFactory(new PropertyValueFactory<>("nom_image"));
        lieucoll.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        datecoll.setCellValueFactory(new PropertyValueFactory<>("date_event"));
        nbplacecool.setCellValueFactory(new PropertyValueFactory<>("nbplace"));

        supp.setOnAction((ActionEvent e) -> {

            Evenement p = (Evenement) table.getSelectionModel().getSelectedItem();
            int a = p.getId();

            table.getItems().remove(p);
            ps.delete(a);

        });
        modif.setOnAction((ActionEvent e) -> {

            java.sql.Date d = java.sql.Date.valueOf(date.getValue());

            Evenement a = new Evenement(Integer.parseInt(id.getText()), Integer.parseInt(categorie.getText()), titre.getText(), image.getText(), lieu.getText(), descripition.getText(), d, Integer.parseInt(nbplace.getText()));

            ps.update(a, a.getId());

            obs.clear();

            ArrayList<Evenement> acts = (ArrayList<Evenement>) ps.readAll();

            ObservableList<Evenement> nobs = FXCollections.observableArrayList(acts);
            table.setItems(nobs);

            idcoll.setCellValueFactory(new PropertyValueFactory<>("id"));
            catcoll.setCellValueFactory(new PropertyValueFactory<>("id_categorie"));
            titcoll.setCellValueFactory(new PropertyValueFactory<>("titre"));
            imagecoll.setCellValueFactory(new PropertyValueFactory<>("nom_image"));
            lieucoll.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            description.setCellValueFactory(new PropertyValueFactory<>("description"));
            datecoll.setCellValueFactory(new PropertyValueFactory<>("date_event"));
            nbplacecool.setCellValueFactory(new PropertyValueFactory<>("nbplace"));
        });
        showbtn.setOnAction(((event) -> {
            Evenement p = (Evenement) table.getSelectionModel().getSelectedItem();

            id.setText(String.valueOf(p.getId()));
            categorie.setText(String.valueOf(p.getId_categorie()));
            titre.setText(String.valueOf(p.getTitre()));
            image.setText(String.valueOf(p.getNom_image()));
            lieu.setText(String.valueOf(p.getLieu()));

            descripition.setText(String.valueOf(p.getDescription()));
            date.setValue(null);
            nbplace.setText(String.valueOf(p.getNbplace()));

        }));

    }

}
