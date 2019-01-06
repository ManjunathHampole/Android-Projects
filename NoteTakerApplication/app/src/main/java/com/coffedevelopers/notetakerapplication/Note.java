package com.coffedevelopers.notetakerapplication;

import android.content.Context;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Manjunath Hampole on 26-10-2018.
 */

public class Note implements Serializable {

    private long nDateTime;
    private String nTitle;
    private String nContent;

    public Note(long nDateTime, String nTitle, String nContent) {
        this.nDateTime = nDateTime;
        this.nTitle = nTitle;
        this.nContent = nContent;
    }

    public long getnDateTime() {
        return nDateTime;
    }

    public String getnTitle() {
        return nTitle;
    }

    public String getnContent() {
        return nContent;
    }

    public void setnDateTime(long nDateTime) {
        this.nDateTime = nDateTime;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    public String getDateTimeFormat(Context context){
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", context.getResources().getConfiguration().locale);
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(new Date(nDateTime));
    }
}
