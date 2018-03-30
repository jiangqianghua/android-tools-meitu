package com.example.meitu1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

public class ColorMatrixActivity extends Activity {

	private ImageView mImageView ;
	private GridLayout mGroup ; 
	private Bitmap bitmap  ;
	private EditText[] mEts = new EditText[20];
	private float[] mColorMatrix = new float[20];
	
	private int mEtWidth , mEtHeight ; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.colormatrix);
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		
		mImageView = (ImageView) findViewById(R.id.imageview);
		mGroup = (GridLayout) findViewById(R.id.gridView);
		mImageView.setImageBitmap(bitmap);
		
		// 获取控件宽高
		mGroup.post(new Runnable() {
			
			@Override
			public void run() {
				mEtWidth = mGroup.getWidth()/5;
				mEtHeight = mGroup.getHeight()/4 ;
				addEts();
				initMartix();
			}
		});
	}
	
	private void addEts(){
		for(int i = 0 ; i < 20 ; i++)
		{
			EditText editText = new EditText(ColorMatrixActivity.this);
			mGroup.addView(editText, mEtWidth, mEtHeight);
			mEts[i] = editText ;
		}
	}
	
	private void initMartix()
	{
		for(int i = 0 ; i < 20 ; i++)
		{
			if(i % 6 == 0)
			{
				mEts[i].setText(String.valueOf(1));
			}
			else
			{
				mEts[i].setText(String.valueOf(0));
			}
		}
	}
	
	private void getMatrix()
	{
		for(int i = 0 ; i < 20 ; i++)
		{
			mColorMatrix[i] =Float.valueOf(mEts[i].getText().toString());
			
		}
	}
	
	private void setImageMartix()
	{
		Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight() , Bitmap.Config.ARGB_8888);
		ColorMatrix colorMatrix = new ColorMatrix();
		colorMatrix.set(mColorMatrix);
		Canvas canvas = new Canvas(bmp);
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
		canvas.drawBitmap(bitmap,0,0,paint);
		mImageView.setImageBitmap(bmp);
	}
	
	public void btnChange(View view)
	{
		getMatrix();
		setImageMartix();
	}
	
	public void btnReset(View view)
	{
		initMartix();
		getMatrix();
		setImageMartix();
		
	}
}
