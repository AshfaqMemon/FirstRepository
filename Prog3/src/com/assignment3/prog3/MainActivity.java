package com.assignment3.prog3;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements TextWatcher, OnClickListener {

	private EditText txtName, txtPass;
	private String storedUser, storedPass, typedUser, typedPass;
	private Button btnSubmit;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txtName = ( EditText )findViewById( R.id.txtUser );
        txtPass = ( EditText )findViewById( R.id.txtPass );
        
        txtName.addTextChangedListener( this );
        txtPass.addTextChangedListener( this );
        
        Resources x = getResources();
        
        storedUser = x.getString( R.string.username );
        storedPass = x.getString( R.string.password );
        
        btnSubmit = (Button)findViewById(R.id.btnlogin);
        btnSubmit.setOnClickListener( this );
    }

	public void afterTextChanged(Editable s) {
		typedUser = txtName.getText().toString();
		typedPass = txtPass.getText().toString();
		
		if ( typedUser.equals(storedUser) && typedPass.equals(storedPass) )
			btnSubmit.setEnabled( true );
		else
			btnSubmit.setEnabled( false );
			
	}

	public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

	public void onTextChanged(CharSequence s, int start, int before, int count) {}

	public void onClick(View v) {

		Intent home = new Intent(getApplicationContext(), Home.class);
		home.putExtra( "username", storedUser );
		startActivity( home );
	}
}
