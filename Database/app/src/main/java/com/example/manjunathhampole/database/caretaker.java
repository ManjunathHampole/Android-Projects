package com.example.manjunathhampole.database;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class caretaker extends AppCompatActivity {
    String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caretaker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void getcaretaker (View view)
    {
        new BackgroundTask().execute();

    }
    class BackgroundTask extends AsyncTask<Void, Void, String>
    {
        String json_url;
        @Override
        protected void onPreExecute() {
            json_url="http://hampole.000webhostapp.com/caretaker.php";
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream= httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while((JSON_STRING = bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(JSON_STRING).append("\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String response) {
            TextView textView= (TextView)findViewById(R.id.caretakerjson);
            textView.setText(response);
            JSON_STRING = response;

        }
    }
    public void caretakerinlist (View view)
    {
        if(JSON_STRING==null)
        {
            Toast.makeText(getApplicationContext(), "First get Result in JSON", Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent intent = new Intent(this,display_caretaker_listview.class);
            intent.putExtra("json_data",JSON_STRING);
            startActivity(intent);
        }

    }

}
