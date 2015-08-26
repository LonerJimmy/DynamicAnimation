package com.example.demos;

import com.example.view.demo1;
import com.example.view.demo2;
import com.example.view.demo3;
import com.example.view.demo4;
import com.example.view.demo5;
import com.example.view.demo6;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
    demo1 demoView1;
    demo2 demoView2;
    demo3 demoView3;
    demo4 demoView4;
    demo5 demoView5;
    demo6 demoView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        demoView1=(demo1)this.findViewById(R.id.demo1);        
        demoView3=(demo3)this.findViewById(R.id.demo2);
        demoView4=(demo4)this.findViewById(R.id.demo3);
        demoView5=(demo5)this.findViewById(R.id.demo4); 
        demoView2=(demo2)this.findViewById(R.id.demo5);   
        demoView6=(demo6)this.findViewById(R.id.demo6);   
    
        demoView1.setOnClickListener(new demo1.OnClickListener() {		  	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, Demo1Activity.class);
				startActivity(intent);
			}		
    });
  
    demoView2.setOnClickListener(new demo2.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, Demo2Activity.class);
				startActivity(intent);
			}		
    });
   
 demoView3.setOnClickListener(new demo3.OnClickListener() {		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, Demo3Activity.class);
			startActivity(intent);
		}		
});
 
 demoView4.setOnClickListener(new demo4.OnClickListener() {		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, Demo4Activity.class);
			startActivity(intent);
		}		
});

 demoView6.setOnClickListener(new demo1.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, Demo6Activity.class);
			startActivity(intent);
		}		
});

 demoView5.setOnClickListener(new demo5.OnClickListener() {		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, Demo5Activity.class);
			startActivity(intent);
		}		
});
        
  
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
