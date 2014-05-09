package com.bungamatahari.gameedukasi;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends Activity{
	
	MediaPlayer OurSong;

	@Override
	protected void onCreate(Bundle BungaMatahariOpening) {
		super.onCreate(BungaMatahariOpening);
		
		// remove title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.splash);
		
		OurSong = MediaPlayer.create(Splash.this, R.raw.coba);
		OurSong.start();
		// making splash
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(3000); // 5000 -> 5 detik
				} catch (InterruptedException ie){
					ie.printStackTrace();
				} finally{
					
					Intent openMainActivity = new Intent("com.bungamatahari.gameedukasi.bungaMatahari");
					//Intent openMainActivity = new Intent("com.bungamatahari.gameedukasi.SceneSatuNarasiSatu");
					startActivity(openMainActivity);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		OurSong.stop();
		finish();
	}
	
}
