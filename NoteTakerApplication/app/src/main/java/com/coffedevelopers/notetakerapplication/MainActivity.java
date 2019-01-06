package com.coffedevelopers.notetakerapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListNote  = (ListView) findViewById(R.id.main_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.act_main_newnote:
                // starts new note activity in new note
                Intent newnoteact = new Intent(this, NoteActivity.class);
                startActivity(newnoteact);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mListNote.setAdapter(null);
        ArrayList<Note> notes = Utilities.getAllSavedNotes(getApplicationContext());
        if(notes==null || notes.size() == 0){
            Toast.makeText(this, "No notes are saved!",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            NoteAdapter na = new NoteAdapter(this, R.layout.item_note,notes);
            mListNote.setAdapter(na);


            mListNote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String fileName = ((Note)mListNote.getItemAtPosition(position)).getnDateTime()+Utilities.FILE_EXTENSION;

                    Intent viewNoteIntent = new Intent(getApplicationContext(),NoteActivity.class);
                    viewNoteIntent.putExtra("NOTE_FILE",fileName);
                    startActivity(viewNoteIntent);
                }
            });
        }
    }
}
