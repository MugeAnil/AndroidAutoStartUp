package com.example.androidautostartup;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	String answer ;
	String question;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button button = (Button) findViewById(R.id.button);
		final EditText editText =(EditText) findViewById(R.id.answer);
		final Spinner spinner = (Spinner) findViewById(R.id.spinnerSoru);

		ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.question, android.R.layout.simple_spinner_item);
		arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(arrayAdapter);



		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				AnswerQuestion answerQuestion = new AnswerQuestion();
				answerQuestion.setAnswer(editText.getText().toString());
				answerQuestion.setQuestion(spinner.getSelectedItem().toString());
				HelperApplication.setSecurity(getApplicationContext(), answerQuestion);

				String displayString = " Kaydedildi " ;
				Toast.makeText(MainActivity.this, displayString, Toast.LENGTH_LONG).show();
				/*answer = editText.getText().toString();
				question= spinner.getSelectedItem().toString();
				String displayString = " Cevbınız" + answer +" olarak kaydedildi " ;
				Toast.makeText(MainActivity.this, displayString, Toast.LENGTH_LONG).show();
				*/
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
