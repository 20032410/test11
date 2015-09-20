package com.llf;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Activity3 extends Activity {
	OnClickListener listener = null;
	Button button;
	String uriApi = "http://m.touzhu.cn/ex_jc.aspx?state=0&ifgetclass=1";
//	String uriApi ="http://www.weather.com.cn/adat/cityinfo/101010100.html";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        listener = new OnClickListener() {
			public void onClick(View v) {
				finish();
			}
		};
		button = (Button) findViewById(R.id.button5);
		button.setOnClickListener(listener);
		setTitle("现在在test2里");
		

        


                new Thread(new Runnable() {

                        @Override
                        public void run() {
                                HttpGet mHttpGet = new HttpGet(uriApi);
                                try {
                                        HttpResponse mHttpResponse = new DefaultHttpClient().execute(mHttpGet);
                                        if (mHttpResponse.getStatusLine().getStatusCode() == 200) {
                                                String result = EntityUtils.toString(mHttpResponse.getEntity());
                                                System.out.println(result);
                                        }
                                } catch (ClientProtocolException e) {
                                        System.out.println("ClientProtocolException");
                                        e.printStackTrace();
                                } catch (IOException e) {
                                        System.out.println("IOException");
                                        e.printStackTrace();
                                }
                        }
                }).start();

        
    }
}