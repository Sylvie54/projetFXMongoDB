/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;


/**
 *
 * @author Acer
 */
public class Connexion  {
  
 //   private static DB database;
    private static MongoDatabase database;

    public static MongoDatabase getDatabase() {
        return database;
    }
   
    public static void AccesBase() throws Exception {
        
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
         //  database = mongoClient.getDB("projetFX");
            database = mongoClient.getDatabase("projetFX");
            System.out.println("connect ok");
            
        }    
        catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        
    } 
        
            
            
           
    
 
}
