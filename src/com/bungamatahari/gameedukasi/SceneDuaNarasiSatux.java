package com.bungamatahari.gameedukasi;



import com.bungamatahari.gameedukasi.R.drawable;

import android.app.Activity;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SceneDuaNarasiSatux extends Activity implements OnTouchListener {

	float x, y, sX, sY, fX, fY;
	ImageView kado;
	TextView hasil;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// remove title
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.scene_dua_narasi_satu);

		x = 0;
		y = 0;
		sX = 0;
		sY = 0;
		fX = 0;
		fY = 0;

		hasil = (TextView) findViewById(R.id.Hasil);
		kado = (ImageView) findViewById(R.id.kado);

		kado.setOnTouchListener(this);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		x = event.getX();
		y = event.getY();
		Boolean balikan = false;
		
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if (v.getId() == R.id.kado) {
				hasil.setText("You Get It!");
				kado.setOnDragListener(new MyDragListener());

				ClipData data = ClipData.newPlainText("", "");
				DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
				v.startDrag(data, shadowBuilder, v, 0);
				//v.setVisibility(View.VISIBLE);
				
				balikan = true;
			}
		case MotionEvent.ACTION_UP:
			kado.setX(x);
			kado.setY(y);
		
		}
		
		return balikan;

		
	}

	class MyDragListener implements OnDragListener {
		Drawable enterShape = getResources().getDrawable(
				R.drawable.kado);
		Drawable normalShape = getResources().getDrawable(R.drawable.kado);

		@Override
		public boolean onDrag(View v, DragEvent event) {
			int action = event.getAction();
			switch (event.getAction()) {
			case DragEvent.ACTION_DRAG_STARTED:
				// do nothing
				hasil.setText("Action Drag Started | x ="+ Float.toString(event.getX()));
				break;
			case DragEvent.ACTION_DRAG_ENTERED:
				hasil.setText("Action Drag Entered");
				 v.setBackgroundDrawable(enterShape);
				
				break;
			case DragEvent.ACTION_DRAG_EXITED:
				
				hasil.setText("Action Drag Exited | x ="+ Float.toString(event.getX()));
				 v.setBackgroundDrawable(normalShape);
				
				break;
			case DragEvent.ACTION_DROP:
				// Dropped, reassign View to ViewGroup
				
				//View view = (View) event.getLocalState();
				AbsoluteLayout container = (AbsoluteLayout) v;
				// target = (ImageView) v;
				ImageView dragged = (ImageView) event.getLocalState();
				container.addView(dragged);
				//container.addView(view);
				//view.setVisibility(View.VISIBLE);
				
				//target.setImageDrawable(normalShape);
				//hasil.setText("Action Drop | x ="+ Float.toString(event.get);
				//kado.setX(event.getX());
				//kado.setY(event.getY());
				break;
			case DragEvent.ACTION_DRAG_ENDED:
				hasil.setText("Action Ended | x ="+ Float.toString(event.getX()));
				//kado.setVisibility(View.VISIBLE);
				
				
				

			default:
				break;
			}
			// TODO Auto-generated method stub
			return true;
		}

	}
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		finish();
	}

}
