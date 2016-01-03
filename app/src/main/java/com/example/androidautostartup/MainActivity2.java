package com.example.androidautostartup;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

//import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by Anıll on 21.12.2015.
 */
public class MainActivity2 extends Activity {

    boolean press = false ;
    private static final long delay = 2000L;
    private boolean mRecentlyBackPressed = false;
    public Handler mExitHandler = new Handler();
    private Runnable mExitRunnable = new Runnable() {

        @Override
        public void run() {
            press=false;
        }
    };

    @Override
    public void onBackPressed() {
        if(press == true){
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onBackPressed();

        Button button = (Button) findViewById(R.id.button);
        final EditText editText =(EditText) findViewById(R.id.answer);
        final Spinner spinner = (Spinner) findViewById(R.id.spinnerSoru);


        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(MainActivity2.this, R.array.question, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AnswerQuestion answerQuestion = HelperApplication.getSecurity(MainActivity2.this);

                if ((editText.getText().toString()).equals(answerQuestion.getAnswer()) && (spinner.getSelectedItem().toString()).equals(answerQuestion.getQuestion())) {
                    press = true;
                    Toast.makeText(MainActivity2.this, "Giris Basarili", Toast.LENGTH_LONG).show();
                } else {
                    press = false;
                    Toast.makeText(MainActivity2.this, "Giris Basarisiz", Toast.LENGTH_LONG).show();
                }


            }
        });

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
}
