package com.hr190014.serkan_berat_ergovan_final.util;

import android.app.ProgressDialog;
import android.content.Context;

import com.hr190014.serkan_berat_ergovan_final.R;

public class ProgressUtil {
    public static void ConnectionCheck(Context context) {
        ProgressDialog progress = new ProgressDialog(context);
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setMessage(context.getResources().getString(R.string.informations_loading_bar));
        progress.show();
        final int totalTime = 100;
        final Thread t = new Thread() {
            @Override
            public void run() {
                int jumpTime = 0;
                while (jumpTime < totalTime) {
                    try {
                        sleep(30);
                        jumpTime += 1;
                        progress.setProgress(jumpTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (jumpTime ==100){
                    progress.dismiss();
                }
            }
        };
        t.start();
    }
}

