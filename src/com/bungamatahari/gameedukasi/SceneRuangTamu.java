package com.bungamatahari.gameedukasi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

public class SceneRuangTamu extends Activity implements OnTouchListener {

	ImageView atasanSatu, atasanDua, atasanTiga, bawahanSatu, bawahanDua,
			bawahanTiga, sepatuSatu, sepatuDua, sepatuTiga, dikenakan;
	TextView hasil;
	boolean statusAtasan = false;
	boolean statusBawahan = false;
	boolean statusSpatu = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// remove title
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.scene_satu_narasi_tiga);

		hasil = (TextView) findViewById(R.id.Hasil);

		// Atasan
		atasanSatu = (ImageView) findViewById(R.id.AtasanSatu);
		atasanDua = (ImageView) findViewById(R.id.AtasanDua);
		atasanTiga = (ImageView) findViewById(R.id.AtasanTiga);

		atasanSatu.setOnTouchListener(this);
		atasanDua.setOnTouchListener(this);
		atasanTiga.setOnTouchListener(this);

		// Bawahan

		bawahanSatu = (ImageView) findViewById(R.id.BawahanSatu);
		bawahanDua = (ImageView) findViewById(R.id.BawahanDua);
		bawahanTiga = (ImageView) findViewById(R.id.BawahanTiga);

		bawahanSatu.setOnTouchListener(this);
		bawahanDua.setOnTouchListener(this);
		bawahanTiga.setOnTouchListener(this);

		// Sepatu

		sepatuSatu = (ImageView) findViewById(R.id.SepatuSatu);
		sepatuDua = (ImageView) findViewById(R.id.SepatuDua);
		sepatuTiga = (ImageView) findViewById(R.id.SepatuTiga);

		sepatuSatu.setOnTouchListener(this);
		sepatuDua.setOnTouchListener(this);
		sepatuTiga.setOnTouchListener(this);

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		// Atasan
		case R.id.AtasanSatu:
			atasanSatu.setVisibility(View.GONE);
			atasanDua.setVisibility(View.VISIBLE);
			atasanTiga.setVisibility(View.VISIBLE);
			dikenakan = (ImageView) findViewById(R.id.AtasanTigaKepake);
			dikenakan.setImageResource(R.drawable.fit_atasan_satu);
			dikenakan.setScaleX((float) 1);
			dikenakan.setScaleY((float) 1);
			dikenakan.setY(229);
			statusAtasan = false;
			periksaPenampilan();
			break;

		case R.id.AtasanDua:
			atasanSatu.setVisibility(View.VISIBLE);
			atasanDua.setVisibility(View.GONE);
			atasanTiga.setVisibility(View.VISIBLE);
			dikenakan = (ImageView) findViewById(R.id.AtasanTigaKepake);
			dikenakan.setImageResource(R.drawable.fit_atasan_dua);
			dikenakan.setScaleX((float) 1.50);
			dikenakan.setScaleY((float) 1.50);
			dikenakan.setY(224);
			statusAtasan = false;
			periksaPenampilan();
			break;

		case R.id.AtasanTiga:
			atasanSatu.setVisibility(View.VISIBLE);
			atasanDua.setVisibility(View.VISIBLE);
			atasanTiga.setVisibility(View.GONE);
			dikenakan = (ImageView) findViewById(R.id.AtasanTigaKepake);
			dikenakan.setImageResource(R.drawable.fit_atasan_tiga);
			dikenakan.setScaleX((float) 1.25);
			dikenakan.setScaleY((float) 1.25);
			dikenakan.setY(230);
			statusAtasan = true;
			periksaPenampilan();
			break;

		// Bawahan

		case R.id.BawahanSatu:
			bawahanSatu.setVisibility(View.GONE);
			bawahanDua.setVisibility(View.VISIBLE);
			bawahanTiga.setVisibility(View.VISIBLE);
			dikenakan = (ImageView) findViewById(R.id.BawahanTigaKepake);
			dikenakan.setImageResource(R.drawable.fit_bawahan_dua);
			statusBawahan = false;
			periksaPenampilan();
			break;

		case R.id.BawahanDua:
			bawahanSatu.setVisibility(View.VISIBLE);
			bawahanDua.setVisibility(View.GONE);
			bawahanTiga.setVisibility(View.VISIBLE);
			dikenakan = (ImageView) findViewById(R.id.BawahanTigaKepake);
			dikenakan.setImageResource(R.drawable.fit_bawahan_satu);
			dikenakan.setScaleX((float) 1.25);
			dikenakan.setScaleY((float) 1);
			dikenakan.setY(290);
			statusBawahan = false;
			periksaPenampilan();
			break;

		case R.id.BawahanTiga:
			bawahanSatu.setVisibility(View.VISIBLE);
			bawahanDua.setVisibility(View.VISIBLE);
			bawahanTiga.setVisibility(View.GONE);
			dikenakan = (ImageView) findViewById(R.id.BawahanTigaKepake);
			dikenakan.setImageResource(R.drawable.fit_bawahan_tiga);
			dikenakan.setScaleX(1);
			dikenakan.setScaleY(1);
			dikenakan.setY(290);
			statusBawahan = true;
			periksaPenampilan();
			break;

		// Sepatu

		case R.id.SepatuSatu:
			sepatuSatu.setVisibility(View.GONE);
			sepatuDua.setVisibility(View.VISIBLE);
			sepatuTiga.setVisibility(View.VISIBLE);
			dikenakan = (ImageView) findViewById(R.id.SepatuTigaKepake);
			dikenakan.setImageResource(R.drawable.fit_sepatu_satu);
			dikenakan.setScaleX(1);
			dikenakan.setScaleY(1);
			dikenakan.setY(367);
			statusSpatu = false;
			periksaPenampilan();
			break;

		case R.id.SepatuDua:
			sepatuSatu.setVisibility(View.VISIBLE);
			sepatuDua.setVisibility(View.GONE);
			sepatuTiga.setVisibility(View.VISIBLE);
			dikenakan = (ImageView) findViewById(R.id.SepatuTigaKepake);
			dikenakan.setImageResource(R.drawable.fit_sepatu_dua);
			dikenakan.setScaleX((float) 1.30);
			dikenakan.setScaleY((float) 1.30);
			dikenakan.setY(371);
			statusSpatu = false;
			periksaPenampilan();
			break;
			
		case R.id.SepatuTiga:
			sepatuSatu.setVisibility(View.VISIBLE);
			sepatuDua.setVisibility(View.VISIBLE);
			sepatuTiga.setVisibility(View.GONE);
			dikenakan = (ImageView) findViewById(R.id.SepatuTigaKepake);
			dikenakan.setImageResource(R.drawable.fit_sepatu_tiga);
			dikenakan.setScaleX((float) 1.30);
			dikenakan.setScaleY((float) 1.30);
			dikenakan.setY(373);
			statusSpatu = true;
			periksaPenampilan();
			break;
		}

		return false;
	}

	public void periksaPenampilan() {
		if (statusAtasan == true && statusBawahan == true && statusSpatu == true) {
			hasil.setText("Berhasil");

			try {
				Class nextClass = Class
						.forName("com.bungamatahari.gameedukasi.SceneDuaNarasiSatu");
				Intent openMainActivity = new Intent(SceneRuangTamu.this,
						nextClass);
				startActivity(openMainActivity);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} else {
			hasil.setText("Salah");
		}
	}

}