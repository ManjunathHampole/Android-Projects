package com.example.manjunathhampole.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class display_time_listview extends AppCompatActivity {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    contactadapter contactadapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_time_listview_layout);
        listView = (ListView)findViewById(R.id.listview);
        contactadapter = new contactadapter(this,R.layout.row_layout);
        listView.setAdapter(contactadapter);
        json_string = getIntent().getExtras().getString("json_data");
        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("Result");
            int count =0;
            String cage, time;

            while(count<jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                cage = JO.getString("Cage_Id");
                time = JO.getString("Timings");
                contacts contacts = new contacts(cage,time);
                contactadapter.add(contacts);
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}