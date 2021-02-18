package com.example.mythread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.FormatFlagsConversionMismatchException;

public class MainActivity extends AppCompatActivity {
    private TextView showMessage;
    private Button read,clear;
    private ProgressBar mProgressBar;
    private Handler mHandler;
    private MyThread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showMessage=findViewById(R.id.Show);
        read=findViewById(R.id.read);
        clear=findViewById(R.id.clear);
        mProgressBar=findViewById(R.id.progressBar);
                mProgressBar.setVisibility(View.VISIBLE);
                Thread.currentThread().setName("Akash Main");
      //<!-- TODO this is my first approach -->
     /*   Runnable r=new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.GONE);
                read.setText("updatad");

                Log.d("mytag",""+Thread.currentThread().getName());
            }
        };
        Handler handler=new Handler();
        handler.postDelayed(r,4000);*/

        //<!-- TODO this is second approach -->

      /*  Runnable r=new Runnable() {
            @Override
            public void run() {

                try {

                    for ( String s:Song.songlist)
                    {
                        Log.d("song","downloaded started  :"+s);

                        Thread.sleep(4000);
                        Log.d("song","downloaded complete  :"+s);
                        Message message=new Message();
                        Bundle bundle=new Bundle();
                        bundle.putString("song",s);
                        message.setData(bundle);
                        mHandler.sendMessage(message);


                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };

        Thread thread=new Thread(r);
        thread.setName("child Tread");
        thread.start();*/
        //<!-- TODO this is 3rd approach -->
    /*    CustomThread thread=new CustomThread();
        for (String s:Song.songlist)
        {
            Log.d("song","downloaded started  :"+s);
            Message message=new Message();
            Bundle bundle=new Bundle();
            bundle.putString("song",s);
            message.setData(bundle);
        }
        thread.start();*/

                thread=new MyThread(this);
        new Thread(thread).start();
      /*  mHandler=new Handler(getMainLooper())
        {

            @Override
            public void handleMessage(@NonNull Message msg) {
                String mesage=msg.getData().getString("song");
                showMessage.append(mesage+"\n");


            }
        };*/
        read.setOnClickListener(view -> {
            for (String song:Song.songlist)
            {
                Message message=Message.obtain();
                 message.obj=song;
                 thread.mHandler.sendMessage(message);
            }

           //readData();
        });
        clear.setOnClickListener(view -> {
         cleaAll();

        });
    }

    private void cleaAll() {
        showMessage.setText("");
        mProgressBar.setVisibility(View.GONE);
    }

    private void readData() {
        mProgressBar.setVisibility(View.VISIBLE);
        showMessage.append(getString(R.string.story));
        showMessage.setMovementMethod(new ScrollingMovementMethod());
    }
}