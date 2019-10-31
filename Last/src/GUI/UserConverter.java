/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Evenement;
import Entity.User;
import javafx.util.StringConverter;

/**
 *
 * @author asus
 */
public class UserConverter extends StringConverter<User> {

    public UserConverter() {
    }
    public String toString(User person) {
        return person == null? null : person.getNom()+ ", " + person.getId();
    }
 
    // Method to convert a String to a Person-Object
    @Override
    public User fromString(String string)
    {
      User person = null;
 
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
            person = new User(commaIndex, lastName);
        }
 
        return person;
    }
}
