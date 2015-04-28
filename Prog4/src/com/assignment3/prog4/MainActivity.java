package com.assignment3.prog4;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView msg;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        msg = (TextView)findViewById(R.id.textView1);
        
        Typeface tf = Typeface.defaultFromStyle(Typeface.BOLD);
        msg.setTypeface(tf);
        
        
		
        ((Spinner)findViewById(R.id.colorSpinner)).setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				
				msg.setTextColor( Color.parseColor( arg0.getItemAtPosition(arg2).toString() ) );
			}

			public void onNothingSelected(AdapterView<?> arg0) {}
        	
		});
        
        ((Spinner)findViewById(R.id.fontSpinner)).setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				
				msg.setTypeface( Typeface.create(arg0.getItemAtPosition(arg2).toString(), Typeface.NORMAL) );	
				
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        	
		});
    }

    
}
