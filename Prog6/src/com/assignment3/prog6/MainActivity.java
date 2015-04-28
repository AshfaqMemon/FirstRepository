package com.assignment3.prog6;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends Activity {

	private WebView browser;
	private WebSettings settings;
	private ProgressDialog progress;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        browser = (WebView)findViewById(R.id.webView1);
        
        progress = ProgressDialog.show(MainActivity.this , "Opening Page", "Loading...");
        
        browser.loadUrl("file:///android_asset/Simple.html");	//Fetch the file from assets folder
        
        
        /*
         * For loading html content
         * browser.loadData(htmldata, "text/html", "utf-8");
         * 
         * For loading web site from Internet
         * browser.loadUrl("www.google.co.in");
         * You have to provide permission android.permission.INTERNET for accessing Internet
         */
        
        browser.setWebChromeClient( new MyChromeClient() );
        browser.setWebViewClient( new WebViewClient() );
        
        settings = browser.getSettings();		 // Getting object of WebSettings for settings of WebView
        settings.setJavaScriptEnabled( true );	 // Enables JavaScript in WebView
        settings.setBuiltInZoomControls( true ); // Enables built in Zoom controls in WebView
        
    }

    class MyWebViewClient extends WebViewClient{
    	
    	@Override
    	public void onPageFinished(WebView view, String url) {
    		super.onPageFinished(view, url);
    		Toast.makeText(MainActivity.this, "Finished Loading", Toast.LENGTH_SHORT).show();
    	}
    	
    }
    
    class MyChromeClient extends WebChromeClient{
    	@Override
    	public void onProgressChanged(WebView view, int newProgress) {
    		super.onProgressChanged(view, newProgress);
    		if ( newProgress > 95)
    			progress.dismiss();
    	}
    }
}