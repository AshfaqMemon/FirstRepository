package com.assignment3.prog5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity implements OnItemClickListener {

	private Intent activity;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = new Intent( this, AnimationDemo.class );
        ((ListView)findViewById(R.id.listView1)).setOnItemClickListener( this );
    }

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
		String animationType = arg0.getItemAtPosition( arg2 ).toString().toLowerCase();
		activity.putExtra("animType", animationType);
		startActivity( activity );
		
	}

    
}
