package com.coffedevelopers.notetakerapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {

    private EditText meditTitle;
    private EditText meditContent;
    private String mNoteFileName;
    private Note mLoadedNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        meditTitle = findViewById(R.id.noteact_title);
        meditContent = findViewById(R.id.noteact_content);

        mNoteFileName = getIntent().getStringExtra("NOTE_FILE");

        if(mNoteFileName!=null && !mNoteFileName.isEmpty()){
            mLoadedNote = Utilities.getNoteByName(this,mNoteFileName);

            if(mLoadedNote!=null) {
                meditTitle.setText(mLoadedNote.getnTitle());
                meditContent.setText(mLoadedNote.getnContent());
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.act_main_save:
                saveNote();
                break;
            case R.id.act_main_delete:
                deleteNote();
                break;
        }
        return true;
    }

    private void saveNote(){
        Note note;

        if(meditTitle.getText().toString().trim().isEmpty() || meditContent.getText().toString().trim().isEmpty() ){
            Toast.makeText(this, "Please enter a title and a content", Toast.LENGTH_SHORT).show();
            return;
        }
        if(mLoadedNote==null) {
            note = new Note(System.currentTimeMillis(), meditTitle.getText().toString(), meditContent.getText().toString());
        }
        else {
            note = new Note(mLoadedNote.getnDateTime(), meditTitle.getText().toString(), meditContent.getText().toString());
        }
        if(Utilities.saveNote(this, note)){
            Toast.makeText(this,"Your note is saved", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Can't save the note",Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    private void deleteNote(){
        if(mLoadedNote == null){
            finish();
        }
        else {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this).setTitle("Are you sure about that?")
                    .setMessage("You are about to delete " + meditTitle.getText().toString() + " note")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Utilities.deleteNote(getApplicationContext(), mLoadedNote.getnDateTime() + Utilities.FILE_EXTENSION);
                            Toast.makeText(getApplicationContext(), meditTitle.getText().toString() + " was deleted", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    })
                    .setNegativeButton("No",null)
                    .setCancelable(false);
                    dialog.show();
        }
    }
}
