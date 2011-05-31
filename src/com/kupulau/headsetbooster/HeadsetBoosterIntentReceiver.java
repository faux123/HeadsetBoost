package com.kupulau.headsetbooster;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class HeadsetBoosterIntentReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        context.startService(new Intent(context, HeadsetBoosterService.class));
        return;
    }
}
