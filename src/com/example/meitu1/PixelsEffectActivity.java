package com.example.meitu1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class PixelsEffectActivity extends Activity {

	private ImageView imageView1 ;
	private ImageView imageView2 ;
	private ImageView imageView3 ;
	private ImageView imageView4 ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pixelsfffect);
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView2 = (ImageView) findViewById(R.id.imageView2);
		imageView3 = (ImageView) findViewById(R.id.imageView3);
		imageView4 = (ImageView) findViewById(R.id.imageView4);
		
		imageView1.setImageBitmap(bitmap);
		imageView2.setImageBitmap(ImageHelper.handlerImageNegative(bitmap));
		imageView3.setImageBitmap(ImageHelper.handlerImageRetro(bitmap));
		imageView4.setImageBitmap(ImageHelper.handlerImagePixlsRelief(bitmap));
		
	}
	
}
