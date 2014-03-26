package com.example.train_android_intent;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class TestActivity extends Activity {
	EditText txtText;
	Button btn1;
	Button btn2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);

		txtText = (EditText) findViewById(R.id.editNumber);
		btn1 = (Button) findViewById(R.id.btnSave1);
		btn2 = (Button) findViewById(R.id.btnSave2);

		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				sendtoMain(MainActivity.resultCode1);

			}
		});
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				sendtoMain(MainActivity.resultCode2);

			}
		});

	}

	public void sendtoMain(int resultCode) {
		Intent main = getIntent();
		int value = Integer.parseInt(txtText.getText() + "");
		main.putExtra("data", value);
		setResult(resultCode, main);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

}
