/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaires;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author Acer
 */
public class Alertes {
    
    /**
     * 
     * @param alertype type d'alerte
     * @param stage stage appelant l'alerte
     * @param title titre du message
     * @param header en tête du message
     * @param message message
     */
    public static void alerte (Alert.AlertType alertype,Stage stage, String title, String header, String message ) {
      Alert alert = new Alert(alertype);
            alert.initOwner( stage);
            alert.setTitle(title);
            alert.setHeaderText(header);
            alert.setContentText(message);

            alert.showAndWait();  
    }
}
