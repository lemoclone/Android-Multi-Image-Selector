package com.orangekit.multiimageselector;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

public class BitmapWorkerTask extends AsyncTask<String, Void, Bitmap> {
	
	private final WeakReference<ImageView> imageViewReference;
	
    public BitmapWorkerTask(ImageView imageView) {        
    	// Use a WeakReference to ensure the ImageView can be garbage collected        
    	imageViewReference = new WeakReference<ImageView>(imageView);  
    //	Log.d("BitmapWorkerTask construction","step in-----------------");
    	}
    
	@Override
	protected Bitmap doInBackground(String... params) {
		//Log.d("BitmapWorkerTask doInBackground","step in-----------------");
		final BitmapFactory.Options options = new BitmapFactory.Options();    
		
		options.inJustDecodeBounds = true;  
		options.inSampleSize = 2;
		BitmapFactory.decodeFile(params[0], options);
		
		int ratioH = options.outHeight/32 > 0 ? options.outHeight/32:1;
		int ratioW = options.outWidth/32 > 0 ? options.outWidth/32:1;
		options.inSampleSize = (ratioH > ratioW ? ratioH:ratioW);  
 	   
		options.inJustDecodeBounds = false;	
	//	Log.e("UtFile_calculateInSampleSize","ratioH is: " + ratioH
	//			+ "ratioW is: " + ratioW);	 
		return BitmapFactory.decodeFile(params[0], options);
	}
    
    // Once complete, see if ImageView is still around and set bitmap.    
    @Override    
    protected void onPostExecute(Bitmap bitmap) { 
    //	Log.d("BitmapWorkerTask onPostExecute","step in-----------------");
    	if (imageViewReference != null && bitmap != null) {            
    		final ImageView imageView = imageViewReference.get();            
    		if (imageView != null) {                
    			imageView.setImageBitmap(bitmap);            
    			}        
    		}    
    	}   
    }