package com.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

public class demo3 extends View {
	
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    int n = 12;
    int j =0;
    int alpha;        
    float x1 , y1 ,x2 ,y2; 
    float radius;        
    float r; 
    float t =0,t2=(float) 2.5;
    float r1,r2,r3,r4;
    float t1=10,tt=0;
    int vol = 10;
    
    int ringWidth,ringWidth1,ringWidth2,ringWidth3;
    
    private DisplayMetrics mDisplayMetrics = new DisplayMetrics();
    
    public demo3(Context context, AttributeSet set) {
        super(context,set);
        setFocusable(true);
        setFocusableInTouchMode(true);

        mPaint.setAntiAlias(true); 
        mPaint.setStyle(Style.STROKE);
        //mPaint.setARGB(255, 138, 43, 226);
        WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(mDisplayMetrics);

    }
    
    protected void onDrawOne(Canvas canvas, int angle){
		canvas.drawColor(Color.CYAN);
		
		t+=0.0625;
		if(t>=5){
			t=0;
		}
		t2+=0.0625;
		if(t2>=5){
			t2=0;
		}

    	//»ñµÃÆÁÄ»µÄ´óÐ¡
		int width=canvas.getWidth();
		int height=canvas.getHeight();	
		canvas.translate(width/2,height/2);
		
		float size = (float)width/(2*300);
		
		for(int i=0;i<12;i++){
			//Log.e("width",width+"");
			//mPaint.setAlpha((int) (200*t));
			mPaint.setAlpha(255);
			if (t<=3){
				mPaint.setAlpha((int) (t*255/3));
			}
			
			x1 = (float) ((56+6*t)*Math.sin((i*30-5*t/5f)*Math.PI/180))*size;
			y1 = (float) ((56+6*t)*Math.cos((i*30-5*t/5f)*Math.PI/180))*size;
			r=(5+t)*size;
			ringWidth =(int) ((2*t)*size);
			mPaint.setStrokeWidth(ringWidth);
			canvas.drawCircle(x1,y1, r-ringWidth/2, mPaint);
			
			mPaint.setAlpha(255);
			if (t2<=3){
				mPaint.setAlpha((int) (t2*255/3));
			}
			x2 = (float) ((56+6*t2)*Math.sin((i*30-5*t2/5f+15)*Math.PI/180))*size;
			y2 = (float) ((56+6*t2)*Math.cos((i*30-5*t2/5f+15)*Math.PI/180))*size;
			r=(5+t2)*size;
			ringWidth =(int) ((int) (2*t2)*size);
			mPaint.setStrokeWidth(ringWidth);
			canvas.drawCircle(x2,y2, r-ringWidth/2, mPaint);
			
		}
		for(int i=0;i<12;i++){
			mPaint.setAlpha(255);
			x1 = (float) ((86+8*t)*Math.sin((i*30-5-5*t/5f)*Math.PI/180))*size;
			y1 = (float) ((86+8*t)*Math.cos((i*30-5-5*t/5f)*Math.PI/180))*size;
			r=(10+t)*size;
			ringWidth =(int) ((12+t)*size);
			mPaint.setStrokeWidth(ringWidth);
			canvas.drawCircle(x1,y1, r-ringWidth/2, mPaint);
			
			mPaint.setAlpha(255);
			x2 = (float) ((86+8*t2)*Math.sin((i*30-5-5*t2/5f+15)*Math.PI/180))*size;
			y2 = (float) ((86+8*t2)*Math.cos((i*30-5-5*t2/5f+15)*Math.PI/180))*size;
			r=(10+t2)*size;
			ringWidth =(int) ((12+t2)*size);
			mPaint.setStrokeWidth(ringWidth);
			canvas.drawCircle(x2,y2, r-ringWidth/2, mPaint);
			
		}
		
		for(int i=0;i<12;i++){
			//mPaint.setAlpha((int) (210-30*t));
			mPaint.setAlpha(255);
			x1 = (float) ((126+10*t)*Math.sin((i*30-10-5*t/5f)*Math.PI/180))*size;
			y1 = (float) ((126+10*t)*Math.cos((i*30-10-5*t/5f)*Math.PI/180))*size;
			r=(15+t)*size;
			ringWidth =(int) ((15-t)*size);
			mPaint.setStrokeWidth(ringWidth);
			canvas.drawCircle(x1,y1, r-ringWidth/2, mPaint);
			
			mPaint.setAlpha(255);			
			x2 = (float) ((126+10*t2)*Math.sin((i*30-10-5*t2/5f+15)*Math.PI/180))*size;
			y2 = (float) ((126+10*t2)*Math.cos((i*30-10-5*t2/5f+15)*Math.PI/180))*size;
			r=(15+t2)*size;
			ringWidth =(int) ((15-t2)*size);
			
			mPaint.setStrokeWidth(ringWidth);
			canvas.drawCircle(x2,y2, r-ringWidth/2, mPaint);
			
		}
		
		for(int i=0;i<12;i++){

			mPaint.setAlpha(255);
			if (t>=3){
				mPaint.setAlpha((int) ((5-t)/2*254));
			}
			
			x1 = (float) ((176+11*t)*Math.sin((i*30-15-5*t/5f)*Math.PI/180))*size;
			y1 = (float) ((176+11*t)*Math.cos((i*30-15-5*t/5f)*Math.PI/180))*size;
			r=(20+t)*size;
			ringWidth =(int) ((10-2*t)*size);
			mPaint.setStrokeWidth(ringWidth);
			canvas.drawCircle(x1,y1, r-ringWidth/2, mPaint);
			
			mPaint.setAlpha(255);
			if (t2>=3){
				mPaint.setAlpha((int) ((5-t2)/2*254));
			}
			
			x2 = (float) ((176+10*t2)*Math.sin((i*30-15-5*t2/5f+15)*Math.PI/180))*size;
			y2 = (float) ((176+10*t2)*Math.cos((i*30-15-5*t2/5f+15)*Math.PI/180))*size;
			r=(20+t2)*size;
			ringWidth =(int) ((10-2*t2)*size);
			
			mPaint.setStrokeWidth(ringWidth);
			canvas.drawCircle(x2,y2, r-ringWidth/2, mPaint);
			
		}
				 
		invalidate();
    	
    }
    
    @Override 
    protected void onDraw(Canvas canvas) {
    	super.onDraw(canvas);

    	onDrawOne(canvas,0);    
    }
        
    /* ¸ù¾ÝÊÖ»úµÄ·Ö±æÂÊ´Ó dp µÄµ¥Î» ×ª³ÉÎª px(ÏñËØ) */  
    public static int dip2px(Context context, double d) {  
     final float scale = context.getResources().getDisplayMetrics().density;  
     return (int) (d * scale + 0.5f);  
    }  

}
