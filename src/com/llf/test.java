package com.llf;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
 
public class test extends Activity {
    /** Called when the activity is first created. */
	
/*	OnClickListener listener1 = null;*/

/*	Button Button01; */

	
	TextView tvb=null;
	EditText edt=null;
	EditText edt1=null;
	int a =1;
	
	
	static final int REQUEST_CODE = 1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tvb=(TextView) findViewById(R.id.tvbc);
        edt=(EditText) findViewById(R.id.EditText01);
        edt1=(EditText) findViewById(R.id.EditText02);
/*		listener1 = new OnClickListener() {
			public void onClick(View v) {
				Intent intent1 = new Intent(test.this, Activity2.class);
				intent1.putExtra("test", "数据来自test");
				startActivityForResult(intent1, REQUEST_CODE);
			}
		};*/
/*		setContentView(R.layout.main); */
/*		Button01 = (Button) findViewById(R.id.Button01);
		Button01.setOnClickListener(listener1);  */
        
        
    }
    public void denglu(View v) {
    	String str=edt.getText().toString();
    	String str1=edt1.getText().toString();
    	if (str.equals("2")&& str1.equals("2"))
    	{
    		tvb.setText("成功登陆服务器");
   	 	Intent intent3 = new Intent(test.this, Activity3.class);
/*			intent2.putExtra("test", "数据来自test");
			startActivityForResult(intent2, REQUEST_CODE);  */
    		startActivity(intent3);
    		Log.v("test","test正确");
    	 	
    	}
    	else if (str.equals("1")&& str1.equals("1"))
    	{
    	 	tvb.setText("成功登陆服务器");
   	 	Intent intent4 = new Intent(test.this, Activity2.class);
/*			intent2.putExtra("test", "数据来自test");
			startActivityForResult(intent2, REQUEST_CODE);  */
   	 a++;	
   	 	startActivity(intent4);
    		Log.v("random", a +"");
    		
    	 	
    	}
    	else
    	{
    	 	tvb.setText("密码或用户名错误");
    	 	
    	 	Log.v("random", "错误密码");
    	}
   
    }
    public void cancel(View v) {
    	this.finish();   
    }
    
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE) {
			if (resultCode == RESULT_CANCELED)
				setTitle("取消");
			else if (resultCode == RESULT_OK) {
				String temp=null;
				 Bundle extras = data.getExtras();
			        if (extras != null) {
			        	temp = extras.getString("store");
			        }
				setTitle(temp);
			}
		}
	}
}