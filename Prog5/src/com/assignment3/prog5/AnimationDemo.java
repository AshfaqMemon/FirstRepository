package com.assignment3.prog5;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationDemo extends Activity {

	private ImageView iv;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        
        iv = (ImageView)findViewById(R.id.imageView1);
        Bundle b = getIntent().getExtras();
        
        String filename = b.getString( "animType");
        
        int fileid = getResources().getIdentifier(filename, "anim", "com.assignment3.prog5");
       
        iv.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), fileid));
    }   
}