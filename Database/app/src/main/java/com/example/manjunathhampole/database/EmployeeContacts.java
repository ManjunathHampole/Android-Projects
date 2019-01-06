package com.example.manjunathhampole.database;

/**
 * Created by Manjunath Hampole on 14-05-2017.
 */
public class EmployeeContacts {
    private String id, firstname, lastname;

    public EmployeeContacts(String id, String firstname, String lastname)
    {
        this.setId(id);
        this.setFirstname(firstname);
        this.setLastname(lastname);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
