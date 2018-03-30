package com.example.meitu1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void btnPrimaryColor(View view)
	{
		startActivity(new Intent(this, PrimaryColor.class));
	}
	
	public void btnColorMartix(View view)
	{
		startActivity(new Intent(this, ColorMatrixActivity.class));
	}
	
	public void btnPixMartix(View view)
	{
		startActivity(new Intent(this, PixelsEffectActivity.class));
	}
}
