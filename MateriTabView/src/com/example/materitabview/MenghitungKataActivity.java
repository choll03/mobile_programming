package com.example.materitabview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class MenghitungKataActivity extends Activity implements OnClickListener{
	EditText teksKataET;
	TextView jumlahKataTV;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menghitung_kata);
		
		teksKataET = (EditText) findViewById(R.id.teksKataEditText);
		jumlahKataTV = (TextView) findViewById(R.id.jumlahKataTextView);
		
		findViewById(R.id.hitungKataButton).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menghitung_kata, menu);
		return true;
	}
	
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.hitungKataButton:
				String teks = teksKataET.getText().toString();
				boolean kata=false, huruf;
				int i, jumlahKata=0, keyCode;
				
				for (i=0; i<teks.length(); i++){
					huruf = false;
					keyCode = teks.charAt(i);
					
					if (((keyCode >= 65) && (keyCode <= 90)) || ((keyCode >= 97) && (keyCode <= 122))){
						huruf=true;
					}
					
					if (huruf){
						if (!kata){
							kata = true; jumlahKata++;
						}
					} else {
						kata = false;
					
					}
				}
				jumlahKataTV.setText(Integer.toString(jumlahKata));
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
