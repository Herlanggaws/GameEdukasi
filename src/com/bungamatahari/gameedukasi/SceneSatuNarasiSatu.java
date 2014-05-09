package com.bungamatahari.gameedukasi;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SceneSatuNarasiSatu extends Activity{
	
	MediaPlayer OurSong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// remove title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.scene_satu_narasi_satu);
        
        OurSong = MediaPlayer.create(SceneSatuNarasiSatu.this, R.raw.coba);
		OurSong.start();
		
		// making splash
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(2000); // 5000 -> 5 detik
				} catch (InterruptedException ie){
					ie.printStackTrace();
				} finally{
					try{
					Class nextClass = Class.forName("com.bungamatahari.gameedukasi.SceneSatuNarasiDua");
					Intent openMainActivity = new Intent(SceneSatuNarasiSatu.this,nextClass);
					startActivity(openMainActivity);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		};
		timer.start();
	}
	
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		OurSong.stop();
		finish();
	}

}
