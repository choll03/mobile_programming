package com.example.materiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;


public class MainActivity extends Activity implements OnClickListener{
	private String[][] dataUser = {{"ADMIN","ADMIN","Administrator"}, {"user1","password1","Nama User 1"}, {"user2","password2","Nama User 2"}};
	private EditText userNameET, passwordET;
	private final int SUCCESS=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        userNameET = (EditText) findViewById(R.id.userNameEditText);
        passwordET = (EditText) findViewById(R.id.passwordEditText);
        
        findViewById(R.id.loginButton).setOnClickListener(this);
        findViewById(R.id.tutupButton).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onClick(View v) {
    	switch (v.getId()){
    	
    		case R.id.loginButton:
    			int i=0;
    			boolean success=false;
    			while ((i<dataUser.length) && (!success)){
    				if ((userNameET.getText().toString().equals(dataUser[i][0])) && (passwordET.getText().toString().equals(dataUser[i][1]))){
    					success=true;
    				} else { 
    					i++; 
    				} 
    			}
    			
    			Intent intent;
    			if (success){
    				intent = new Intent(this, SuccessActivity.class);
    				intent.putExtra("namaUser", dataUser[i][2]);
    				startActivityForResult(intent,SUCCESS);
    			} else { 
    				intent = new Intent(this, FailedActivity.class);
    				startActivity(intent);
    			}
    			startActivity(intent);
    			break;
    		case R.id.tutupButton:
    			System.exit(0);
    	
    	}
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent data){
    	switch (requestCode) {
    		case SUCCESS:
    			userNameET.setText("");
    			passwordET.setText("");
    			break;
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
