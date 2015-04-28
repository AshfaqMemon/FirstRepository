package com.assignment3.prog7;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnItemSelectedListener {

	private ImageView image;
	private ShapeDrawable sd = null;
	private int color, shapenum;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        image = (ImageView)findViewById(R.id.imageView1);
        
		
        ((Spinner)findViewById(R.id.colorSpinner)).setOnItemSelectedListener( this ); 
        ((Spinner)findViewById(R.id.shapeSpinner)).setOnItemSelectedListener( this );
        
    }

        
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		
		try{
			color = Color.parseColor( arg0.getItemAtPosition(arg2).toString().toLowerCase() );
		}
		catch( IllegalArgumentException iaex){
			shapenum = arg2;
		}
	
		
		switch ( shapenum ) {
			case 0:
				//Rectangle
				sd = DrawShapes.getRectangle(80, 150, color);
				
				break;
			case 1:
				//Circle
				sd = DrawShapes.getOval(100, 100, color);
				break;
			case 2:
				//Square
				sd = DrawShapes.getRectangle(100, 100, color);
				break;
			case 3:
				sd = DrawShapes.getOval(100, 50, color);
				break;
				
		}
		image.setImageDrawable(sd);
	}

	public void onNothingSelected(AdapterView<?> arg0) {}
}

//Class that provide ShapeDrawable Object for different shapes
class DrawShapes{
	
	public static ShapeDrawable getRectangle ( int width, int height, int color){
		ShapeDrawable sd = new ShapeDrawable ( new RectShape() );
		
		sd.setIntrinsicWidth( width );
		sd.setIntrinsicHeight( height );
		sd.getPaint().setColor( color );
		return sd;
	}
	
	public static ShapeDrawable getOval ( int width, int height, int color){
		ShapeDrawable sd = new ShapeDrawable ( new OvalShape() );
		
		sd.setIntrinsicWidth( width );
		sd.setIntrinsicHeight( height );
		sd.getPaint().setColor( color );
		
		return sd;
	}
}