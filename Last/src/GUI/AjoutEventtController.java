/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Categorie;
import Entity.Evenement;

import Service.CategorieBD;
import Service.EvenementBD;
import Utils.MyBDConnection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AjoutEventtController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField titre;
    @FXML
    private TextField lieu;
    @FXML
    private TextField description;
    @FXML
    private TextField nom_image;
    @FXML
    private ComboBox idCat;
    @FXML
    private TextField nbplace;
    @FXML
    private DatePicker date_event;
    @FXML
    private ImageView UploadImage;
     private String imageUpload;
    @FXML
    private Button uploadImage;
    @FXML
    private Button ajoute;
    private int IdpourAjouter;
    @FXML
    private Button annuler;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Connection mycon = MyBDConnection.getInstanceBD().getConnection(); 
        ajouterdata();
    CategorieBD crud =new CategorieBD();
        //  CategorieDB crud=new  CategorieDB();
        List<Categorie> c=new ArrayList();
        List l=new ArrayList();
        try {
            c= crud.afficherComb();
        } catch (SQLException ex) {
            Logger.getLogger(ModifiereventtController.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.forEach(s->l.add(s.getLibelle()));
       // c.forEach((s->l.add(s.getLibelle())));
        idCat.setItems(FXCollections.observableArrayList(l));
        
    }    

    @FXML
    private void uploadImage(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
           FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)","*.jpg");
           FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)","*.png");
           fc.getExtensionFilters().addAll(ext1,ext2);
           Stage stage = new Stage();
           File file = fc.showOpenDialog(stage);
           BufferedImage bf;
           if( file != null){
               bf = ImageIO.read(file);
           javafx.scene.image.Image image = SwingFXUtils.toFXImage(bf, null);
           UploadImage.setImage(image);
           FileInputStream fin = new FileInputStream(file);
           imageUpload = file.getName();
           }
    }
    private int findId(List<Categorie> c){
        int id=0;
        for(int i=0;i<c.size();i++){
            if(c.get(i).getLibelle().equals(idCat.getValue())){
                id=c.get(i).getId();
            }
        }
        return id;
    }


    @FXML
    private void ajoutevent(ActionEvent event) throws SQLException {
         File outputFile = new File("C:/Users/asus/Documents/NetBeansProjects/Last/src/" + imageUpload);
        BufferedImage bImage = SwingFXUtils.fromFXImage(UploadImage.getImage(), null);
        try {
      ImageIO.write(bImage, "png", outputFile);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
        
        if(id.getText().isEmpty() || titre.getText().isEmpty() || lieu.getText().isEmpty()
                 || description.getText().isEmpty() || nbplace.getText().isEmpty() )
         {
          
             Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider vos champs");
            alert1.setHeaderText(null);
            alert1.setContentText("Veuillez remplir les champs ");
            alert1.showAndWait();
         
         }
        else if(date_event.getValue()==null)
         {
          Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider vos champs");
            alert1.setHeaderText(null);
            alert1.setContentText("Veuillez remplir les champs ");
            alert1.showAndWait();
         }else if(imageUpload==null){
              Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider vos champs");
            alert1.setHeaderText(null);
            alert1.setContentText("Veuillez choisir une image ");
            alert1.showAndWait();
         
         }else if(!lieu.getText().matches("^[a-zA-Z\\s]*$") )
         {
              Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider les noms des acteurs");
            alert1.setHeaderText(null);
            alert1.setContentText("Veuillez les noms des lieu ");
            alert1.showAndWait();
         }else if(!description.getText().matches("^[a-zA-Z\\s]*$") )
         {
              Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Valider le nom du directeur");
            alert1.setHeaderText(null);
            alert1.setContentText("Veuillez verifier le nom du description ");
            alert1.showAndWait();
         }else if(LocalDate.now().isAfter(date_event.getValue()))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Date de l'evenement est inférieure à la date actuelle!");
            alert.setContentText("Erreur");
            alert.showAndWait();
        }
       else  if(Integer.parseInt(nbplace.getText())<0)
          {
         Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("veuillez saisir un nbre de place positif");
            alert.setContentText("Erreur");
            alert.showAndWait();
        } 
       else if(((Integer.parseInt(nbplace.getText()))>1000)||((Integer.parseInt(nbplace.getText()))<1))
          {
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("veuillez saisir un nbre de place entre 1 et 1000");
            alert.setContentText("Erreur");
            alert.showAndWait();
        } 
        else
        {
        
        CategorieBD c1=new CategorieBD();
      //  CategorieDB cl=new CategorieDB();
        List<Categorie> c=new ArrayList();
        List l=new ArrayList();
             c= c1.afficherComb();
            
         Evenement E;
                  E =new Evenement(Integer.parseInt(id.getText()),titre.getText(),lieu.getText(),description.getText(),Date.valueOf(date_event.getValue().format(DateTimeFormatter.ISO_DATE)),Integer.parseInt(nbplace.getText()),imageUpload,findId(c));

       // E = new Evenement(Integer.parseInt(id.getText()),findId(c),titre.getText(),imageUpload,lieu.getText(),description.getText(),Date.valueOf(date_event.getValue().format(DateTimeFormatter.ISO_DATE)),Integer.parseInt(nbplace.getText()));
        //EvenementDB  crud = new  EvenementDB  ();
        EvenementBD crud =new EvenementBD();
 
      crud.ajouterEvent(E);
    // Event_tab.setItems(crud.afficherEvent()); 
     Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
            alert3.setTitle("Information Dialog");
            alert3.setHeaderText("Ajout avec Succes");
            Optional <ButtonType> result=alert3.showAndWait();
            if(result.get()==ButtonType.OK)
                {
                    clear();
                }
            
        
        
        } 
    }
     public void clear()
     {
         id.clear();
         titre.clear();
         description.clear();
         lieu.clear();
          nbplace.clear();
        
         UploadImage.setImage(null);
         date_event.setValue(null);
          idCat.setValue(null);
         
         
     
     }

    @FXML
    private void anuulerbtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminEventt.fxml"));
                
        Scene newScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    private void ajouterdata() {
  Connection mycon = MyBDConnection.getInstanceBD().getConnection(); 
        try {
            ResultSet rs = mycon.createStatement().executeQuery("SELECT * FROM `evenement` WHERE id="+IdpourAjouter);
            while(rs.next()) {
               Evenement c=(new Evenement(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),
                    rs.getInt(6),rs.getString(7),rs.getInt(8)));
                 
              
                
              Categorie b=new Categorie();
           id.setText(String.valueOf(c.getId()));
              lieu.setText(c.getLieu()); 
               description.setText(c.getDescription());
               titre.setText(c.getTitre());
               description.setText(c.getDescription());
                 nbplace.setText(String.valueOf(c.getNbplace()));
                 idCat.setValue(b.getLibelle());
               date_event.setValue(c.getDate_event().toLocalDate());
               
              
               
                 }
        }catch (SQLException ex) {
            Logger.getLogger(ModifiereventtController.class.getName()).log(Level.SEVERE, null, ex);
    }    }
    
    
}
