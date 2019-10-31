/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dialog;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class AlertDialog {
    
    

    public static void display(String title, String message) {
        //emplty window
        Stage window = new Stage();
        window.setTitle(title);
        window.setMinWidth(500);
        window.setMaxHeight(500);

        Label label = new Label();
        label.setText(message);
        Button buttonOk = new Button("ok");

        buttonOk.setOnAction(e -> window.close());

        VBox layout = new VBox(5);
        layout.getChildren().addAll(label, buttonOk);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }

    
}
