package com.example.service;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;
public class MyService extends Service {

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
        
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText( this, "Service Started...", Toast.LENGTH_SHORT ).show();
        mediaPlayer = MediaPlayer.create( getApplicationContext(), Settings.System.DEFAULT_NOTIFICATION_URI );
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        Toast.makeText( this, "Service Destroyed...", Toast.LENGTH_SHORT ).show();
    }
}
