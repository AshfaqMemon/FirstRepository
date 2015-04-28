package com.assignment3.prog9;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private ImageView iv;
	private String selectedAnimation;
	private Animation animation;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ((Button)findViewById(R.id.btnStart)).setOnClickListener( this );
        ((Button)findViewById(R.id.btnStop)).setOnClickListener( this );
        
        iv = (ImageView)findViewById(R.id.imageView1);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*getMenuInflater().inflate(R.menu.activity_main, menu);*/
    	menu.add("Scaling Circle");
    	menu.add("Transform Square");
    	menu.add("Rotate Line");
    	menu.add("Rotate Text");
    	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
    	selectedAnimation = (String) item.getTitle();    	
    	return super.onMenuItemSelected(featureId, item);
    }

	public void onClick(View v) {

		switch ( v.getId() ){
			
			case R.id.btnStart:
				performAnimation( selectedAnimation );
				break;
			case R.id.btnStop:
				iv.clearAnimation();
				break;
		}
	}
	
	public void performAnimation( String animationName ){
		if ( animationName.equals( "Scaling Circle" )){
			iv.setImageDrawable( getResources().getDrawable(R.drawable.circle ));
			animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scaling );
		}
		
		else if ( animationName.equals( "Transform Square" )){
			iv.setImageDrawable( getResources().getDrawable(R.drawable.rectangle ));
			animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.transform );
		}
		else if ( animationName.equals( "Rotate Line" )){
			iv.setImageDrawable( getResources().getDrawable(R.drawable.line ));
			animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate );
		}
		else{
			Paint p = new Paint();
			p.setColor( Color.MAGENTA );
			Typeface tf=Typeface.create(Typeface.SERIF, Typeface.BOLD);
			p.setTypeface(tf);
			p.setTextSize(14);
			Canvas c = new Canvas();
			
			c.drawText("Android", 100, 50, p);
			
			iv.draw(c);
			animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate );
			
			Toast.makeText(getApplicationContext(), "Text", Toast.LENGTH_SHORT).show();
		}
		iv.startAnimation( animation );
	}
}