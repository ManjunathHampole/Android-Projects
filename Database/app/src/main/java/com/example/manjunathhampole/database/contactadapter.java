package com.example.manjunathhampole.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manjunath Hampole on 14-05-2017.
 */
public class contactadapter extends ArrayAdapter {
    List list = new ArrayList();
    public contactadapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(contacts object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        ContactHolder contactHolder;
        if(convertView== null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            contactHolder = new ContactHolder();
            contactHolder.tx_cage = (TextView)row.findViewById(R.id.tx_cage);
            contactHolder.tx_time = (TextView)row.findViewById(R.id.tx_time);
            row.setTag(contactHolder);
        }
        else
        {
            contactHolder = (ContactHolder)row.getTag();
        }
        contacts contacts = (contacts)this.getItem(position);
        contactHolder.tx_cage.setText(contacts.getCage());
        contactHolder.tx_time.setText(contacts.getTime());
        return row;
    }

    static class ContactHolder
    {
        TextView tx_cage, tx_time;
    }
}

