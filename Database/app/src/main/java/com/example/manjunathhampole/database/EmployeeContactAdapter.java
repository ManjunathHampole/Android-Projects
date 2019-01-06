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
public class EmployeeContactAdapter  extends ArrayAdapter {

    List list = new ArrayList();
    public EmployeeContactAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(EmployeeContacts object) {
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
            row = layoutInflater.inflate(R.layout.employeerow_layout,parent,false);
            contactHolder = new ContactHolder();
            contactHolder.tx_id = (TextView)row.findViewById(R.id.tx_id);
            contactHolder.tx_firstname = (TextView)row.findViewById(R.id.tx_firstname);
            contactHolder.tx_lastname = (TextView)row.findViewById(R.id.tx_lastname);
            row.setTag(contactHolder);
        }
        else
        {
            contactHolder = (ContactHolder)row.getTag();
        }
        EmployeeContacts employeeContacts = (EmployeeContacts)this.getItem(position);
        contactHolder.tx_id.setText(employeeContacts.getId());
        contactHolder.tx_firstname.setText(employeeContacts.getFirstname());
        contactHolder.tx_lastname.setText(employeeContacts.getLastname());
        return row;
    }

    static class ContactHolder
    {
        TextView tx_id, tx_firstname, tx_lastname;
    }
}
