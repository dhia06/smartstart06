/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entité.Actualite;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import service.ActualiteService;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherActualiteController implements Initializable {

    @FXML
    private TableView<Actualite> table;
    @FXML
    private TableColumn<Actualite, String> coltitre;

    @FXML
    private TableColumn<Actualite, Integer> colid;
    @FXML
    private TableColumn<Actualite, String> coldescr;
    @FXML
    private TableColumn<Actualite, String> img;
    @FXML
    private TableColumn<Actualite, Date> coldate;
    @FXML
    private TextField idm;
    @FXML
    private TextField titrem;
    @FXML
    private DatePicker datem;
    @FXML
    private TextArea desm;
    @FXML
    private TextField imm;
    @FXML
    private Button show;
    @FXML
    private Button delete;
    @FXML
    private Button update;

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

        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        coldescr.setCellValueFactory(new PropertyValueFactory<>("description"));
        img.setCellValueFactory(new PropertyValueFactory<>("img"));

        delete.setOnAction((ActionEvent e) -> {

            Actualite p = (Actualite) table.getSelectionModel().getSelectedItem();
            int a = p.getId();

            table.getItems().remove(p);
            as.delete(a);

        });

        show.setOnAction(((event) -> {
            Actualite p = (Actualite) table.getSelectionModel().getSelectedItem();

            idm.setText(String.valueOf(p.getId()));
            titrem.setText(String.valueOf(p.getTitre()));
            datem.setValue(null);

            desm.setText(String.valueOf(p.getDescription()));
            imm.setText(String.valueOf(p.getimg()));

        }));

        update.setOnAction((ActionEvent e) -> {
            
            java.sql.Date d = java.sql.Date.valueOf(datem.getValue());

            Actualite a = new Actualite( Integer.parseInt(idm.getText()),titrem.getText(),d,desm.getText(), imm.getText());

            as.update(a, a.getId());
            
            
            act.clear();
           
             ArrayList<Actualite>acts=(ArrayList<Actualite>) as.readAll();
            
            
            ObservableList<Actualite> nobs =FXCollections.observableArrayList(acts);
            table.setItems(nobs);
            
            colid.setCellValueFactory(new PropertyValueFactory<>("id"));
            coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
            coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
            coldescr.setCellValueFactory(new PropertyValueFactory<>("description"));
            img.setCellValueFactory(new PropertyValueFactory<>("img"));

        });
    }
}
