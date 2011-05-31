package com.kupulau.headsetbooster;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class HeadsetBoosterSettings extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        startService(new Intent(this, HeadsetBoosterService.class));
        finish();
    }

}
