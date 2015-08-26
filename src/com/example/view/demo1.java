/**
 *
 */
package com.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class demo1 extends View
{
	private int N=36;
	private Paint paint = new Paint();
	private float mRotate;
    int n = 12;        
    int alpha;        
    float x , y; 
    float x1,y1;
    float radius;        
    float r;        
    int R;
    int width=0,height=0;
    float t1=6*R,t2=4*R,t3=2*R;
    float tt1=1,tt2=(float) 0.8,tt3=(float) 0.5;
    float t=0;
    boolean tt=true;
    
    int count=1;
    
    int restart=0;
	
	public demo1(Context context, AttributeSet set)
	{
		super(context, set);
		init(context);
	}
		
	  private void init(Context context) {
		// TODO Auto-generated method stub
		
	}
	 
	public demo1(Context context) {
          super(context);
          
      }
	  
	  public float calc_sin(int i,float r,int p)
	  {
		return (float) (r*Math.sin(p* Math.PI / 180*i));		  
	  }
	  
	  public float calc_cos(int i,float r,int p)
	  {
		return (float) (r*Math.cos(p* Math.PI / 180*i));		  
	  }
	  
	  public void draw(Canvas canvas,int pp,float r)
	  {	  
		  float r2=r;
		  for (int i= 0; i < 6; i++ ){
	            //Log.e("onDraw","#####0");
				   // r=120;
	          x = (float) calc_cos(i,r,60);//(r*Math.cos(60* Math.PI / 180*i));
	          y = (float) calc_sin(i,r,60); 	
	                
	          canvas.drawCircle(x,y,R, paint); 
	      }
		  
		  r2=(float) Math.sqrt(Math.pow(R,2)+Math.pow(Math.sqrt(3)/2*r, 2));
	      for(int i=0;i<20;i++)
	      {
	    	  if((i%pp)==0)
	    	  {
	    		  
	    	  }
	    	  else
	    	  {
	    	  x = (float) calc_cos(i,r2,60/pp);//(r*Math.cos(60* Math.PI / 180*i));
	          y = (float) calc_sin(i,r2,60/pp); 	
	                
	          canvas.drawCircle(x,y,R, paint); 
	    	  }
	      }
			
	  }
	  
		  
	@Override
	// 重写该方法，进行绘图
	protected void onDraw(Canvas canvas)
	{
		canvas.drawColor(Color.BLUE);
		paint.setColor(Color.WHITE);
		paint.setStyle(Paint.Style.STROKE);
		paint.setFlags(Paint.ANTI_ALIAS_FLAG);
		paint.setStrokeWidth(2);
		
		width=canvas.getWidth();
		height=canvas.getHeight();	
		if(R==0)
		{
			R=width/20;
			t1=6*R;t2=4*R;t3=2*R;
		}
					
		canvas.drawCircle(width/2, height/2, R, paint);
		
		canvas.translate(width/2,height/2);
        canvas.rotate(-mRotate);    
        
        draw(canvas,3,t1);
        draw(canvas,2,t2);
        draw(canvas,1,t3);         
        
        //t1大，t2中，t3小
       if(restart==0)
       {
         if(t3<=R)
         {
    	   if(t2>2*R)
    	   {
    		   t2-=tt2;
    		   t1-=tt1;
    	   }
    	   else
    	   {
    		   if(t1>3*R)
    			   t1-=tt1;
    		   else
    		   {
    			   restart=1;//都开始放大
    			  
    		   }
    	   }
         }
         else
         {
    	   t1-=tt1;
    	   t2-=tt2;
    	   t3-=tt3;
         }
       }
       else
       {
    	   if(t3>=2*R)
           {
      	   if(t2<4*R)
      	   {
      		   t2+=tt2;
      		   t1+=tt1;
      	   }
      	   else
      	   {
      		   if(t1<6*R)
      			   t1+=tt1;
      		   else
      		   {
      			 restart=0;//都开始缩小
      			 
      			   
      		   }
      	   }
           }
           else
           {
      	   t1+=tt1;
      	   t2+=tt2;
      	   t3+=tt3;
           }
       }
        /*
        if(t1<70)
        	t1=(float) (t1+0.5);
        if(t2<70)
        	t2=(float) (t2+0.495);
        if(t3<70)
        	t3=(float) (t3+0.49);
        
        if(t1>0)
        	t1=(float) (t1-0.5);
        if(t2>0)
        	t2=(float) (t2-0.495);
        if(t3>0)
        	t3=(float) (t3-0.49);    
        
        if(t1<70 && t2<70 && t3<70)
        {
        	t1=(float)(t1+0.5);
			t2=(float)(t2+0.495);
			t3=(float)(t3+0.490);
        }
        
        if(t1<70 && t2<70 && t3<70)
        {
        	t1=(float)(t1+0.5);
			t2=(float)(t2+0.495);
			t3=(float)(t3+0.490);
        }        
               
		if(t1==70 && t2<70 && t3<70)
		{
			t1=(float)(t1);
			t2=(float)(t2+0.495);
			t3=(float)(t3+0.490);
		}
		
		if(t1==70 && t2>70 && t3<70)
		{
			t1=(float)(t1);
			t2=(float)(t2);
			t3=(float)(t3+0.490);
		}
		
		if(t1==70 && t2>70 && t3>70)
		{
			t1=(float)(t1-0.5);
			t2=(float)(t2-0.495);
			t3=(float)(t3-0.49);
		}
		

		if(t1==0 && t2>0 && t3>0)
		{
			t1=(float)(t1);
			t2=(float)(t2-0.495);
			t3=(float)(t3-0.490);
		}
		
		if(t1==0 && t2<0 && t3>0)
		{
			t1=(float)(t1);
			t2=(float)(t2);
			t3=(float)(t3-0.490);
		}
		
		if(t1==0 && t2<0 && t3<0)
		{
			t1=(float)(t1+0.5);
			t2=(float)(t2+0.495);
			t3=(float)(t3+0.490);	
			
		}*/
      
		invalidate();
				
	}

	
}