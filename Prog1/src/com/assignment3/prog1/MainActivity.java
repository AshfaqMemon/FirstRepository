package com.assignment3.prog1;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView iv;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final AnimationDrawable ad = new AnimationDrawable();
        
        ad.addFrame ( (Drawable)getResources().getDrawable( R.drawable.australia ), 500);
        ad.addFrame ( (Drawable)getResources().getDrawable( R.drawable.china ), 500);
        ad.addFrame ( (Drawable)getResources().getDrawable( R.drawable.indianflag ), 1500);
        ad.setOneShot( false );
        
        iv = (ImageView)findViewById( R.id.imageView1);        
        iv.setImageDrawable( ad );
        
        ((Button)findViewById(R.id.btnstart)).setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				ad.start();
			}
		});
        
        ((Button)findViewById(R.id.btnstop)).setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				ad.stop();
			}
		});
    }
}
