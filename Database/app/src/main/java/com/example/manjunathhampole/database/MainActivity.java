package com.example.manjunathhampole.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.zootime).setOnClickListener(timing);
        findViewById(R.id.animals).setOnClickListener(animallist);
        findViewById(R.id.caretaker).setOnClickListener(caretaker);
        findViewById(R.id.employees).setOnClickListener(employee);
        findViewById(R.id.services).setOnClickListener(service);

    }
    View.OnClickListener timing = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1 = new Intent(MainActivity.this, Timing.class);
            startActivity(intent1);
        }
    };

    View.OnClickListener animallist = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent2 = new Intent(MainActivity.this, animals.class);
            startActivity(intent2);
        }
    };

    View.OnClickListener caretaker = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent3 = new Intent(MainActivity.this, caretaker.class);
            startActivity(intent3);
        }
    };


    View.OnClickListener employee = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent4 = new Intent(MainActivity.this, employees.class);
            startActivity(intent4);
        }
    };

    View.OnClickListener service = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent6 = new Intent(MainActivity.this, services.class);
            startActivity(intent6);
        }
    };



}
