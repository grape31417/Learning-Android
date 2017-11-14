package com.example.bluedream.actionbar;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by BlueDream on 2017/11/13.
 */

public class MwdiaPlayService extends Service {
    private MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Uri uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().getPath()+"/song.mp3"));
        String Path = "android.resource://"+getPackageName()+"/"+R.raw.song;
        Uri uri = Uri.parse(Path);
        player=MediaPlayer.create(this,uri);
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}