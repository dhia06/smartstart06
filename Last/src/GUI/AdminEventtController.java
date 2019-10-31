/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Evenement;
import Service.EvenementBD;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.controlsfx.control.Notifications;

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
    private TableColumn<Evenement, String> titrecolE;
    @FXML
    private TableColumn<Evenement, String> lieucolE;
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
    public ArrayList<Evenement> ran;

    private ObservableList<Evenement> data;
    @FXML
    private TextField rechercheCol;
    @FXML
    private Button eventaujour;
    @FXML
    private ComboBox<String> trierEvnet;
    ObservableList<String> TriList = FXCollections.observableArrayList("Titre", "Date");
    @FXML
    private Button excelbtn;
    @FXML
    private Button liste;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        EvenementBD crud = new EvenementBD();
        // EvenementDB  crud = new  EvenementDB  ();
        Evenement e;
        Search();
        data = FXCollections.observableArrayList();
        trierEvnet.setItems(TriList);
        idcolE.setCellValueFactory(new PropertyValueFactory<>("id")); //from entity
        titrecolE.setCellValueFactory(new PropertyValueFactory<>("titre"));
        lieucolE.setCellValueFactory(new PropertyValueFactory<>("lieu"));
        descriptioncollE.setCellValueFactory(new PropertyValueFactory<>("description")); //from entity
        date_evnetcollE.setCellValueFactory(new PropertyValueFactory<>("date_event"));
        nbplacecollE.setCellValueFactory(new PropertyValueFactory<>("nbplace"));
        nom_imagecollE.setCellValueFactory(new PropertyValueFactory<>("nom_image"));

        categoriecollE.setCellValueFactory(new PropertyValueFactory<>("id_categorie"));

        tabevent.setItems(crud.afficherEvent());
        //notif();

    }

    public void Search() {
        EvenementBD bs = new EvenementBD();
        //  EvenementDB bs = new   EvenementDB();

        rechercheCol.setOnKeyReleased(e -> {
            if (rechercheCol.getText().equals("")) {
                bs.afficherEvent();
            } else {
                data.clear();
                data = bs.searchEvent(rechercheCol.getText());
                tabevent.setItems(data);
            }
        });

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
        AllCovs = tabevent.getItems();

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
        EvenementBD cs = new EvenementBD();
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
        cs.delete_Event(tabevent.getSelectionModel().getSelectedItem());
        tabevent.setItems(cs.afficherEvent()); //Affichage après suppression
    }

    @FXML
    private void eventaujour(ActionEvent event) {
        Task<ArrayList<Evenement>> task = new Task() {

            @Override
            protected Object call() throws SQLException {
                ran = (ArrayList<Evenement>) new EvenementBD().afficherEvenementsAjourdhui();
                return ran;
            }
        };
        task.setOnSucceeded((WorkerStateEvent e) -> {
            idcolE.setCellValueFactory(new PropertyValueFactory<>("id")); //from entity
            titrecolE.setCellValueFactory(new PropertyValueFactory<>("titre"));
            lieucolE.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            descriptioncollE.setCellValueFactory(new PropertyValueFactory<>("description")); //from entity
            date_evnetcollE.setCellValueFactory(new PropertyValueFactory<>("date_event"));
            nbplacecollE.setCellValueFactory(new PropertyValueFactory<>("nbplace"));
            nom_imagecollE.setCellValueFactory(new PropertyValueFactory<>("nom_image"));
            categoriecollE.setCellValueFactory(new PropertyValueFactory<>("id_categorie"));
            tabevent.setItems(FXCollections.observableArrayList(task.getValue()));
        });
        task.setOnFailed(e -> {
            EvenementBD crud = new EvenementBD();
            tabevent.setItems(crud.afficherEvent());
        });
        Thread th = new Thread(task);
        th.start();

        notif();
    }

    private void notif() {
        EvenementBD es = new EvenementBD();
        //EvenementDB es = new EvenementDB();
        if (es.Notif() != -1) {

            Notifications notificationBuilder = Notifications.create()
                    .title("Notification")
                    .text("vous avez " + es.Notif() + " evenements aujourd'hui Veuillez consulter la liste des evenements")
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_CENTER);

            notificationBuilder.darkStyle();
            notificationBuilder.showWarning();

        } else {

            Notifications notificationBuilder1 = Notifications.create()
                    .title("Notification")
                    .text("vous n'avez aucun evenement aujourd'hui")
                    .graphic(null)
                    .hideAfter(Duration.seconds(10))
                    .position(Pos.TOP_CENTER);

            notificationBuilder1.darkStyle();
            notificationBuilder1.showWarning();
        }
    }

    @FXML
    private void trierEventbtn(ActionEvent event) {
        if (trierEvnet.getSelectionModel().getSelectedItem().equals("Titre")) {
            TrierTitre();
        }  else  {
            TrierDate();
        }
    }

    private void TrierTitre() {
        Task<ArrayList<Evenement>> task = new Task() {

            @Override
            protected Object call() throws SQLException {

                ran = (ArrayList<Evenement>) new EvenementBD().TrierTitre();
                //  ran = (ArrayList<Salle>) new CRUDSalle().afficherSalle();
                return ran;
            }
        };
        task.setOnSucceeded((WorkerStateEvent e) -> {
            idcolE.setCellValueFactory(new PropertyValueFactory<>("id")); //from entity
            titrecolE.setCellValueFactory(new PropertyValueFactory<>("titre"));
            lieucolE.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            descriptioncollE.setCellValueFactory(new PropertyValueFactory<>("description")); //from entity
            date_evnetcollE.setCellValueFactory(new PropertyValueFactory<>("date_event"));
            nbplacecollE.setCellValueFactory(new PropertyValueFactory<>("nbplace"));
            nom_imagecollE.setCellValueFactory(new PropertyValueFactory<>("nom_image"));

            categoriecollE.setCellValueFactory(new PropertyValueFactory<>("id_categorie"));
            tabevent.setItems(FXCollections.observableArrayList(task.getValue()));

        });
        task.setOnFailed(e -> {
            EvenementBD crud = new EvenementBD();
            tabevent.setItems(crud.afficherEvent());
        });
        Thread th = new Thread(task);
        th.start();
    }

    

    private void TrierDate() {
Task<ArrayList<Evenement>> task = new Task() {

            @Override
            protected Object call() throws SQLException {

                ran = (ArrayList<Evenement>) new EvenementBD().TrierDate();
                //  ran = (ArrayList<Salle>) new CRUDSalle().afficherSalle();
                return ran;
            }
        };
        task.setOnSucceeded((WorkerStateEvent e) -> {
            idcolE.setCellValueFactory(new PropertyValueFactory<>("id")); //from entity
            titrecolE.setCellValueFactory(new PropertyValueFactory<>("titre"));
            lieucolE.setCellValueFactory(new PropertyValueFactory<>("lieu"));
            descriptioncollE.setCellValueFactory(new PropertyValueFactory<>("description")); //from entity
            date_evnetcollE.setCellValueFactory(new PropertyValueFactory<>("date_event"));
            nbplacecollE.setCellValueFactory(new PropertyValueFactory<>("nbplace"));
            nom_imagecollE.setCellValueFactory(new PropertyValueFactory<>("nom_image"));

            categoriecollE.setCellValueFactory(new PropertyValueFactory<>("id_categorie"));
            tabevent.setItems(FXCollections.observableArrayList(task.getValue()));

        });
        task.setOnFailed(e -> {
            EvenementBD crud = new EvenementBD();
            tabevent.setItems(crud.afficherEvent());
        });
        Thread th = new Thread(task);
        th.start();    }

    @FXML
    private void esporter_table(ActionEvent event) throws FileNotFoundException, IOException {
        Workbook workbook = new HSSFWorkbook();
            Sheet spreadsheet = workbook.createSheet("sample");
            org.apache.poi.ss.usermodel.Row row = spreadsheet.createRow(0);
            for (int j = 0; j < tabevent.getColumns().size(); j++) {
                row.createCell(j).setCellValue(tabevent.getColumns().get(j).getText());
            }
            for (int i = 0; i < tabevent.getItems().size(); i++) {
                row = spreadsheet.createRow(i + 1);
                for (int j = 0; j <tabevent.getColumns().size(); j++) {
                    if(tabevent.getColumns().get(j).getCellData(i) != null) {
                        row.createCell(j).setCellValue(tabevent.getColumns().get(j).getCellData(i).toString());
                    }
                    else {
                        row.createCell(j).setCellValue("");
                    }
                }
            }
            FileOutputStream fileOut = new FileOutputStream("validations.xls");
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Data is wrtten Successfully");
    }

    @FXML
    private void liste(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ListeEvent.fxml"));

        Scene newScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

}
