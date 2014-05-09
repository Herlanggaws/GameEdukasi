package com.bungamatahari.gameedukasi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Accelerate extends Activity implements SensorEventListener{

	float x, y, sensorX, sensorY;
	Bitmap kado,kadot;
	SensorManager sm;
	accelerateView ourSurfaceView;
	boolean kanan= false;
	boolean kiri= false;
	
	
	
	public class accelerateView extends SurfaceView implements Runnable {

		SurfaceHolder ourHolder;
		Thread ourThread = null;
		boolean isRunning = false;
		MediaPlayer OurSong;
		
		
		public accelerateView(Context context) {
			super(context);
			ourHolder = getHolder();
			
		}
		
		public void pause(){
			isRunning = false;
			while(true){
				try {
					ourThread.join();
				} catch (InterruptedException e){
					e.printStackTrace();
				}
				break;
			}
			ourThread = null;
		}
		
		public void resume(){
			isRunning = true;
			ourThread = new Thread(this);
			ourThread.start();
		}

		@Override
		public void run() {
			while(isRunning){
				if(!ourHolder.getSurface().isValid())
					continue;
				
				Canvas canvas = ourHolder.lockCanvas();
				canvas.drawColor(Color.WHITE);
				float centerX = canvas.getWidth()/4;
				float centerY = canvas.getHeight()/2;
				
				//canvas.drawBitmap(kado, centerX+sensorX*20, centerY+sensorY*20, null);
				canvas.drawBitmap(kado, centerX+sensorX*20, centerY, null);
				
				
				if (sensorX>=5){
					kanan = true;
					//lagu dimatiin dulu
					//OurSong = MediaPlayer.create(Accelerate.this, R.raw.coba);
					//OurSong.start();
					cekDering();
				} else if(sensorX<=-5){
					kiri = true;
					cekDering();
				}
				else {
					//OurSong.stop();
				}
				
				ourHolder.unlockCanvasAndPost(canvas);
				
				
			}
			
		}
		
	}
	
	public void cekDering(){
		if(kanan == true && kiri == true){
			try {
				Class nextClass = Class
						.forName("com.bungamatahari.gameedukasi.SceneSatuNarasiSatu");
				Intent openMainActivity = new Intent(Accelerate.this,
						nextClass);
				startActivity(openMainActivity);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		sm =  (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		if (sm.getSensorList(Sensor.TYPE_ACCELEROMETER).size()!=0){
			Sensor s =  sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
		}
		
		kadot = BitmapFactory.decodeResource(getResources(), R.drawable.kado);
		kado = Bitmap.createScaledBitmap(kadot, 100, 100, true);
		
		
		
		x = y = sensorX = sensorY = 0;
		ourSurfaceView = new accelerateView(this);
		ourSurfaceView.resume();
		setContentView(ourSurfaceView);
	}
	
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		sm.unregisterListener(this);
		super.onPause();
		finish();
	}



	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent e) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(16);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		sensorX = e.values[0]*-1; // x Axis 
		sensorY = e.values[1]; // y Axis 
		
		
	}
	
	

}
