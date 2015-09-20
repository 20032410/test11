package com.llf;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class Activity2 extends Activity {
	OnClickListener listener = null;
	private TextView textview1=null;
	private Button button10=null;
	Button button;
	String uriApi = "http://m.touzhu.cn/ex_jc.aspx?state=0&ifgetclass=1";
//	String uriApi ="http://www.weather.com.cn/adat/cityinfo/101010100.html";
//	String uriApi ="101010100.html";
	
	private String result =null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        textview1=(TextView)findViewById(R.id.textView1);
        listener = new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		};
		button = (Button) findViewById(R.id.button4);
		button.setOnClickListener(listener);
		button10=(Button)findViewById(R.id.button10);
		button10.setOnClickListener((OnClickListener) new ButtonListener());
		setTitle("现在是在test1里");
		

	//	textview1.setText(result);
    }
    
    class ButtonListener implements  OnClickListener{
    	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	//	new Thread(new Runnable() {

   //         @Override
  //          public void run() {
                    HttpGet mHttpGet = new HttpGet(uriApi);
                    try {
                            HttpResponse mHttpResponse = new DefaultHttpClient().execute(mHttpGet);
                          //  if (mHttpResponse.getStatusLine().getStatusCode() == 200) {
                            if (mHttpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {    
                                    String result = EntityUtils.toString(mHttpResponse.getEntity());
                                    System.out.println(result);
                                //    textview1.setText(result);
                            }
                    } catch (ClientProtocolException e) {
                            System.out.println("ClientProtocolException");
                            e.printStackTrace();
                    } catch (IOException e) {
                            System.out.println("IOException");
                            e.printStackTrace();
                    }
   //         }
  //  }).start();
		textview1.setText(result);	
	}
    }
    
    
}