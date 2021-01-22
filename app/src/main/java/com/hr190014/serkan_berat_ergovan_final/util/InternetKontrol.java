package com.hr190014.serkan_berat_ergovan_final.util;

import android.content.Context;
import android.net.ConnectivityManager;

public class InternetKontrol {
    public static boolean checkConnection(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}
