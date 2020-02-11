/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.DB;
import com.mongodb.MongoClient;


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
