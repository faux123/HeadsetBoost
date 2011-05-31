/**
 *
 */
package com.kupulau.headsetbooster;

import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;

public class HeadsetBoosterService extends Service
{
    BroadcastReceiver headsetPlugReceiver 		= null;

    @Override
    public void onCreate()
    {
    	super.onCreate();
	    IntentFilter filter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
	    filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY - 1);
		headsetPlugReceiver = new BroadcastReceiver() {
		      @Override
		      public void onReceive(Context context, Intent intent) {
		    	  setBoost();
		      }
	    };
	    registerReceiver(headsetPlugReceiver, filter);
    }
	@Override
	public void onDestroy()
	{
		try {
			unregisterReceiver(headsetPlugReceiver);
		}
		catch(Exception e) {
		}
	}

	void setBoost()
	{
    	FileOutputStream f;
		try {
			f = new FileOutputStream("/sys/devices/platform/star_wm8994/data");
	    	f.write("1c     7f\n".getBytes());
	    	f.flush();
	    	f.close();
			f = new FileOutputStream("/sys/devices/platform/star_wm8994/data");
	    	f.write("1d     17f\n".getBytes());
	    	f.flush();
	    	f.close();
			Toast.makeText(this, "Headset Volume Boosted", Toast.LENGTH_LONG).show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public IBinder onBind(Intent intent)
	{
		return null;
	}
}
