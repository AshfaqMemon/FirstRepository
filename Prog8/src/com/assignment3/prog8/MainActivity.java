package com.assignment3.prog8;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView iv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        iv = (ImageView)findViewById(R.id.imageView1);
        
        ((Button)findViewById(R.id.button1)).setOnClickListener( new OnClickListener() {
			
			public void onClick(View v) {
				iv.startAnimation( AnimationUtils.loadAnimation(getApplicationContext(), R.anim.custom) );
			}
		});
    }

    
}
