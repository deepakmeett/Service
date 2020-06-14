package com.example.service;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
public class MyService extends Service {

    //It will only work on android API level 6.0
    
    MediaPlayer mediaPlayer;
    public static final String TAG = "MyTAg";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d( TAG, "onBind: " );
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText( this, "Service Started...", Toast.LENGTH_SHORT ).show();
        mediaPlayer = MediaPlayer.create( getApplicationContext(), Settings.System.DEFAULT_NOTIFICATION_URI );
        mediaPlayer.setLooping( true );
        mediaPlayer.start();

        Log.d( TAG, "onStartCommand: " + Thread.currentThread().getName() );
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        Log.d( TAG, "onDestroy: " );
        Toast.makeText( this, "Service Destroyed...", Toast.LENGTH_SHORT ).show();
    }
}
    