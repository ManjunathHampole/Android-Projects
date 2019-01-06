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
public class CaretakerContactAdapter extends ArrayAdapter {
    List list = new ArrayList();

    public CaretakerContactAdapter(Context context, int resource) {
        super(context, resource);
    }
    public void add(CaretakerContacts object) {
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
            row = layoutInflater.inflate(R.layout.caretakerrow_layout,parent,false);
            contactHolder = new ContactHolder();
            contactHolder.tx_emp = (TextView)row.findViewById(R.id.tx_emp);
            contactHolder.tx_cage = (TextView)row.findViewById(R.id.tx_cage);
            contactHolder.tx_doc = (TextView)row.findViewById(R.id.tx_doc);
            row.setTag(contactHolder);
        }
        else
        {
            contactHolder = (ContactHolder)row.getTag();
        }
        CaretakerContacts caretakerContacts = (CaretakerContacts)this.getItem(position);
        contactHolder.tx_emp.setText(caretakerContacts.getEmp());
        contactHolder.tx_cage.setText(caretakerContacts.getCage());
        contactHolder.tx_doc.setText(caretakerContacts.getDoc());
        return row;
    }

    static class ContactHolder
    {
        TextView tx_emp, tx_cage, tx_doc;
    }
}
