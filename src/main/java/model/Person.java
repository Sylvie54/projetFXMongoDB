/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Acer
 */
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class Person {
    private final IntegerProperty id;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final IntegerProperty postalCode;
    private final StringProperty city;
    private final ObjectProperty<LocalDate> birthday;
   

    /**
     * Default constructor.
     * 
     * @throws java.lang.Exception
     */
    public Person() throws Exception     {
        this(0,null, null);
    }
    
    /**
     * Constructor with some initial data.
     * 
     * @param id
     * @param firstName
     * @param lastName
     * @throws model.ExceptionsModele
     * 
     */
    public Person(int id,String firstName, String lastName) throws ExceptionsModele  {
        
        if (firstName != null && firstName.length() <2 ) {
            throw new ExceptionsModele("le nom doit faire au moins 2 caractères");
        }
        this.id = new SimpleIntegerProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        
        // Some initial dummy data, just for convenient testing.
        this.street = new SimpleStringProperty("some street");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.city = new SimpleStringProperty("some city");
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
     
        
        
    }
    public int getId() {
        return id.get();
      
    }
    
    public void setId(int id) {
        this.id.set(id);
    }
    
    public String getFirstName() {
       return firstName.get();
    }

    public void setFirstName(String firstName) throws ExceptionsModele  {
        if ((firstName != null) && firstName.length() <2 )  {
            throw new ExceptionsModele("le nom doit faire au moins 2 caractères");
       } 
       this.firstName.set(firstName);
    }
    
    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
       return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }
    
    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }
    
    public StringProperty streetProperty() {
        return street;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }
    
    public IntegerProperty postalCodeProperty() {
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }
    
    public StringProperty cityProperty() {
        return city;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }
    
    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", street=" + street + ", postalCode=" + postalCode + ", city=" + city + ", birthday=" + birthday + '}';
    }
    
    
}    
