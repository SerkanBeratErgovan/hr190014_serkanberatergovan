package com.hr190014.serkan_berat_ergovan_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

import com.hr190014.serkan_berat_ergovan_final.R;
import com.hr190014.serkan_berat_ergovan_final.util.InternetKontrol;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init(getBaseContext());
    }
    private void init(Context context){
        CountDownTimer countDownTimer =new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long l) {
                Log.e("COUNTER","TİCK");
            }
            @Override
            public void onFinish() {
                if (!InternetKontrol.checkConnection(context)) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                    builder.setMessage(context.getResources().getString(R.string.internet_exit_message));
                    builder.setCancelable(true);
                    builder.setNegativeButton(context.getResources().getString(R.string.internet_negative_button), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            System.exit(0);
                        }
                    });
                    builder.setPositiveButton(context.getResources().getString(R.string.internet_positive_button), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else {
                    openNextActivity();
                }
            }
        };
        countDownTimer.start();
    }
    private void openNextActivity(){
        Log.e("COUNTER","FİNİSH");
        Intent secondActivityIntent=new Intent(getApplicationContext(), ListActivity.class);
        startActivity(secondActivityIntent);
        finish();
    }
}