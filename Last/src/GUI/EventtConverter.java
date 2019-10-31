/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Evenement;
import javafx.util.StringConverter;

/**
 *
 * @author asus
 */
public class EventtConverter extends StringConverter<Evenement> {

    public EventtConverter() {
        
    }
     
   

    // Method to convert a Person-Object to a String
    @Override
    public String toString(Evenement person) {
        return person == null? null : person.getTitre()+ ", " + person.getId();
    }
 
    // Method to convert a String to a Person-Object
    @Override
    public Evenement fromString(String string)
    {
       Evenement person = null;
 
        if (string == null)
        {
            return person;
        }
 
        int commaIndex = string.indexOf(",");
 
        if (commaIndex == -1)
        {
           // person = new Livres(string, null);
        }
        else
        {
           // String firstName = string.substring(commaIndex + 2);
            String lastName = string.substring(0, commaIndex);
            person = new Evenement(commaIndex, lastName);
        }
 
        return person;
    }
    
}
