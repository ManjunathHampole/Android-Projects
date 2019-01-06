package com.example.manjunathhampole.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class display_employees_listview extends AppCompatActivity {

    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    EmployeeContactAdapter employeeContactAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_employees_listview_layout);
        listView = (ListView)findViewById(R.id.employeelistview);
        employeeContactAdapter = new EmployeeContactAdapter(this,R.layout.employeerow_layout);
        listView.setAdapter(employeeContactAdapter);
        json_string = getIntent().getExtras().getString("json_data");
        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("Result");
            int count =0;
            String emp, fname, lname;

            while(count<jsonArray.length())
            {
                JSONObject JO = jsonArray.getJSONObject(count);
                emp = JO.getString("Emp_Id");
                fname = JO.getString("First Name");
                lname = JO.getString("Last Name");
                EmployeeContacts employeeContacts = new EmployeeContacts(emp,fname,lname);
                employeeContactAdapter.add(employeeContacts);
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
