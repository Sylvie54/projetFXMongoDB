/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import AFPA.CDA03.demo.App;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.ExceptionsModele;
import model.Person;

/**
 *
 * @author Sylvie
 */
public class BaseMongoDB {
   
   /**
    * méthode de sélection de toutes les personnes
    * @throws Exception
    */
    public static void selectAll() throws Exception{
        try {
            
            DBCollection restoCollection = Connexion.getDatabase().getCollection("restaurants");
                BasicDBObject query = new BasicDBObject();
                BasicDBObject field = new BasicDBObject();
                query.put("name", "Kosher Island");
                field.put("name", 1);
                field.put("cuisine", 1);
            DBCursor cursor = restoCollection.find(query, field);
            try {
            while(cursor.hasNext()) {
               DBObject obj = cursor.next();
               System.out.println(obj.get("name") + " => " + obj.get("cuisine"));
               }
            } finally {
               cursor.close();
            }
        }
        catch (Exception e) { 
            e.printStackTrace();
            System.exit(0);
        
        }    
    }
    /**
     * méthode d'insertion d'une personne
     * @param person Person
     * @return int valeur de l'identifiant crée en auto incrément 
     * @throws java.lang.Exception
     */
    public static int insert(Person person) throws Exception {
        System.out.println("insert à faire");
        return 0;
    }
    /**
     * 
     * @param person Person
     * @param ancId String ancien nom de la personne
     * @throws java.lang.Exception
     */
    public static void update(Person person, int ancId) throws Exception {
        System.out.println("update à faire");
        
    }
    /**
     * méthode de supression d' une personne
     * @param person Person
     * @throws java.lang.Exception
     */
    public static void delete(Person person) throws Exception {
        System.out.println("delete à faire");
    }
 
}
