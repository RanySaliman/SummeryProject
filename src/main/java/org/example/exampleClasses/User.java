package org.example.exampleClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Anottations.AutoIncrement;
import org.example.Anottations.NotNull;
import org.example.Anottations.PrimaryKey;
import org.example.Anottations.Unique;

public class User {
    @NotNull
    @AutoIncrement
    @PrimaryKey
    private int id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    @Unique
    private String email;


    public User() {
    }

    public static User createUser(String firstName, String lastName, String email, int id){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setId(id);
        return user;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        if(id < 0){
            throw new IllegalArgumentException("Id cannot be negative");
        }
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        if(firstName == null){
            throw new NullPointerException("First name is null");
        }

        if(firstName.equals("")){
            throw new IllegalArgumentException("First name cannot be empty, Please insert product name");
        }

        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        if(lastName == null){
            throw new NullPointerException("Last name is null");
        }

        if(lastName.equals("")){
            throw new IllegalArgumentException("Lat name cannot be empty, Please insert product name");
        }
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
