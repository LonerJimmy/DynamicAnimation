package com.example.demos;

import android.app.Activity;
import android.os.Bundle;

import com.example.*;
import com.example.view.demo5;
import com.example.view.demo6;

/**
 * Description:
 * <br/>site: <a href="http://www.crazyit.org">crazyit.org</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class Demo6Activity extends Activity
{
	
	demo6 mView;
	
	@Override
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demo6);
		
	}
}