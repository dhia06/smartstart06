/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utils.MyBDConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class StatistController implements Initializable {

    @FXML
    private BarChart<String, Integer> barchart;
    @FXML
    private Button show;
    @FXML
    private Button retourE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showstat(ActionEvent event) {
         Connection mycon = MyBDConnection.getInstanceBD().getConnection(); 
 
    
      String requete;
       
     requete = "SELECT lieu, count(*)  FROM evenement GROUP BY lieu";  
         XYChart.Series<String,Integer> series = new XYChart.Series<>();
            try {
            PreparedStatement ps = mycon.prepareStatement(requete);
         
           ResultSet resultat = ps.executeQuery();
            
            while (resultat.next()){  
                series.getData().add(new XYChart.Data<>(resultat.getString(1),resultat.getInt(2)));
            }
      barchart.getData().add(series);
    }
            catch (SQLException ex) {
            
            System.out.println("erreur  " + ex.getMessage());
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
    
}
