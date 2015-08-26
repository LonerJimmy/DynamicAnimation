package com.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

public class demo4 extends View {

	
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    //mRotate--Ðý×ªµÄ½ÇËÙ¶È£»
    //n--Ô²µÄ¸öÊý
    //alpha--Í¸Ã÷¶È
    //x , y--Ïà¶ÔÓÚÖÐÐÄÔ­µã x y µÄ×ø±ê
    //radius--Ð¡Ô²µÄ°ë¾¶´óÐ¡
    //r--ÂÖÀªÔ²µÄ°ë¾¶´óÐ¡
    //t--ÖÐ¼ä±äÁ¿
    private float mRotate;
    int n = 12;        
    int alpha;        
    float x , y; 
    float radius;        
    float r;        
    float t;
    int vol = 10;
    
    private DisplayMetrics mDisplayMetrics = new DisplayMetrics();
    
    public demo4(Context context, AttributeSet set) {
        super(context,set);
        setFocusable(true);
        setFocusableInTouchMode(true);

        mPaint.setColor(Color.RED);
        WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
		wm.getDefaultDisplay().getMetrics(mDisplayMetrics);

    }

    @Override 
    protected void onDraw(Canvas canvas) {
    	super.onDraw(canvas);
		canvas.drawColor(Color.WHITE);

        //Paint paint = mPaint;
    	//»ñµÃÆÁÄ»µÄ´óÐ¡
		int width=canvas.getWidth();
		int height=canvas.getHeight();	
		//´óÔ²µÄ°ë¾¶£¬ÉèÎªÆÁÄ»µÄËÄ·ÖÖ®Ò»
		if (width >height){
			r = height/4;
		}else {
			r = width/4;
		}
		
		//Ðý×ª½ÇËÙ¶È£¬Ã¿´Î+1
        mRotate += 1;        
     
        //ÉèÖÃ»­²¼µÄÑÕÉ«Îª°×É«£¬½«Ô­µãÆ½ÒÆµ½ÆÁÄ»ÖÐ¼ä£¬»­²¼ÄæÊ±ÕëÐý×ª
        canvas.drawColor(Color.WHITE);
        canvas.translate(width/2,height/2);
        canvas.rotate(-mRotate);
        
        //forÑ­»·»­³ö12¸ö²»Í¬´óÐ¡ºÍÍ¸Ã÷¶ÈµÄÐ¡Ô²
        for (int i= 0; i < n; i++ ){
            //Log.e("onDraw","#####0");
            //Ð¡Ô²µÄÔ²ÐÄÎª×ø±êÎªx y£¬¾ùÔÈµÄ·Ö²¼ÔÚ´óÔ²µÄËÄÖÜ£¬
            
            x = (float) (r*Math.cos(30* Math.PI / 180*i));
            y = (float) (r*Math.sin(30* Math.PI / 180*i)); 
            
            //tÊÇÖÐ¼ä±äÁ¿£¬t=1-cos£¨-mRotate/10+Ã¿¸öÐ¡Ô²µÄ½Ç¶È£©
            t = (float) (1-Math.cos(-mRotate/vol+(30* Math.PI / 180*i)));
            //°ë¾¶ºÍÍ¸Ã÷¶È×÷ÎªtµÄº¯Êý£¬ËæÐý×ª½Ç¶ÈmRotate±ä»¯£¬tµÄÈ¡Öµ·¶Î§ÊÇ£¨0¡ª¡ª2£©£¬ÓàÏÒÇúÏß
            radius = t*r/18+10;//°ë¾¶µÄµÄ·¶Î§ÊÇ£¨10¡ª¡ª30£©£¬alphaµÄ·¶Î§ÊÇ£¨15¡ª¡ª255£©
            alpha = (int) (15+120*t);
            
            mPaint.setAlpha(alpha);
        	canvas.drawCircle(x,y ,radius, mPaint);

        }    
        invalidate();            
    }

}
