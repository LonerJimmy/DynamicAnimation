/**
 *
 */
package com.example.view;

import android.content.Context;
import android.util.Log; 
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
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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
public class demo6 extends View
{
	
	//private Handler viewHandler2 = new ViewHandler2(this);
	private static final int MSG_DRAW = 0;
	private boolean bShow = false;
	private float width=0;
	private float height=0;
	Paint paint=new Paint();
	private float x=0,y=0;
	//Path path1,path2,path3,path4,path5,path6,path7,path8;
	Path path=new Path();
	
	  //path7=new Path();
	  //path8=new Path();
	private float centerX=0,centerY=0;
	private float R;
	private float r=0;
	private double mRote=0;
	private double mRote2=0;
	private double mRote3=0;
	private double mRote4=0;

	private int who;
	//private circle[] center;
	private boolean isR=true;
	//private boolean isForth=false;
	
	private int level=1;//level=1,第一层；level=2，第二层。。。。。    
	
	public demo6(Context context, AttributeSet set)
	{
		super(context, set);
		init();
	}
	
	  public demo6(Context context) {
          super(context);
          
      }
	  
	  private void init() {
		// TODO Auto-generated method stub
		  who=0;
		  R=0;
		  paint.setColor(Color.WHITE);
		  paint.setStyle(Paint.Style.STROKE);
		  paint.setStrokeWidth(2);
		  //start(true);
		  //center=new circle[50];	
	}
/*
		public final void start(boolean show)
		{
			bShow = show;
			if (bShow) {
				viewHandler2.sendEmptyMessage(MSG_DRAW);
			}
		}*/
	@Override
	// 重写该方法，进行绘图
	protected void onDraw(Canvas canvas)
	{
		canvas.drawColor(Color.GREEN);
		width=canvas.getWidth();
		height=canvas.getHeight();		
        
		canvas.translate(width/2,height/2);
		if(R==0)
		{
		R=width/3;		
		}
				
		switch(level)
		{
		case 1:
		draw_rect(0,0,R,Math.PI/6,canvas,path);        
		draw_rect(0,0,R,Math.PI/6+mRote,canvas,path);
		Log.v(demo6.VIEW_LOG_TAG,"mRote="+mRote); 
		//Log.e("rect="+mRote, null);
		break;
		case 2:	
			r=R/3;
			draw_rect(0,0,R,Math.PI/6,canvas,path);        
			draw_rect(0,0,R,Math.PI/6+mRote,canvas,path);
			
			draw_six_rect(0,0,R,r,mRote2,canvas,path);
			Log.v(demo6.VIEW_LOG_TAG,"mRote2="+mRote2); 
			//draw_six_rect2(0,0,R,r,mRote2,canvas,path);
			break;
		case 3:
			draw_rect(0,0,R,Math.PI/6,canvas,path);        
			draw_rect(0,0,R,Math.PI/6+mRote,canvas,path);
			
			draw_six_rect(0,0,R,r,mRote2,canvas,path);
			draw_third(R/9,-mRote3,canvas,path);
			
			Log.v(demo6.VIEW_LOG_TAG,"mRote3="+mRote3); 
			break;
		case 4:	
			
			draw_rect(0,0,R,Math.PI/6,canvas,path);        
			draw_rect(0,0,R,Math.PI/6+mRote,canvas,path);
			
			draw_six_rect(0,0,R,r,mRote2,canvas,path);
			draw_third(R/9,-mRote3,canvas,path);
			
			Log.v(demo6.VIEW_LOG_TAG,"mRote4="+mRote4); 
			//draw_forth(R/27,-mRote4,canvas,path);
			
			draw_forth(R/27,-mRote4,canvas,path);
			break;
		}
	
		if(isR)
		{
		if(level==1)
		{
			if(mRote>(Math.PI/3))
			{
				mRote=(float) (Math.PI/3);
				level++;
			}
			else
			{
				mRote+=0.01*Math.PI;
			}
		}
		if(level==2)
			{
				if(mRote2>Math.PI/3)
				{
				mRote2=(float) (Math.PI/3);
				level++;
				}
				else
				{
					mRote2+=0.01*Math.PI;
				}
			}
		
		if(level==3)
		{
			if(mRote3>Math.PI/3)
			{
			mRote3=(float) (Math.PI/3);
			level++;
			//isForth=true;
			}
			else
			{
				mRote3+=0.01*Math.PI;
			}
		}
		
		if(level==4)
		{
			if(mRote4>Math.PI/3)
			{
			mRote4=(float) (Math.PI/3);
			isR=false;
			level=4;
			//isForth=false;
			}
			else
			{
				mRote4+=0.1*Math.PI;
			}
		}
			
		}
		else
		{
			if(level==1)
			{
				if(mRote<0)
				{
					mRote4=0;
					isR=true;
					level=1;
				}
				else
				{
					mRote-=0.01*Math.PI;
				}
			}
			if(level==2)
				{
					if(mRote2<0)
					{
					mRote2=0;
					level--;
					}
					else
					{
						mRote2-=0.01*Math.PI;
					}
				}
			
			if(level==3)
			{
				if(mRote3<0)
				{
				mRote3=0;
				level--;
				}
				else
				{
					mRote3-=0.01*Math.PI;
				}
			}
			
			if(level==4)
			{
				if(mRote4<0)
				{
				mRote4=0;
				//isR=false;
				level--;
				}
				else
				{
					mRote4-=0.1*Math.PI;
				}
			}
		}
		//path.reset();
		canvas.restore();
		invalidate();
      				
	}
	
