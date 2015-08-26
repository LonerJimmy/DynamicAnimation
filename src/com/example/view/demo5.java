package com.example.view;


import com.example.demos.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class demo5 extends View {
	private static final int MSG_DRAW_SPIRAL = 0;
//	private DisplayMetrics mDisplayMetrics = new DisplayMetrics();
	//private Handler viewHandler = new ViewHandler(this);
	private boolean bShow = false;
	
	private int numFrames = 120;
	private int background = 0xFFA57FAE;
	private int objectColor = 0xffffffff;
	private int maxRadius = 50;
	private int space = 200;
	private int diffuse = 650;
	private int count = 200, smallCount = 10;
	private float delta;
	private int width;
	private int height;
	
	private boolean shadow;
	private float factor, d;
	private Paint mPaint;
	private int frameCount = 0;

	public demo5(Context context) {
		super(context);
		init(context);
	}

	public demo5(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		// Load attributes
//		((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(mDisplayMetrics);

		mPaint = new Paint();

		//width = this.getResources().getDimensionPixelSize(R.dimen.spiral_view_width);
		//height = this.getResources().getDimensionPixelSize(R.dimen.spiral_view_height);
		frameCount = 1;

		mPaint.setAntiAlias(true);
		//start(true);
	}

	public final void start(boolean show)
	{
		bShow = show;
		if (bShow) {
			//viewHandler.sendEmptyMessage(MSG_DRAW_SPIRAL);
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.save();
		float temp = frameCount-1;
		
		int w=canvas.getWidth();
		int h=canvas.getHeight();
		if(width==0)
			width=w;
		if(height==0)
			height=h;
		if(maxRadius==0)
			maxRadius=50*(width/10);
		
		
		if (temp < 0) {
			temp = 0;
		} else if (temp > numFrames) {
			temp = numFrames;
			frameCount = 0;
		}
		delta = temp / (float)(numFrames);
		drawSpiral(canvas);
		frameCount++;
		canvas.restore();
		invalidate();
	}

	void spiral(Canvas canvas) {
		canvas.save();
		canvas.translate((float) (width/2), (float) (height/2));
		canvas.rotate(-(float)Math.toDegrees(Math.PI/2));
		for (int i=0; i<count; i++) {
			canvas.save();
			float scale = (float)(.9*Math.exp(-.052*(i-smallCount*delta)));
			canvas.scale(scale, scale);
			canvas.rotate((float)Math.toDegrees(Math.PI*2*i/(smallCount+.5)+Math.PI*2*delta/(2*smallCount+1)));
			factor = 0;
			if (i<2*smallCount) {
				factor = (float)(delta + .5 - i/((float)(smallCount)));
				factor = 2*factor;
				if (factor < 0) {
					factor = 0;
				} else if (factor > 1) {
					factor = 1;
				}
				factor = (float)Math.pow(factor, 3.5);
			}
			
			canvas.translate(diffuse*factor, 0);
			d = maxRadius*(float)Math.exp(-.75*factor);
			if (shadow)
				d*=1.05;
//			Log.e("", "####factor:"+factor+",d:"+d);
			canvas.drawCircle(space, 0, d, mPaint);
			canvas.restore();
		}
		canvas.restore();
	}

	void drawSpiral(Canvas canvas) {
		mPaint.setColor(background);
		mPaint.setStyle(Paint.Style.FILL);
		canvas.drawRect(0, 0, width, height, mPaint);
		
//		shadow = true;
//		canvas.save();
//		canvas.translate(2, 2.5f);
//		spiral(canvas);
//		canvas.restore();

		shadow = false;
		mPaint.setColor(objectColor);
		spiral(canvas);
	}

	/*private static class ViewHandler extends Handler
	{
		private demo5 mFingertipView;

		public ViewHandler(demo5 view)
		{
			super();
			mFingertipView = view;
		}

		public final void handleMessage(Message msg)
		{

			switch (msg.what)
			{
			case MSG_DRAW_SPIRAL:
				if(!mFingertipView.bShow || mFingertipView.getVisibility() != View.VISIBLE) {
					return;
				}
				mFingertipView.invalidate();
				this.sendEmptyMessageDelayed(MSG_DRAW_SPIRAL, 35L);
				break;

			default:
				break;
			}
		}
	}*/
}
