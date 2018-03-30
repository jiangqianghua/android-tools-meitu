package com.example.meitu1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class PrimaryColor  extends Activity implements SeekBar.OnSeekBarChangeListener{

	private ImageView mImageView ; 
	private SeekBar mSeekBarhue , mSeekBarStaturation , mSeekBarlum ;
	
	private static int MAX_VALUE = 255; 
	private static int MID_VALUE = 127 ;
	
	private float mHue , mStaturation , mLum ;
	
	private Bitmap mBitmap ;
	@Override
	protected void onCreate(Bundle savedInstanceState)  {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.primarycolor);
		
		mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		mSeekBarhue = (SeekBar) findViewById(R.id.seekbar_Hue);
		
		mSeekBarStaturation = (SeekBar) findViewById(R.id.seekbar_saturation);
		
		mSeekBarlum = (SeekBar) findViewById(R.id.seekbar_lum);
		
		mImageView = (ImageView) findViewById(R.id.imageview);
		mSeekBarhue.setOnSeekBarChangeListener(this);
		mSeekBarStaturation.setOnSeekBarChangeListener(this);
		mSeekBarlum.setOnSeekBarChangeListener(this);
		
		mSeekBarhue.setMax(MAX_VALUE);
		mSeekBarStaturation.setMax(MAX_VALUE);
		mSeekBarlum.setMax(MAX_VALUE);
		
		mSeekBarhue.setProgress(MID_VALUE);
		mSeekBarStaturation.setProgress(MID_VALUE);
		mSeekBarlum.setProgress(MID_VALUE);
		
		mImageView.setImageBitmap(mBitmap);
		
	}
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {

		switch (seekBar.getId()) {
		case R.id.seekbar_Hue:
			mHue = (progress - MID_VALUE) * 1.0f/MID_VALUE * 180 ;
			break;
		case R.id.seekbar_saturation:
			mStaturation = progress * 1.0f/MID_VALUE  ;		
			break;
		case R.id.seekbar_lum:
			mLum = progress * 1.0f/MID_VALUE  ;		
			break;
		default:
			break;
		}
		
		mImageView.setImageBitmap(ImageHelper.handlerImageEffect(mBitmap, mHue, mStaturation, mLum));
	}
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
}
