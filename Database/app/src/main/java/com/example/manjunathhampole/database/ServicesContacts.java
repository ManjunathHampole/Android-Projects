package com.example.manjunathhampole.database;

/**
 * Created by Manjunath Hampole on 14-05-2017.
 */
public class ServicesContacts {

    private String id, name,charge;

    public ServicesContacts(String id, String name, String charge)
    {
        this.setId(id);
        this.setName(name);
        this.setCharge(charge);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
}
