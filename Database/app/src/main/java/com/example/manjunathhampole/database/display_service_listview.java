package com.example.manjunathhampole.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class display_service_listview extends AppCompatActivity {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ServicesContactAdapter servicesContactAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_service_listview_layout);

        listView = (ListView)findViewById(R.id.servicelistview);
        servicesContactAdapter = new ServicesContactAdapter(this,R.layout.servicerow_layout);
        listView.setAdapter(servicesContactAdapter);
        json_string = getIntent().getExtras().getString("json_data");
        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("Result");
            int count =0;
            String id, name, charge;

            while(count<jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                id = JO.getString("Ser_Id");
                name = JO.getString("Ser_Name");
                charge = JO.getString("Crg_hr");
                ServicesContacts servicesContacts = new ServicesContacts(id,name,charge);
                servicesContactAdapter.add(servicesContacts);
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
