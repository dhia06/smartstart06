/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MediaController implements Initializable {

    @FXML
    private MediaView mediaView;
    private MediaPlayer MediaPlayer;
    private MediaPlayer MediaPlayer1;
    private Media media;
    private Media media1;
    @FXML
    private Button play;
    @FXML
    private Button stop;
    @FXML
    private Button pause;
    @FXML
    private Slider volume;
    @FXML
    private MediaView mediaView1;
    @FXML
    private Button play1;
    @FXML
    private Button pause1;
    @FXML
    private Button stop1;
    @FXML
    private Slider volume1;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO
        
        String path= new File("src\\media\\asus.mp4").getAbsolutePath();
        String path1 =new File("src\\media\\vache.mp4").getAbsolutePath();
        media=new Media(new File(path).toURI().toString());
        media1=new Media (new File(path1).toURI().toString());
        MediaPlayer=new MediaPlayer(media);
        MediaPlayer1=new MediaPlayer(media1);
        mediaView.setMediaPlayer(MediaPlayer);
        mediaView1.setMediaPlayer(MediaPlayer1);
        volume.setValue(MediaPlayer.getVolume()*100);
        volume1.setValue(MediaPlayer1.getVolume()*100);
       
        
        volume1.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                MediaPlayer.setVolume(volume1.getValue()/100);
            }
        });
        volume.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                MediaPlayer.setVolume(volume.getValue()/100);
            }
        });
       
        
    }    

    @FXML
    private void play(ActionEvent event) {
         MediaPlayer.play();
    }

    @FXML
    private void stop(ActionEvent event) {
        MediaPlayer.seek(MediaPlayer.getStopTime());
        MediaPlayer.stop();
        
    }

    @FXML
    private void pause(ActionEvent event) {
        MediaPlayer.pause();
    }

    @FXML
    private void play1(ActionEvent event) {
        MediaPlayer1.play();
    }

    @FXML
    private void pause1(ActionEvent event) {
        MediaPlayer1.pause();
    }

    @FXML
    private void stop1(ActionEvent event) {
          MediaPlayer1.seek(MediaPlayer1.getStopTime());
        MediaPlayer1.stop();
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
        
        Parent root;
          root=FXMLLoader.load(getClass().getResource("consulterpublicite.fxml"));
            retour.getScene().setRoot(root);
    }
    
}
