/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Service.AvisEventBD;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class PiechartController implements Initializable {

    @FXML
    private PieChart pirchart;
    ObservableList<PieChart.Data> list=FXCollections.
            observableArrayList();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AvisEventBD pdao=AvisEventBD.getInstanceBD();
        List<Integer> nbr = new ArrayList<>();
        List<String> avis=pdao.displayAllbyType(nbr);
        int i =0;
        for(String a:avis) {
            list.addAll(
                new PieChart.Data(a, nbr.get(i)) 
                    
        );
            i++;
        }
      pirchart.setAnimated(true);
       pirchart.setData(list);
    }    
    
}
