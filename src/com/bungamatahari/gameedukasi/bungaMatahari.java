package com.bungamatahari.gameedukasi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class bungaMatahari extends Activity implements OnClickListener {

	Button buttonStart, buttonDua, buttonTiga, buttonEmpat, buttonLima;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttonStart = (Button) findViewById(R.id.buttonStart);
		buttonStart.setOnClickListener(this);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.buttonStart:
			try {
				//Class nextClass = Class.forName("com.bungamatahari.gameedukasi.SceneSatuNarasiSatu");
				Class nextClass = Class.forName("com.bungamatahari.gameedukasi.SceneDuaNarasiSatux");
				Intent openMainActivity = new Intent(bungaMatahari.this,nextClass);
				startActivity(openMainActivity);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
			/*
		case R.id.buttonDua :
			try {
				//Class nextClass = Class.forName("com.bungamatahari.gameedukasi.SceneSatuNarasiSatu");
				Class nextClass = Class.forName("com.bungamatahari.gameedukasi.SceneDuaNarasiSatu");
				Intent openMainActivity = new Intent(bungaMatahari.this,nextClass);
				startActivity(openMainActivity);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		case R.id.buttonTiga :
			try {
				//Class nextClass = Class.forName("com.bungamatahari.gameedukasi.SceneSatuNarasiSatu");
				Class nextClass = Class.forName("com.bungamatahari.gameedukasi.Voice");
				Intent openMainActivity = new Intent(bungaMatahari.this,nextClass);
				startActivity(openMainActivity);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		case R.id.buttonEmpat :
			try {
				//Class nextClass = Class.forName("com.bungamatahari.gameedukasi.SceneSatuNarasiSatu");
				Class nextClass = Class.forName("com.bungamatahari.gameedukasi.Accelerate");
				Intent openMainActivity = new Intent(bungaMatahari.this,nextClass);
				startActivity(openMainActivity);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		case R.id.buttonLima :
			try {
				//Class nextClass = Class.forName("com.bungamatahari.gameedukasi.SceneSatuNarasiSatu");
				Class nextClass = Class.forName("com.bungamatahari.gameedukasi.SceneDuaNarasiSatux");
				Intent openMainActivity = new Intent(bungaMatahari.this,nextClass);
				startActivity(openMainActivity);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		*/

	}

	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
