package com.example.progressbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.widget.ProgressBar;

@SuppressLint("UseValueOf")
public class MainActivity extends Activity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final MainActivityHandler handler = new MainActivityHandler(this);

        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    doProcess();
                    Integer progress = new Integer(i);
                    Message msg = Message.obtain();
                    msg.what = R.id.PROGRESS;
                    msg.obj = progress;
                    msg.setTarget(handler);
                    msg.sendToTarget();
                }
            }
        }).start();
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void updateProgress(int progress) {
        progressBar.setProgress(progress);
    }
    
    private void doProcess() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
