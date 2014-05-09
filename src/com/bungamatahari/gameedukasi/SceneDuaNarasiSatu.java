package com.bungamatahari.gameedukasi;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;

public class SceneDuaNarasiSatu extends Activity implements OnTouchListener {
 
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		finish();
	}

	ViewSceneDuaNarasiSatu DragAndDropView;
	float x, y, sX, sY, fX, fY;
	Bitmap test, plus, tasDepan, resizeTasDepan, tasBelakang,
			resizeTasBelakang, kado, resizeKado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		super.onCreate(savedInstanceState);
		// remove title
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		DragAndDropView = new ViewSceneDuaNarasiSatu(this);
		DragAndDropView.setOnTouchListener(this);
		x = 100;
		y = 100;
		sX = 0;
		sY = 0;
		fX = 0;
		fY = 0;
		test = BitmapFactory.decodeResource(getResources(),
				R.drawable.sepatu_dua);
		plus = BitmapFactory.decodeResource(getResources(), R.drawable.box);
		tasDepan = BitmapFactory.decodeResource(getResources(),
				R.drawable.tas_depan);
		resizeTasDepan = Bitmap.createScaledBitmap(tasDepan, 200, 200, true);

		tasBelakang = BitmapFactory.decodeResource(getResources(),
				R.drawable.tas_belakang);
		resizeTasBelakang = Bitmap.createScaledBitmap(tasBelakang, 200, 250,
				true);

		kado = BitmapFactory.decodeResource(getResources(), R.drawable.kado);
		resizeTasBelakang = Bitmap.createScaledBitmap(tasBelakang, 100, 100,
				true);

		setContentView(DragAndDropView);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		DragAndDropView.pause();
		finish();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		DragAndDropView.resume();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		
			sX = event.getX();
			sY = event.getY();
		
			
		
		

		/*
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:

			sX = event.getX();
			sY = event.getY();

			break;
		case MotionEvent.ACTION_UP:
			fX = event.getX();
			fY = event.getY();
			break;
		}
		*/
		return true; // agar bisa di drag and drop bila false sebaliknya
	}

	public class ViewSceneDuaNarasiSatu extends SurfaceView implements Runnable {

		SurfaceHolder ourHolder;
		Thread ourThread = null;
		boolean isRunning = false;
		Typeface font;

		public ViewSceneDuaNarasiSatu(Context context) {
			super(context);
			ourHolder = getHolder();
			font = Typeface.createFromAsset(context.getAssets(), "ARIAL.TTF");
		}

		public void pause() {
			isRunning = false;
			while (true) {
				try {
					ourThread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			ourThread = null;
		}

		public void resume() {
			isRunning = true;
			ourThread = new Thread(this);
			ourThread.start();
		}

		
		public void run() {
			while (isRunning) {
				if (!ourHolder.getSurface().isValid())
					continue;

				Canvas canvas = ourHolder.lockCanvas();
				

				canvas.drawColor(Color.WHITE);
				
				Paint textPaint = new Paint();
				//textPaint.setARGB(100, 100, 100, 100);
				textPaint.setColor(Color.BLACK);
				textPaint.setTextAlign(Align.CENTER);
				textPaint.setTextSize(50);
				canvas.drawText("x =" + Float.toHexString(sX) + " | y =" + Float.toHexString(sY), 200, 200, textPaint);
				canvas.drawBitmap(resizeTasBelakang, 350, 200, null);
				canvas.drawBitmap(test, x, y, null);
				
				

				if(x== 100 && y == 100){
					canvas.drawBitmap(test, sX, sY, null);
				}
				
				
				
				
				
				

				canvas.drawBitmap(resizeTasDepan, 350, 200, null);

				/*
				 * 
				 * 
				 * if (sX != 0 && sY != 0) {
				 * 
				 * canvas.drawBitmap(plus, sX - (plus.getWidth() / 2), fY -
				 * (plus.getHeight() / 2), null); } if (fX != 0 && fY != 0) {
				 * 
				 * canvas.drawBitmap(plus, fX - (plus.getWidth() / 2), fY -
				 * (plus.getHeight() / 2), null); }
				 */
				ourHolder.unlockCanvasAndPost(canvas);
			}
		}
	}

}
