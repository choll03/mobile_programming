package com.example.materitabview;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Intent intent;
        TabHost tabHost = getTabHost();
        TabHost.TabSpec tabSpec;
        
        intent = new Intent(this, MenghitungHurufActivity.class);
        tabSpec = getTabHost().newTabSpec("tab1").setIndicator( "Menghitung Huruf").setContent(intent);
        tabHost.addTab(tabSpec);
        
        intent = new Intent(this, MenghitungKataActivity.class);
        tabSpec = getTabHost().newTabSpec("tab2").setIndicator( "Menghitung Kata").setContent(intent);
        tabHost.addTab(tabSpec);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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
