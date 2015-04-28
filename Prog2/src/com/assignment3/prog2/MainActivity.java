package com.assignment3.prog2;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnItemSelectedListener {

	private ImageView image;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ((Spinner)findViewById(R.id.spinner1)).setOnItemSelectedListener(this);
        image = (ImageView)findViewById(R.id.imageView1);
    }

	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {

		String shapeName = arg0.getItemAtPosition( arg2 ).toString().replace(" ", "").toLowerCase();
		int resid = getResources().getIdentifier( shapeName, "drawable", "com.assignment3.prog2" );
		Drawable d = getResources().getDrawable( resid );
		image.setImageDrawable( d );
		
	}

	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}


}
