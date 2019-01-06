package com.example.manjunathhampole.database;

/**
 * Created by Manjunath Hampole on 14-05-2017.
 */
public class AnimalContacts {

    private String animalname, cage;

    public AnimalContacts(String animalname, String cage)
    {
        this.setAnimalname(animalname);
        this.setCage(cage);
    }

    public String getAnimalname() {
        return animalname;
    }

    public void setAnimalname(String animalname) {
        this.animalname = animalname;
    }

    public String getCage() {
        return cage;
    }

    public void setCage(String cage) {
        this.cage = cage;
    }
}
