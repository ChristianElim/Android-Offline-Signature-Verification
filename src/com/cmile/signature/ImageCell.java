package com.cmile.signature;

import android.graphics.Bitmap;

public class ImageCell {
	private static final int PIXEL_X=0;
	private static final int PIXEL_Y=1;
	

	private int[] xPixels;
	private int[] yPixels;
	private int[] centerOfGravity;
	private float x;
	private float y;
	private float height;
	private float width;
	
	
	public ImageCell(Bitmap bitmap){
		
		
		//discretize the image into data
	
		discretize(bitmap);
		
	}
	
	
	private void discretize(Bitmap bitmap){
		x =0;
		 y=0;
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		
		int index=0;
		
		//get positions off all black pixels
		for(int x = 0; x < width; x++){
			
			for(int y = 0; y< height; y++){
				
				if(bitmap.getPixel(x, y) == 0){
					xPixels[index]= x;
					yPixels[index] = y;
					index++;
				}
			}
			
			
		}
		
		
		
		//get center of gravity
		
		int centerX=0;
		int centerY=0;
		
		
		for(int i = 0 ; i < xPixels.length; i++){
			centerX += xPixels[i];
		}
		centerX = centerX/xPixels.length;
		
		
		for(int j = 0 ; j < yPixels.length;j++){
			centerY += yPixels[j];
		}
		centerY = centerY/xPixels.length;
		
		centerOfGravity[0] = centerX;
		centerOfGravity[1] = centerY;
		
	}
	
	
	
	
	
	public ImageCell(int[] xPixels, int[] yPixels, float x, float y,
			float height, float width) {
		super();
		this.xPixels = xPixels;
		this.yPixels = yPixels;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}






	public int[] getxPixels() {
		return xPixels;
	}


	public void setxPixels(int[] xPixels) {
		this.xPixels = xPixels;
	}


	public int[] getyPixels() {
		return yPixels;
	}


	public void setyPixels(int[] yPixels) {
		this.yPixels = yPixels;
	}


	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public float getHeight() {
		return height;
	}
	public float getWidth() {
		return width;
	}


	public int[] getCenterOfGravity() {
		return centerOfGravity;
	}
	
	
	
	
	
}
