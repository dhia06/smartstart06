/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import entite.Projet;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.ProjetService;

/**
 * FXML Controller class
 *
 * @author belhassan
 */
public class AjouterController implements Initializable {

    @FXML
    private TextField txtduree;
    @FXML
    private TextField txtobj;
    @FXML
    private TextField titretxt;
    @FXML
    private TextField txtdesc;
    @FXML
    private Button Buttonajouter;

   
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Buttonajouter.setOnAction(e->
            {Projet p=new Projet(titretxt.getText(),txtobj.getText(),txtduree.getText(),txtdesc.getText());
            ProjetService ps=new ProjetService();
            ps.insert(p);
            Parent root;
        try {
            root=FXMLLoader.load(getClass().getResource("Afficher.fxml"));
            Buttonajouter.getScene().setRoot(root);
        } catch (IOException ex) {
            //Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
                    });
    }    
    
}
