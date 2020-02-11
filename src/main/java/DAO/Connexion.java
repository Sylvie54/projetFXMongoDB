/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import AFPA.CDA03.demo.App;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Optional;
import java.util.Properties;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import utilitaires.Alertes;


/**
 *
 * @author Acer
 */
public class Connexion  {
  
    private static DB database;

    public static DB getDatabase() {
        return database;
    }
   
    public static void AccesBase() throws Exception {
        
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            database = mongoClient.getDB("projetFX");
            System.out.println("connect ok");
        }    
        catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        
    } 

    
 
}
