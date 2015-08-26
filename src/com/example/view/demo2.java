/**
 *
 */
package com.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
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
public class demo2 extends View
{
	private float R1=30;
	private float R2=30;
	private float h=30;//三角形圆心之间的距离
	private Paint paint = new Paint();
	private float mRotate;
	private float[] x=new float[4];
	private float[] y=new float[4];
	private float[] xx=new float[4];
	private float[] yy=new float[4];
	private float[] xxx=new float[4];
	private float[] yyy=new float[4];
	private float[] xxxx=new float[4];
	private float[] yyyy=new float[4];
	Path path = new Path();
	float count=0;
	float count_r=0;
	boolean flag=true;
	Matrix mtx=new Matrix();
    	
	public demo2(Context context, AttributeSet set)
	{
		super(context, set);
		
	}
	
	  public demo2(Context context) {
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
	  
	@Override
	// 重写该方法，进行绘图
	protected void onDraw(Canvas canvas)
	{
		canvas.drawColor(Color.BLACK);
		
		paint.setColor(Color.WHITE);
		paint.setStyle(Paint.Style.FILL);
		//paint.setStrokeWidth(4);
		
		int width=canvas.getWidth();
		int height=canvas.getHeight();		
				
		canvas.translate(width/2,height/2);
        canvas.rotate(mRotate);           
              
        mRotate=(float) (mRotate+0.2);
       
        draw_point(canvas);
        draw_path(canvas);
	    h+=0.4;
        R2-=0.1;
        R1+=0.1;
        
        if(R2<=0)
        {        	
        	h=30;
            R2=30;
            R1=30; 
            //System.out.println("mRote="+mRotate); 
            mRotate=0;
            
            draw_point(canvas);
        }
        path.reset();       
		invalidate();
				
	}	

		
	private void draw_point(Canvas canvas)
	{
		//中间三角形三个点
		
		 for(int i=0;i<3;i++)
	        {        	
	        	x[i]=(float) (R1*Math.cos((-30+120*i)*Math.PI/180));
	        	y[i]=(float) (R1*Math.sin((-30+120*i)*Math.PI/180));
	        }
	        
	        //右下角三角形三个点
	        xx[0]=(float)((h+R2)*Math.cos(30*Math.PI/180));
	    	yy[0]=(float) ((h+R2)*Math.sin(30*Math.PI/180));
	    	xx[1]=(float) (h*Math.cos(30*Math.PI/180));
	    	yy[1]=(float) (h/2-R2);
	    	xx[2]=(float) (xx[0]-Math.sqrt(3)*R2);
	    	yy[2]=(float) (yy[0]); 
	    	
	        //上面三角形三个点
	        xxx[0]=0;
	    	yyy[0]=(float) (-(h+R2));
	    	yyy[1]=(float)(-h+R2/2);
	    	xxx[1]=(float)(Math.sqrt(3)*R2/2);
	    	xxx[2]=-xxx[1];
	    	yyy[2]=yyy[1];
	    	
	    	
	    	//左下角三角形三个点
	        xxxx[0]=-xx[0];
	    	yyyy[0]=yy[0];
	    	xxxx[1]=-xx[1];
	    	yyyy[1]=yy[1];
	    	xxxx[2]=-xx[2];
	    	yyyy[2]=yy[2];  	
	}
	
	private void draw_path(Canvas canvas)
	{		  	        
	       
	        /*
	        for(int i=0;i<3;i++)
	        {        	
	        	xx[i]=(float) (2*R*Math.cos((-30-120*i+count)*Math.PI/180));
	        	yy[i]=(float) (2*R*Math.sin((-30-120*i+count)*Math.PI/180));
	        }*/

	        paint.setStyle(Paint.Style.FILL);
	        paint.setColor(Color.WHITE);
	        
		    path.moveTo(x[0],y[0]);
		    path.lineTo(x[1],y[1]);
		    //canvas.drawPath(path, paint);
		    
		    //path.moveTo(x[1],y[1]);
		    path.lineTo(x[2],y[2]);
		    //canvas.drawPath(path, paint);
		    
		    //path.moveTo(x[2],y[2]);
		    path.lineTo(x[0],y[0]);
		    canvas.drawPath(path, paint);
		    path.close();
		    //
		    path.moveTo(xx[0],yy[0]);
		    path.lineTo(xx[1],yy[1]);
		   // canvas.drawPath(path, paint);
		    
		    //path.moveTo(xx[1],yy[1]);
		    path.lineTo(xx[2],yy[2]);
		    //canvas.drawPath(path, paint);
		    
		   // path.moveTo(xx[2],yy[2]);
		    path.lineTo(xx[0],yy[0]);
		    canvas.drawPath(path, paint);	 
		    path.close();
		    //
		    path.moveTo(xxx[0],yyy[0]);
		    path.lineTo(xxx[1],yyy[1]);
		    //canvas.drawPath(path, paint);
		    
		    //path.moveTo(xxx[1],yyy[1]);
		    path.lineTo(xxx[2],yyy[2]);
		    //canvas.drawPath(path, paint);
		    
		    //path.moveTo(xxx[2],yyy[2]);
		    path.lineTo(xxx[0],yyy[0]);
		    canvas.drawPath(path, paint);
		    path.close();
		    //
		    path.moveTo(xxxx[0],yyyy[0]);
		    path.lineTo(xxxx[1],yyyy[1]);
		    //canvas.drawPath(path, paint);
		    
		    //path.moveTo(xxxx[1],yyyy[1]);
		    path.lineTo(xxxx[2],yyyy[2]);
		   // canvas.drawPath(path, paint);
		    
		    //path.moveTo(xxxx[2],yyyy[2]);
		    path.lineTo(xxxx[0],yyyy[0]);
		    canvas.drawPath(path, paint);   
		    path.close();
		    
		    
	}
		
	
}