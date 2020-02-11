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
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import model.Person;
import org.bson.Document;


/**
 *
 * @author Sylvie
 */
public class BaseMongoDB {
    private static final MongoCollection CLIENTCOLLECTION = Connexion.getDatabase().getCollection("client");
    private static int derInd =0;
   /**
    * méthode de sélection de toutes les personnes
    * @throws Exception
    */
    public static void selectAll() throws Exception{
        try {
            
           
//                BasicDBObject query = new BasicDBObject();
//                BasicDBObject field = new BasicDBObject();
//                query.put("name", "Kosher Island");
//                field.put("name", 1);
//                field.put("cuisine", 1);
//            DBCursor cursor = restoCollection.find(query, field);
            FindIterable<Document> cursor = CLIENTCOLLECTION.find();
            for (Document obj : cursor) {
                Person person;
                int id = Integer.parseInt(obj.get("id").toString());
                String nom =  obj.get("nom").toString();
                String prenom = obj.get("prenom").toString();
                person = new Person(id, nom, prenom);
                App.getPersonData().add(person);
               }
            
            
           derInd = sortCollection();
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
        try {
        Document bO = new Document();
        derInd++;
        bO.put("id", derInd);
        bO.put("nom", person.getFirstName());
        bO.put("prenom", person.getLastName());
        CLIENTCOLLECTION.insertOne(bO);
        }
        catch (Exception e) {
            throw new Exception ("pb d'insertion" + e.getMessage());
        }
        return derInd;
    }
    /**
     * 
     * @param person Person
     * @param ancId String ancien nom de la personne
     * @throws java.lang.Exception
     */
    public static void update(Person person, int ancId) throws Exception {
        try {
        Document newDocument = new Document();
         newDocument.append("id", person.getId());
        newDocument.append("nom", person.getFirstName());
        newDocument.append("prenom", person.getLastName());
        
            System.out.println("ancid " + ancId + "getId "+ person.getId());
        Document searchQuery = new Document("id", ancId);
        CLIENTCOLLECTION.updateOne(searchQuery, new Document("$set", newDocument));
         }
        catch (Exception e) {
            e.printStackTrace();
            throw new Exception ("pb de modification" + person + e.getMessage());
        }
    }
    /**
     * méthode de supression d' une personne
     * @param person Person
     * @throws java.lang.Exception
     */
    public static void delete(Person person) throws Exception {
        try {
            Document cliDel = new Document();
            System.out.println("id personne à supprimer " +person.getId());
            cliDel.put("id", person.getId());
            CLIENTCOLLECTION.deleteOne(cliDel);
        } catch (Exception e) {
            throw new Exception ("pb de suppression" + e.getMessage());
        }
    }
    
    private static int sortCollection() throws Exception {
        // méthode pour trier la collection par ordre décroissant
        // puis de récupérer le premier enregistrement qui correspond au dernier indice
        // en lisant le curseur
        // je pourrais passer par une collection mais c'est pour essayer le sort
        Document dbo = new Document();
        dbo.put("id", -1);
        FindIterable<Document> cursor = CLIENTCOLLECTION.find().sort(dbo);
        int i = 0;
        int id, derInd = 0;
        for (Document obj : cursor) {
            
            id = Integer.parseInt(obj.get("id").toString());
            if (i == 0) {
                derInd = id;
                i=1;
            }
        }
        System.out.println("derInd " + derInd);
        return derInd;
    }
 
}
