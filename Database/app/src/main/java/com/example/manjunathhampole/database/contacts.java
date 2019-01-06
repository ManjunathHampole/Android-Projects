package com.example.manjunathhampole.database;

/**
 * Created by Manjunath Hampole on 14-05-2017.
 */
public class contacts {

    private String cage, time;

    public contacts(String cage,String time)
    {
        this.setCage(cage);
        this.setTime(time);
    }

    public String getCage() {
        return cage;
    }

    public void setCage(String cage) {
        this.cage = cage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
