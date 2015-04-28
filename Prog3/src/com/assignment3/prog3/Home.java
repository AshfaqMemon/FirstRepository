package com.assignment3.prog3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView( R.layout.home );
		String uname = getIntent().getExtras().getString("username");
		((TextView)findViewById(R.id.lblUname)).setText( "Username : " + uname);
	}
}
