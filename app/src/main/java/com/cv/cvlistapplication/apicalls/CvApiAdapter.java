package com.cv.cvlistapplication.apicalls;

import android.content.Context;
import android.text.TextUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CvApiAdapter {

    private static final String BASE_API_URL = "";

    private static volatile CvApiService cvApiService;
    private static volatile OkHttpClient okHttpClient;

    private CvApiAdapter() {
    }

    public static synchronized CvApiService getApiService(Context context) {
        if (cvApiService == null) {
            cvApiService = refreshCvApiService(context);
        }
        return cvApiService;
    }

    private static CvApiService refreshCvApiService(Context context) {
        OkHttpClient okHttpClient = getHttpClient(context);
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return restAdapter.create(CvApiService.class);
    }

    public static synchronized void reset() {
        cvApiService = null;
        okHttpClient = null;
    }

    public static OkHttpClient getHttpClient(Context context) {
        if (okHttpClient != null) return okHttpClient;
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);

        okHttpClient = builder.build();
        return okHttpClient;
    }

    public static CvApiService getApiService(Context context, String bbVid,
                                             String bbAuthToken) {
        if (!TextUtils.isEmpty(bbVid) && !TextUtils.isEmpty(bbAuthToken)) {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS);

            OkHttpClient okHttpClient = builder.build();
            Retrofit restAdapter = new Retrofit.Builder()
                    .baseUrl(BASE_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
            return restAdapter.create(CvApiService.class);
        }
        return null;
    }

}
