package com.example.mythread;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class CustomHandler extends Handler {
    private static final String TAG = "CustomHandler";
    @Override
    public void handleMessage(@NonNull Message msg) {
        downLoadSong(msg.obj.toString());

    }
    private  void downLoadSong(String songName)
    {
        Log.d(TAG, "downLoad Start : "+songName);
        try {
            Thread.sleep(4000);

        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        Log.d(TAG, "downLoad complete: "+songName);


    }
}
