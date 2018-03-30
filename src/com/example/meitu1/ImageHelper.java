package com.example.meitu1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * 图像处理工具类
 * @author jiangqianghua
 *
 */
public class ImageHelper {
	// 图像颜色调节													色相                             饱和度                                 亮度						
	public static Bitmap handlerImageEffect(Bitmap bm , float hue ,float saturation , float lum){
		
		Bitmap bmp = Bitmap.createBitmap(bm.getWidth(),bm.getWidth(),Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bmp);
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		
		// 设置色相
		ColorMatrix hueMatrix = new ColorMatrix();
		hueMatrix.setRotate(0, hue);
		hueMatrix.setRotate(1, hue);
		hueMatrix.setRotate(2, hue);
		// 设置饱和度
		ColorMatrix saturationMatrix = new ColorMatrix();
		saturationMatrix.setSaturation(saturation);
		//设置亮度
		ColorMatrix lumMatrix = new ColorMatrix();
		lumMatrix.setScale(lum, lum, lum, 1);
		
		//把三个设置统一
		ColorMatrix imageMatrix = new ColorMatrix();
		imageMatrix.postConcat(hueMatrix);
		imageMatrix.postConcat(saturationMatrix);
		imageMatrix.postConcat(lumMatrix);
		paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
		canvas.drawBitmap(bm, 0, 0, paint);
		
		return bmp ;
	}
	/**
	 * 底片处理
	 * @param bm
	 * @return
	 */
	public static Bitmap handlerImageNegative(Bitmap bm)
	{
		int width = bm.getWidth() ; 
		int height = bm.getHeight() ;
		
		int color ;
		int r, g , b , a ;
		Bitmap bmp = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
		
		// 获取像素点
		int[] oldPx = new int[width*height];
		int[] newPx = new int[width*height];
		bm.getPixels(oldPx, 0, width, 0, 0, width, height);
		
		// 改变像素点
		for(int i = 0 ; i < width * height ; i++)
		{
			color = oldPx[i];
			r = Color.red(color);
			g = Color.green(color);
			b = Color.blue(color);
			a = Color.alpha(color);
			
			r = 255 - r ; 
			g = 255 - g ; 
			b = 255 - b ;
			
			r = checkRGB(r);
			g = checkRGB(g);
			b = checkRGB(b);
			
			newPx[i] = Color.argb(a, r, g, b);
		}
		bmp.setPixels(newPx, 0, width, 0, 0, width, height);
		return bmp ;
	}
	
	/**
	 * 复古处理
	 * @param bm
	 * @return
	 */
	public static Bitmap handlerImageRetro(Bitmap bm)
	{
		int width = bm.getWidth() ; 
		int height = bm.getHeight() ;
		
		int color ;
		int r, g , b , a , r1, g1 ,b1;
		Bitmap bmp = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
		
		// 获取像素点
		int[] oldPx = new int[width*height];
		int[] newPx = new int[width*height];
		bm.getPixels(oldPx, 0, width, 0, 0, width, height);
		
		// 改变像素点
		for(int i = 0 ; i < width * height ; i++)
		{
			color = oldPx[i];
			r = Color.red(color);
			g = Color.green(color);
			b = Color.blue(color);
			a = Color.alpha(color);
			
			r1 = (int)(0.393 * r + 0.769 * g + 0.189 *b );
			g1 = (int)(0.349 * r + 0.686 * g + 0.168 *b );
			b1 = (int)(0.272 * r + 0.534 * g + 0.131 *b );
			
			r1 = checkRGB(r1);
			g1 = checkRGB(g1);
			b1 = checkRGB(b1);
			
			newPx[i] = Color.argb(a, r1, g1, b1);
		}
		bmp.setPixels(newPx, 0, width, 0, 0, width, height);
		return bmp ;
	}
	
	/**
	 * 浮雕处理
	 * @param bm
	 * @return
	 */
	public static Bitmap handlerImagePixlsRelief(Bitmap bm)
	{
		int width = bm.getWidth() ; 
		int height = bm.getHeight() ;
		
		int color , beforColor;
		int r, g , b , a , r1, g1 ,b1;
		Bitmap bmp = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
		
		// 获取像素点
		int[] oldPx = new int[width*height];
		int[] newPx = new int[width*height];
		bm.getPixels(oldPx, 0, width, 0, 0, width, height);
		
		// 改变像素点
		for(int i = 1 ; i < width * height ; i++)
		{
			
			// 取出上一个值
			beforColor = oldPx[i-1];
			
			r = Color.red(beforColor);
			g = Color.green(beforColor);
			b = Color.blue(beforColor);
			a = Color.alpha(beforColor);
			
			// 取出当前值
			color = oldPx[i];
			r1 = Color.red(color);
			g1 = Color.green(color);
			b1 = Color.blue(color);
			
			
			r = (r - r1 +127);
			g = (g - g1 +127);
			b = (b - b1 +127);
			
			
			r = checkRGB(r);
			g = checkRGB(g);
			b = checkRGB(b);
			
			newPx[i] = Color.argb(a, r, g, b);
		}
		bmp.setPixels(newPx, 0, width, 0, 0, width, height);
		return bmp ;
	}
	
	private static  int checkRGB(int rgb)
	{
		if(rgb > 255)
		{
			rgb = 255 ;
		}
		else if(rgb < 0)
		{
			rgb = 0 ;
		}
		
		return rgb ;
	}
}