	private void draw_forth(float r, double mRote, Canvas canvas,Path path) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<6;i++)
		{
			centerX=(float) ((R-R/9)*Math.cos(Math.PI/6+i*2*Math.PI/6));
			centerY=(float) ((R-R/9)*Math.sin(Math.PI/6+i*2*Math.PI/6));
			//draw_six_rect(centerX,centerY,R/9,r,0,canvas,path);
			draw_six_rect(centerX,centerY,R/9,r,-mRote,canvas,path);	
		}
		
		for(int i=0;i<6;i++)
		{
			centerX=(float) ((4*R/9)*Math.cos(Math.PI/6+i*2*Math.PI/6));
			centerY=(float) ((4*R/9)*Math.sin(Math.PI/6+i*2*Math.PI/6));
			//draw_six_rect(centerX,centerY,R/9,r,0,canvas,path);
			draw_six_rect(centerX,centerY,R/9,r,-mRote,canvas,path);	
		}
		
		//Math.atan(Math.sqrt(3)/9);
		
		for(int i=0;i<6;i++)
		{
			centerX=(float) ((R*2*Math.sqrt(7)/9)*Math.cos(Math.atan(Math.sqrt(3)/9)+i*2*Math.PI/6));
			centerY=(float) ((R*2*Math.sqrt(7)/9)*Math.sin(Math.atan(Math.sqrt(3)/9)+i*2*Math.PI/6));
			//draw_six_rect(centerX,centerY,R/9,r,0,canvas,path);
			draw_six_rect(centerX,centerY,R/9,r,-mRote,canvas,path);	
		}
		
		for(int i=0;i<6;i++)
		{
			centerX=(float) ((R*Math.sqrt(28)/9)*Math.cos(Math.atan(Math.sqrt(3)*2/3)+i*2*Math.PI/6));
			centerY=(float) ((R*Math.sqrt(28)/9)*Math.sin(Math.atan(Math.sqrt(3)*2/3)+i*2*Math.PI/6));
			//draw_six_rect(centerX,centerY,R/9,r,0,canvas,path);
			draw_six_rect(centerX,centerY,R/9,r,-mRote,canvas,path);	
		}
		
		for(int i=0;i<6;i++)
		{
			centerX=(float) ((R*Math.sqrt(52)/9)*Math.cos(Math.atan(Math.sqrt(3)*5/9)+i*2*Math.PI/6));
			centerY=(float) ((R*Math.sqrt(52)/9)*Math.sin(Math.atan(Math.sqrt(3)*5/9)+i*2*Math.PI/6));
			//draw_six_rect(centerX,centerY,R/9,r,0,canvas,path);
			draw_six_rect(centerX,centerY,R/9,r,-mRote,canvas,path);	
		}
		
		for(int i=0;i<6;i++)
		{
			centerX=(float) ((R*Math.sqrt(52)/9)*Math.cos(Math.atan(Math.sqrt(3)/6)+i*2*Math.PI/6));
			centerY=(float) ((R*Math.sqrt(52)/9)*Math.sin(Math.atan(Math.sqrt(3)/6)+i*2*Math.PI/6));
			//draw_six_rect(centerX,centerY,R/9,r,0,canvas,path);
			draw_six_rect(centerX,centerY,R/9,r,-mRote,canvas,path);	
		}
		path.reset();
		
	}


	private void draw_third(float r,double mRote,Canvas canvas,Path path) {
		// TODO Auto-generated method stub
		//画第一个三角形中的三个三角形
		//draw_six_rect(R/3,r,mRote,canvas);	
		centerX=(float) ((R-R/3)*Math.cos(Math.PI/6));
		centerY=(float) ((R-R/3)*Math.sin(Math.PI/6));
		//draw_six_rect(centerX,centerY,R/3,r,0,canvas,path);
		draw_six_rect(centerX,centerY,R/3,r,-mRote,canvas,path);
		
		//画第二个三角形中的三个三角形
		centerX=(float) ((R-R/3)*Math.cos(Math.PI/2));
		centerY=(float) ((R-R/3)*Math.sin(Math.PI/2));
		//draw_six_rect(centerX,centerY,R/3,r,0,canvas,path);
		draw_six_rect(centerX,centerY,R/3,r,mRote,canvas,path);
		
		centerX=(float) ((R-R/3)*Math.cos(Math.PI*5/6));
		centerY=(float) ((R-R/3)*Math.sin(Math.PI*5/6));
		//draw_six_rect(centerX,centerY,R/3,r,0,canvas,path);
		draw_six_rect(centerX,centerY,R/3,r,-mRote,canvas,path);
		
		centerX=(float) ((R-R/3)*Math.cos(Math.PI*7/6));
		centerY=(float) ((R-R/3)*Math.sin(Math.PI*7/6));
		//draw_six_rect(centerX,centerY,R/3,r,0,canvas,path);
		draw_six_rect(centerX,centerY,R/3,r,-mRote,canvas,path);
		
		centerX=(float) ((R-R/3)*Math.cos(Math.PI*3/2));
		centerY=(float) ((R-R/3)*Math.sin(Math.PI*3/2));
		//draw_six_rect(centerX,centerY,R/3,r,0,canvas,path);
		draw_six_rect(centerX,centerY,R/3,r,mRote,canvas,path);

		centerX=(float) ((R-R/3)*Math.cos(Math.PI*11/6));
		centerY=(float) ((R-R/3)*Math.sin(Math.PI*11/6));
		//draw_six_rect(centerX,centerY,R/3,r,0,canvas,path);
		draw_six_rect(centerX,centerY,R/3,r,-mRote,canvas,path);
		
		
	}
	

	private void draw_rect(float x,float y,float r,double d,Canvas canvas,Path path)
	{
		//Path path1=new Path();
		path.moveTo((float) (x+r*Math.cos(d+4*Math.PI/3)),(float) (y+r*Math.sin(d+4*Math.PI/3)));
		path.lineTo((float) (x+r*Math.cos(d)),(float) (y+r*Math.sin(d)));
		path.lineTo((float) (x+r*Math.cos(d+2*Math.PI/3)), (float) (y+r*Math.sin(d+2*Math.PI/3)));
		path.lineTo((float)(x+r*Math.cos(d+4*Math.PI/3)),(float) (y+r*Math.sin(d+4*Math.PI/3)));
		canvas.drawPath(path, paint);
		path.reset();
	}

	
	
	private void draw_six_rect(float centerX,float centerY,float R,float r,double mRote,Canvas canvas,Path path)//x，y为大三角形圆心的横纵坐标
	{
		x=(float) ((R-r)*Math.cos(Math.PI/6));
		y=(float) ((R-r)*Math.sin(Math.PI/6));
		//draw_rect(centerX+x,centerY+y,r,Math.PI/6,canvas,path);
		draw_rect(centerX+x,centerY+y,r,Math.PI/6-mRote,canvas,path);
		
		x=(float) ((R-r)*Math.cos(Math.PI/2));
		y=(float) ((R-r)*Math.sin(Math.PI/2));
		//draw_rect(centerX+x,centerY+y,r,Math.PI/2,canvas,path);
		draw_rect(centerX+x,centerY+y,r,Math.PI/2+mRote,canvas,path);
		
		x=(float) ((R-r)*Math.cos(Math.PI*5/6));
		y=(float) ((R-r)*Math.sin(Math.PI*5/6));
		//draw_rect(centerX+x,centerY+y,r,Math.PI*5/6,canvas,path);
		draw_rect(centerX+x,centerY+y,r,Math.PI*5/6-mRote,canvas,path);
		
		x=(float) ((R-r)*Math.cos(Math.PI*7/6));
		y=(float) ((R-r)*Math.sin(Math.PI*7/6));
		//draw_rect(centerX+x,centerY+y,r,Math.PI*7/6,canvas,path);
		draw_rect(centerX+x,centerY+y,r,Math.PI*7/6-mRote,canvas,path);
		
		x=(float) ((R-r)*Math.cos(Math.PI*3/2));
		y=(float) ((R-r)*Math.sin(Math.PI*3/2));
		//draw_rect(centerX+x,centerY+y,r,Math.PI*3/2,canvas,path);
		draw_rect(centerX+x,centerY+y,r,Math.PI*3/2+mRote,canvas,path);
		
		x=(float) ((R-r)*Math.cos(Math.PI*11/6));
		y=(float) ((R-r)*Math.sin(Math.PI*11/6));
		//draw_rect(centerX+x,centerY+y,r,Math.PI*11/6,canvas,path);
		//path.reset();
		draw_rect(centerX+x,centerY+y,r,Math.PI*11/6-mRote,canvas,path);
		
	}
	

	
}