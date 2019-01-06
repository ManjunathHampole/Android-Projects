package com.example.manjunathhampole.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class display_animal_listview extends AppCompatActivity {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    AnimalContactAdapter animalContactAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_animal_listview_layout);
        listView = (ListView)findViewById(R.id.animallistview);
        animalContactAdapter = new AnimalContactAdapter(this,R.layout.animalrow_layout);
        listView.setAdapter(animalContactAdapter);
        json_string = getIntent().getExtras().getString("json_data");
        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("Result");
            int count =0;
            String animalname, cage;

            while(count<jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                animalname = JO.getString("Animal Name");
                cage = JO.getString("Cage");
                AnimalContacts animalContacts = new AnimalContacts(animalname,cage);
                animalContactAdapter.add(animalContacts);
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
