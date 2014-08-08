package com.example.progressbar;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

public class MainActivityHandler extends Handler{
    private MainActivity activity;

    public MainActivityHandler(Context context) {
        activity = (MainActivity)context;
    }
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
        case R.id.PROGRESS:
            int progress = ((Integer)(msg.obj)).intValue();
            activity.updateProgress(progress);
            break;

        default:
            break;
        }
    }

}
