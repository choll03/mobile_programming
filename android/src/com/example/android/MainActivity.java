package com.example.android;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;


public class MainActivity extends Activity implements OnClickListener{
	private EditText utsET, uasET, nilaiAkhirET;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        utsET = (EditText) findViewById(R.id.utsEditText);
        uasET = (EditText) findViewById(R.id.uasEditText);
        nilaiAkhirET = (EditText) findViewById(R.id.nilaiAkhirEditText);
        
        findViewById(R.id.hitungButton).setOnClickListener(this);
        findViewById(R.id.tutupButton).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onClick(View v) {
    	// TODO Auto-generated method stub
    	switch (v.getId()){
    		case R.id.hitungButton:
    			double uts=0, uas=0, nilaiAkhir;
    			try {
    				uts = Double.parseDouble(utsET.getText().toString());
    			} catch (Exception ex) {}
    			try {
    				uas = Double.parseDouble(uasET.getText().toString());
    			} catch (Exception ex) {}
    			
    			nilaiAkhir = (uts + uas)/2;
    			
    			if (nilaiAkhir >= 60){
    				nilaiAkhirET.setBackgroundResource(R.color.hijau);
    			} else {
    				nilaiAkhirET.setBackgroundResource(R.color.merah);
    			}
    			
    			nilaiAkhirET.setText(Double.toString(nilaiAkhir));
    			break;
    		case R.id.tutupButton: System.exit(0);
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
