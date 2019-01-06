package com.example.manjunathhampole.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class display_caretaker_listview extends AppCompatActivity {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    CaretakerContactAdapter caretakerContactAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_caretaker_listview_layout);
        listView = (ListView)findViewById(R.id.caretakerlistview);
        caretakerContactAdapter = new CaretakerContactAdapter(this,R.layout.caretakerrow_layout);
        listView.setAdapter(caretakerContactAdapter);
        json_string = getIntent().getExtras().getString("json_data");
        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("Result");
            int count =0;
            String emp, cage, doc;

            while(count<jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                emp = JO.getString("Emp_Id");
                cage = JO.getString("Cage_Id");
                doc = JO.getString("Doc_Id");
                CaretakerContacts caretakerContacts = new CaretakerContacts(emp,cage,doc);
                caretakerContactAdapter.add(caretakerContacts);
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
