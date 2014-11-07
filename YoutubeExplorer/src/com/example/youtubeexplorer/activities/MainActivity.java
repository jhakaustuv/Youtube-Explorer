package com.example.youtubeexplorer.activities;

import org.apache.http.Header;

import com.example.youtubeexplorer.R;
import com.example.youtubeexplorer.R.id;
import com.example.youtubeexplorer.R.layout;
import com.example.youtubeexplorer.R.menu;
import com.example.youtubeexplorer.helperclasses.ProjectConstants;
import com.example.youtubeexplorer.helperclasses.Utils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	
	private Context mContext;
	private AsyncHttpClient httpClient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mContext = this;
		httpClient = new AsyncHttpClient();
		
		RequestParams requestParams = new RequestParams();
		requestParams.put("key", ProjectConstants.YOUTUBE_API_KEY);
		requestParams.put("part", "contentDetails");
		requestParams.put("mine", "true");
		
		httpClient.get(mContext, ProjectConstants.DOMAIN+"/channels", requestParams, new TextHttpResponseHandler() {
			
			@Override
			public void onStart() {
				// Initiated the request
				Utils.printMe("START");
			}
			
			@Override
			public void onSuccess(int responseCode, Header[] headers, String response) {
				// TODO Auto-generated method stub
				Utils.printMe("SUCCESS: "+responseCode+" "+response);
			}
			
			@Override
			public void onFailure(int responseCode, Header[] headers, String response, Throwable e) {
				// TODO Auto-generated method stub
				Utils.printMe("FAILURE: "+responseCode+" "+e.getLocalizedMessage());
			}
			
			@Override
			public void onFinish() {
				// Completed the request (either success or failure)
				Utils.printMe("STOPPED");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
