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
import model.Person;


/**
 *
 * @author Sylvie
 */
public class BaseMongoDB {
    private static DBCollection clientCollection = Connexion.getDatabase().getCollection("client");
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
            DBCursor cursor = clientCollection.find();

            try {
            Person person;    
            while(cursor.hasNext()) {
                DBObject obj = cursor.next();
                int id = Integer.parseInt(obj.get("id").toString());
                String nom = (String) obj.get("nom");
                String prenom = (String) obj.get("prenom");
                person = new Person(id, nom, prenom);
                App.getPersonData().add(person);
               }
            } finally {
               cursor.close();
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
        BasicDBObject bO = new BasicDBObject();
        bO.put("id", derInd);
        bO.put("nom", person.getFirstName());
        bO.put("prenom", person.getLastName());
        derInd++;
        
        clientCollection.insert(bO);
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
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("id", person.getId());
        newDocument.put("nom", person.getFirstName());
        newDocument.put("prenom", person.getLastName());
        
        
        BasicDBObject searchQuery = new BasicDBObject().append("id", ancId);
        clientCollection.update (searchQuery, newDocument);
         }
        catch (Exception e) {
            throw new Exception ("pb de modification" + e.getMessage());
        }
    }
    /**
     * méthode de supression d' une personne
     * @param person Person
     * @throws java.lang.Exception
     */
    public static void delete(Person person) throws Exception {
        try {
            BasicDBObject cliDel = new BasicDBObject();
            System.out.println("id personne à supprimer " +person.getId());
            cliDel.put("id", person.getId());
            clientCollection.remove(cliDel);
        } catch (Exception e) {
            throw new Exception ("pb de suppression" + e.getMessage());
        }
    }
    
    private static int sortCollection() throws Exception {
        // méthode pour trier la collection par ordre décroissant
        // puis de récupérer le premier enregistrement qui correspond au dernier indice
        // en lisant le curseur
        BasicDBObject dbo = new BasicDBObject();
        dbo.put("id", -1);
        DBCursor cursor = clientCollection.find().sort(dbo);
        int i = 0;
        int id, derInd = 0;
        while(cursor.hasNext()) {
            DBObject obj = cursor.next();
            id = Integer.parseInt(obj.get("id").toString());
            if (i == 0) {
                derInd = id;
                derInd++;
                i=1;
            }
        }
        System.out.println("derInd " + derInd);
        return derInd;
    }
 
}
