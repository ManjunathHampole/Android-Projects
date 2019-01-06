package com.example.manjunathhampole.database;

/**
 * Created by Manjunath Hampole on 14-05-2017.
 */
public class CaretakerContacts {

    private String emp, cage, doc;

    public CaretakerContacts(String emp, String cage, String doc)
    {
        this.setEmp(emp);
        this.setCage(cage);
        this.setDoc(doc);
    }

    public String getEmp() {
        return emp;
    }

    public void setEmp(String emp) {
        this.emp = emp;
    }

    public String getCage() {
        return cage;
    }

    public void setCage(String cage) {
        this.cage = cage;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }
}
