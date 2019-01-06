package com.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech ts1;
    EditText edt1;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText) findViewById(R.id.edittext1);
        bt1 = (Button) findViewById(R.id.button1);

        ts1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    ts1.setLanguage(Locale.US);
                }

            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toSpeak = edt1.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_LONG).show();
                ts1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);

            }
        });
    }

    public void onPause()
    {
        if (ts1 != null)
        {
            ts1.stop();
            ts1.shutdown();
        }
        super.onPause();
    }
}