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
public class ServicesContactAdapter  extends ArrayAdapter {

    List list = new ArrayList();
    public ServicesContactAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(ServicesContacts object) {
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
            row = layoutInflater.inflate(R.layout.servicerow_layout,parent,false);
            contactHolder = new ContactHolder();
            contactHolder.tx_id = (TextView)row.findViewById(R.id.tx_id);
            contactHolder.tx_name = (TextView)row.findViewById(R.id.tx_name);
            contactHolder.tx_charge = (TextView)row.findViewById(R.id.tx_charge);
            row.setTag(contactHolder);
        }
        else
        {
            contactHolder = (ContactHolder)row.getTag();
        }
        ServicesContacts servicesContacts = (ServicesContacts)this.getItem(position);
        contactHolder.tx_id.setText(servicesContacts.getId());
        contactHolder.tx_name.setText(servicesContacts.getName());
        contactHolder.tx_charge.setText(servicesContacts.getCharge());
        return row;
    }

    static class ContactHolder
    {
        TextView tx_id, tx_name, tx_charge;
    }
}
