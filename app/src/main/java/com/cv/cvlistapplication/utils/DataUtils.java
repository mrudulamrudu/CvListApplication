package com.cv.cvlistapplication.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class DataUtils {

    public static boolean isInternetAvailable(Context context) {
        return getConnectionStatus(context) == NetworkStatusCodes.NET_CONNECTED;
    }

    public static int getConnectionStatus(Context context) {
        final ConnectivityManager conMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr == null) return NetworkStatusCodes.NET_DISCONNECTED;
        NetworkInfo networkInfo = conMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            if (networkInfo.isConnected()) {
                return NetworkStatusCodes.NET_CONNECTED;
            } else if (networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                return NetworkStatusCodes.NET_CONNECTING;
            }
        }
        return NetworkStatusCodes.NET_DISCONNECTED;
    }
}
