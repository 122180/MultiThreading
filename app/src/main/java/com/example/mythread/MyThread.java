package com.example.mythread;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class MyThread implements Runnable{
  public   CustomHandler mHandler;
    private static final String TAG = "MyThread";
    private Context mContext;

    public MyThread(Context mContext) {
        this.mContext=mContext;

    }


    @Override
    public void run() {
        Looper.prepare(); // to create message queue and looper
        mHandler=new CustomHandler();
        Looper.loop();

    }

}
