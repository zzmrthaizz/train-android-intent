package com.example.train_android_intent;

import java.util.ArrayList;
import java.util.zip.Inflater;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	Button nhap;
	ListView ls;
	ArrayAdapter<Integer> adapter;
	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	public final static int requestCode_input = 113;
	public final static int resultCode1 = 115;
	public final static int resultCode2 = 116;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		nhap = (Button) findViewById(R.id.btnopenactivity);
		nhap.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent test = new Intent(MainActivity.this, TestActivity.class);

				startActivityForResult(test, requestCode_input);

			}
		});
		ls = (ListView) findViewById(R.id.lvdata);
		adapter = new ArrayAdapter<Integer>(this,
				android.R.layout.simple_list_item_1, arrayList);
		ls.setAdapter(adapter);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == requestCode_input) {
			switch (resultCode) {
			case resultCode1:
				int v1 = data.getIntExtra("data", 0);
				arrayList.add(v1 * v1);
				adapter.notifyDataSetChanged();
				break;
			case resultCode2:
				int v2 = data.getIntExtra("data", 0);
				arrayList.add(v2);
				adapter.notifyDataSetChanged();
				break;
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
